Here’s a **complete README.md** with *everything* inside so someone can just land, scroll, and run without hunting for extra files.

````markdown
# 📧 Notification Service (Spring Boot)

A lightweight **email notification microservice** built with **Spring Boot**.  
Supports asynchronous email sending via SMTP and is fully configurable for any SMTP provider.

---

##  Features
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

## ⚙️ Quick Start

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/sarv-projects/notification-service.git
cd notification-service
````

---

### 2️⃣ Set Environment Variables

```bash
export MAIL_USERNAME=youremail@example.com
export MAIL_PASSWORD=yourpassword
```

> **Note:**
>
> * For Gmail, use an **App Password**, not your main account password.
> * For Windows PowerShell:
>
> ```powershell
> setx MAIL_USERNAME "youremail@example.com"
> setx MAIL_PASSWORD "yourpassword"
> ```

---

### 3️⃣ Run the Service

```bash
mvn spring-boot:run
```

---

### 4️⃣ Test the API

```bash
curl -X POST http://localhost:8080/api/notifications/send-email \
-H "Content-Type: application/json" \
-d '{"to":"recipient@example.com","subject":"Hi","body":"messageexample"}'
```

---

## 📂 Project Structure

```
notification-service/
 ├── src/main/java/com/sarvesh/notificationservice/
 │    ├── controller/      # REST API endpoints
 │    ├── service/         # Email sending logic
 │    └── NotificationServiceApplication.java
 ├── pom.xml               # Maven dependencies
 └── README.md
```

---

## 🔧 Configuration

In `application.properties` (already included in this repo), SMTP properties are read from environment variables:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=${MAIL_USERNAME}
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

No passwords or private data are stored in the repo.

---

## 🧪 API Endpoints

**POST** `/api/notifications/send-email`
Request body:

```json
{
  "to": "recipient@example.com",
  "subject": "Hello",
  "body": "This is a test email"
}
```

Response:

```json
{
  "status": "Email sent successfully"
}
```

---





