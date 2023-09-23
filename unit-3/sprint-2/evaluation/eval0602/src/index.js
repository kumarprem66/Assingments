
// Problem 1. 
function Animal(name, type) {
    this.name = name;
    this.type = type;
}

Animal.prototype.makeSound = function(){
    return "Animal is making a sound";
}

function Mammal(name, type, hasFur) {
    Animal.call(this,name,type);
    this.hasFur = hasFur;
}

Object.setPrototypeOf(Mammal.prototype,Animal.prototype);
Mammal.prototype.makeSound = function(){
    return "Mammal is making a sound"
}

function Dog(name, type, hasFur, breed) {
    Mammal.call(this,name,type,hasFur);
    this.breed = breed;
}

Object.setPrototypeOf(Dog.prototype,Mammal.prototype);

Dog.prototype.makeSound = function(){
    return "Woof Woof!";
}

class Character {
    constructor(name,health,attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    attack(charObj){
        charObj.health -= charObj.attackPower;
    }
    isAlive(){
        if(this.health>0){
            return true;
        }else{
            return false;
        }
        
    }
}

class Warrior extends Character {
    constructor(name,health,attackPower,weapon,armor){
        super(name,health,attackPower);
        this.weapon = weapon;
        this.armor = armor;
    }

    attack(charObj){
        if(this.weapon=="sword"){
            charObj.attackPower += 10;
        }
        charObj.health -= charObj.attackPower;
    }

    defend(){
        this.health += 10;
    }
}


export { Dog, Mammal, Animal, Character, Warrior }
