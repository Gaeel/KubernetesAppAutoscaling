#! /bin/bash

apt install apt-transport-https ca-certificates curl software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -

add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
(lsb_release -cs) \
stable"

apt instal docker-ce

swapoff -a

sed -i s%/swap.img%#/swap.img%g /etc/fstab

mkdir -p /opt/kubernetes/bin

curl https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl -o /opt/kubernetes/bin/kubectl

apt install socat

curl https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 -o /opt/kubernetes/bin/minikube

curl https://get.helm.sh/helm-v2.16.1-linux-arm64.tar.gz -o /usr/local/src/helm-v2.16.1-linux-arm64.tar.gz

cd /usr/local/src
tar xfvz helm-v2.16.1-linux-amd64.tar.gz
mv linux-amd64/{helm,tiller} /opt/kubernetes/bin/
cd -

