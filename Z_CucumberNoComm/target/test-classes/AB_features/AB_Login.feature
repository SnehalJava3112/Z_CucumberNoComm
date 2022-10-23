Feature: Login to application with multiple users

@Snehal_1
  Scenario Outline: Login to ecomm application
    Given AB User browser launch
    When AB User enters url "https://admin-demo.nopcommerce.com/admin/"
    When AB User enters login credentials as '<emails>' and '<passwords>'
         
    When AB user click on login button
    Then AB Validate user successfully logged in application
	
		Examples:
		
      | emails              | passwords |
      | admin@yourstore.com | admin     |
      | snehal@gmail.com    | xyz@123   |
      
   
@Snehal_2     
   Scenario: Default status of checkbox
    Given AB User browser launch
    When AB User enters url "https://admin-demo.nopcommerce.com/admin/"
    Then AB validate remember_me checkbox status