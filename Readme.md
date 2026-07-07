# Blues Backend Service

Hệ thống Backend cốt lõi cho siêu ứng dụng **Blues**, được xây dựng trên kiến trúc **Microservices** để đảm bảo khả năng mở rộng, tính độc lập và hiệu năng cao.

## 🏗 Kiến trúc Hệ thống
Dự án được cấu trúc theo dạng **Maven Multi-module Project**, giúp dễ dàng quản lý dependencies và chia sẻ logic giữa các service.



[Image of microservices architecture diagram]


## 🛠 Tech Stack
- **Framework:** Spring Boot 4.x, Spring Cloud.
- **Database:** PostgreSQL (Primary), Redis (Caching).
- **Communication:** RESTful API, RabbitMQ (Asynchronous Events).
- **Security:** Spring Security, JWT (JSON Web Token).
- **Containerization:** Docker & Docker Compose.

## 📦 Cấu trúc Modules
- `common-lib`: Thư viện dùng chung (DTO, Exceptions, Security Config).
- `gateway-service`: Cổng giao tiếp duy nhất, quản lý định tuyến và xác thực Token.
- `identity-service`: Quản lý người dùng, xác thực (Auth/OTP/OAuth2).
- `social-service`: Feed bài viết, Chat thời gian thực (WebSocket).
- `trader-service`: Quản lý sàn giao dịch và đơn hàng.
- `storage-service`: Quản lý tệp tin và quyền truy cập file.

## 🚀 Hướng dẫn khởi động
1. Clone dự án: `git clone <repo-url>`
2. Đảm bảo đã cài đặt Docker.
3. Chạy lệnh: `docker-compose up -d`
4. Hệ thống sẽ khởi động các container Database, Redis và các Service của bạn.

## 📝 Quy trình Git
- `main`: Nhánh production.
- `develop`: Nhánh tích hợp cho dev.
- `feature/*`: Nhánh phát triển tính năng mới.

## 📁 Code Structure
**Identity Service**
```
src/main/java/com/blues/identity/
├── config/              # Các cấu hình: Security, JPA, Swagger, v.v.
├── controller/          # Định nghĩa các REST API endpoints
├── dto/                 # Các đối tượng truyền dữ liệu (Request/Response)
│   ├── request/         # DTO cho input (LoginRequest, RegisterRequest...)
│   └── response/        # DTO cho output (UserResponse, TokenResponse...)
├── entity/              # Các JPA Entities (User, UserProfile, Role, Permission)
├── repository/          # Giao tiếp với Database (JPA Interfaces)
├── service/             # Chứa logic nghiệp vụ chính
│   └── impl/            # Các class cài đặt chi tiết của Service
├── exception/           # Xử lý ngoại lệ toàn cục (Global Exception Handler)
├── mapper/              # Chuyển đổi giữa Entity <-> DTO (dùng MapStruct)
└── IdentityApplication.java # Entry point của ứng dụng
```