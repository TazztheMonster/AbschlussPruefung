helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update
helm install mongodb bitnami/mongodb
mongodb-password=$(kubectl get secret --namespace default mongodb -o jsonpath="{.data.mongodb-root-password}")
