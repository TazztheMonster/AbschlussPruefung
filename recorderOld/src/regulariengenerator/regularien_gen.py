"""
Regularien Generator: read regularien from yaml file
and send it to the RegularienService
"""

from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

# stdlib
import os
import yaml
import logging
import sys

LOG_LEVEL = os.getenv("LOG_LEVEL", logging.DEBUG)


formatter = logging.Formatter("%(asctime)s - %(name)s - %(levelname)s - %(message)s")
logger = logging.getLogger("regularien")
logger.setLevel(LOG_LEVEL)
# create handler
ch = logging.StreamHandler()
ch.setFormatter(formatter)

logger.addHandler(ch)


class LoadRegulaRienException(Exception):
    pass

class PushRegulaRienException(Exception):
    pass


def load_regularien(default_path="regularien.yaml", env_key="REGULARIEN_PATH"):
    """Load regularien from yaml files

    Args:
        default_path (string): default config path
        env_key (string): environment variable used for file configuration
    Return: a dict containings the conf variables
    """

    try:
        logger.info("Loading regularien")
        regularien_map = {}
        regularien_path = _get_regularien_path(default_path, env_key)
        
        with open(regularien_path, "r") as f:
            try:
                regularien_map = yaml.safe_load(f)
                logger.debug(f"regularien Map: :{regularien_map}")
            except Exception as e:
                logger.exception(f"Error while loading regularien :{e}")
                raise LoadRegulaRienException(str(e))
    except FileNotFoundError as e:
        logger.exception(f"Error while loading configuration :{e}")
        raise LoadRegulaRienException(str(e))
    else:
        logger.info(f"loading regularien sucessfull")

    return regularien_map

def _get_regularien_path(default_path, env_key):
    absolut_path = os.getenv(env_key, default_path)
    logger.debug(f"Confgigured Path:{absolut_path}")

    if absolut_path == default_path:
        absolut_path = os.path.dirname(os.path.abspath(__file__))

    regularien_path = os.path.join(absolut_path, default_path)
    logger.debug(f"Regularien Path:{regularien_path}")
    
    return regularien_path


def push_regularien(regularien):
    """ push regularien to the regularien service via http.
    Args:
        regularien (list of dict): the regularien
    Raises:
        PushRegularienException: the exception raised if an error occur
    """


def run():
    try:
        return_code = 0
        regularien = load_regularien()
    except LoadRegulaRienException as e:
        return_code = -1
    else:
        try:
            push_regularien(regularien)
        except PushRegulaRienException as e:
            return_code = -1
    
    sys.exit(return_code)



if __name__ == "__main__":
    run()
