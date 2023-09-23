import data from "../../submissionData.json"; // do not create this file

// let data = [{ submission_link: "http://localhost:8080/", id: 67890 }];

data.forEach((ele) => {
  describe("Test", () => {
    let url = ele.submission_link;
    let acc_score = 1;
    if (url && url.trim().length) {
      it("The Navbar has been built with flex", () => {
        cy.visit(url);
        cy.get(".nav")
          .should("have.css", "display", "flex")
          .then(() => {
            acc_score += 1;
          });
        cy.get(".nav h1");
        cy.get(".nav button");
        cy.get(".nav>div p");

        cy.then(() => {
          acc_score += 1;
        });
      }); // Giving a score of 2
      it("Top part has display grid & the basic structure", () => {
        cy.visit(url);
        cy.get(".top div")
          .should("have.css", "display", "grid")
          .then(() => {
            acc_score += 1;
          });
        cy.get(".top>div>div img");
        cy.get(".top>div>div h3");
        cy.get(".top>div>div p");
        cy.then(() => {
          acc_score += 1;
        });
      }); // Giving a score of 2

      it("Mid Part has display grid and the basic structure", () => {
        cy.visit(url);
        cy.get(".mid>div")
          .should("have.css", "display", "grid")
          .then(() => {
            acc_score += 1;
          });

        cy.get(".mid>div>div img");
        cy.get(".mid>div>div p");
        cy.get(".mid>div>div h3");
        cy.get(".mid>div>div div");

        cy.then(() => {
          acc_score += 1;
        });
      }); // Giving a score of 2

      it("Bottom part has display flex and the basic structure", () => {
        cy.get(".bottom").children("div").should("have.length", 2);
        cy.get(".bottom>div:nth-child(1) img");
        cy.get(".bottom>div:nth-child(2) img");
        cy.get(".bottom>div:nth-child(2) h1");
        cy.get(".bottom>div:nth-child(2) p");
        cy.then(() => {
          acc_score += 1;
        });
      }); // Giving a score of 1
      it(`Check the responsiveness of the website`, () => {
        cy.viewport(900, 800);
        cy.get(".nav>div")
          .should("not.be.visible")
          .then(() => {
            acc_score += 1;
          });
        cy.get(".bottom")
          .should("have.css", "flex-direction", "column")
          .then(() => {
            acc_score += 1;
          });
      }); // 2
    }
    it(`generate score`, () => {
      //////////////
      console.log(acc_score);
      let result = {
        id: ele.id,
        marks: Math.floor(acc_score),
      };
      result = JSON.stringify(result);
      cy.writeFile("results.json", `\n${result},`, { flag: "a+" }, (err) => {
        if (err) {
          console.error(err);
        }
      });
    });
  });
});
