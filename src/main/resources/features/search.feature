Feature: Search Product

  Scenario: User searches for product "Ноутбук"
    Given User is on the homepage
    When User searches for "Ноутбук"
    Then The search URL should contain "noutbuki"
