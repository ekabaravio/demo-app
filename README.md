This is a simple demo app, a RESTful API that allows users to create, retrieve, update, and delete notes. Each note can consist of a title and a body. Applied Login with JWT Authentication and Authorization
<br><br>
To see complete list of URL, you may see swagger here:<br>
http://localhost:8080/swagger-ui.html<br>
<br>
**Tech Used**<br>
Java, Spring Boot, JWT, H2 Database<br>
<br>
**Note API URL List**<br>
**Login**<br>
Authenticate: localhost:8080/auth/authenticate<br>
Signup: /auth/signup<br>
Number of Users (Public): /public/numberOfUsers<br>
Number of Notes (Public): /public/numberOfNotes<br>
User Details (Admin and User): /api/users/me<br>
Get User Details (Admin Only): /api/users/admin<br>
Delete User Details (Admin Only): /api/users/user<br>

**Notes**<br>
Retrieve Note List (Admin Only): /notes<br>
Retrieve Note By Id Details (Admin Only): /notes/:id<br>
Create Note (Admin and User): /notes<br>
Update Note (Admin Only): /notes/:id<br>
Delete Note (Admin Only): /notes/:id<br>
<br>
You may download Postman Collection here: https://drive.google.com/file/d/1SJJzAD6p9YKnY2YQF-_OC7Z8hZ8UZjdy/view?usp=drive_link
