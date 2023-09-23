import data from "../../submissionData.json"; // do not create this file
// let subdata = [{ submission_link: "http://localhost:8080/", id: 67890 }];
import "cypress-localstorage-commands";

// import { start, submitData } from "../../../data";

const Data = [
  {
    name: "S",
    doctor_id: "s1",
    specialization: "Dermatologist",
    experience: 1,
    email: "s@gmail.com",
    mobile: 98,
  },
  {
    name: "M",
    doctor_id: "m1",
    specialization: "Dentist",
    experience: 4,
    email: "m@gmail.com",
    mobile: 98,
  },
  {
    name: "G",
    doctor_id: "g1",
    specialization: "Gynecologist",
    experience: 6,
    email: "g@gmail.com",
    mobile: 98,
  },
];
describe("Test", function () {
  let acc_score = 1;
  data.map(({ submission_link: url, id }) => {
    if (url.charAt(url.length - 1) != "/") {
      url = url + "/";
    }
    if (url && url.length) {
      beforeEach(() => {
        cy.restoreLocalStorage();
      });
      afterEach(() => {
        cy.saveLocalStorage();
      });

      const submitForm = (data,length,score) => {
        cy.get("#name").clear().type(data.name);
        cy.get("#doctor_id").clear().type(data.doctor_id);
        cy.get("#experience").clear().type(data.experience);
        cy.get("#email").clear().type(data.email);
        cy.get("#mobile").clear().type(data.mobile);
        cy.get("#specialization").select(data.specialization);
        cy.get("form").submit();
        cy.get("tbody tr").should("have.length",length).then(() =>{
          acc_score += score;
        })
      };

      const checkTable = (data,index,score) =>{
        cy.get("tbody tr").eq(index).contains("td",data.name)
        cy.get("tbody tr").eq(index).contains("td",data.doctor_id)
        cy.get("tbody tr").eq(index).contains("td",data.experience)
        cy.get("tbody tr").eq(index).contains("td",data.email)
        cy.get("tbody tr").eq(index).contains("td",data.mobile)
        cy.get("tbody tr").eq(index).contains("td",data.specialization);
        cy.then(() =>{
          acc_score += score
        })
      }

      it(`Submit the Form Once and check the table`, () =>{
        cy.visit(url);
        submitForm(Data[0],1,1);
        checkTable(Data[0],0,1)
      })// 2

      it(`Submit the Form multiple Times`, () =>{
        submitForm(Data[1],2,0.5);
        checkTable(Data[1],1,0.5);

        submitForm(Data[2],3,0.5);
        checkTable(Data[2],2,0.5);
      })//2

      it(`Checking the Role Part`, () =>{
        cy.get("tbody tr").eq(0).contains("td","Trainee");
        cy.get("tbody tr").eq(1).contains("td","Junior");
        cy.get("tbody tr").eq(2).contains("td","Senior");

        cy.then(() =>{
          acc_score += 1
        })
      })// 1
      it(`Check the delete Part`, () =>{
        cy.get("tbody tr").eq(2).children("td").eq(7).click();
        cy.get("tbody tr").should("have.length",2).then(() =>{
          acc_score += 2
        });
      })// 2

      it(`Check the Filter Part`, () =>{
        cy.get("#filter").select("Dermatologist");
        cy.get("tbody tr").should("have.length",1)
        cy.get("tbody tr").eq(0).contains("tr","Dermatologist");

        cy.get("#filter").select("Dermatologist");
        cy.get("tbody tr").should("have.length",1)
        cy.get("tbody tr").eq(0).contains("tr","Dermatologist");

        cy.then(() =>{
          acc_score += 2
        }) 
        cy.then(() => console.log(acc_score))
      })// 2
    }

    it(`generate score`, () => {
      //////////////
      console.log(acc_score);
      let result = {
        id,
        marks: Math.floor(acc_score),
      };
      result = JSON.stringify(result);
      cy.writeFile("results.json", `\n${result},`, { flag: "a+" }, (err) => {
        if (err) {
          console.error(err);
        }
      });
      //////////////////
    });
  });
});
