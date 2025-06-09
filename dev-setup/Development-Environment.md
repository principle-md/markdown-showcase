# Development Environment Perfection

Stop manually configuring everything. Here's your complete dev setup in minutes.

## The Perfect Dev Setup Flow

```mermaid
flowchart LR
    A["💻 Fresh Install"] --> B["🔧 VS Code Setup"]
    B --> C["📦 Extensions"]
    C --> D["⚙️ Settings"]
    D --> E["🎯 Project Config"]
    
    style A fill:#2196f3
    style B fill:#4caf50
    style C fill:#ff9800
    style D fill:#e91e63
    style E fill:#9c27b0
```

## VS Code Essential Extensions

### Must-Have Extensions
```bash
# Install via command palette (Ctrl+Shift+P)
# Or use these extension IDs:

# Core Development
ext install ms-vscode.vscode-typescript-next
ext install esbenp.prettier-vscode  
ext install ms-vscode.vscode-eslint
ext install bradlc.vscode-tailwindcss

# Git & Version Control
ext install eamodio.gitlens
ext install mhutchie.git-graph

# Productivity
ext install ms-vscode.vscode-thunder-client
ext install formulahendry.auto-rename-tag
ext install ms-vscode.vscode-json
```

### Language-Specific Extensions
```bash
# React Development
ext install dsznajder.es7-react-js-snippets
ext install burkeholland.simple-react-snippets

# Vue Development  
ext install johnsoncodehk.volar
ext install sdras.vue-vscode-snippets

# Node.js Development
ext install ms-vscode.vscode-node-azure-pack
ext install christian-kohler.npm-intellisense
```

```prompt
Recommend VS Code extensions for my {{project_type}} development workflow with {{technologies}}
```

## Perfect VS Code Settings

### settings.json (Global)
```json
{
  "editor.fontSize": 14,
  "editor.fontFamily": "'Fira Code', 'Cascadia Code', Consolas, monospace",
  "editor.fontLigatures": true,
  "editor.tabSize": 2,
  "editor.insertSpaces": true,
  "editor.detectIndentation": false,
  "editor.formatOnSave": true,
  "editor.formatOnPaste": true,
  "editor.minimap.enabled": false,
  "editor.bracketPairColorization.enabled": true,
  "editor.guides.bracketPairs": "active",
  "workbench.iconTheme": "material-icon-theme",
  "workbench.colorTheme": "One Dark Pro",
  "files.autoSave": "onFocusChange",
  "files.trimTrailingWhitespace": true,
  "files.insertFinalNewline": true,
  "terminal.integrated.fontSize": 13,
  "git.autofetch": true,
  "git.confirmSync": false,
  "emmet.includeLanguages": {
    "javascript": "javascriptreact",
    "typescript": "typescriptreact"
  }
}
```

### Workspace Settings (.vscode/settings.json)
```json
{
  "typescript.preferences.quoteStyle": "single",
  "javascript.preferences.quoteStyle": "single",
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "editor.codeActionsOnSave": {
    "source.fixAll.eslint": true,
    "source.organizeImports": true
  },
  "[javascript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "[typescript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "[json]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  }
}
```

## Environment Variables Setup

### .env File Structure
```bash
# Database
DATABASE_URL=postgresql://user:password@localhost:5432/mydb
REDIS_URL=redis://localhost:6379

# Authentication
JWT_SECRET=your-super-secret-jwt-key
JWT_EXPIRES_IN=7d

# API Keys
STRIPE_SECRET_KEY=sk_test_...
SENDGRID_API_KEY=SG...

# Environment
NODE_ENV=development
PORT=3000
HOST=localhost

# External Services
AWS_ACCESS_KEY_ID=your-access-key
AWS_SECRET_ACCESS_KEY=your-secret-key
AWS_REGION=us-east-1
```

### Environment Loading (.env.example)
```bash
# Copy this file to .env and fill in your values

# Database
DATABASE_URL=postgresql://user:password@localhost:5432/mydb

# Authentication  
JWT_SECRET=change-this-in-production
JWT_EXPIRES_IN=7d

# API Keys (get from respective services)
STRIPE_SECRET_KEY=
SENDGRID_API_KEY=

# Environment
NODE_ENV=development
PORT=3000
```

```prompt
Help me organize environment variables for my {{app_type}} that uses {{services_list}}
```

## Package.json Scripts That Save Time

### Complete Scripts Setup
```json
{
  "scripts": {
    "dev": "next dev",
    "build": "next build",
    "start": "next start",
    "lint": "eslint . --ext .js,.jsx,.ts,.tsx",
    "lint:fix": "eslint . --ext .js,.jsx,.ts,.tsx --fix",
    "format": "prettier --write .",
    "format:check": "prettier --check .",
    "type-check": "tsc --noEmit",
    "test": "jest --watch",
    "test:ci": "jest --ci --coverage --watchAll=false",
    "clean": "rm -rf .next node_modules/.cache",
    "reinstall": "rm -rf node_modules package-lock.json && npm install",
    "analyze": "ANALYZE=true npm run build",
    "db:generate": "prisma generate",
    "db:push": "prisma db push",
    "db:studio": "prisma studio"
  }
}
```

