

# POC

This a Java web application with the essential features: user registration, login, logout and view users list (edit user and delete user) with user information stored in MySQL database.

## Welcome page
![1681794015375](https://user-images.githubusercontent.com/34713501/232699181-c86feefa-3ba0-4f8e-9c59-1022cd0845dd.png)


## List all users

1. If user wants to access the user database, user must login first enforced by spring security.
![1682493874705](https://user-images.githubusercontent.com/34713501/234500752-55b5497e-7756-4ea1-85e4-6b5a6197f6d6.png)


2. GET ALL 

![1681794391198](https://user-images.githubusercontent.com/34713501/232699381-b09b94b2-0561-4b05-a794-2cd190c5f92b.png)

![1681795410861](https://user-images.githubusercontent.com/34713501/232699595-84cffd36-66cd-4344-af44-1cf29b23a9f9.png)



3. Click Edit to update user info by GET method.

![1681794986375](https://user-images.githubusercontent.com/34713501/232699674-1baa6b9c-86b0-4605-a31d-c086dacb0504.png)

![1681795230882](https://user-images.githubusercontent.com/34713501/232699753-698a5744-b578-4c82-a402-7c856bf9c799.png)

![1681795262465](https://user-images.githubusercontent.com/34713501/232699834-09ac6969-ac0a-46f0-b67d-e44462343605.png)


4. Click delete to remove a user from database.

![1681795123380](https://user-images.githubusercontent.com/34713501/232699964-59b80c5d-caae-4c72-9c63-c0a4b3afbb7f.png)


## Register page

Password is encrypted by BCryptPasswordEncoder.

![1681794441332](https://user-images.githubusercontent.com/34713501/232700090-afac332e-5397-44e5-a399-955074f4f072.png)

![1681794670520](https://user-images.githubusercontent.com/34713501/232700153-d48cc16d-c584-4509-b1ed-c333774a9e3a.png)

User logins the user name and password store in the MySQL database by the POST operation.

## Login page

![1681794468062](https://user-images.githubusercontent.com/34713501/232700293-b52ca436-e4e0-4722-b4dd-1c14c4acbbca.png)

## jwt Authentication
User can use authenticate api to retrive a jwt token to get authentication to asscess edit/update/delete
![1682493212902](https://user-images.githubusercontent.com/34713501/234498216-ac27d883-74d7-4acb-b675-0c312479235c.png)

A example of edit with authorization header with jwt token.
![1682493249263](https://user-images.githubusercontent.com/34713501/234498427-06d6fe41-9909-4771-854c-c80032cc065b.png)

## Unit Test

Tests for create user and find user by email

![1681795532730](https://user-images.githubusercontent.com/34713501/232700357-b5b96153-6f44-4242-93a2-683b202e2b49.png)


## API test by Postman
Test for list api
![1682453577753](https://user-images.githubusercontent.com/34713501/234392132-11f11f38-1930-43fe-b873-f9c5d1b0f8e1.png)



