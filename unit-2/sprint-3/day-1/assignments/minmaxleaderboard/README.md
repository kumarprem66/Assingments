# WEB - Masai Game Scores

## Submission Instructions [Please note]

## Maximum Marks - 6

- The Submission should not contain spaces, for example,/js-101 folder/eval will not work
- Do not push node_modules and package_lock.json to GitHub

```
 ✅ able to submit the app - 1 mark ( minimum score )
 ✅ Check the score updating when clicked on keypad - 1 marks.
 ✅ Press enter button and check the score(Getting Reset)  - 1 marks.
 ✅ Check if on first time both max and min is equal to score - 1 marks.
 ✅ If the score > max the max gets updated - 1 marks.
 ✅ If the score > min the min gets updated - 1 marks.
```

## Installation

- you can use any node version that works for you ( 14+ )
- Download and unzip the boilerplate
- Navigate to the correct path

## Folder structure

- index.html
- Please Ignore all the other files except for the above-mentioned files.

### You haven't taught cypress to run the test cases locally, you can see the passed/ failed test cases and test errors on CP itself.

## Description

#### Use the template provided below to write your code (Mandatory)

## Some Rules to follow:-

- Before writing a single line of code please read the problem statement very carefully.
- Don't change the already given ids or classes.
- If you don't follow these rules you might not get any marks even if you do everything correctly.

## Problem Statement:-
- In the template we have 4 divs with id max,min,score,keypad.
- Inside the div keypad we have 10 buttons with different numbers. Which is basically our keypad for entering our scores.
- When clicked on the keypad buttons the score divs text should get updated.Which means when clicked on the keypad numbers the current score gets updated.
- There is also a button with id:- `enter`.
- Clicked on that will reset your current score.
- There are 2 more divs with id:- `max` & `min`.
- When the user clicks the `enter` button for the first time the current score should reset and both max and min scores should become the current score.
- But from the next time onwards:- 
   1. If score is < min then min gets updated to score.
   2. Similarly if score > max then max gets updated to score.
- Please reffer to this image for better understanding:- ![image](https://raw.githubusercontent.com/masai-school/full-stack-dev-1908/master/course/week_03/day_3/templates/leaderboard.jpg)

#### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding,
- so we request you to read the problem carefully and debug it before itself
- we also request you not just submit it last minute
- try to keep one submission at a time.
