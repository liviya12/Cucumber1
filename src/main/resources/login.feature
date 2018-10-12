#Author: your.email@your.domain.com

Feature: To check add customer functionality
  
 
  Scenario Outline: To login as a new customer
    Given The user is in guru login page
    And The user login with valid username & password
    |mngr157008|nazUsut|
    When The user navigates to new customer page
    And The user provides the personal details to login "<custname>","<dob>","<address>","<city>","<state>","<pin>","<mobile>","<email>","<password>"
    Then The user should be registered as a new cutomer

    Examples: 
   |custname|gender|dob|address|city|state|pin|mobile|email|password|
   |nafisa|03071973|karapakkam|chennai|tamilnadu|641603|8888877777|nafisa@gmail.com|2222200000|
   |seena|05081975|nedumkandam|kerala|kerala|641603|9999988888|seena@gmail.com|1111100000| 
   |liviya|07121994|karapakkam|chennai|tamilnadu|600097|9898989898|liviya@gmail.com|3333300000|
   
 