### Node.js API Scripts
```json
{
  "scripts": {
    "dev": "ts-node-dev --respawn --transpile-only src/index.ts",
    "build": "tsc",
    "start": "node dist/index.js",
    "debug": "ts-node-dev --inspect --respawn --transpile-only src/index.ts",
    "test": "jest --watchAll",
    "test:coverage": "jest --coverage",
    "db:migrate": "knex migrate:latest",
    "db:seed": "knex seed:run",
    "docker:up": "docker-compose up -d",
    "docker:down": "docker-compose down"
  }
}
```

## Git Configuration

### Global Git Config
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --global init.defaultBranch main
git config --global core.editor "code --wait"
git config --global merge.tool vscode
git config --global mergetool.vscode.cmd 'code --wait $MERGED'
```

### Useful Git Aliases
```bash
git config --global alias.co checkout
git config --global alias.br branch
git config --global alias.ci commit
git config --global alias.st status
git config --global alias.unstage 'reset HEAD --'
git config --global alias.last 'log -1 HEAD'
git config --global alias.visual '!gitk'
git config --global alias.graph 'log --oneline --graph --decorate'
```

### .gitignore Template
```
# Dependencies
node_modules/
npm-debug.log*
yarn-debug.log*
yarn-error.log*

# Environment
.env
.env.local
.env.development.local
.env.test.local
.env.production.local

# Build outputs
dist/
build/
.next/
out/

# IDE
.vscode/
.idea/
*.swp
*.swo

# OS
.DS_Store
Thumbs.db

# Testing
coverage/
.nyc_output

# Logs
logs
*.log

# Runtime data
pids
*.pid
*.seed
*.pid.lock
```

```prompt
Create a .gitignore file for my {{project_type}} project using {{frameworks_and_tools}}
```

## Terminal & Shell Setup

### Oh My Zsh Installation
```bash
sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

### Useful Aliases (.zshrc or .bashrc)
```bash
# Navigation
alias ..="cd .."
alias ...="cd ../.."
alias ll="ls -la"
alias la="ls -la"

# Git shortcuts
alias g="git"
alias gs="git status"
alias ga="git add"
alias gc="git commit"
alias gp="git push"
alias gl="git pull"

# Development
alias ni="npm install"
alias nr="npm run"
alias ns="npm start"
alias nt="npm test"
alias nrd="npm run dev"

# Docker
alias d="docker"
alias dc="docker-compose"
alias dcu="docker-compose up"
alias dcd="docker-compose down"
```

## Project Structure Templates

### React/Next.js Structure
```
my-app/
├── .env.example
├── .env.local
├── .gitignore
├── .eslintrc.json
├── .prettierrc
├── next.config.js
├── package.json
├── tailwind.config.js
├── tsconfig.json
├── public/
├── src/
│   ├── components/
│   ├── pages/
│   ├── styles/
│   ├── utils/
│   └── types/
└── .vscode/
    ├── settings.json
    └── extensions.json
```

### Node.js API Structure
```
my-api/
├── .env.example
├── .gitignore
├── .eslintrc.json
├── .prettierrc
├── package.json
├── tsconfig.json
├── docker-compose.yml
├── src/
│   ├── controllers/
│   ├── middleware/
│   ├── models/
│   ├── routes/
│   ├── utils/
│   └── index.ts
├── tests/
└── .vscode/
    └── settings.json
```

## Debugging Configuration

### VS Code launch.json
```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "Debug Node.js",
      "type": "node",
      "request": "launch",
      "program": "${workspaceFolder}/src/index.ts",
      "runtimeArgs": ["-r", "ts-node/register"],
      "env": {
        "NODE_ENV": "development"
      }
    },
    {
      "name": "Debug Jest Tests",
      "type": "node",
      "request": "launch",
      "program": "${workspaceFolder}/node_modules/.bin/jest",
      "args": ["--runInBand"],
      "console": "integratedTerminal"
    }
  ]
}
```

```prompt
Set up a complete development environment for {{project_type}} with debugging, testing, and {{specific_requirements}}
```

## Pro Productivity Tips

### VS Code Shortcuts
- `Ctrl+Shift+P` - Command Palette
- `Ctrl+P` - Quick Open Files
- `Ctrl+Shift+F` - Search Across Files
- `Ctrl+D` - Select Next Occurrence
- `Alt+Up/Down` - Move Line Up/Down
- `Ctrl+/` - Toggle Comment

### Terminal Shortcuts
- `Ctrl+R` - Search Command History
- `Ctrl+L` - Clear Terminal
- `Ctrl+A` - Beginning of Line
- `Ctrl+E` - End of Line

### Development Workflow
1. **Use workspace settings** for project-specific configs
2. **Set up debugging** before you need it
3. **Automate repetitive tasks** with scripts
4. **Use environment files** for different stages
5. **Share configs** with your team via git

> **Remember**: A well-configured development environment is like a sharp knife - it makes everything easier and more enjoyable! 