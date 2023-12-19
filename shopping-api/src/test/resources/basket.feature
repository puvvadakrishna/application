Feature: Intelligent Recommendations

  Scenario: Adding item to the basket
    Given When and user selects an item to add to the basket
    When the selected quality is greater than 0
    Then item should be added to basket
    And inventory should be updated