# Spring Boot Microservice Template

A **Spring Boot microservice template** designed to quickly bootstrap new backend services with **secure defaults**, **consistent architecture**, and **minimal setup**.

⚠️ This repository is a **template**, not a deployable application.

---

## Purpose

This template provides a **standardized foundation** for building Spring Boot microservices by implementing common **cross-cutting concerns upfront**, allowing teams to focus only on **business logic**.

It is built to ensure:
- Consistent service structure
- Secure-by-default behavior
- Clean separation of concerns
- Faster project startup

---
## 2. Features

### Core Features (Always Available)
- Spring Boot application bootstrap
- REST APIs (Spring MVC)
- Global exception handling
- Request / response logging
- Actuator health checks
- Profile-based configuration
- Clean layered architecture

### Optional Infrastructure Features
- Database (JPA / JDBC)
- OpenFeign (synchronous service-to-service calls)
- RabbitMQ (asynchronous messaging)
- Security (JWT-based, gateway-friendly)
- Validation support

---

##  What This Template Provides

###  Canonical Project Structure
```
com.company.platform
├── config # Framework and security configuration
├── security # JWT validation and security components
├── controller # REST API entry points
├── service # Business logic layer
├── repository # Persistence layer
├── dto # Request / response models
├── exception # Global exception handling
└── util # Shared utilities
```

This structure is enforced so all services follow the same architectural conventions.

---

## 🚀 How to Use This Template

### 1. Create a New Microservice

Use this repository as a **template**:

- Click **“Use this template”** in GitHub/GitLab  
  **or**
- Copy the repository to create a new service

Example:
microservice-template → order-service



---

### 2. Rename the Service

Update the following items to reflect the new microservice identity:

-  Rename the root project folder to match the service name.
-  Update the Maven artifact ID so the build output correctly represents the service.
-  Rename the base package (for example: `com.company.platform`) across the project to match your organization and service naming conventions.


### 3. Set Application Name
```
spring:
  application:
    name: order-service
```

Each microservice must have a unique application name.

---
## 4. Baseline Run 

Run the application **without enabling any optional infrastructure** using the following command:

```
mvn spring-boot:run -Dspring.profiles.active=dev
```
Verify the application is running correctly by calling the health endpoint:

GET /actuator/health
Expected response:
```
{ "status": "UP" }
```
This confirms that the template baseline is stable and the application starts successfully with only the core features enabled.

---
## 6. Feature Usage Guide

Each feature requires **explicit configuration and code wiring**.  
Simply enabling a feature flag is **not sufficient**.

---

### 6.1 REST APIs (Always Used)

Create controllers that expose APIs and delegate all logic to the service layer.

```
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
}
```
### 6.2 Validation
Add validation annotations to request DTOs.
```
@NotNull
@NotBlank
```
Validation errors are automatically handled by the global exception handler.

### 6.3 Global Exception Handling
Provided by default.

Rules:

Do not catch exceptions in controllers

Throw custom business exceptions

All errors are converted into consistent HTTP responses

#### 6.4 Logging
The template includes request and response logging.

Configure logging levels via:
```
logging:
  level:
    root: INFO
```
### 6.5 Actuator & Health Checks
Check application health:

```GET /actuator/health```
With database enabled:

```"db": { "status": "UP" }```
### 6.6 Database (Optional)
#### Step 1: Configure Datasource
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/orderdb
    username: user
    password: password
```
#### Step 2: Create Entity
```
@Entity
public class Order {
    @Id
    private Long id;
}
```
#### Step 3: Create Repository
```
public interface OrderRepository
        extends JpaRepository<Order, Long> {
}
```
#### Step 4: Use Repository in Service Layer
```
@Service
public class OrderService {
    private final OrderRepository repository;
}
```
### 6.7 OpenFeign (Optional – Synchronous Communication)
#### Step 1: Enable Feign Clients
```@EnableFeignClients(basePackages = "com.company.platform.client")```
#### Step 2: Create Feign Client
```
@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    UserDto getUser(@PathVariable String id);
}
```
#### Step 3: Use Feign Client in Service Layer
```
@Service
public class OrderService {
    private final UserClient userClient;
}
```
### 6.8 RabbitMQ (Optional – Asynchronous Messaging)
#### Step 1: Infrastructure
The template provides exchange, queue, and binding configuration.

No messages are sent or consumed by default.

#### Step 2: Create Producer (If Required)
```
rabbitTemplate.convertAndSend(
    "order.exchange",
    "order.created",
    event
);
```
#### Step 3: Create Consumer (If Required)
```
@RabbitListener(queues = "order.created.queue")
public void consume(OrderCreatedEvent event) {
}
```
### 6.9 Security (Optional)
#### Step 1: Enable Security Configuration
Security components exist but are not enforced by default.

#### Step 2: Secure Endpoints
```.anyRequest().authenticated()```
#### Step 3: Send JWT Token

```Authorization: Bearer <jwt-token>```

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
