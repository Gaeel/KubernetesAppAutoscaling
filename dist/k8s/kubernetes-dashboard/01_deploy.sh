#! /bin/bash

minikube addons enable dashboard

kubectl create -n kubernetes-dashboard -f ./dashboard-ingress.yml
