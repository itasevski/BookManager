import React, {Component} from 'react';
import ReactPaginate from 'react-paginate';
import {Link} from 'react-router-dom';

import BookTerm from '../BookTerm/bookTerm';


class Books extends Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5
        }
    }

    render() {
        const offset = this.state.page * this.state.size;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);

        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div className="bootstrap snippets bootdey">
                <div className="row">
                    <div className="col-lg-12">
                        <div className="main-box no-header clearfix">
                            <div className="main-box-body clearfix">
                                <div className="table-responsive">
                                    <table className="table user-list">
                                        <thead>
                                        <tr>
                                            <th><span>Name</span></th>
                                            <th className="text-center"><span>Author</span></th>
                                            <th><span>Available copies</span></th>
                                            <th>&nbsp;</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {books}
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col mb-3">
                    <div className="row">
                        <div className="col-sm-12 col-md-12">
                            <Link className="btn btn-block btn-primary" to={"/books/add"}>Add new product</Link>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"Back"}
                               nextLabel={"Next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        );
    }


    handlePageClick = (e) => {
        var selected = e.selected;
        this.setState({
            page: selected
        });
    };

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((term, index) => {
            return (
                <BookTerm term={term} onDeleteBook={this.props.onDeleteBook}
                          onDecrementBook={this.props.onDecrementBook}
                          onEditClick={this.props.onEditClick}/>
            );
        }).filter((book, index) => (index >= offset && index < nextPageOffset));
    }

}


export default Books;