// Function constructor
function FourWheeler(model, color, speed, fuel) {

    this.wheels = 4;
    this.model = model;
    this.color = color;
    this.speed = speed;
    this.fuel = fuel;
}

// FourWheeler.prototype.setSpeed = function(sp){
//     this.speed = sp;
// }

// FourWheeler.prototype.updateColor =function(col){
//     this.color = col;
// }

// FourWheeler.prototype.updateFuel = function(fu){
//     this.fuel = fu;
// }



// Parent object for Object.create
let FourWheelerObject = {
    

    setSpeed : function(sp){
        this.speed = sp
    },

    updateColor : function(col){
        this.color = col;
    },

    updateFuel : function(fu){
        this.fuel = fu
    }


};
Object.setPrototypeOf(FourWheeler.prototype,FourWheelerObject)

// Store function contructor object here
var car1 = new FourWheeler("lambo","black",100,4);

// Store Object.create here
var car2 = Object.create(FourWheelerObject);
car2.wheels = 4;
car2.model = "lam";
car2.color = "bla";
car2.speed = 100;
car2.fuel = 4;

export { car1, car2 };
