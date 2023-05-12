# Vision

What is the vision of this product?

- The vision of our product is to allow users to sign up and login to the application and view active properties for sale and favorite the properties. Users can also filter out various property features.  

What pain point does this project solve?

- Our project will allow for users to gain access to the Relational Database with ease of access to the home buying search without being overwhelmed by too much information within a website.

Why should we care about your product?

- It will be an informative, creative, and useful website that will allow users to find a property with the features and amenities that they desire.

## Scope (in/out)

IN

- Our website will provide information to users by the use of a JSON file of our property listings

- It will allow agents to create and edit listings.

- Users will be able to login through Auth0 to find all their previously viewed listings to update or delete them.

- Agents will be able to login through Auth0 to view users saved listings.

- Admins will be able to login and moderate Agents and user data.

- Users will be able to search for specific listings.

- (stretch) Users will be able to 'heart' properties

OUT

- This website will never be ported into an IOS or Android Application.
- This website will never sell user's information.
- This website will not be monetized to force user's to pay to access the material.

## MVP (minimum viable product) & Stretch Goals

- Our MVP will consist of a functioning Front End that allows Agents to get, post, put, and delete listings which will all be stored in a local database. Which will be connected through Postgres to our front end of the application

- Some of our stretch goals will be to add additional features and search filter options

## Data Flow

- The flow of our data will allow users to utilize the view feature in our MVC application where models will be created based on listings and allow access to agents and admin to implement CRUD within our local database.

![data flow](./data%20flow.png)

## Non-functional requirements

- For security will be implementing Spring Security to allow Agents security for their created and edits to listings.

- We will be utilizing the CRUD model for testing purposes.  We want to ensure that Agents can create, update, delete, and retrieve the listings that have been created.  We want this to have full functionality so users can have access to the most up-to-date property listing.