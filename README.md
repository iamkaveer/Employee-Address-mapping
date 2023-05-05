# Employee-Address-mapping
## EmployeeController
## Methods:
GET /employees - get all employees

GET /employees/{id} - get an employee by id

POST /employees - create a new employee

PUT /employees/{id} - update an employee by id

DELETE /employees/{id} - delete an employee by id

## AddressController
## Methods:
GET /addresses - get all addresses

GET /addresses/{id} - get an address by id

POST /addresses - create a new address

PUT /addresses/{id} - update an address by id

DELETE /addresses/{id} - delete an address by id

### The Employee entity class has a one-to-one mapping with the Address entity class. This is achieved by adding a @OneToOne annotation to the address attribute in the Employee class.

