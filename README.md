Lemonade app
==================================

Introduction
------------

The Lemonade app is a simple Compose app that allows the user to make digital lemonade by tapping
through a series of steps: select a lemon from the tree, squeeze the lemon, drink the glass of
lemonade, and start again.

The concepts covered in this app are:
- Simple UI layout in Compose
- Add clickable behavior to a composable
- Use remember and mutableStateOf to keep track of relevant state in the app

Here's how the app works:
------------------------

- When the user first launches the app, they see a lemon tree. There's a label that prompts them to 
tap the lemon tree image to "select" a lemon from the tree.
- After they tap the lemon tree, the user sees a lemon. They are prompted to tap the lemon to 
"squeeze" it to make lemonade. They need to tap the lemon several times to squeeze it. The 
number of taps required to squeeze the lemon is different each time and is a randomly generated
number between 2 to 4 (inclusive).
- After they've tapped the lemon the required number of times, they see a refreshing glass of 
lemonade! They are asked to tap the glass to "drink" the lemonade.
- After they tap the lemonade glass, they see an empty glass. They are asked to tap the 
empty glass to start again.
- After they tap the empty glass, they see the lemon tree and can begin the process again. 
More lemonade please!

Screenshot:
-----------
![Application Flow Overview](overview.png)
