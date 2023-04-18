

# POC

This a Java web application with the essential features: user registration, login, logout and view users list (edit user and delete user) with user information stored in MySQL database.

## Welcome page

![1681794015375](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794015375.png)

## List all users

1. If user wants to access the user database, user must login first enforced by spring security.

![1681794845560](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794845560.png)

2. GET ALL 

![1681794391198](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794391198.png)

![1681795410861](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681795410861.png)

3. Click Edit to update user info by GET method.

![1681794986375](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794986375.png)

![1681795230882](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681795230882.png)

![1681795262465](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681795262465.png)

4. Click delete to remove a user from database.

   ![1681795123380](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681795123380.png)

## Register page

Password is encrypted by BCryptPasswordEncoder.

![1681794441332](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794441332.png)

![1681794670520](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794670520.png)

User logins the user name and password store in the MySQL database by the POST operation.

## Login page

![1681794468062](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681794468062.png)



## Unit Test

Tests for create user and find user by email

![1681795532730](D:\WeChat\WeChat Files\yjs0791\FileStorage\Temp\1681795532730.png)

API test by Postman

