helm install mongodb bitnami/mongodb
mongodb-password=$(kubectl get secret --namespace default mongodb -o jsonpath="{.data.mongodb-root-password}")
