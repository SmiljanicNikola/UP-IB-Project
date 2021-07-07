import React from 'react'
import UserService from '../services/UserService'
import RolesService from '../services/RolesService'
import PacijentService from '../services/PacijentService'
import KorisnikService from '../services/KorisnikService'

class RegistracijeZahtevi extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            users:[],
            roles:[],
            pacijenti:PacijentService.getPacijente(),
        }
        this.odbij = this.odbij.bind(this);
        this.prihvati = this.prihvati.bind(this);

    }

    componentDidMount(){

        PacijentService.getPacijente().then((response)=>{
            this.setState({pacijenti:response.data})
        });

        UserService.getUsers().then((response) =>{

            

            this.setState({users:response.data})
            this.setState({users: this.state.users.filter(users => (users.active ==false))})});
        RolesService.getRoles().then((response)=>{
            this.setState({roles:response.data})
        });
    }

    
    odbij(id){
        this.setState({users: this.state.users.filter(users => users.id !== id)})
    }

    prihvati(id){
        KorisnikService.unblockUser(id).then(res => {
            this.setState({users : this.state.users.filter(users => users.id !== id)})
        })
    }


    render(){
        return (
            <div>
                <br></br>
                <h1 className="text-center"> Zahtevi za registraciju(I Blokirani) </h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    

                </div>
                <br></br><br></br>
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
                                    <td>          
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.odbij(user.id)} className="btn btn-danger">Odbij</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.prihvati(user.id)} className="btn btn-success">Prihvati</button>

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

