Feature: Home Page

  Background: Open home page
    Given I have navigated to the 'the-internet' home page

  Scenario: Verify home page contents are correct
    Then the header text is "Welcome to the-internet"
    And the sub-header text is "Available Examples"
    And a list of the following sub-pages is displayed
      | A/B Testing                   |
      | Add/Remove Elements           |
      | Basic Auth                    |
      | Broken Images                 |
      | Challenging DOM               |
      | Checkboxes                    |
      | Context Menu                  |
      | Digest Authentication         |
      | Disappearing Elements         |
      | Drag and Drop                 |
      | Dropdown                      |
      | Dynamic Content               |
      | Dynamic Controls              |
      | Dynamic Loading               |
      | Entry Ad                      |
      | Exit Intent                   |
      | File Download                 |
      | File Upload                   |
      | Floating Menu                 |
      | Forgot Password               |
      | Form Authentication           |
      | Frames                        |
      | Geolocation                   |
      | Horizontal Slider             |
      | Hovers                        |
      | Infinite Scroll               |
      | Inputs                        |
      | JQuery UI Menus               |
      | JavaScript Alerts             |
      | JavaScript onload event error |
      | Key Presses                   |
      | Large & Deep DOM              |
      | Multiple Windows              |
      | Nested Frames                 |
      | Notification Messages         |
      | Redirect Link                 |
      | Secure File Download          |
      | Shadow DOM                    |
      | Shifting Content              |
      | Slow Resources                |
      | Sortable Data Tables          |
      | Status Codes                  |
      | Typos                         |
      | WYSIWYG Editor                |

  Scenario Outline: Open <page> page
    When I click on the "<page>" link
    Then the "<page>" page opens
    Examples:
      | page                |
      | Checkboxes          |
      | Dropdown            |
      | Dynamic Controls    |
      | Form Authentication |
      | Inputs              |