<img src="https://github.com/diasandre/which-episode-to-watch-again/blob/master/src/img/logo.png?raw=true"/>

# `which-episode-to-watch-again-api`

It's working fine but the new heroku policies made it impossible to deploy so i migrated everything to use aws lambda
https://github.com/diasandre/which-episode-to-watch-again-lambda

## Requirements 

- Spring Boot
- Mongo DB

## Environment variables
- MONGO_LOGIN
- MONGO_PASSWORD
- MONGO_URL = xxx.mongodb.net\
- -Djdk.tls.client.protocols=TLSv1.2

## Requests (Without BASIC AUTH)

### Get random episode from tv show

`GET /random/{tvShowId}`

#### Response

{
"id": Long,
"tvShow": Long,
"title": String?
}

### Get tv shows

`GET /tv-shows/`

#### Response

[{
"id": Long,
"title": String
}]

## Requests (BASIC AUTH)

### Get all episodes of tv show

`GET /episodes/{tvShowId}`

#### Response

[{
"id": Long,
"tvShow": Long,
"title": String?
}]

### Save episodes to one tv show

`POST /episodes/{tvShowId}`

#### Body

[{
"id": Long,
"tvShow": Long?,
"title": String
}]

### Save tv show

`POST /tv-shows/save`

#### Body

{
"id": Long,
"title": String
}

### Create user

`POST /user/`

#### Body

{
"id": String,
"email": String,
"password: String,
"role": String (ROLE_ADMIN, ROLE_USER)
}
