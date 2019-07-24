Feature: App Login

As a user
I want to use a calculator to add numbers
So that I don't need to add myself
  
Scenario Outline: Home page default login
Given User opens the app
When user enters <username> and password <password>
Then Dashboard page opened is <condition>
And all charts and KPI status shown is <condition>

Examples:
|username	| password	| condition |
|acbc1111	| abc123	| true		|
|acbc2222	| abc1232	| true		|
|acbc3333	| abc1233	| false		|