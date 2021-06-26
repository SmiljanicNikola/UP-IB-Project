import React from 'react'
import UserService from '../services/UserService'


class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }

        this.addUser = this.addUser.bind(this);
    }

    componentDidMount(){
        UserService.getUsers().then((response) =>{
            this.setState({users:response.data})
        });
    }

    addUser(){
        this.props.history.push('/register');
    }


    render(){
        return (
            <div>
                <h1 className="text-center"> Lista korisnika</h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    

                </div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Ime</td>
                            <td>Prezime</td>
                            <td>Email</td>
                            <td>Adresa</td>
                            <td>Grad</td>
                            <td>Drzava</td>
                            <td>Telefon</td>
                            <td>Uloga</td>
                            <td>Actions</td>

                           
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.users.map(
                                user=>
                                <tr key = {user.id}>
                                    <td> {user.id}</td>
                                    <td> {user.firstname}</td>
                                    <td>{user.lastname}</td>
                                    <td>{user.username}</td>
                                    <td>{user.adress}</td>
                                    <td>{user.city}</td>
                                    <td>{user.country}</td>
                                    <td>{user.phone}</td>
                                    <td>{user.roles.id}</td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>


            </div>
        )
    }

}

export default UserComponent

