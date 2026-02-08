#  Microservices Using Spring Boot for Humanitarian Aid

---

This project is a **microservices-based application built using Spring Boot** to demonstrate the practical implementation of a distributed system architecture.

The application focuses on a **humanitarian aid domain** as a use case, but it is **not dedicated to any real organization**. Instead, it serves as an **educational and technical example** of how microservices can be designed, implemented, and integrated.

The system is composed of multiple independent microservices, each responsible for a specific business capability such as **beneficiaries management** and **financial services**. Service communication and coordination are handled using **Eureka Service Discovery** and an **API Gateway**, ensuring scalability, flexibility, and loose coupling between services.

This project is intended for **learning purposes** and as a reference for developers who want to understand **microservices architecture using Spring Boot**.

---

##  How to Run the Project (Using Apache NetBeans)

To run this microservices project successfully, please follow the steps below.  
 **Apache NetBeans IDE is required** to open and run the services.


##  Prerequisites

- Java JDK 17 (or compatible version)
- Apache NetBeans IDE
- Maven
- Internet connection (for dependency downloads)


## Steps

### 1️⃣ Open Apache NetBeans
- Launch **Apache NetBeans IDE**
- Click on **File → Open Project**
- Select the cloned project folder


### 2️⃣ Load Maven Projects
- NetBeans will automatically detect all microservices as **Maven projects**
- Wait until all dependencies are downloaded successfully  
  ⏳ (This may take a few minutes on the first run)


### 3️⃣ Run the Eureka Discovery Service
- Locate the `registery` (**Eureka Server**) project
- Right-click on it → **Run**
- Make sure the Eureka Server is running before starting any other service


### 4️⃣ Run the API Gateway
- Locate the `clude-gateway` project
- Right-click → **Run**
- The API Gateway will handle routing requests to the registered microservices


### 5️⃣ Run the Microservices
- Start each microservice one by one (e.g. `Beneficiariesservice`, `Financeservice`)
- Right-click on each service → **Run**
- Ensure that each service registers successfully in the Eureka Dashboard


### 6️⃣ Verify Services
- Open a browser and access the Eureka Dashboard:
```text
http://localhost:8761
