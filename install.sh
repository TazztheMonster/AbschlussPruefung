#Settings

node="gke-f73-gr2-tg-6-data-node-f73-gr2-tg-6d9ae589-p807" #Get node name with "kubectl get nodes"

dbName="carData"
dbUser="achilles"
dbPass="CHANGEME"



#Script (DO NOT TOUCH THINGS FROM HERE!)

#install helm
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update

#set up database
helm install mongodb --set auth.username=$dbUser,auth.password=$dbPass,auth.database=$dbName bitnami/mongodb
./changeDatabaseCredentials.sh $dbName $dbUser $dbPass

#add recorderYaml to root node
sh ./createRecorderYAML.sh $node



#dau protection
#./sd.sh