Feature: Add contacts into the address book
  As a user
  I want to add a contact to my address book
  So that I can store contact information easily

  Scenario: Add a new contact
    Given a typical address book
    When I add a new contact with the name "John Doe" and address "123 Main St"
    Then the address book should contain the added contact "John Doe" with the address "123 Main St"
