dbName=$1
dbUser=$2
dbPass=$3

sed -i 's/\s\susername:.*/  username: '$dbUser'/g' ./kubernetes/backend/mongo-secret.yaml
sed -i 's/\s\spassword:.*/  password: '$dbPass'/g' ./kubernetes/backend/mongo-secret.yaml

sed -i 's/\s\sdatabase:.*/  database: '$dbName'/g' ./kubernetes/backend/config-map-backend.yaml