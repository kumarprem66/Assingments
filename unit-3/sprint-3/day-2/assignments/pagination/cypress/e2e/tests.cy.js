import "cypress-localstorage-commands";
import data from "../../submissionData.json";
// let data = [{ submission_link: "http://localhost:8080", id: 67890 }];

/// <reference types="cypress" />

// let baseServerURL = Cypress.env("serverUrl");

import recipeData from "../fixtures/recipeData.json";
import patchedRecipe from "../fixtures/patchedRecipe.json";

let t = {
  accessToken:
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImZpcnN0bmFtZSI6IkFkIiwibGFzdG5hbWUiOiJNaW5pc3RlciIsImVtYWlsIjoiYWRtaW5AbWFpbC5jb20iLCJwYXNzd29yZCI6IiQyYiQxMCRsTG01THA0MHVCUjlDVXJabjU4Q2RPbDh5dTVHcDJ1bUFPLjZseS52V2NaMGEwdlVLc0hpQyIsImF2YXRhciI6Imh0dHBzOi8vY2xvdWRmbGFyZS1pcGZzLmNvbS9pcGZzL1FtZDNXNUR1aGdIaXJMSEdWaXhpNlY3NkxoQ2taVXo2cG5GdDVBSkJpeXZIeWUvYXZhdGFyLzc2Mi5qcGciLCJ1c2VyTGV2ZWwiOjQsImNyZWF0ZWRBdCI6MTY3MDE2NTk4MDYzOCwiaWF0IjoxNjcwNzI4ODg1LCJleHAiOjE2NzA3Mzk2ODV9.fFL7sflnhLs0C0cj4c8EgsTeJHu3Sh9u80cLFgMwPm0",
  user: {
    id: 1,
    username: "admin",
    firstname: "Ad",
    lastname: "Minister",
    email: "admin@mail.com",
    password: "$2b$10$lLm5Lp40uBR9CUrZn58CdOl8yu5Gp2umAO.6ly.vWcZ0a0vUKsHiC",
    avatar:
      "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/762.jpg",
    userLevel: 4,
    createdAt: 1670165980638,
  },
}; 

data.map(({ submission_link: url, id }) => {
  describe("Test", () => {
    let acc_score = 1;

    beforeEach(() => {
      Cypress.on("uncaught:exception", (err, runnable) => {
        return false;
      });
    });

    before(() => {
      // cy.setLocalStorage("userId", null);
      // cy.setLocalStorage("localAccessToken", null);
    });

    beforeEach(() => {
      // cy.restoreLocalStorage();
    });

    afterEach(() => {
      // cy.saveLocalStorage();
    });

    // let numOfRecipes = recipeData.length;

    it("Able to display 10 user cards on load", () => {
      cy.visit(url);
      cy.wait(1000);


      const cards = ".data-list-wrapper .card-list .card";

      cy.get(cards).should('have.length',10);

      cy.get(cards).first().should("contain", "Ad Minister");

      cy.then(() => {
        acc_score += 5;
      });
    });

    it("Able browse paginated data", () => {
      const paginationButtons = "#pagination-wrapper .pagination-button";
      cy.get(paginationButtons).should('have.length.at.least', 2);
      cy.get(paginationButtons).eq(1).click()


      const cards = ".data-list-wrapper .card-list .card";
      cy.get(cards).should('have.length',10);

      cy.get(cards).first().find('.card__img').should('exist')
      cy.get(cards).first().find('.card__body').should('exist')
      cy.get(cards).first().find('.card__title').should('exist')
      cy.get(cards).first().find('.card__description').should('exist')

      cy.then(() => {
        acc_score += 4;
      });
    });

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
  }); // describe
});
