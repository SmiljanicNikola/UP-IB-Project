import React, { Component } from 'react'
import PregledService from '../../services/PregledService';
import KorisnikService from '../../services/KorisnikService';


class UpdateNurseComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstname: '',
            lastname: '',
            username: '',
            adress: '',
            password: '',
            city: '',
            country: '',
            phone: '',
            active: '',
            clinic_id: '',
        }
        this.changeFirstnameHandler = this.changeFirstnameHandler.bind(this);
        this.changeLastnameHandler = this.changeLastnameHandler.bind(this);
        this.changeAdressHandler = this.changeAdressHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeCountryHandler = this.changeCountryHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
      

        this.updateNurse = this.updateNurse.bind(this);
}

componentDidMount(){
    KorisnikService.getUserById(this.state.id).then( (res) =>{
        let korisnik = res.data;
        this.setState({
            firstname: korisnik.firstname,
            lastname: korisnik.lastname,
            city: korisnik.city,
            country: korisnik.country,
            phone: korisnik.phone,
            adress: korisnik.adress,
            password: korisnik.password,
            username: korisnik.username,
            active: korisnik.active,
        });

    });
}

updateNurse = (e) =>{
        e.preventDefault();
        let korisnik = {firstname: this.state.firstname, lastname: this.state.lastname,
            username: this.state.username, adress: this.state.adress,
            password: this.state.password,
            city: this.state.city,  country: this.state.country,
            phone: this.state.phone,  active: this.state.active

        }
        console.log('korisnik => ' + JSON.stringify(korisnik));
        KorisnikService.updateeKorisnik(korisnik, this.state.id).then(res => {
            this.props.history.push('/medicinskesestre');
        });
   
}

changeFirstnameHandler= (event) =>{
    this.setState({firstname: event.target.value});
}

changeLastnameHandler= (event) =>{
    this.setState({lastname: event.target.value});
}

changeAdressHandler= (event) =>{
    this.setState({adress: event.target.value});
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


cancel(){
    this.props.history.push('/medicinskesestre');
}

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Edit nurse (User)</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Firstname</label>
                                        <input placeholder="Firstname" name="firstname" className="form-control"
                                            value={this.state.firstname} onChange={this.changeFirstnameHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Lastname</label>
                                        <input placeholder="Lastname" name="lastname" className="form-control"
                                            value={this.state.lastname} onChange={this.changeLastnameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Adress</label>
                                        <input placeholder="Adress" name="adress" className="form-control"
                                            value={this.state.adress} onChange={this.changeAdressHandler}/>
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
                                        <label>Phone</label>
                                        <input placeholder="Phone" name="phone" className="form-control"
                                            value={this.state.phone} onChange={this.changePhoneHandler}/>
                                    </div>
        
                                    <button className="btn btn-success" onClick={this.updateNurse}>Edit</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default UpdateNurseComponent