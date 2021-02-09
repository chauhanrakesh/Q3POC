
Feature: Test the search feature on redbus site with credentials source and destination
  search buses on particular route using source and destination

  Scenario: test input source and destination 
    Given open redbus url
    When enter the source "Hyd" and select LB Nagar,Hyderabad 
    And destination "Maj" and select Majesty,Banglore
    And selct current date
    Then click search bus and should redirect to result page
    