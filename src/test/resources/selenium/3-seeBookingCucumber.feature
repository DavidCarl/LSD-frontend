Feature: FindBooking

Scenario Outline: getBooking
Given the pnr <png>
When getBooking
Then the bookingOutput should be <bookingOutput>

Examples:
|pnr           |bookingOutput |
|1234          |something     |


