class Book {

    constructor(name,author,section){
        this.name = name;
        this.author = author;
        this.section = section;
    }
}

class Section {
    constructor(name){
        this.name = name;
        this.books = [];
    }

    addBookToSection(book){
       if(!this.checkbookInSection(book)){
        this.books.push(book)
       }

    }

    checkbookInSection(book){
        for (const b of this.books) {
            if(b.name == book.name && b.author == book.author){
                return true;
            }
        }
        return false;
    }
}

class Library {

    constructor(name){
        this.name = name;
        this.sections = [];
    }

    addSection(sectionobj){
        if(!this.checksection(sectionobj)){
            this.sections.push(sectionobj);
        }
    }

    addBookToLibrary(book){
        for (const sec of this.sections) {
            if(sec.name == book.section){
                sec.addBookToSection(book)
            }
        }
    }

    checksection(sec){
        for (const s of this.sections) {
            if(s.name == sec.name){
                return true;
            }
        }
        return false;
    }

}

// Do not change the export statement below

export { Library, Section, Book };
