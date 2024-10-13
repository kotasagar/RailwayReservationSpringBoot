# Railway Management System

A comprehensive railway management system designed to handle train availability, seat booking, and user management, similar to IRCTC. This application allows users to check train schedules, view seat availability, and book seats, all while ensuring real-time operations and handling race conditions effectively.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- **User Registration:** Register new users with basic details.
- **User Login:** Secure login functionality for users.
- **Admin Functions:** Admins can add new trains and update seat availability.
- **Train Availability:** Users can check for trains between two stations and view seat availability.
- **Seat Booking:** Users can book seats if available, with proper handling of simultaneous bookings.
- **Booking Details:** Users can retrieve their booking details.

## Tech Stack

- **Web Framework:** Java (Spring Boot)
- **Database:** MySQL
- **Build Tool:** Maven
- **DataBase:** MySQL
- **Api Tool:** Postman


## Installation

Follow these steps to set up the project locally:

1. Clone the repository:<br/>
   ```bash
   git clone https://github.com/kotasagar/RailwayReservationSpringBoot/railway-management-system.git
   cd railway-management-system
Install dependencies:

For Python:<br/>
pip install -r requirements.txt

For Node.js:<br/>
npm install

Set up the database:<br/>
Create a MySQL database and configure the connection settings in the application.

## Usage
Run the Application:

For Java:<br/>
Run Project as SpringBootApp in Spring Tool Suite

For Node.js:<br/>
node server.js

Access the application at http://localhost:8080 (or the port your application is running on).

## API Endpoints

- **User Registration**
POST /api/register
Registers a new user.
- **User Login**
POST /api/login
Authenticates a user and returns an authorization token.
- **Add a New Train (Admin)**
POST /api/admin/train
Creates a new train with source and destination (API key required).
- **Get Seat Availability**
GET /api/seats?source={source}&destination={destination}
Fetches trains and seat availability for a given route.
- **Book a Seat**
POST /api/book
Books a seat on a specified train (Authorization token required).
- **Get Specific Booking Details**
GET /api/booking/{bookingId}
Retrieves booking details (Authorization token required).


## Contributing
Contributions are welcome! Please follow these steps:

1.Fork the repository <br/>
2.Create a new branch (git checkout -b feature-branch)<br/>
3.Make your changes<br/>
4.Commit your changes (git commit -m 'Add new feature')<br/>
5.Push to the branch (git push origin feature-branch)<br/>
6.Create a new Pull Request


## Contact
Kota Sagar - sagarkota008@gmail.com

Project Link: https://github.com/kotasagar/RailwayReservationSpringBoot


Feel free to customize it further to match your project's specific details and style!
