# JS-VITE-WITH-MOCK-SERVER

Please do NOT use VSCode live-server. It will not work. Use the npm commands suggested to you here.

## Installation
```
npm i
```

## Start only Backend server
```
npm run server
```

## Start only Frontend server
```
npm run start
```

## Start both BE & FE in a single command
```
npm run watch
```

# Important files
```
.
├── index.html
├── scripts
│   └── main.js
└── styles
    └── style.css
```

## Maximum Marks - 10

- The Submission should not contain spaces, for example /rct-101 folder/eval will not work
- Do not push node_modules and package_lock.json to github

## Rubrics

```
✅ able to submit the app - 1 mark ( minimum score )
✅ the list of users must be displayed - 5 marks
✅ Implement Pagination - 4 marks
```
### You haven't been taught cypress to run the test cases locally, you can see the passed/ failed test cases and test errors on CP itself.


## Some Rules to follow:-

- Before writing a single line of code please read the problem statement very carefully.
- Don't change the already given ids or classes.
- If you don't follow these rules you might not get any marks even if you do everything correctly.

# Problem statements 1.

## Problem 1. On the page load, the list of users must be displayed. The result should limit to 10 users.

![picture 1](https://res.cloudinary.com/drxuo575c/image/upload/v1675917557/coding-problems/c4d1ea0c7aead13ecb023f8bf48a6c246d0453b394a56c88625d8bda322b8bd2.png)  

Markup: 

![picture 2](https://res.cloudinary.com/drxuo575c/image/upload/v1675917610/coding-problems/ccc68ddf79ead9b222ca0fcd77bc31ce7269b1fbb60324c929f8d74543b645e7.png)  

FetchURL:
```
`${baseServerURL}/users
```

Server Documentation: https://github.com/typicode/json-server 

## Problem statement 2.

Implement Pagination

![picture 3](https://res.cloudinary.com/drxuo575c/image/upload/v1675917807/coding-problems/47998d2066f4f045a585b16ed5f1e457513d7820c21cbe6774d6ac2b8cefbba4.png)  


The pagination button should be inserted in `div#pagination-wrapper`


```
<div class="row">
    <div class="columns twelve main">
        <div class="notifications-wrapper" id="notifications-wrapper"></div>
        <div class="data-list-wrapper" id="data-list-wrapper"></div>
        <div class="pagination-wrapper" id="pagination-wrapper"></div>
    </div>
</div>
```      





### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding,
- so we request you to read the problem carefully and debug it before itself
- we also request you not just submit it last minute
- try to keep one submission at a time
- Use `${baseServerURL}/what-ever-route` for server url & not `localhost:9090/what-ever-route` in your solution. Failing to do so may cause all the tests to fail.
- If you try to use VSCodes live server, it wont work. Use the npm commands provided in this file only.
