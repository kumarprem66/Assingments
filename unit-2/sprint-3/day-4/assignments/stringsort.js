function sortstrdes(a,b){

  
    if(a>b){
        return -1;
    }else if(a<b){
        return 1;
    }else{
        return 0;
    }
}

function sortstrasc(a,b){


    if(a>b){
        return 1;
    }else if(a<b){
        return -1;
    }else{
        return 0;
    }
   
}

let numbers = ['cat', 'dog', 'elephant', 'bee', 'ant'];
numbers.sort(sortNumberasc);
console.log(numbers);
numbers.sort(sortNumberdes);
console.log(numbers);