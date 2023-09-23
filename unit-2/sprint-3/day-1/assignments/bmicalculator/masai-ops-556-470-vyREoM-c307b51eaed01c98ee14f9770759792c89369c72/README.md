# WEB - Masai BMI Calculator

## Submission Instructions [Please note]

## Maximum Marks - 9

- The Submission should not contain spaces, for example,/js-101 folder/eval will not work
- Do not push node_modules and package_lock.json to GitHub

```
 ✅ able to submit the app - 1 mark ( minimum score )
 ✅ Check BMI - 1 marks.
 ✅ Check Status  - 1 marks.
 ✅ Check Normal Weight - 2 marks.
 ✅ Check Obese - 2 marks.
 ✅ Check Overweight - 2 marks.
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

- In the template you have 2 input:number for weight and height.
- When user clicks on the button show the BMI of the user in the span tag with an id:- `bmi`.
- When append it to the dom make sure you don't show more that one number in decimal. 
- Formula to calculate bmi = weight/(height^2)
```
bmi.textcontent = bmiValue.toFixed(1);
```
- Now user should have a status based on his bmi.
  1. bmi < 18.5 -> `UnderWeight`.
  2. bmi >= 18.5 && bmi <= 24.9 -> `Normal Weight`.
  3. bmi >= 25 && bmi <= 29.9 -> `Overweight`.
  4. bmi >= 30 -> `Obese`.
- Show the user's status in the span tag with id:- `status`.

#### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding,
- so we request you to read the problem carefully and debug it before itself
- we also request you not just submit it last minute
- try to keep one submission at a time.
