import React from 'react';
import {useHistory} from 'react-router-dom';


const BookAdd = (props) => {

    const history = useHistory();
    const[formData, updateFormData] = React.useState({
        name: "",
        availableCopies: 0,
        author: 1,
        category: "NOVEL"
    });

    const handleFieldChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const submit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const author = formData.author;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, author, availableCopies);
        history.push("/");
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={submit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder="Enter book name..."
                               onChange={handleFieldChange}
                               required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="Enter available copies..."
                               onChange={handleFieldChange}
                               required
                        />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleFieldChange}>
                            {props.authors.map((term) => <option value={term.id}>{term.name} {term.surname}</option>)}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleFieldChange}>
                            {props.categories.map((term) => <option value={term}>{term}</option>)}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );

};


export default BookAdd;