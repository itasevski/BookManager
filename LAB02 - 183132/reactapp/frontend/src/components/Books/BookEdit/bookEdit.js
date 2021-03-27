import React from 'react';
import {useHistory} from 'react-router-dom';


const EditProduct = (props) => {

    const history = useHistory();
    const[formData, updateFormData] = React.useState({
        name: "",
        availableCopies: -1,
        author: 0,
        category: ""
    });

    const handleFieldChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const submit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const category = formData.category !== "" ? formData.category : props.book.category;
        const author = formData.author !== 0 ? formData.author : props.book.author.id;
        const availableCopies = formData.availableCopies !== -1 ? formData.availableCopies : props.book.availableCopies;

        props.onEditBook(props.book.id, name, category, author, availableCopies);
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
                               placeholder={props.book.name}
                               onChange={handleFieldChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Available copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               onChange={handleFieldChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleFieldChange}>
                            {props.authors.map((term) => {
                                if(props.book.author !== undefined && props.book.author.id === term.id)
                                    return <option value={term.id} selected={term.id}>{term.name} {term.surname}</option>;
                                else
                                    return <option value={term.id}>{term.name} {term.surname}</option>;
                            })}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleFieldChange}>
                            {props.categories.map((term) => {
                                if(props.book.category !== undefined && props.book.category === term)
                                    return <option value={term} selected={term}>{term}</option>;
                                else
                                    return <option value={term}>{term}</option>;
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );

};


export default EditProduct;