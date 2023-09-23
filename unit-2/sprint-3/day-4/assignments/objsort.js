let employees = [
    {
        firstName: 'john',
        lastName: 'doe',
        age: 27,
        joinedDate: 'December 15, 2017'
    },

    {
        firstName: 'ana',
        lastName: 'rosy',
        age: 25,
        joinedDate: 'January 15, 2019'
    },

    {
        firstName: 'zion',
        lastName: 'albert',
        age: 30,
        joinedDate: 'February 15, 2011'
    }
];

function sortstrdes(a,b){

   
    if(a.firstName>b.firstName){
        return -1;
    }else if(a.firstName<b.firstName){
        return 1;
    }else{
        return 0;
    }
}

function sortstrasc(a,b){


    if(a.firstName>b.firstName){
        return 1;
    }else if(a.firstName<b.firstName){
        return -1;
    }else{
        return 0;
    }
   
}

employees.sort(function(a,b){
    return a.age-b.age;
})
console.log(employees);
employees.sort(function(a,b){
    return b.age-a.age;
})
console.log(employees);

employees.sort(sortstrasc);
console.log(employees);
employees.sort(sortstrdes);
console.log(employees);