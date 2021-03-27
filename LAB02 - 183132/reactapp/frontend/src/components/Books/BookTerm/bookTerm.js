import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr>
            <td>
                <span className="user-link">{props.term.name}</span>
                <span className="user-subhead">{props.term.category}</span>
            </td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td className="text-center">
                <span className="label label-default">{props.term.availableCopies}</span>
            </td>
            <td style={{width: 20 + "%"}}>
                <a className="table-link text-warning btn btn-danger" style={{marginRight: 7 + "px"}}
                   onClick={() => props.onDeleteBook(props.term.id)}>
                                            <span className="fa-stack">
                                                <i className="icon-trash icon-large"></i>
                                            </span>
                </a>
                <Link className="table-link text-info btn" style={{marginRight: 7 + "px"}}
                    onClick={() => props.onEditClick(props.term.id)}
                    to={`/books/edit/${props.term.id}`}>
                                            <span className="fa-stack">
                                                <i className="icon-cog icon-large icon-spin"></i>
                                            </span>
                </Link>
                <a className="table-link text-info btn btn-small btn-warning"
                    onClick={() => props.onDecrementBook(props.term.id)}>
                                            <span className="fa-stack">
                                                Mark as taken
                                            </span>
                </a>
            </td>
        </tr>
    );
};

export default bookTerm;