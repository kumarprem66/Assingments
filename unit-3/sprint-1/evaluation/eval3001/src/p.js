function yes(a,b,...ar){
  b(ar,a)
}

// let arr = [1,2,4];
// arr = arr.reduce((acc,cur)=>{
//   (acc+cur)*10
//   return acc;
// })

// console.log(arr);
yes(10,(x,y)=>{console.log(x.reduce((ac,cur)=>ac+cur)*10)},1,2,4)