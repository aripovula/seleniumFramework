Feature: App Login

As a user
I want to use a calculator to add numbers
So that I don't need to add myself
  
#Scenario: Home page default login
#Given User opens the app
#When user enters "abc" and password "xyz"
#Then Dashboard page opened is "true"
#And all charts and KPI status shown is "true"

Scenario Outline: Home page default login
Given User opens the app
When user enters <username> and password <password>
Then Dashboard page opened is <condition>
And all charts and KPI status shown is <condition>

Examples:
|username	| password	| condition |
|abc1111	| abc123	| true		|
|abc2222	| abc1232	| true		|