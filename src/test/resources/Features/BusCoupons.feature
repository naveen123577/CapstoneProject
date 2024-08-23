Feature: Validate the Offer Coupons
  Scenario: Verify that all offer coupons have a coupon code on the Offers page
    Given user opens the website
    Then verify user is on homepage
    When user navigate to the offers page
    Then verify offer coupons page is displayed
    And verify each offer coupon should have a coupon code displayed
