@Address
Feature: Address module API Automation

  @Add
  Scenario Outline: Verify add user address to the application through API
    Given User add header and bearer authorization for accessing address endpoint
    When User add request body for new address "<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<addressType>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the addUserAddres response matches with "Address added successfully" and save the address_id
   

    Examples: 
      | firstName | lastName | mobile     | apartment | state | city | country | zipcode | address            | addressType |
      | Santhana  | Prakash  | 9876543210 | AJK       |    35 | 4241 |     101 |  101010 | 64/63 partap nagar | home        |

  @Update
  Scenario Outline: Verify update user address to the application through API
    Given User add headers  for accessing updateAddress endpoint
    When User add request body for new address id  "<addressId>","<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<addressType>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the updateUserAddress response matches with "Address updated successfully"

    Examples: 
      | addressId | firstName | lastName | mobile     | apartment | state | city | country | zipcode | address            | addressType |
      |     57014 | Santhana  | Prakash  | 9876543210 | AJK       |    35 | 4241 |     101 |  101010 | 64/63 partap nagar | home        |

  @GetAddress
  Scenario Outline: Verify Get user address to the application through API
    Given User add header and bearer authorization for accessing getUserAddress endpoint
    When User send "GET" request for getUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the getUserAddress response city name matches with "Srivilliputtur"

  @DeleteAddress
  Scenario Outline: Verify Delete user address to the application through API
    Given User add header and bearer authorization for accessing deleteAddress endpoint
    When User add request body for delete the existing "<addressId>"
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User should verify the status code is 200
    And User should verify the deleteUserAddress response matches with "Address deleted successfully"

    Examples: 
      | addressId |
      |     57014 |
