@cucumber
Feature: Login to Contact Feature And Create New User Skill
In order to create a new user skill
As an administrator
I want to login and create a new user skill


  Scenario: Login As An Admin
    Given that Badr has Accessed The Contact Authentication Page
    When he inputs his username 'secret' and password 'secret'
    And  he clicks on the connect button
    Then he authenticated successfuly
    And Clicks On The Administration Tile
    Then The Users List Is Displayed
    
  Scenario: Create New User Skill
  	Given that Badr is on the users list page
  	When he clicks on the Skills List Link
  	Then The skill list is displayed
  	When Badr clicks on the create new skill button
  	Then the skill create form is displayed
  	
  Scenario: Login As An Admin
  	Given that Badr opens another window