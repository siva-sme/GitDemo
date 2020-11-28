Feature: Application login

Scenario Outline: Negative scenario login
Given Initialize the browser
And Navigate to "http://www.qaclickacademy.com/"
And Click on Login button
When user enter <username> and <password>
Then Error message is displayed
And close browsers

Examples:
|username  |password  |
|sivas     |test      |
|testmail  |password1 |