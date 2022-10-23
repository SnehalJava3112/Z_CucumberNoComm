Feature: Login to application

  Scenario: Login to ecomm application
    Given A User browser launch
    When A User enters url "https://admin-demo.nopcommerce.com/admin/"
    When A User enters login credentials as below
  
      | Sr.No. | emails              | passwords |
      |     01 | admin@yourstore.com | admin     |
      |     02 | snehal@gmail.com       | xyz@123   |
      
    When A user click on login button 
    Then A Validate user successfully logged in application

    Scenario: Default status of checkbox
    Given A User browser launch
    When A User enters url "https://admin-demo.nopcommerce.com/admin/"
    Then A validate remember_me checkbox status
    