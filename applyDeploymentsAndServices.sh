k="kubernetes/"
f="frontend/"
i="ingress/"
r="recorder/"

declare -a files=("./"$k$b"mongo-secret.yaml" \
"./"$k$b"config-map-backend.yaml" \
"./"$k$b"backend-service.yaml" \
"./"$k$b"backend.yaml" \
"./"$k$f"frontend-service.yaml" \
"./"$k$f"frontend.yaml" \
"./"$k$r"recorder.yaml" \
"./"$k$i"ingress.yaml")

for var in "$files"
do
    echo $var
    echo "------"
done