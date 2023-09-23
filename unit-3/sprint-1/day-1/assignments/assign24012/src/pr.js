let arr = new Array(5);
let top = -1;
let n = 5;


function push(ele){
  if(top==n-1){
    console.log("stackover flow")
    return;
  }
  top++;
  arr[top] = ele;
}

function pop(){
    if(top==-1){
        console.log("Stack is empty");
        return;
    }
    let ans =  arr[top];
    
    top--;
    return ans;
    
}

function peek(){
    if(top==-1){
        console.log("Stack is empty");
        return;
    }
    console.log(arr[top]);
    
}

push(23);
push(34);
push(56);
push(98);
push(67);
push(34);
let s = pop()
console.log(s);
peek()
console.log(arr);