# store-backend

Backend for a simple store

## Table of contents

* [General Info](#general-info)
    * [Project definition](#project-definition)
    * [Features](#features)
* [Technologies](#technologies)
    * [Database Model](#database-model)
    * [Class Diagram](#class-diagram)
    * [Dependencies](#dependencies)
* [Api Endpoints](#api-endpoints)

## General info

### Project definition

Simple store without payment option (for now) built for a friend's mom

### Features

- CRUD operations with ArtPiece-& Category-objects in the PostgreSQL database

## Technologies

- Java 17
- Java Spring Boot 2.6.6
- PostgreSQL as database

### Database Model

![alt.text](./src/main/resources/static/DatabaseModel.png)

### Class Diagram

![alt.text](./src/main/resources/static/ShopBackendClassdiagram.png)

### Dependencies

```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
	</dependencies>
```

## Api Endpoints

Base URL: ```https://mighty-spire-02089.herokuapp.com/``` (hosted)

### Insert Item

```http
POST /art
```

|Body-parameter | Type | Description |
| :--- | :--- | :---|
| name | String | Name of the item |
| prize | Float | Price of the item |
| imagelink | String | Link to an image of the item |
| description | String | Description of the item |
| categoryDbo | String | Category of the item |

### Get All Items

```http
GET /art/all
```

Response:

```json
[
  {
    "id": "string",
    "name": "string",
    "prize": "float",
    "imagelinke": "string",
    "description": "string",
    "categoryDbo": "string"
  }
]
```

### Get By ID

```http
GET /art/id/{id}
```

|Body-parameter | Type | Description |
| :--- | :--- | :---|
| id | String | ID of the requested item |

```json
{
    "id": "string",
    "name": "string",
    "prize": "float",
    "imagelink": "string",
    "description": "string",
    "categoryDbo": "string"
  }
```

### Get All Categories

```http
GET /categories/all
```

```json
{
    "id": "string",
    "categoryname": "string"
  }
```

### Delete By ID

```http
DELETE /art/{id}
```

|Body-parameter | Type | Description |
| :--- | :--- | :---|
| id | String | ID of the requested item |

### Delete All Artpieces

```http
DELETE /art
```

### Get all Orders

```http
GET /orders/all
```

```json
[
  {
    "ordereditemid": "int",
    "total": "float",
    "customeremail": "String",
    "orderedattimestamp": "long",
    "fullfilled": "boolean"
  }
]
```

### Get Order by ID

```http
GET /orders/{id}
```

|Body-parameter | Type | Description |
| :--- | :--- | :---|
| id | String | ID of the requested orderDbo |

```json
{
    "ordereditemid": "int",
    "total": "float",
    "customeremail": "String",
    "orderedattimestamp": "long",
    "fullfilled": "boolean"
  }
```

### Create new Order

```http
POST /orders
```



