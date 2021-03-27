import axios from '../axios-custom/axios';

const bmService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "authorId" : author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "authorId" : author,
            "availableCopies" : availableCopies
        });
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    decrementBookCopies: (id) => {
        return axios.get(`/books/decrement/${id}`);
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    }
};

export default bmService;