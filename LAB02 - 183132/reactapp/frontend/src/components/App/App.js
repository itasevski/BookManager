import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';

import axios from '../../axios-custom/axios';
import bmRepository from '../../repository/bmRepository';

import Header from '../Header/header';
import Books from '../Books/BookList/books';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from '../Books/BookEdit/bookEdit';
import Categories from '../Categories/categories';


class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            books: [],
            categories: [],
            authors: [],
            currentBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header />
                <main>
                    <div className="container">
                        <Route path={"/"} exact render={() => <Books books={this.state.books}
                                                                     onDeleteBook={this.deleteBook}
                                                                     onDecrementBook={this.decrementBookCopies}
                                                                     onEditClick={this.fetchBook}/>}/>
                        <Route path={"/books"} exact render={() => <Books books={this.state.books}
                                                                          onDeleteBook={this.deleteBook}
                                                                          onDecrementBook={this.decrementBookCopies}
                                                                          onEditClick={this.fetchBook}/>}/>
                        <Route path={"/books/add"} exact render={() => <BookAdd authors={this.state.authors}
                                                                                categories={this.state.categories}
                                                                                onAddBook={this.addBook}/>}/>
                        <Route path={"/books/edit/:id"} exact render={() => <BookEdit authors={this.state.authors}
                                                                                      categories={this.state.categories}
                                                                                      book={this.state.currentBook}
                                                                                      onEditBook={this.editBook}/>}/>

                        <Route path={"/categories"} exact render={() => <Categories categories={this.state.categories}/>}/>

                        <Redirect to={"/"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }


    loadBooks = () => {
        bmRepository.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                });
            });
    };

    loadCategories = () => {
        bmRepository.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                });
            });
    };

    loadAuthors = () => {
        bmRepository.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                });
            });
    };

    addBook = (name, category, author, availableCopies) => {
        bmRepository.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    };

    editBook = (id, name, category, author, availableCopies) => {
        bmRepository.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    };

    deleteBook = (id) => {
        bmRepository.deleteBook(id)
            .then(() => {
                this.loadBooks()
            });
    };

    fetchBook = (id) => {
        bmRepository.fetchBook(id)
            .then((data) => {
                this.setState({
                    currentBook: data.data
                });
            });
    };

    decrementBookCopies = (id) => {
        bmRepository.decrementBookCopies(id)
            .then(() => {
                this.loadBooks()
            });
    };

}


export default App;