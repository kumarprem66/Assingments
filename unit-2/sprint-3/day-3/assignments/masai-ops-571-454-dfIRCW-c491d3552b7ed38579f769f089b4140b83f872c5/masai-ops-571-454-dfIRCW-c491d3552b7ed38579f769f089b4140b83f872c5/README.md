# WEB - LS-Methods

## Submission Instructions [Please note]

## Maximum Marks - 9

- The Submission should not contain spaces, for example,/js-101 folder/eval will not work
- Do not push node_modules and package_lock.json to GitHub

```
 ✅ able to submit the app - 1 mark ( minimum score )
 ✅ Able to store Name in LS on Button Click - 1 marks.
 ✅ Able to show the Name  on Click in h1  - 1 marks.
 ✅ Able to store Mobile No in LS on Button Click - 1 marks.
 ✅ Able to show the Mobile No  on Click in h1  - 1 marks.
 ✅ Able to store Hobbies in LS on Button Click - 1 marks.
 ✅ Able to show the Hobbies  on Click in h1  - 1 marks.
 ✅ Able to store Students in LS on Button Click - 1 marks.
 ✅ Able to show the Students  on Click in h1  - 1 marks.
```

## Installation

- you can use any node version that works for you ( 14+ )
- Download and unzip the boilerplate
- Navigate to the correct path

## Folder structure

- index.html(Signup Page)
- signin.html(Signin Page)
- Please Ignore all the other files except for the above-mentioned files.

### You haven't taught cypress to run the test cases locally, you can see the passed/ failed test cases and test errors on CP itself.

## Description

#### Use the template provided below to write your code (Mandatory)

## Some Rules to follow:-

- Before writing a single line of code please read the problem statement very carefully.
- Don't change the already given ids or classes.
- If you don't follow these rules you might not get any marks even if you do everything correctly.

## Problem Statement:-

- This problem statement has 8 parts

### Part-1

- Create a button "Store name to LS"
- On Click of button, store "Masai School" into local storage with key called "username"
- Check Local storage whether name is store or not

### Part-2

- Create a button "Get name from LS"
- On click of button, get `username` from local storage which you stored in previous part, and display it in h1 tag
- Check whether name is getting displayed on dom or not

### Part-3

- Create a button "Store Mobile Num to LS"
- On Click of button, store "999999999" into local storage with key called "mobile"
- Check Local storage whether name is store or not

### Part-4

- Create a button "Get Mobile Number from LS"
- On click of button, get `mobile` from local storage which you stored in previous part, and display it in h1 tag
- Check whether name is getting displayed on dom or not

### Part-5

- Create a button "Store Hobbies to LS"
- On Click of button, store hobbies into local storage with key called "my_hobbies"

```
let hobbies =["cricket","music"]
```

- Check Local storage whether hobbies are store or not
- Note : use JSON methods

### Part-6

- Create a button "Get Hobbies from LS"
- On click of button, get `my_hobbies` from local storage which you stored in previous part. Now there is a h1 tag with an id:- `show-hobbies`.Convert the array to text seperated by `/`. Use array.join method for it:- [here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join)

```
Hint:- ["a","b","c"] -> a/b/c
```

### Part-7

- Create a button "Store Students Data to LS"
- On Click of button, store students data into local storage with key called "students"

```
let students =
[
    {"name":"Nrupul",place:"Banglore"},
    {"name":"Prateek",place:"Mumbai"}
]
```

- Check Local storage whether students data is stored or not
- Note: use JSON methods

### Part-8

- Create a button "Get Students data from LS"
- On click of button, get `students` from local storage which you stored in previous part. Now show the names of the students in a `/` seperated string as textContent of h1 with id:- `show-students`.

```
Hint:- [{"name":"Nrupul",place:"Banglore"},{"name":"Prateek",place:"Mumbai"}
] -> Nrupul/Prateek
```

#### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding,
- so we request you to read the problem carefully and debug it before itself
- we also request you not just submit it last minute
- try to keep one submission at a time
