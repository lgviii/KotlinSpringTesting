# Kotlin Testing Reference App

---

## Overview

This project contains a reference implementation for a Spring web backend using a database and exposing service endpoints.

###Areas covered:
- Kotlin
- Spring
- Dependency Injection
- Repository
- Testing

---

## Project Concept

###Team to do list API

The project is setup as a simple list application. The initial state is that two endpoints are available. One allows a user to add list items and the other allows for retrieving all the lists grouped by user.

### Current Features:

 - Each team member can add items to their list by using their user id.
 - Each team member only has one list.
 - Any team member can view all lists.

--- 

## Exercise

Now that users can create and view their list items, they want to add a feature to delete items they are done with. 

Try to use test driven development to first write failing test for the behavior you expect of the system. Then implement the code to get the tests to pass.

There is no one correct way to do this, but you can look at the current tests and controller as examples.

### Expected Features:

- Each team member can delete one list item at a time by referencing their user id and the item id.
- If a team member attempts to delete a itme that does not exist, an error is returned.
- If a team member attempts to delete a another person's item, an error is returned.

### Acceptance Criteria/Steps:

1) Create a new list with a new item
2) Add another item
3) See both items
4) Delete the first item
5) See that second item is remaining
6) Delete an item that does not exist
7) See an error message back for display to the user









