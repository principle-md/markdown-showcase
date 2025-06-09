# Cloud Deployment Simplified

Deploy your apps without the fear. AWS CLI and deployment made easy.

## AWS CLI Setup (One Time)

```bash
aws configure
```

```prompt
I need to deploy my {{app_type}} application to AWS. What's the simplest architecture you'd recommend?
```

## The Deployment Journey

```mermaid
flowchart LR
    A["💻 Local Code"] --> B["🔧 Build"]
    B --> C["📦 Package"]
    C --> D["☁️ Upload"]
    D --> E["🚀 Deploy"]
    
    style A fill:#2196f3
    style B fill:#4caf50
    style C fill:#ff9800
    style D fill:#e91e63
    style E fill:#9c27b0
```

## S3: Static Site Hosting

### Upload Website
```bash
aws s3 sync ./build s3://my-website-bucket --delete
```

### Make Public
```bash
aws s3 website s3://my-website-bucket --index-document index.html
```

### Check Status
```bash
aws s3 ls s3://my-website-bucket
```

```prompt
Help me set up a static website on S3 with CloudFront CDN for {{website_description}}
```

## EC2: Virtual Servers

### List Instances
```bash
aws ec2 describe-instances --query 'Reservations[*].Instances[*].[InstanceId,State.Name,PublicIpAddress]' --output table
```

### Connect to Server
```bash
ssh -i my-key.pem ec2-user@ec2-ip-address
```

### Start/Stop Instances
```bash
aws ec2 start-instances --instance-ids i-1234567890abcdef0
aws ec2 stop-instances --instance-ids i-1234567890abcdef0
```

## Lambda: Serverless Functions

### Deploy Function
```bash
zip function.zip index.js
aws lambda update-function-code --function-name my-function --zip-file fileb://function.zip
```

### Invoke Function
```bash
aws lambda invoke --function-name my-function output.txt
```

### View Logs
```bash
aws logs tail /aws/lambda/my-function --follow
```

```prompt
Convert this Express.js route to an AWS Lambda function: {{express_route_code}}
```

## RDS: Managed Databases

### List Databases
```bash
aws rds describe-db-instances --query 'DBInstances[*].[DBInstanceIdentifier,DBInstanceStatus,Endpoint.Address]' --output table
```

### Create Snapshot
```bash
aws rds create-db-snapshot --db-instance-identifier mydb --db-snapshot-identifier mydb-snapshot-$(date +%Y%m%d)
```

## ECS: Container Orchestration

### Update Service
```bash
aws ecs update-service --cluster my-cluster --service my-service --force-new-deployment
```

### View Service Status
```bash
aws ecs describe-services --cluster my-cluster --services my-service
```

```prompt
Help me create an ECS task definition for my {{app_type}} Docker container with {{requirements}}
```

## Monitoring & Debugging

### CloudWatch Logs
```bash
aws logs describe-log-groups
aws logs tail my-log-group --follow
```

### Check Billing
```bash
aws ce get-cost-and-usage --time-period Start=2024-01-01,End=2024-01-31 --granularity MONTHLY --metrics BlendedCost
```

## One-Command Deployments

### Serverless Framework
```bash
serverless deploy
```

### AWS CDK
```bash
cdk deploy
```

### Amplify CLI
```bash
amplify push
```

```prompt
Create a simple deployment script that builds my {{framework}} app and deploys it to {{aws_service}}
```

## Pro Tips

- Use AWS profiles for multiple accounts
- Tag everything for cost tracking
- Set up billing alerts
- Use IAM roles, not root access keys
- Script your deployments

> **Remember**: The cloud is just someone else's computer. But it's a really good computer that scales! 