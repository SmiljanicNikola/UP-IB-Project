import React from 'react'
import UserService from '../services/UserService'
import RolesService from '../services/RolesService'
import PacijentService from '../services/PacijentService'

class RegistracijeZahtevi extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users:[],
            roles:[],
            pacijenti:PacijentService.getPacijente(),
        }
        this.odbij = this.odbij.bind(this);

    }

    componentDidMount(){

        PacijentService.getPacijente().then((response)=>{
            this.setState({pacijenti:response.data})
        });

        UserService.getUsers().then((response) =>{


            PacijentService.getPacijente().then((response)=>{
                this.setState({pacijenti:response.data})
            

            this.setState({users:response.data})
            this.setState({users: this.state.users.filter(users => ((users.active == true) && (users.id == this.state.pacijenti.user.id)))})});})
        RolesService.getRoles().then((response)=>{
            this.setState({roles:response.data})
        });
    }

    
    odbij(id){
        UserService.deleteUser(id).then(res => {
            this.setState({korisnik: this.state.users.filter(users => users.id !== id)})
        })
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
                            <td>Active</td>
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
                                    <td>{user.active}</td>
                                    <td>          
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.odbij(user.id)} className="btn btn-danger">Odbij</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.odbij(user.id)} className="btn btn-success">Prihvati</button>

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

export default RegistracijeZahtevi

