function sortNumberdes(a,b){

    return a-b;
    // if(a>b){
    //     return -1;
    // }else if(a<b){
    //     return 1;
    // }else{
    //     return 0;
    // }
}

function sortNumberasc(a,b){


    // if(a>b){
    //     return 1;
    // }else if(a<b){
    //     return -1;
    // }else{
    //     return 0;
    // }
    return b-a;
}

let numbers = [0, 1 , 2, 30, 10, 25, 40, 30];
numbers.sort(sortNumberasc);
console.log(numbers);
numbers.sort(sortNumberdes);
console.log(numbers);