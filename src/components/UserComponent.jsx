import React from 'react'
import UserService from '../services/UserService'
import RolesService from '../services/RolesService'

class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users:[],
            roles:[],
        }

        this.blockUser = this.blockUser.bind(this);

    }

    componentDidMount(){
        UserService.getUsers().then((response) =>{
            this.setState({users:response.data})
        });
        RolesService.getRoles().then((response)=>{
            this.setState({roles:response.data})
        });
    }

    
    blockUser(id){
        this.props.history.push(`/blockUser/${id}`);
    }


    render(){
        return (
            <div>
                <h1 className="text-center"> Korisnici</h1>
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
                            {<td>Uloga</td>}
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

                                     <td>{user.roles.naziv}</td> 
                                    <td>          
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.blockUser(user.id)} className="btn btn-danger">Block</button>
                                    </td>
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

