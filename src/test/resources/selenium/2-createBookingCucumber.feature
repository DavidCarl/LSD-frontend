Feature: SearchFlight 

Scenario Outline: SearchFlight 
Given the fromAirport <fromAirport>
Given the toAirport <toAirport>
Given the fromDate <fromDate>
Given the toDate <toDate>
When flightSearch
Then the searchOutput should be <searchOutput>

Examples:
|fromAirport   |toAirport     |fromDate      |toDate      | searchOutput|
|CPH           |MMX           |01/21/2020    |01/30/2020  | something   |


