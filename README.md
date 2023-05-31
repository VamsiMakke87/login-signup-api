# login-signup-api

- This is a backend API built using Spring Boot and Spring Security.
- Contains two APIs signup and login
- A token is generated for authorised requests and for unauthorised requests HttpStauts 403 is returned



**Spring Boot Verison:** 3.1.0

**Java Version:** Java 17

## Steps to run the api

- Clone the repository using ``` git clone https://github.com/VamsiMakke87/login-signup-api-spring-boot ```
- Import the project in Spring Tool Suite.
- create a database ```loginapi``` in MySQL
- Run the project in Spring Tool Suite


### Signup

- URL: ``` http://localhost:8080/api/signup ```
```
Body:

  {
    "firstname":"vamsi",
    "email":"vamsi@gmail.com",
    "password":"1234"
  }

```

### Login

- URL: ``` http://localhost:8080/api/login ```
```
Body:

  {
    "email":"vamsi@gmail.com",
    "password":"1234"
  }

```



