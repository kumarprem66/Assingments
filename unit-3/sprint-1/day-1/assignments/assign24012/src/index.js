function studentData(firstName,lastName,age,marksArray,hobbies) {
  return {
    fullName:`${firstName} ${lastName}`,
    age:age,
    marksArray: marksArray,
    hobbies :hobbies,

    getInfo(){
      return `${this.fullName}'s age is ${this.age}.`
    },
    getResult(){
      if(age<50){
          return 'Result: PASS';
      }else if(age >= 50){
          return 'Result: FAIL';
      }
    }
  }
}

export {
  studentData
}