#! /bin/bash

helm install --values prometheus-values.yml --name prometheus --namespace monitoring stable/prometheus
helm install --namespace monitoring --name prometheus-adapter --values prometheus-adapter-values.yml stable/prometheus-adapter
helm install --name grafana --namespace monitoring --values grafana-values.yml stable/grafana
kubectl get secret --namespace monitoring grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo
