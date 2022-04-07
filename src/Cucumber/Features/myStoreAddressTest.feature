Feature: adding an address in myStore
  Scenario Outline: user can add an address to their myStore account

    Given opened myStore webpage
    When user is signed in
    And address form is opened
    And address form is filled with <alias> <address> <city> <postalCode> <phone>
    And save button is clicked
    Then "Address successfully added!" is displayed
    And address is deleted
    And user sees "Address successfully deleted!"



    Examples:
      |alias        |address             |city           |postalCode   |phone      |
      |Address2     |MaidenLane          |NewYork        |000000       |333444555  |
      |Address3     |BeachDrive          |Washington     |111111       |777999222  |
      |Address4     |UnionStreet         |NewJersey      |222222       |444888000  |
      |Address5     |MulhollandDrive     |LosAngeles     |333333       |999222888  |
      |Address6     |Marszałkowska1      |Warsaw         |444444       |123456789  |
      |Address7     |SchwedterStraße     |Berlin         |555555       |555000111  |