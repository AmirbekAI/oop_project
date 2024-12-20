# Donation Management System

A Spring Boot application for managing donations, campaigns, and donors. This system allows organizations to create fundraising campaigns, track donations, and generate detailed receipts.

## 🚀 Live Demo
The application is deployed at: https://oop-project-fnpv.onrender.com

## 📋 Features
- Campaign Management
- Donor Registration
- Donation Tracking
- Receipt Generation
- Real-time Campaign Progress Tracking

## 🛠 Tech Stack
- Java 21
- Spring Boot 3.x
- PostgreSQL
- Gradle
- JPA/Hibernate

## 🔗 API Endpoints

### Campaigns
- **GET /api/campaigns** - Get all campaigns
- **GET /api/campaigns/{id}** - Get specific campaign
- **POST /api/campaigns** - Create new campaign
  ```json
  {
      "title": "Campaign Title",
      "description": "Campaign Description",
      "startDate": "2024-03-14T00:00:00",
      "endDate": "2024-12-31T23:59:59",
      "targetAmount": 10000
  }
  ```
- **PUT /api/campaigns/{id}** - Update campaign
- **DELETE /api/campaigns/{id}** - Delete campaign

### Donors
- **GET /api/donors** - Get all donors
- **GET /api/donors/{id}** - Get specific donor
- **POST /api/donors** - Create new donor
  ```json
  {
      "name": "John Doe",
      "email": "john@example.com",
      "phoneNumber": "1234567890"
  }
  ```
- **PUT /api/donors/{id}** - Update donor
- **DELETE /api/donors/{id}** - Delete donor

### Donations
- **GET /api/donations** - Get all donations
- **GET /api/donations/{id}** - Get specific donation
- **GET /api/donations/campaign/{campaignId}** - Get donations by campaign
- **GET /api/donations/donor/{donorId}** - Get donations by donor
- **POST /api/donations** - Create new donation
  ```json
  {
      "amount": 100.00,
      "donationDate": "2024-03-14T10:00:00",
      "donor": {
          "id": 1
      },
      "campaign": {
          "id": 1
      }
  }
  ```
- **DELETE /api/donations/{id}** - Delete donation

### Receipts
- **GET /api/receipts/donor/{donorId}** - Get donor receipt
- **GET /api/receipts/campaign/{campaignId}** - Get campaign receipt

## 📝 Database Schema

### Campaign
- `id` (Long) - Primary key
- `title` (String) - Campaign title
- `description` (String) - Campaign description
- `startDate` (LocalDateTime) - Campaign start date
- `endDate` (LocalDateTime) - Campaign end date
- `targetAmount` (BigDecimal) - Campaign target amount
- `donations` (List<Donation>) - List of donations for this campaign

### Donor
- `id` (Long) - Primary key
- `name` (String) - Donor's name
- `email` (String) - Donor's email
- `phoneNumber` (String) - Donor's phone number
- `donations` (List<Donation>) - List of donations made by this donor

### Donation
- `id` (Long) - Primary key
- `amount` (BigDecimal) - Donation amount
- `donationDate` (LocalDateTime) - Date and time of donation
- `donor` (Donor) - Reference to donor
- `campaign` (Campaign) - Reference to campaign

## 🚀 Setup and Installation

### Prerequisites
- Java 21
- PostgreSQL
- Gradle

### Local Development
1. Clone the repository