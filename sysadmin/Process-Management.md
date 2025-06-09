# Process Management Mastery

Stop Force-Quitting everything. Learn to manage processes like a pro.

## The Process Lifecycle

```mermaid
flowchart LR
    A["▶️ Start Process"] --> B["🔍 Monitor"]
    B --> C["⚡ Optimize"]
    C --> D["⏸️ Control"]
    D --> E["🛑 Stop"]
    
    style A fill:#2196f3
    style B fill:#4caf50
    style C fill:#ff9800
    style D fill:#e91e63
    style E fill:#9c27b0
```

## See What's Running

### Process Overview
```bash
ps aux
ps aux | grep node
```

### Real-time Process Monitor
```bash
top
htop
```

### Process Tree
```bash
pstree
ps auxf
```

```prompt
My server is running slowly. Help me identify which processes are consuming the most resources: {{ps_output}}
```

## Memory & CPU Analysis

### Memory Usage by Process
```bash
ps aux --sort=-%mem | head -10
```

### CPU Usage by Process
```bash
ps aux --sort=-%cpu | head -10
```

### System Resource Summary
```bash
free -h
cat /proc/meminfo
```

### Load Average
```bash
uptime
cat /proc/loadavg
```

## Process Control

### Kill Processes Safely
```bash
# Graceful shutdown
kill -TERM 1234
killall -TERM node
```

### Force Kill (Last Resort)
```bash
kill -9 1234
pkill -9 -f "my-app"
```

### Send Signals
```bash
# Reload configuration
kill -HUP 1234
# Pause process  
kill -STOP 1234
# Resume process
kill -CONT 1234
```

```prompt
I have a {{process_name}} process that won't stop normally. What's the safest way to terminate it?
```

## Background Process Management

### Run in Background
```bash
nohup ./my-script.sh &
```

### View Background Jobs
```bash
jobs
jobs -l
```

### Bring to Foreground
```bash
fg 1
```

### Send to Background
```bash
bg 1
```

## Service Management

### SystemD Services
```bash
systemctl status nginx
systemctl start nginx
systemctl stop nginx
systemctl restart nginx
systemctl reload nginx
```

### Enable/Disable Services
```bash
systemctl enable nginx
systemctl disable nginx
```

### View Service Logs
```bash
journalctl -u nginx -f
journalctl -u nginx --since "1 hour ago"
```

```prompt
Help me create a systemd service file for my {{app_type}} application that runs on port {{port}}
```

## Performance Monitoring

### I/O Activity
```bash
iotop
iostat 1
```

### Network Activity by Process
```bash
nethogs
lsof -i
```

### File Descriptors
```bash
lsof -p 1234
ls -la /proc/1234/fd/
```

## Finding Resource Hogs

### CPU Intensive Processes
```bash
ps -eo pid,ppid,cmd,%mem,%cpu --sort=-%cpu | head
```

### Memory Intensive Processes
```bash
ps -eo pid,ppid,cmd,%mem,%cpu --sort=-%mem | head
```

### Disk I/O Intensive
```bash
iotop -a -o
```

```prompt
My application is using 100% CPU. Help me diagnose what's causing the high CPU usage: {{top_output}}
```

## Process Debugging

### Attach to Running Process
```bash
strace -p 1234
```

### Monitor System Calls
```bash
strace -c ./my-program
```

### Check Process Environment
```bash
cat /proc/1234/environ | tr '\0' '\n'
```

### Memory Maps
```bash
cat /proc/1234/maps
pmap 1234
```

## Cron Jobs & Scheduled Tasks

### List Cron Jobs
```bash
crontab -l
sudo crontab -l -u username
```

### Edit Cron Jobs
```bash
crontab -e
```

### System-wide Cron
```bash
ls -la /etc/cron.*
cat /etc/crontab
```

## Resource Limits

### Check Process Limits
```bash
ulimit -a
cat /proc/1234/limits
```

### Set Resource Limits
```bash
ulimit -n 4096  # File descriptors
ulimit -u 1024  # Max processes
```

```prompt
My process keeps running out of file descriptors. How do I increase the limit for {{service_name}}?
```

## Container Process Management

### Docker Process Monitoring
```bash
docker stats
docker exec -it container-name top
```

### Container Process Tree
```bash
docker exec -it container-name ps auxf
```

### Kill Container Processes
```bash
docker exec -it container-name kill -TERM 1
docker kill container-name
```

## Zombie Process Cleanup

### Find Zombie Processes
```bash
ps aux | grep -w Z
ps aux | awk '$8=="Z" {print}'
```

### Parent Process Investigation
```bash
ps -eo pid,ppid,state,comm | grep -w Z
```

## Emergency Process Recovery

### When System is Unresponsive
```bash
# Magic SysRq keys (if enabled)
echo 1 > /proc/sys/kernel/sysrq
echo f > /proc/sysrq-trigger  # Kill memory hogs
```

### Safe Reboot
```bash
sync && sudo reboot
```

```prompt
My server is completely unresponsive but I can still SSH in. What's the safest way to recover without losing data?
```

## Pro Tips

- Use `htop` instead of `top` for better visualization
- Always try graceful shutdown before force kill
- Monitor trends, not just snapshots
- Set up process monitoring/alerting
- Keep logs of resource usage patterns

> **Remember**: Processes are just programs in action. Understanding them gives you superpowers for debugging and optimization! 