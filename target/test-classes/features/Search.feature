Feature: Search functionality
Scenario: search existing product

Given user navigate to home page
When user enter valid product in search box
And click on search button
Then user found a product in search field

Scenario: search invalid product 
Given user navigate to home page
When user enter invalid product in search box
And click on search button
Then user not found a product in search field

