class Vehicle {

    constructor(type,registrationNumber,color){
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}

class Car extends Vehicle{
    constructor(registrationNumber,color){
       super("Car",registrationNumber,color);
    }
}

class Bike extends Vehicle{
    constructor(registrationNumber,color){
        super("Bike",registrationNumber,color);
    }
}

class Bus extends Vehicle{
    constructor(registrationNumber,color){
        super("Bus",registrationNumber,color);
    }
}

class Slot {
   constructor(type,number){
    this.type = type;
    this.number = number;
    this.isBooked = false;
   }
}

class ParkingFloor {

    constructor(floorNumber,maxLimit){
        this.floorNumber = floorNumber;
        this.maxLimit = maxLimit;
        this.parkingSpots = [];
        this.vacantParkingSpots = [];

        this.parkingSpots.push(new Slot("Bus",1));
        this.parkingSpots.push(new Slot("Bike",2));
        this.parkingSpots.push(new Slot("Bike",3));
        this.parkingSpots.push(new Slot("Car",4));
    }

    displayAvailableSlots(){
         this.vacantParkingSpots = this.parkingSpots.filter((slot)=>{
            if(slot.isBooked === false){
                return true;
            }else{
                return false;
            }
         });

         return this.vacantParkingSpots;
    }

    findAndParkVehicle(vehicle){
        let currentVehicleType = vehicle.type;
        for(let parkingSpot of this.parkingSpots){
            if(parkingSpot.type == currentVehicleType){
                if(parkingSpot.isBooked == false){
                    parkingSpot.isBooked = true;
                    return true;
                }
            }
        }
        return false;
    }

    parkVehicle(vehicleObject){
        let parkingSuccessfull = this.findAndParkVehicle(vehicleObject);
        if(!parkingSuccessfull){
            return `${vehicleObject.type} slots are full`;
        }
        this.displayAvailableSlots();
    }

}  


let pf = new ParkingFloor(1,4);

let bs = new Bus("b2","orange");
let bike = new Bus("bike1","orange");
let bike2 = new Bus("bike2","black");
let car = new Bus("car","white");

pf.parkVehicle(bs);
pf.parkVehicle(bike);
pf.parkVehicle(bike2);
pf.parkVehicle(car);
console.log(pf.parkingSpots);
console.log(pf.displayAvailableSlots());





export {Vehicle, Car, Bike, Bus, Slot, ParkingFloor}


