# 📧 Notification Service (Spring Boot)

A lightweight **email notification microservice** built with **Spring Boot**.  
Supports asynchronous email sending via SMTP and is fully configurable for any SMTP provider.

---

## 🚀 Features
- Send plain-text emails using SMTP
- Asynchronous sending with `@Async` for better performance
- RESTful API endpoints
- Easily forkable and configurable
- Works with Gmail, Outlook, and custom SMTP providers

---

## 🛠 Tech Stack
- **Java 21**
- **Spring Boot**
- **Spring Mail (JavaMailSender)**
- **Maven**

---

---

## ⚙️ Setup Instructions

### 1️. Clone the Repository
Open your terminal (bash).
```bash
git clone https://github.com/sarv-projects/notification-service.git
cd notification-service
Set  the environment variables in your teminal
##2.
```bash
export MAIL_USERNAME=youremail@example.com
export MAIL_PASSWORD=yourpassword
##3.Run the service
```bash
mvn spring-boot:run


##4.Test the API
```bash
curl -X POST http://localhost:8080/api/notifications/send-email \
-H "Content-Type: application/json" \
-d '{"to":"recipient@example.com","subject":"Hi","body":"messageexample"}'
