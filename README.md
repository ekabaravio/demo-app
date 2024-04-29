This is a simple demo app, a RESTful API that allows users to create, retrieve, update, and delete notes. Each note can consist of a title and a body. Applied Login with JWT Authentication and Authorization

To see complete list of URL, you may see swagger here:
http://localhost:8080/swagger-ui.html

**Note API URL List**
**Login**
Authenticate: localhost:8080/auth/authenticate
Signup: /auth/signup
Number of Users (Public): /public/numberOfUsers
Number of Notes (Public): /public/numberOfNotes
User Details (Admin and User): /api/users/me
Get User Details (Admin Only): /api/users/admin
Delete User Details (Admin Only): /api/users/user

**Notes**
Retrieve Note List (Admin Only)t: /notes
Retrieve Note By Id Details (Admin Only): /notes/:id
Create Note (Admin and User): /notes
Update Note (Admin Only): /notes/:id
Delete Note (Admin Only): /notes/:id
