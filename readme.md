# School Spring App

This project has the following technologies

- Flyway maven plugin for db migrations
- JPA for the interaction with the database
- Spring Boot framework
- Thymeleaf

----

## How to run this project

In order to run this project, the user must execute the flyway migration sql scripts, via the command

```
mvn flyway:migrate
```

All the sql scripts are located at <root-of-project>\src\main\resources\db\migration in case the user chooses to execute
them by hand

The command to run the spring boot application is the following:

```
mvn spring-boot:run
```

----

## Security

All the users are located in the users table, and the password to log in in every one of them is <b>1234</b>

In case the user chooses to make changes, he\she can use the utility classes <b>PasswordHashChecker</b> and <b>
PasswordHashGenerator</b>

---

## Crud operations

The crud operations happen in the admin account

```
username: jdoe@test.com
password: 1234
```

in the /admin page

The other pages (/teacher and /student are basic)


