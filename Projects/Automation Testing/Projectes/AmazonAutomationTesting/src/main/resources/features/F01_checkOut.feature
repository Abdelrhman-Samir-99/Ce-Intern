Feature: F01_CheckOut | user try to buy the items in the cart

  Background: user open chrome browser
    Given user could search for a product named "pencil"
    And user select the item
    And the selected item has no extended warranty
    And user clicks on add_to_cart button
    And user clicks on proceed_to_checkout button

  Scenario: not registered user try buying items in the cart
    Then Sign-in page should appear
  Scenario: registered user try buying items in the cart
    Then Sign-in page should appear
    And user enter his username "abdulrhman.samir123@gmail.com" and password "123456"
