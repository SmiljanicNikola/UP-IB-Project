import React, { Component } from 'react'
import "../App.css";
//import AuthService from "../services/auth.service";
class Login extends Component {

    constructor(props){
        super(props)

        this.state = {
            
            email: '',
            lozinka: '',
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        
        this.changeLozinkaHandler = this.changeLozinkaHandler.bind(this);
        

        //this.saveKorisnik = this.saveKorisnik.bind(this);

    }
    /*saveKorisnik = (e) =>{
        e.preventDefault();
        let korisnik = {ime: this.state.ime, prezime: this.state.prezime, email: this.state.email,
                        adresa: this.state.adresa, lozinka: this.state.lozinka, grad: this.state.grad,
                        drzava: this.state.drzava, telefon: this.state.telefon, uloga: this.state.uloga};
        console.log('korisnik => ' + JSON.stringify(korisnik));
    }*/
    changeImeHandler= (event) =>{
        this.setState({ime:event.target.value});
    }

    changePrezimeHandler= (event) =>{
        this.setState({prezime:event.target.value});
    }

    changeEmailHandler= (event) =>{
        this.setState({email:event.target.value});
    }

    changeAdresaHandler= (event) =>{
        this.setState({adresa:event.target.value});
    }

    changeLozinkaHandler= (event) =>{
        this.setState({lozinka:event.target.value});
    }

    changeGradHandler= (event) =>{
        this.setState({grad:event.target.value});
    }

    changeDrzavaHandler= (event) =>{
        this.setState({drzava:event.target.value});
    }

    changeTelefonHandler= (event) =>{
        this.setState({telefon:event.target.value});
    }

    changeUlogaHandler= (event) =>{
        this.setState({uloga:event.target.value});
    }


    cancel(){
        this.props.history.push('/korisnici');
    }

    
    render(){
        return (
            
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Login</h3>
                            <div className="card-body">
                                <form>

                                        <div className="form-group">    
                                            <label>Email: </label>
                                            <input placeholder="email" name="email" className="form-control"
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>

                                    
                                        <div className="form-group">                
                                            <label>Lozinka: </label>
                                            <input placeholder="lozinka" name="lozinka" className="form-control"
                                                value={this.state.lozinka} onChange={this.changeLozinkaHandler}/>
                                        </div>

                                        <br></br>
                                        <center>
                                            <button className="btn btn-success" onClick={this.saveKorisnik}>Login</button>
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
