Feature: Login to application
Scenario: Login to ecomm application

Given User is on Login page
When User enters username and password
When User click on Login button
Then Validate user successfully logged in application