# 💰 Banking Management System (Spring Boot REST API)

A simple **Banking REST API** built using **Spring Boot**, **MySQL**, and **Spring Data JPA**.  
This project allows you to manage **Accounts** and **Transactions** — including creating accounts, transferring money, and fetching transaction history.

---

## 🧰 Tech Stack

- **Backend:** Spring Boot 3.x  
- **Database:** MySQL  
- **ORM:** Spring Data JPA (Hibernate)  
- **Language:** Java 17+  
- **Build Tool:** Maven  
- **Testing Tool:** Postman (for API testing)

---

## 📁 Project Structure

```
com.banking
│
├── controller
│   ├── AccountController.java
│   └── TransactionController.java
│
├── model
│   ├── Account.java
│   ├── Transaction.java
│   └── TransferRequest.java
│
├── repository
│   ├── AccountRepo.java
│   └── TransactionRepo.java
│
├── service
│   ├── AccountService.java
│   └── TransactionService.java
│
└── BankingApplication.java
```

---

## ⚙️ Features

### 🏦 Account Management
- Create a new account  
- Fetch account details by ID  
- Fetch all accounts  
- Update account balance (deposit/withdraw)  
- Link/Update Customer ID  

### 💸 Transaction Management
- Transfer money between accounts  
- View transaction by ID  
- View all transactions of an account  
- View transactions within a specific date range  

---

## 🔧 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/BankingRestAPI.git
cd BankingRestAPI
```

### 2. Configure MySQL Database
- Create a new MySQL database:
```sql
CREATE DATABASE banking_db;
```

- Update your `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
```

### 3. Build and Run the Project
```bash
mvn clean install
mvn spring-boot:run
```

Your application will start on **http://localhost:8080**

---

## 🚀 API Endpoints

### 🏦 Account APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/accounts/createAccount` | Create a new account |
| GET | `/accounts/getAccount/{id}` | Get account details by ID |
| GET | `/accounts/getAllAccounts` | Fetch all accounts |
| PUT | `/accounts/{id}/deposit/{amount}` | Deposit amount into account |
| PUT | `/accounts/{id}/updateCustId/{custId}` | Update customer ID |

#### 🧾 Example: Create Account (POST)
```json
{
  "accountNumber": "1234567890",
  "balance": 10000.00,
  "customerId": 1
}
```

---

### 💸 Transaction APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| POST | `/transactions/transfer` | Transfer amount between accounts |
| GET | `/transactions/byTransactionId/{tid}` | Get transaction details by ID |
| GET | `/transactions/history/{accountId}` | Get transaction history by account ID |
| GET | `/transactions/history/{accountId}/daterange` | Get transaction history by account ID within date range |

#### 🧾 Example: Transfer Amount (POST)
```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 500.00
}
```

#### Example: Get Transaction by Date Range (GET)
```
/transactions/history/1/daterange?startDate=2025-11-01T00:00:00&endDate=2025-11-08T23:59:59
```

---

## 🧪 Testing the APIs
You can test all endpoints using:
- **Postman**
- **cURL**
- **Swagger UI** (if added later)

---

## 🧱 Future Enhancements
- Add JWT Authentication for secure access  
- Add Role-based access (Admin, Customer)  
- Implement Transaction Reversal API  
- Integrate Email Notification for transfers  
- Add Swagger API Documentation  

---

## 🤝 Contributing
Pull requests are welcome. For major changes, please open an issue first  
to discuss what you would like to change.

---

## 🧑‍💻 Author
**Rohit Dande**  
📧 [your.email@example.com]  
🌐 GitHub: [github.com/yourusername](https://github.com/yourusername)

---

## 🪪 License
This project is licensed under the **MIT License** – you’re free to use, modify, and distribute it with attribution.
