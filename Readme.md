Endpoints:

http://localhost:8080/mockaccount/generatetestdata

http://localhost:8080/account/list


Description

Team to do list API

The app shows everyone what's on the teams to do lists for each person

Each person can add items to their list. Each team member only has one list. 
This is done with their user id and the content of the to do item. 


Next phase

The team wants to add a feature to delete items they are done with.

the story looks like this:

Acceptance Criteria:

Create a new list with a new item
Add another item
See both items
Delete the first item
See that second item is remaining

If there is any error, sent a string error message back for display to the user.

Features:

Add an item


Errors:
-Item does not exist
-You can not delete another users' item
-User does not have an account/access