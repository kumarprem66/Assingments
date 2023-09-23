// function isBalance(s,n){
//     let st = [];
//     for(let i=0;i<n;i++){
//         let input = s[i];
//         if(input=='(' || input=='{' || input=='['){
//             st.push(input);
//         }else{
//             if(st.length==0){
//                 return false;
//             }

//             let output = st.pop();
//             if(output=='[' && input != ']'){
//                 return false;
//             }
//             if(output=='(' && input != ')'){
//                 return false;
//             }
//             if(output=='{' && input != '}'){
//                 return false;
//             }
//         }
//     }

//     return st.length==0;
// }

// let str = "{{{}}}";
// console.log(isBalance(str,str.length))


// =============== stock plan problem ================= //

// function fun(p,n){
//     let res = new Array(n);
//     res[0] = 1;
//     for(let i=1;i<n;i++){
//         res[i] = 1;
//         for(let j=i-1;j>=0 && p[j]<=p[i];j--){
            
//             res[i] = res[i]+1;
               
            
//         }
//     }
//     return res;
// }

function fun(p,n){
    let res = new Array(n);
    let st = [];
    res[0] = 1;
    st.push(0);
    for(let i=1;i<n;i++){
        while(st.length>0 && p[st.length-1]<=p[i]){
            st.pop();
        }
        if(st.length>0){
            res[i] = i-st[st.length-1];
        }else{
            res[i] = i+1;
        }
        st.push(i);
    }
    return res;
}


let price = [100,80,60,70,60,75,85];
console.log(fun(price,price.length))