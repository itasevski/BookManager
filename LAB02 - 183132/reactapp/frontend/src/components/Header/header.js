import React from 'react';
import {Link} from 'react-router-dom';

const header = (props) => {
    return (
        <nav className="navbar navbar-inverse">
            <div className="container-fluid">
                <div className="navbar-header">
                    <span className="navbar-brand" style={{color: "white"}}>BookManager</span>
                </div>
                <div className="collapse navbar-collapse">
                    <ul className="nav navbar-nav">
                        <li style={{paddingTop: 7 + "px"}}>
                            <Link to={"/books"}>Books</Link>
                        </li>
                        <li style={{paddingTop: 7 + "px"}}>
                            <Link to={"/categories"}>Categories</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
};

export default header;