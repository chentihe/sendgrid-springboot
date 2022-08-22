# sendgrid-springboot

## Send Grid
[Send Grid](https://sendgrid.com/) is a cloud-based service that assists businesses with email delivery.
1. Create an account
2. Setup a Single Sender Verification
3. Create a API Key
4. Create a Dynamic Template (you can edit the template on Send Grid and send email to users with specific template)

## Spring Boot
1. Create a Spring Boot project via [Spring Initializr](https://start.spring.io/)

2. Add Spring Web & Spring Boot DevTools dependencies

3. Add SendGrid dependency via maven repository
  - setup YAML config file
  - create YAML Config Bean

## Deploy on Heroku with Docker
1. Create an app on Heroku

2. Open the terminal and navigate to the root directory

3. Execute `mvn clean package` to package the project

4. Setup the environment variables on your heroku app

![image](https://user-images.githubusercontent.com/48288259/185825473-806ffffd-4ea9-48b7-8c26-6b737647fbd5.png)

5. Login Heroku CLI

```
$ heroku login
$ heroku container:login
```

6. Push your project on Heroku Registry

```
$ heroku container:push web -a {your heroku app name}
```

7. Release your project

```
$ heroku container:release web -a {your heroku app name}
```
