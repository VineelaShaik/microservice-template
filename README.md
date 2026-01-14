# Spring Boot Microservice Template

A **Spring Boot microservice template** designed to quickly bootstrap new backend services with **secure defaults**, **consistent architecture**, and **minimal setup**.

⚠️ This repository is a **template**, not a deployable application.

---

## 🎯 Purpose

This template provides a **standardized foundation** for building Spring Boot microservices by implementing common **cross-cutting concerns upfront**, allowing teams to focus only on **business logic**.

It is built to ensure:
- Consistent service structure
- Secure-by-default behavior
- Clean separation of concerns
- Faster project startup

---

## 🧱 What This Template Provides

### ✅ Canonical Project Structure

com.company.platform
├── config # Framework and security configuration
├── security # JWT validation and security components
├── controller # REST API entry points
├── service # Business logic layer
├── repository # Persistence layer
├── dto # Request / response models
├── exception # Global exception handling
└── util # Shared utilities


This structure is enforced so all services follow the same architectural conventions.

---

### 🔐 Security (Implemented)

This template includes **stateless, JWT-based security**, suitable for microservices.

**Implemented features:**
- JWT validation (`Authorization: Bearer <token>`)
- Signature and integrity verification
- Automatic expiry validation (`exp` claim, if present)
- Stateless security (no HTTP sessions)
- Proper HTTP responses:
  - `401 Unauthorized` for missing or invalid tokens
  - No redirects or HTML login pages

**Intentionally NOT included:**
- Login / signup
- Token generation
- Refresh tokens
- User database checks

Authentication is expected to be handled by an **API Gateway or dedicated Auth Service**.

---

### 🚨 Global Exception Handling (Implemented)

The template provides centralized exception handling using `@RestControllerAdvice`.

**Features:**
- Consistent JSON error responses
- Correct HTTP status codes
- No stack trace leakage
- Clean controllers (no try/catch blocks)

**Handled globally:**
- Business exceptions
- Runtime exceptions
- JSON parsing errors
- Unexpected failures (`500 Internal Server Error`)

**Not handled here (by design):**
- Authentication errors (`401`)
- Authorization errors (`403`)
- Filter-level or startup errors

---

### 📊 Observability (Baseline)

- Spring Boot Actuator included
- Health endpoint available (`/actuator/health`)
- Logging configured via `logback-spring.xml`

---

## 🚀 How to Use This Template

### 1️⃣ Create a New Microservice

Use this repository as a **template**:

- Click **“Use this template”** in GitHub/GitLab  
  **or**
- Copy the repository to create a new service

Example:
microservice-template → order-service



---

### 2️⃣ Rename & Configure

After creating a new service:
- Update `spring.application.name`
- Change server port if needed
- Update Maven artifact and group IDs
- Add service-specific configuration (database, messaging, etc.)

---

### 3️⃣ Start Writing Business Logic

Add:
- Controllers inside `controller`
- Business logic inside `service`
- Persistence logic inside `repository`

Security and exception handling are already in place.

---

## ❌ What This Template Intentionally Does NOT Include

To keep the template reusable and flexible, it does **not** include:

- Database configuration (JPA, MongoDB, etc.)
- Messaging systems (Kafka, RabbitMQ)
- Service discovery
- API Gateway
- OAuth authorization server
- Cloud-specific dependencies

These concerns should be added **per service**, not enforced by the template.

---

## 🧠 Design Principles

- Secure by default
- Stateless services
- Clear separation of concerns
- Template defines structure, not business behavior
- Services validate trust, not establish identity

---

## 📌 Intended Users

- Backend developers starting new microservices
- Teams looking for consistent service foundations
- Projects using centralized authentication (gateway/auth service)

---

## 🛠 Requirements

- Java 17+
- Maven
- Spring Boot

---

## 📄 Status

✔ Security: Complete  
✔ Global exception handling: Complete  
✔ Template ready for reuse
