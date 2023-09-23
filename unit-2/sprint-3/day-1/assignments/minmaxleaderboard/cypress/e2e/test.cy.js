import data from "../../submissionData.json"; // do not create this file
// let subdata = [{ submission_link: "http://localhost:8080/", id: 67890 }];
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

      it(`Check the score part`,() =>{
        cy.visit(url);
        cy.get("#keypad button").eq(1).click()
        cy.get("#keypad button").eq(0).click()
        cy.get("#keypad button").eq(0).click()
        cy.get("#score").contains(100).then(() =>{
          acc_score += 1
        })
      })//1
      it(`Press enter button and check the score`,() =>{
        cy.get("#enter").click();
        cy.get("#score").should("have.text","").then(() =>{
          acc_score += 1
        })
      })//1

      it(`Check if min-max is getting updated`,() =>{
        cy.get("#min").contains(100);
        cy.get("#max").contains(100);
        cy.then(() =>{
          acc_score+=1
        })
      })//1

      it(`Check min updating part`,() =>{
        cy.visit(url);
        cy.get("#keypad button").eq(9).click()
        cy.get("#keypad button").eq(0).click()
        cy.get("#enter").click();
        cy.get("#min").contains(90).then(() =>{
          acc_score += 1
        });
      })//1

      it(`Check max updating part`,() =>{
        cy.visit(url);
        cy.get("#keypad button").eq(1).click()
        cy.get("#keypad button").eq(0).click()
        cy.get("#keypad button").eq(1).click()
        cy.get("#enter").click();
        cy.get("#max").contains(101).then(() =>{
          acc_score+=1
        });
      })//1
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
