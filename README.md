# AbschlussPruefung

## Installation

### 1. Requirements

To use this project you need ...  
[Docker](https://www.docker.com/)  
[Kubernetes (kubectl)](https://kubernetes.io/de/)  
[Helm](https://helm.sh/)  
[kubectl node-shell](https://github.com/kvaps/kubectl-node-shell)

### 2. Preparation

Before you can start with the installation process, you have to build the docker images and push them into your docker registry. Also you have to update the kubernetes yaml files to match with your docker images.

backend/Dockerfile -> kubernetes/backend/backend.yaml (line 22 "image: \<yourBackendImage\>")

frontend/Dockerfile -> kubernetes/frontend/frontend.yaml (line 22 "image: \<yourFrontendImage\>")

recorder/Dockerfile -> kubernetes/recorder/recorder.yaml (line 18 "image: \<yourRecorderImage\>")

### 3. Installation

#### Automatic installation:

We provide a script that do the installation fully automatic. To use that give all the "*.sh" scripts in the main directory execution permissions. 
```
chmod +x install.sh
chmod +x createRecorderYAML.sh
chmod +x changeDatabaseCredentials.sh
chmod +x applyDeploymentsAndServices.sh
chmod +x sd.sh
```
Than run the "install.sh" script in the main directory. (Please execute it while you are in the main directory! The execution while you are in another directory can cause problems!)

#### Manual installation:

1. Install the MongoDB. (Prefered to use HELM for this task)
2. Update the credentials for the MongoDB in the `kubernetes/backend/config-map-backend.yaml` and  
`kubernetes/backend/mongo-secret.yaml`.
3. Copy the recorder/data/recorder.yaml into your node at /mnt/stateful_partition/data/recorder.yaml
4. Run the kubernetes files in the kubernetes directory and sub folders. (Run the config-map's and secrets first!)
