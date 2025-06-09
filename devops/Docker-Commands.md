# Docker Made Simple

Stop being afraid of containers. Here are the commands you actually need.

## Build Your First Container

```bash
docker build -t my-app .
```

```prompt
Help me create a Dockerfile for my {{language}} application with these dependencies: {{list_dependencies}}
```

## The Container Lifecycle

```mermaid
flowchart LR
    A["💻 Code"] --> B["🔧 Build Image"]
    B --> C["🚀 Run Container"]
    C --> D["📦 Push to Registry"]
    
    style A fill:#2196f3
    style B fill:#4caf50
    style C fill:#ff9800
    style D fill:#e91e63
```

## Essential Daily Commands

### Start a Container
```bash
docker run -d -p 3000:3000 --name my-app my-app:latest
```

### View Running Containers
```bash
docker ps
```

### Stop and Remove
```bash
docker stop my-app && docker rm my-app
```

### Clean Up Everything
```bash
docker system prune -a
```

## Debug Like a Pro

### Enter Running Container
```bash
docker exec -it my-app /bin/bash
```

### View Container Logs
```bash
docker logs -f my-app
```

### Check Resource Usage
```bash
docker stats
```

```prompt
My Docker container is using too much memory. Can you help me optimize the Dockerfile: {{dockerfile_content}}
```

## Multi-Container Magic

```bash
docker-compose up -d
```

```bash
docker-compose down
```

```bash
docker-compose logs -f service-name
```

## Push to Production

```bash
docker tag my-app:latest registry.com/my-app:v1.0
docker push registry.com/my-app:v1.0
```

```prompt
Help me create a docker-compose.yml for {{app_description}} with these services: {{services_list}}
```

## Pro Tips

- Use `.dockerignore` to exclude unnecessary files
- Multi-stage builds keep images small
- Always tag your images with versions
- Use `--rm` flag for temporary containers

> **Remember**: Docker is just running your app in a box. That box is predictable, portable, and disposable. 