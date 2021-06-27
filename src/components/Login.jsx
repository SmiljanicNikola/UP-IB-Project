import axios from 'axios';
import React, { Component } from 'react'
import "../App.css";
//import AuthService from "../services/auth.service";
class Login extends Component {

    /*constructor(props){
        super(props)

        this.state = {
            
            username: '',
            password: '',
        }
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        

        //this.saveKorisnik = this.saveKorisnik.bind(this);

    }*/

    handeSubmit = e =>{
        e.preventDefault();


        const data = {
            username: this.username,
            password: this.password
        };

        axios.post("http://localhost:8080/api/auth/login", data)
            .then(res => {
                localStorage.setItem('accessToken', res.data.token);
            })
            .catch(err => {
                console.log(err)
            })


    };
    /*saveKorisnik = (e) =>{
        e.preventDefault();
        let korisnik = {ime: this.state.ime, prezime: this.state.prezime, email: this.state.email,
                        adresa: this.state.adresa, lozinka: this.state.lozinka, grad: this.state.grad,
                        drzava: this.state.drzava, telefon: this.state.telefon, uloga: this.state.uloga};
        console.log('korisnik => ' + JSON.stringify(korisnik));
    }*/

    changeUsernameHandler= (event) =>{
        this.setState({username:event.target.value});
    }
    changePasswordHandler= (event) =>{
        this.setState({password:event.target.value});
    }

    cancel(){
        this.props.history.push('/login');
    }

    
    render(){
        return (
            
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Login</h3>
                            <div className="card-body">
                                <form onSubmit={this.handleSubmit}>


                                        <div className="form-group">    
                                            <label>Username: </label>
                                            <input placeholder="username" type="username" className="form-control"
                                               onChange={e => this.username = e.target.value}/>
                                        </div>

                                        <div className="form-group">                
                                            <label>Password: </label>
                                            <input placeholder="password" type="password" className="form-control"
                                                onChange={e => this.password = e.target.value}/>
                                        </div>
                                        <br></br>
                                        <center>
                                            <button className="btn btn-primary btn-block">Login</button>
                                            <button className="btn btn-danger" onClick={this.cancel}>Cancel</button>

                                        </center>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default Login
