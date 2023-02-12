Feature: User Registration
   I want to check that the usre can register in our e-commerce website
   
   Scenario Outline: User Registration
   Given the user in the home page
   When I click on Register link
   And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>"
   Then the Confirmation label is displayed successfully
   
   Examples:
   | firstname | lastname | email | password |
   | aa | aa | aa@aa.com | 12345678|
   | bb | bb | bb@bb.com | 12345678 |


   
   

