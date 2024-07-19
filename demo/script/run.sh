#!/bin/sh
SCRIPT_DIR=$(dirname "$0")
DEMO_DIR=$(cd "${SCRIPT_DIR}/.." || exit 1; pwd)
DC_FILE="${DEMO_DIR}/compose.yaml"
docker compose -f "${DC_FILE}" up -d