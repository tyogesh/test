Feature: HomePage Validation

Scenario: Verify Subscription Message

Given User launch the application
When User enter email "abcd@gmail.com" in the subscription text box
Then User should see subscription Message


Scenario Outline: Verify Tabs in Home Page

Given User launch the application
When User Click on the tab "<tab>"
Then User should see the respective details page "<tab>"

Examples:
|tab|
|DRESSES|

Scenario Outline: Verify Product Count

Given User launch the application
When User Click on the tab "<tab>"
Then User should see the same number of products count matching with the product header count displayed

Examples:
|tab|
|DRESSES|


Scenario Outline: Verify Product cart

Given User launch the application
When User Click on the tab "<tab>"
And the click on Add to cart button for the product "<product>"
Then the product should added to cart page

Examples:

|tab|products|
|DRESSES|Printed Chiffon Dress|


