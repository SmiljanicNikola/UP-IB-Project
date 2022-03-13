import React, { Component } from 'react'
import ClinicService from '../services/ClinicService';
import KorisnikService from '../services/KorisnikService';


class ChangePasswordComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstname: '',
            lastname: '',
            username: '',
            password:'',
            repeatPassword:'',
            adress: '',
            city: '',
            country: '',
            phone: '',
        }

        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.changerepeatPasswordHandler = this.changerepeatPasswordHandler.bind(this);
        this.changeFirstnameHandler = this.changeFirstnameHandler.bind(this);
        this.changeLastnameHandler = this.changeLastnameHandler.bind(this);
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changeAdressHandler = this.changeAdressHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeCountryHandler = this.changeCountryHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);

        this.updatePassword = this.updatePassword.bind(this);
    }

    componentDidMount(){
        KorisnikService.getKorisnikById(this.state.id).then( (res) =>{
            let korisnik = res.data;
            this.setState({
                firstname: korisnik.firstname,
                lastname: korisnik.lastname,
                username: korisnik.username,
                adress: korisnik.adress,
                city: korisnik.city,
                country: korisnik.country,
                phone: korisnik.phone,
                
            });
        });
    }

    updatePassword = (e) =>{
            e.preventDefault();
            let test={repeatPassword:this.state.repeatPassword, password:this.state.password}
        
            if(test.repeatPassword != test.password){
            console.log('Lozinke se ne podudaraju!');
            }
            else if(test.password.length < 5){
            console.log('Lozinka je previse kratka!')
            }
            else{
            let korisnik = {firstname: this.state.firstname, lastname: this.state.lastname, password: this.state.password, username: this.state.username,
                adress: this.state.adress, city: this.state.city,  country: this.state.country, phone:this.state.phone}
            
            KorisnikService.updateKorisnik(korisnik, this.state.id).then(res => {
                this.props.history.push('/profile');
            });
    
        }
    }

    changePasswordHandler = (event) =>{
        this.setState({password: event.target.value});
    }

    changerepeatPasswordHandler = (event) =>{
        this.setState({repeatPassword: event.target.value});
    }

    changeFirstnameHandler = (event) =>{
        this.setState({firstname: event.target.value});
    }

    changeLastnameHandler = (event) =>{
        this.setState({lastname: event.target.value});
    }

    changePhoneHandler = (event) =>{
        this.setState({phone: event.target.value});
    }

    changeCityHandler = (event) =>{
        this.setState({city: event.target.value});
    }

    changeCountryHandler = (event) =>{
        this.setState({city: event.target.value});
    }

    changeAdressHandler = (event) =>{
        this.setState({adress: event.target.value});
    }

    changeUsernameHandler = (event) =>{
        this.setState({username: event.target.value});
    }

    cancel(){
        this.props.history.push('/profile');
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Change Password</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <input placeholder="Password" name="password" type="password" className="form-control"
                                            value={this.state.password} onChange={this.changePasswordHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Repeat password</label>
                                        <input placeholder="Repeat password" name="repeatPassword" type="password" className="form-control"
                                            value={this.state.repeatPassword} onChange={this.changerepeatPasswordHandler}/>
                                    </div>

                                    <br></br>
                                    <button className="btn btn-success" onClick={this.updatePassword}>Confirm change</button>
                                
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ChangePasswordComponent