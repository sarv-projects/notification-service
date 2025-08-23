# 📧 Notification Service 

A lightweight **email notification microservice** built with **Spring Boot**. Supports sending asynchronous emails via SMTP and is fully configurable for any SMTP provider.

## ✨ Features
- Send plain-text emails using SMTP
- Asynchronous sending with @Async for improved performance
- Well-defined RESTful API with JSON payloads
- Easily configurable for different environments
- Works with common providers like Gmail, Outlook, and custom SMTP servers

## 🛠 Tech Stack
- Java 21
- Spring Boot
- Spring Mail (JavaMailSender)
- Maven

## ⚙️ Quick Start
1. Clone the Repository  
   git clone https://github.com/sarv-projects/notification-service.git  
   cd notification-service

2. Configure Environment Variables  
   On Linux/Mac:
   export MAIL_USERNAME=youremail@example.com  
   export MAIL_PASSWORD=your_app_password  

   On Windows (PowerShell):  
   setx MAIL_USERNAME "youremail@example.com"  
   setx MAIL_PASSWORD "your_app_password"

   **Note:** For Gmail, you must use an App Password instead of your main account password.

3. Run the Service  
   mvn spring-boot:run

4. Test the API with cURL  
   curl -X POST http://localhost:8080/api/notifications/send-email -H "Content-Type: application/json" -d "{\"to\":\"recipient@example.com\",\"subject\":\"Hello from my service!\",\"body\":\"This is a test email message.\"}"

## 📂 Project Structure
notification-service/  
 ├── src/main/java/com/sarvesh/notificationservice/  
 │   ├── controller/        # REST API endpoints  
 │   ├── service/           # Email sending logic  
 │   ├── dto/               # Data Transfer Objects (DTOs)  
 │   └── NotificationServiceApplication.java  
 ├── pom.xml                # Maven dependencies  
 └── README.md

## 🔧 Configuration (application.properties)
spring.mail.host=smtp.gmail.com  
spring.mail.port=587  
spring.mail.username=${MAIL_USERNAME}  
spring.mail.password=${MAIL_PASSWORD}  
spring.mail.properties.mail.smtp.auth=true  
spring.mail.properties.mail.smtp.starttls.enable=true

## 🧪 API Endpoints

### POST /api/notifications/send-email
Sends an email using the details provided in a JSON request body.

**Request Body (NotificationRequest DTO):**  
{ "to": "recipient@example.com", "subject": "Hello", "body": "This is a test email" }

**Success Response (200 OK - NotificationResponse DTO):**  
{ "success": true, "message": "Email sent successfully to recipient@example.com" }

**Error Response (500 Internal Server Error - NotificationResponse DTO):**  
{ "success": false, "message": "Failed to send email: [specific error message]" }
