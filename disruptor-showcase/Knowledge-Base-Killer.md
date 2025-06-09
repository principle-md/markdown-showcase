# Onboarding Guide: Welcome to the Team!

This interactive document replaces our static Confluence onboarding pages. Complete these steps to get your development environment fully configured.

**Assigned To:** `new.engineer@example.com`
**Progress:** `2/5 Steps Completed`

---

## 1. Install System Dependencies

First, you'll need Homebrew, Git, Node.js, and Docker.

- [x] **Install Homebrew:** The macOS package manager.
  ```bash
  /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
  ```
- [x] **Install Git, Node & Docker:**
  ```bash
  brew install git node yarn docker
  ```
- [ ] **Verify Installations:** Run this command to check that everything was installed correctly.
  ```bash
  git --version && node --version && docker --version
  ```

---

## 2. Set Up Your Code Editor

We use VS Code. These commands will install it and our standard set of extensions.

- [ ] **Install VS Code:**
  ```bash
  brew install --cask visual-studio-code
  ```
- [ ] **Install Recommended Extensions:**
  ```bash
  code --install-extension esbenp.prettier-vscode
  code --install-extension dbaeumer.vscode-eslint
  code --install-extension eamodio.gitlens
  ```

---

## 3. Clone and Configure the Repository

Now, let's get the code and set up your local environment.

- [ ] **Clone the main repository:**
  ```bash
  git clone git@github.com:your-company/main-repo.git
  cd main-repo
  ```
- [ ] **Install dependencies:**
  ```bash
  npm install
  ```
- [ ] **Create your `.env` file:**
  ```bash
  cp .env.example .env
  ```
- [ ] **Start dependent services (Database, Redis):**
  ```bash
  docker-compose up -d
  ```

---

## 4. Run the Application

Let's make sure the application runs correctly on your machine.

- [ ] **Run database migrations:**
  ```bash
  npm run db:migrate
  ```
- [ ] **Start the development server:**
  ```bash
  npm run dev
  ```
- [ ] **Verify:** Open [http://localhost:3000](http://localhost:3000) in your browser. You should see the login page.

---

## 5. Your First Task

You're all set up! Here is a link to your first good-first-issue task.

- [ ] **Review your first task:** [TICKET-451](./Project-Management-Killer.md)

### Need Help?

If you get stuck on any step, use the prompt below to ask our AI assistant for help.

```prompt
I'm having trouble with the 'Run database migrations' step. The command `npm run db:migrate` is failing with the following error: {{paste_error_here}}. What should I do?
```

> **The Guidewire Advantage:** Onboarding is no longer a passive reading exercise. It's an interactive, executable checklist that new hires can run directly, with AI assistance available at any step. This dramatically reduces setup time and frustration. 