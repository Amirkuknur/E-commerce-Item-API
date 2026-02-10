# E-commerce Item API (Sample Task)

This is a simple Spring Boot REST API built as per the assignment requirement.  
It manages e-commerce items with in-memory storage using an ArrayList.

---

## 🚀 Features

- Add a new item  
- Get item by ID  
- Input validation  
- In-memory data store  
- Lightweight & easy to deploy  

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 
- Maven
- Lombok

---

## ▶️ How to Run

### 1. Clone or download the project
```bash
git clone <https://github.com/Amirkuknur/E-commerce-Item-API.git>
2. Run the project
mvn spring-boot:run
API will start at:

http://localhost:8080
🌐 API Documentation
➤ Add Item
POST /add
Body Example:

{
  "name": "Smartphone",
  "description": "5G Android Phone",
  "price": 29999,
  "category": "Electronics"
}
➤ Get Item by ID
GET /item/{id}
