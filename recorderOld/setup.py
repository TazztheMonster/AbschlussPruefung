from setuptools import setup, find_packages
import os, sys

source_path = "src"
path = os.path.abspath(os.path.dirname(sys.argv[0]))
os.chdir(path)


setup(
    name="regulariengenerator", 
    version="0.1",
    author="sereni.Awountsa@numcloud.net",
    description="regularien Generator",
    packages=find_packages(source_path),
    package_dir={"": source_path},
    classifiers=[
        "Topic :: Script",
        "Intended Audience :: Developers",
        "Intended Audience :: Open Source",
        "Operating System :: OS Independent",
        "Programming Language :: Python :: 3.6",
        "Programming Language :: Python :: 3.7",
        "Programming Language :: Python :: 3.8",
    ],
    )
