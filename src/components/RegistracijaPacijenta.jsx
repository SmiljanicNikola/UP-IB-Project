import React, { Component } from 'react'
import UserService from '../services/UserService';
import PacijentService from '../services/PacijentService';


class RegistracijaPacijenta extends React.Component {
    constructor(props){
        super(props)

        this.state = {
            firstname: '',
            lastname: '',
            username: '',
            adress: '',
            password: '',
            repeatPassword: '',
            city: '',
            country: '',
            phone: '',
            active: false,
            prviput:true,
            lbo: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeAdressHandler = this.changeAdressHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.changerepeatPasswordHandler = this.changerepeatPasswordHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeCountryHandler = this.changeCountryHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.changeActiveHandler = this.changeActiveHandler.bind(this);
        this.changeLboHandler = this.changeLboHandler.bind(this);

        this.savePatient = this.savePatient.bind(this);
    
    }

    savePatient = (e) =>{
        e.preventDefault();
        let test={repeatPassword:this.state.repeatPassword, password:this.state.password}
        
        if(test.repeatPassword != test.password){
            console.log('Lozinke se ne podudaraju!');
        }
        else if(test.password.length < 5){
            console.log('Lozinka je previse kratka!')
        }
        else{
        let pacijent = {firstname: this.state.firstname, lastname: this.state.lastname, username: this.state.username,
            adress: this.state.adress, password: this.state.password, city: this.state.city,
            country: this.state.country, phone: this.state.phone, active: this.state.active, prviput:this.state.prviput,
            lbo: this.state.lbo
            }
            console.log('Pacijent => ' + JSON.stringify(pacijent));
            
            PacijentService.createPacijent(pacijent).then(res=>{
                this.props.history.push('/api/auth/patient/signup')
            });
        }

    }

    changeFirstNameHandler= (event) =>{
        this.setState({firstname: event.target.value});
    }

    changeLastNameHandler= (event) =>{
        this.setState({lastname: event.target.value});
    }

    changeUserNameHandler= (event) =>{
        this.setState({username: event.target.value});
    }

    changeAdressHandler= (event) =>{
        this.setState({adress: event.target.value});
    }

    changePasswordHandler= (event) =>{
        this.setState({password: event.target.value});
    }

    changeCityHandler= (event) =>{
        this.setState({city: event.target.value});
    }

    changeCountryHandler= (event) =>{
        this.setState({country: event.target.value});
    }

    changePhoneHandler= (event) =>{
        this.setState({phone: event.target.value});
    }

    changeActiveHandler= (event) =>{
        this.setState({active: false});
    }

    changeLboHandler= (event) =>{
        this.setState({lbo: event.target.value});
    }

    changerepeatPasswordHandler= (event) =>{
        this.setState({repeatPassword: event.target.value});
    }

    cancel(){
        this.props.history.push('/korisnici');
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Registracija pacijenata</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Firstname:</label>
                                        <input placeholder="First name" name="firstname" className="form-control"
                                            value={this.state.firstname} onChange={this.changeFirstNameHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Lastname:</label>
                                        <input placeholder="Last name" name="lastname" className="form-control"
                                            value={this.state.lastname} onChange={this.changeLastNameHandler}/>    
                                    </div>

                                    <div className="form-group">
                                        <label>Username:</label>
                                        <input placeholder="Username" name="username" className="form-control"
                                            value={this.state.username} onChange={this.changeUserNameHandler}/>      
                                    </div>

                                    <div className="form-group">
                                        <label>Adress:</label>
                                        <input placeholder="Adress" name="adress" className="form-control"
                                            value={this.state.adress} onChange={this.changeAdressHandler}/>    
                                    </div>

                                    <div className="form-group">
                                        <label>Password:</label>
                                        <input placeholder="Password" name="password" type="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Ponovljen password:</label>
                                        <input placeholder="Ponovljen password" name="repeatPassword" type="password" className="form-control"
                                            value={this.state.repeatPassword} onChange={this.changerepeatPasswordHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>City</label>
                                        <input placeholder="City" name="city" className="form-control"
                                            value={this.state.city} onChange={this.changeCityHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Country</label>
                                        <input placeholder="Country" name="country" className="form-control"
                                            value={this.state.country} onChange={this.changeCountryHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Phone number</label>
                                        <input placeholder="Phone" name="phone" className="form-control"
                                            value={this.state.phone} onChange={this.changePhoneHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Lbo</label>
                                        <input placeholder="Lbo" name="lbo" className="form-control"
                                            value={this.state.lbo} onChange={this.changeLboHandler}/>
                                    </div>

                                    <button className="btn btn-success" onClick={this.savePatient}>Save    </button>
                                    <button className="btn btn-danger" onClick={this.cancel}>   Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default RegistracijaPacijenta