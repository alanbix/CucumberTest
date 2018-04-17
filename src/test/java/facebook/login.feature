Feature: Login

  #This is how background can be used to eliminate duplicate steps
  Background:
    Given I am on Facebook login page

  #Succesfull scenario
  Scenario:
    When I enter username as "sistemas4dawin@gmail.com"
    And I enter password as "bitchesvikingas"
    Then Login should succeed

  #Fail scenario
  Scenario:
    When I enter username as "imaginary@email.com"
    And I enter password as "imaginarypassword"
    Then Login should fail