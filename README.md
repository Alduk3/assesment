# Coupon Management System

## Overview

The Coupon Management System is a robust API designed to handle the management and redemption of discount coupons for an e-commerce platform. Built using Java and Spring Boot, this system will streamline the process of creating, managing, and redeeming coupons.

## Features

- **User Management**:
  - Register users

- **Coupon Management**:
  - Create and list coupons
  - Modify and delete unused coupons
  - Verify coupon validity (expiration date, status)

- **Coupon Redemption**:
  - Allow users to redeem coupons during purchases
  - View coupon redemption history by user

- **Product Management**:
  - List products

## Business Rules

- A user can redeem a coupon only once.
- Each coupon must have a unique code, expiration date, and discount percentage.
- To redeem a coupon, the user ID and product ID are required.
- Upon redemption, update the user’s redemption history and provide the new product price.
- The system must have at least 10 products in the database upon startup.

## API Endpoints

### User Management

- **Register User**
  - `POST /users/register`
  - **Description**: Register a new user.

### Coupon Management

- **Create Coupon**
  - `POST /coupons`
  - **Description**: Create a new coupon.

- **List Coupons**
  - `GET /coupons`
  - **Description**: Retrieve a list of all coupons.

- **Update Coupon**
  - `PUT /coupons/{id}`
  - **Description**: Modify an existing coupon.

- **Delete Coupon**
  - `DELETE /coupons/{id}`
  - **Description**: Delete a coupon if it has not been used.

- **Validate Coupon**
  - `GET /coupons/{id}/validate`
  - **Description**: Validate a coupon's expiration date and status.

### Coupon Redemption

- **Redeem Coupon**
  - `POST /redemptions`
  - **Description**: Redeem a coupon for a purchase.

### Product Management

- **List Products**
  - `GET /products`
  - **Description**: Retrieve a list of all products.
