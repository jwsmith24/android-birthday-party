# Android Birthday Party User Stories

## Story #1: Invitation List

Type: **feature**

_As a party planner, I can see all the invites that I've sent out and their status so that I can easily track who will
be coming to my party._

### Acceptance Criteria

```gherkin
Scenario: View an invitation

Given at least one invitation has been sent
When I view an invitation
Then I see the name, RSVP status, and address of who I sent it to
And I see if they'll have a plus one or not
```

```gherkin
Scenario: Display list of invitations

Given at least one invitation has been sent
When I open the application
Then I see a scrollable list of invitations ordered newest first
And each row shows who I invited and their RSVP status
```

```gherkin
Scenario: Empty list

Given no invitations have been sent out
When I open the application
Then I see the message "No invitations sent"
```

```gherkin
Scenario Outline: RSVP status badge colors

Given an invitation has RSVP status "<status>"
When I view the invitation list
Then the status badge is <color>

Examples:
| status    | color  |
| Pending   | yellow |
| Declined  | red    |
| Attending | green  |
```

## Story #2: Send Invitation

Type: **feature**

_As a party planner, I can create a new invitation so that I can send it and track its status._

### Acceptance Criteria

```gherkin
Scenario: Navigate to invitation form

Given I am on the main screen
When I tap the create invitation button
Then I navigate to the invitation form
```

```gherkin
Scenario: Send invitation

Given I am on the invitation form screen
When I enter valid data
And I tap the send invitation button
Then I get a confirmation toast
And I navigate to the main screen
```

```gherkin
Scenario: Enter invalid data

Given I am missing required fields or I have entered invalid data
When I tap the send invitation button
Then I get an error toast
And the invalid fields show an error message
And my invitation is not sent
```

---

## Bonus Stories
Work through these if you have time or want to keep practicing after the course!

### Story #3: Guest Metrics

Type: **feature**

_As a party planner, I can see stats on how many guests confirmed, declined, are still pending so that I can adjust my
headcount for food and follow up with guests._


#### Acceptance Criteria

```gherkin
Scenario: Stats displayed

Given at least one invitation has been sent
When I view the top of the invitation list
Then I can see how many guests were invited
And I can see how many guests have accepted their invitation
And I can see how many guests have declined their invitation
And I can see how many guests have not responded yet
```

### Story #4: Delete Invitation

Type: **feature**

_As a party planner, I can remove an invitation on my list so that I don't have to see invitations that I've revoked._

#### Acceptance Criteria

```gherkin
Scenario: Delete Invitation

Given I have a valid invitation on the main screen
When I delete the invitation
Then I see the invitation is removed from the list
And I see a confirmation toast that invite got deleted
```

```gherkin
Scenario: Cancel deletion

Given I am on the main screen with at least one invitation
When I tap delete and then cancel the confirmation
Then the dialog closes 
And the invitation is still present in the list
```