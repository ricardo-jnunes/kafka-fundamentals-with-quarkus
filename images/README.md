## Commands

Run this docker-compose to have the environment running.

```console
# Using Rancher Desktop to run k8s and dockers containers using nerdctl CLI
nerdctl compose -f docker-compose.yml up
```

#### Other

```console
nerdctl ps
```

```console
nerdctl exec -it <nome-ou-id-do-container> /bin/sh
```