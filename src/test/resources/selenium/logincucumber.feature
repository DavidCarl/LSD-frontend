Feature: Login 

Scenario Outline: Login
Given the user <user>
Given the password <password>
Given the agencyNumber <agencyNumber>
When logs in
Then the session should be <output>

Examples:
|user     |password   |agencyNumber     |output      | 
|admin    |admin      |62               |hello admin |


