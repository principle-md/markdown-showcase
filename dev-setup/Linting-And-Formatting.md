# Linting & Formatting That Just Works

Stop fighting with ESLint configs. Here are setups that work out of the box.

## The Developer Experience Flow

```mermaid
flowchart LR
    A["💻 Write Code"] --> B["🔧 Auto Format"]
    B --> C["✅ Auto Lint"]
    C --> D["🚀 Commit"]
    D --> E["✨ Deploy"]
    
    style A fill:#2196f3
    style B fill:#4caf50
    style C fill:#ff9800
    style D fill:#e91e63
    style E fill:#9c27b0
```

## ESLint + Prettier: The Dream Team

### Install Everything You Need
```bash
npm install -D eslint prettier eslint-config-prettier eslint-plugin-prettier
npx eslint --init
```

### Perfect .eslintrc.json
```json
{
  "extends": [
    "eslint:recommended",
    "@typescript-eslint/recommended",
    "prettier"
  ],
  "plugins": ["prettier"],
  "rules": {
    "prettier/prettier": "error",
    "no-unused-vars": "warn",
    "no-console": "warn"
  },
  "env": {
    "browser": true,
    "node": true,
    "es6": true
  }
}
```

```prompt
Help me create an ESLint configuration for my {{framework}} project with these specific requirements: {{requirements}}
```

## Prettier Configuration

### .prettierrc.json
```json
{
  "semi": true,
  "trailingComma": "es5",
  "singleQuote": true,
  "printWidth": 80,
  "tabWidth": 2,
  "useTabs": false
}
```

### .prettierignore
```
node_modules/
dist/
build/
coverage/
*.min.js
```

## React/Next.js Setup

### Install React-Specific Rules
```bash
npm install -D eslint-plugin-react eslint-plugin-react-hooks
```

### React .eslintrc.json
```json
{
  "extends": [
    "eslint:recommended",
    "plugin:react/recommended",
    "plugin:react-hooks/recommended",
    "prettier"
  ],
  "plugins": ["react", "react-hooks", "prettier"],
  "settings": {
    "react": {
      "version": "detect"
    }
  },
  "rules": {
    "react/prop-types": "off",
    "react/react-in-jsx-scope": "off"
  }
}
```

## Vue.js Setup

### Install Vue-Specific Rules
```bash
npm install -D eslint-plugin-vue
```

### Vue .eslintrc.json
```json
{
  "extends": [
    "eslint:recommended",
    "plugin:vue/vue3-recommended",
    "prettier"
  ],
  "plugins": ["vue", "prettier"],
  "rules": {
    "vue/multi-word-component-names": "off"
  }
}
```

```prompt
My Vue/React components are showing linting errors that don't make sense. Help me debug this ESLint configuration: {{eslint_config}}
```

## Auto-Format on Save

### VS Code settings.json
```json
{
  "editor.formatOnSave": true,
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "editor.codeActionsOnSave": {
    "source.fixAll.eslint": true
  },
  "[javascript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "[typescript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  }
}
```

## Pre-commit Hooks with Husky

### Install Husky and lint-staged
```bash
npm install -D husky lint-staged
npx husky-init && npm install
```

### package.json scripts
```json
{
  "scripts": {
    "lint": "eslint . --ext .js,.jsx,.ts,.tsx",
    "lint:fix": "eslint . --ext .js,.jsx,.ts,.tsx --fix",
    "format": "prettier --write ."
  },
  "lint-staged": {
    "*.{js,jsx,ts,tsx}": [
      "eslint --fix",
      "prettier --write"
    ]
  }
}
```

### .husky/pre-commit
```bash
#!/usr/bin/env sh
. "$(dirname -- "$0")/_/husky.sh"

npx lint-staged
```

```prompt
Set up pre-commit hooks for my {{project_type}} that runs {{linting_tools}} and prevents bad commits
```

## Fixing Common Issues

### ESLint Ignoring Files
```
# .eslintignore
node_modules/
dist/
build/
*.config.js
```

### Prettier vs ESLint Conflicts
```bash
npm install -D eslint-config-prettier
```

### TypeScript Integration
```bash
npm install -D @typescript-eslint/parser @typescript-eslint/eslint-plugin
```

## Project-Specific Configs

### Monorepo Setup
```json
{
  "root": true,
  "extends": ["./packages/shared/eslint-config.js"],
  "overrides": [
    {
      "files": ["apps/frontend/**/*"],
      "extends": ["plugin:react/recommended"]
    },
    {
      "files": ["apps/backend/**/*"],
      "extends": ["plugin:node/recommended"]
    }
  ]
}
```

## Quick Setup Commands

### New React Project
```bash
npx create-react-app my-app
cd my-app
npm install -D eslint-config-prettier eslint-plugin-prettier prettier
```

### New Node.js Project
```bash
npm init -y
npm install -D eslint prettier eslint-config-prettier eslint-plugin-prettier
npx eslint --init
```

```prompt
I'm starting a new {{project_type}} project. Generate a complete linting and formatting setup for me.
```

## Pro Tips

- **Use --fix flag** for automatic fixes: `eslint --fix`
- **Combine with CI/CD** to enforce standards
- **Share configs** across projects with npm packages
- **Use editor extensions** for real-time feedback
- **Gradually adopt** rules to avoid overwhelming legacy code

> **Remember**: Perfect linting setup takes 30 minutes to configure but saves hours every week. It's the best investment in code quality! 