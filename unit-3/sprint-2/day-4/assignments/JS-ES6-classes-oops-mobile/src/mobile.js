class Mobile {

    
    #unlockpin;
    constructor(model,number){
        this.model = model;
        this.number = number;
        this.#unlockpin = "1111"
    }
    

    getUnlockPin(){
        return this.#unlockpin;
    }

    unlockPin(){
        this.#unlockpin = "2222";
    }

    sendSMS(message){
       return message;
    }

}

let m = new Mobile(3,3434);
console.log(m.getUnlockPin())
m.unlockPin();
console.log(m.sendSMS("I love you"))
console.log(m.getUnlockPin())



  
export default Mobile
