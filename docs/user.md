# User API 

## Register User

End point : POST /api/users/register

Request Body :

```json
{
  "name" : "nidhom",
  "email" : "nidhom@gmail.com",
  "passwrod" : "rahasia",
  "phone" : "123456789",
  "name_card" : "nidhom",
  "credit_card_number": "098765",
  "credit_card_expired_date" :"2023-12-12"
}
```

Response Body (Success) :

```json
{
  "data" : "Successfully registered"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Failed to register"
}
```

## Login User

End Point : POST /api/auth/login

Request Body :

```json
{
  "email": "nidhom@gmail.com",
  "password": "rahasia"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 23621731209
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "email or password wrong"
}
```

## Get User

Endpoint : GET /api/users/profile

Request Header :

- X-API-TOKEN or Bearer Token

Response Body (Success) :

```json
{
  "name" : "nidhom",
  "email" : "nidhom@gmail.com",
  "passwrod" : "rahasia",
  "phone" : "123456789",
  "name_card" : "nidhom",
  "credit_card_number": "098765",
  "credit_card_expired_date" :"2023-12-12"
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/update

Request Header :

- X-API-TOKEN or Bearer Token

Request Body :

```json
{
  "name" : "nidhom",
  "email" : "nidhom@gmail.com",
  "passwrod" : "rahasia",
  "phone" : "123456789",
  "name_card" : "nidhom",
  "credit_card_number": "098765",
  "credit_card_expired_date" :"2023-12-12"
}
```

Reponse Body (Success) :

```json
{
  "name" : "nidhom",
  "email" : "nidhom@gmail.com",
  "passwrod" : "rahasia",
  "phone" : "123456789",
  "name_card" : "nidhom",
  "credit_card_number": "098765",
  "credit_card_expired_date" :"2023-12-12"
}
```
Response Body (Failed) :

```json
{
  "errors" : "Unauthorized"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN or Bearer Token

Response Body (Success) :

```json
{
  "data" : "Logout Success"
}
```
