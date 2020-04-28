# CS 425 Project Breakdown and Timeline

**First Deliverable**: Each group will develop an E-R model for the application and upload it as any type of
image format due by March 15.

**Second Deliverable**: The E-R model will be translated into a relational schema implemented by an
SQL script. The script should run on a PostgreSQL database (or a comparable database of your choice). In
addition to defining the tables and constraints the script should create indexes where appropriate due
by April 05.

**Last Deliverable**: is an application that uses the relational schema defined in the first two deliverables.
Due by April 29.

## Submittal
Each individual will submit the part they worked on. If the group decided to submit one final version,
each team member’s contribution has to be stated. The project will be submitted via blackboard. For the
last deliverable please submit one code.

## Project Description
The objective of the project is to create an ERP application, allowing tracking sales, employee salaries
and benefits, inventory and running reports.

## Database Requirements
### Login
Information about the users of the system must be maintained. There will be 4 types of users with
different privileges (admin, sales, HR, engineering). Each user will have the following fields:
- User ID
- Privilege
- LoginTime
- LogoutTime
Engineering includes employee designing the product, manufacturing and all employee interested in
tracking inventory.

### Inventory
- Id
- Cost
- Lead time
- Category Type
- number…

### Model
- ModelNumber
- Sale price
- …

### Employee
- First Name
- Last Name
- SSN
- Employee ID
- Salary
- Type hourly vs salaried
- Job type
- 1: HR
- 2: Sale
- 3: Engineering
- ….

### Customer
- First Name
- Last Name
- Customer ID
- …

### Order
All sales transaction will be logged with the following information
- OrderNumber
- Customer ID
- EmployeeID (for sale person)
- Model
- Sale value

## Application requirements
### Login
The application must provide a login portal for user to login. The application will validate the user
credentials and privileges.

### Privileges
1- Users with admin privileges can do the following:
a. Create a new employee
b. Set up tables: order table, employee, model table for product, inventory
c. Grant access
d. Access and create the business reporting ….

2- The sale person should be able to view:
a. View and update customer
b. Create an Order
c. Access sales reports

3- Users with engineer privileges can do the following:
a. Access and update model
b. Access and update inventory
c. Limited view to employee information, first and last name, title ….
4- Users with HR privileges can do the following:
a. Access and update of employee information
b. View of employee and associated sales number

### Reporting and analytics
The admin will have the capability of running business analytics reports that will help them monitor
business operations.
- Total revenue from sale, associated employee and customer
- Customer model bought and quantity to make prediction and understand trending
- For each order, the associated parts and available inventory
- Expense report, employee showing salary, bonus expense and part cost
