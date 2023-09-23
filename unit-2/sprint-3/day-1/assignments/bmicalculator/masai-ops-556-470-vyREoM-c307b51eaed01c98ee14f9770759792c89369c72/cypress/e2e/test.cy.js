import data from "../../submissionData.json"; // do not create this file
// let data = [{ submission_link: "http://localhost:8080/", id: 67890 }];
import "cypress-localstorage-commands";

// import { start, submitData } from "../../../data";
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

      it(`Check BMI`,() =>{
        cy.visit(url);
        cy.get("#height").clear().type(1.63);
        cy.get("#weight").clear().type(30);
        cy.get("#calculate").click();
        cy.get("#bmi").contains((30/(1.63**2)).toFixed(1)).then(() =>{
          acc_score += 1
        });
      })//1
      it(`Check Status`,() =>{
        cy.get("#status").contains("UnderWeight").then(() =>{
          acc_score += 1
        });
      })//1

      it(`Check Normal Weight`,() =>{
        cy.get("#height").clear().type(1.63);
        cy.get("#weight").clear().type(50);
        cy.get("#calculate").click();
        cy.get("#bmi").contains((50/(1.63**2)).toFixed(1)).then(() =>{
          acc_score += 1
        });
        cy.get("#status").contains("Normal Weight").then(() =>{
          acc_score += 1
        });
      })//2

      it(`Check Obese`,() =>{
        cy.get("#height").clear().type(1.63);
        cy.get("#weight").clear().type(90);
        cy.get("#calculate").click();
        cy.get("#bmi").contains((90/(1.63**2)).toFixed(1)).then(() =>{
          acc_score += 1
        });
        cy.get("#status").contains("Obese").then(() =>{
          acc_score += 1
        });
      })//2

      it(`Check Overweight`,() =>{
        cy.get("#height").clear().type(1.63);
        cy.get("#weight").clear().type(70);
        cy.get("#calculate").click();
        cy.get("#bmi").contains((70/(1.63**2)).toFixed(1)).then(() =>{
          acc_score += 1
        });
        cy.get("#status").contains("Overweight").then(() =>{
          acc_score += 1
        });
      })//2
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
