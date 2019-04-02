Feature:Gmail Login
Background:
Given launch site
Scenario Outline:validate userid field
When enter userid like "<x>" value
And click userid next button
Then validate userid output for "<x>" with "<y>" criteria
When close site

Examples:
|     x       |    y     |
|sekharp488   |   valid  |
|             | invalid  |
|sekharp40111 | invalid  |

Scenario Outline:validate password field
When enter userid like "sekharp488" value
And click userid next button
When enter password like "<x>" value
And click password next button
Then Validate password output for "<x>" with "<y>" criteria
When close site

Examples:
|     x     |    y     |
|rajasekhar |   valid  |
|           | invalid  |
|rajaaaa    | invalid  |