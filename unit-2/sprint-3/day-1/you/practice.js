function fun(n,k,arr){
    let l = 0;
    let r = n-1;
    let res = -1;
    arr.sort();
    while(l<r){
        if(arr[l]+arr[r]==k){
            res = 1;
            break;
        }else if(arr[l]+arr[r]>k){
            r--;
            
        }else{
            l++
        }
    }
    console.log(res);
}

let arr = [-7,-6,4,10,-5,0,-3,1,-6,5];
let result = fun(10,-13,arr);