OLD="$(docker ps | grep apro_backend)"

if [ -z "$OLD" ]
then
	echo "docker ps apro_backend not found"
else
	echo "docker ps apro_backend stop"
	docker stop apro_backend
	docker rm apro_backend
fi

IMG="$(docker images | grep apro_backend)"

if [ -z "$IMG" ]
then
	echo "docker image apro_backend not found"
else
	echo "docker image apro_backend delete"
	docker rmi apro_backend
fi
