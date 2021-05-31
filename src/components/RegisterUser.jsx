import React, { Component } from 'react'

class RegisterUser extends Component {

    constructor(props){
        super(props)

        this.state = {
            ime: '',
            prezime: '',
            email: '',
            adresa: '',
            lozinka: '',
            grad: '',
            drzava: '',
            telefon: '',
            uloga: ''
        }

        this.changeImeHandler = this.changeImeHandler.bind(this);
        this.changePrezimeHandler = this.changePrezimeHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeAdresaHandler = this.changeAdresaHandler.bind(this);
        this.changeLozinkaHandler = this.changeLozinkaHandler.bind(this);
        this.changeGradHandler = this.changeGradHandler.bind(this);
        this.changeDrzavaHandler = this.changeDrzavaHandler.bind(this);
        this.changeTelefonHandler = this.changeTelefonHandler.bind(this);
        this.changeUlogaHandler = this.changeUlogaHandler.bind(this);

        this.saveKorisnik = this.saveKorisnik.bind(this);



    }


    saveKorisnik = (e) =>{
        e.preventDefault();
        let korisnik = {ime: this.state.ime, prezime: this.state.prezime, email: this.state.email,
                        adresa: this.state.adresa, lozinka: this.state.lozinka, grad: this.state.grad,
                        drzava: this.state.drzava, telefon: this.state.telefon, uloga: this.state.uloga};
        console.log('korisnik => ' + JSON.stringify(korisnik));
    }

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
                            <h3 className="text-center">Register</h3>
                            <div className="card-body">
                                <form>
                                    <div class="form-group">
                                        <label>Ime: </label>
                                        <input placeholder="ime" name="ime" className="form-control"
                                            value={this.state.ime} onChange={this.changeImeHandler}/>
                                        </div>

                                        <div className="form-group">    
                                            <label>Prezime: </label>
                                            <input placeholder="prezime" name="prezime" className="form-control"
                                                value={this.state.prezime} onChange={this.changePrezimeHandler}/>
                                        </div>

                                        <div className="form-group">    
                                            <label>Email: </label>
                                            <input placeholder="email" name="email" className="form-control"
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <div className="form-group">    
                                            <label>Adresa: </label>
                                            <input placeholder="adresa" name="adresa" className="form-control"
                                                value={this.state.adresa} onChange={this.changeAdresaHandler}/>
                                        </div>

                                        <div className="form-group">                
                                            <label>Lozinka: </label>
                                            <input placeholder="lozinka" name="lozinka" className="form-control"
                                                value={this.state.lozinka} onChange={this.changeLozinkaHandler}/>
                                        </div>


                                        <div className="form-group">    
                                            <label>Grad: </label>
                                            <input placeholder="grad" name="grad" className="form-control"
                                                value={this.state.grad} onChange={this.changeGradHandler}/>
                                        </div>

                                        <div className="form-group">
                                            <label>Drzava: </label>
                                            <input placeholder="drzava" name="drzava" className="form-control"
                                                value={this.state.drzava} onChange={this.changeDrzavaHandler}/>
                                        </div>

                                        <div className="form-group">
                                            <label>Telefon: </label>
                                            <input placeholder="telefon" name="telefon" className="form-control"
                                                value={this.state.telefon} onChange={this.changeTelefonHandler}/>
                                        </div>

                                        <div className="form-group">
                                            <label>Uloga: </label>
                                            <input placeholder="uloga" name="uloga" className="form-control"
                                                value={this.state.uloga} onChange={this.changeUlogaHandler}/>
                                        </div>

                                        <center>
                                        <button className="btn btn-success" onClick={this.saveKorisnik}>Register</button>
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

export default RegisterUser
