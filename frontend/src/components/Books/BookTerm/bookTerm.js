import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.availableCopies}</td>

            <td className={"text-right"}>

                <button className={"btn btn-success"}
                        onClick={() => props.markAsTaken(props.term.id)}
                        disabled={props.term.availableCopies === 0}>Mark as Taken
                </button>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>Edit
                </Link>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>Delete
                </a>
            </td>
        </tr>
    )
}

export default bookTerm;
