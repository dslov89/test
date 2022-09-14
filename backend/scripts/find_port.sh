#! /usr/bin/env bash

function find_idle_port() {
  CURRENT_PORT=$(cat /etc/nginx/conf.d/service-url.inc | grep -Po '[0-9]+' | tail -1)

  if [ ${CURRENT_PORT} -eq 8081 ]; then
    echo "8082"
  elif [ ${CURRENT_PORT} -eq 8082 ]; then
    echo "8081"
  fi
}