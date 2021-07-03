import React, { Component } from 'react'
import ClinicService from '../../services/ClinicService';



class UpdateClinicComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            adresa: '',
            prosecnaOcena: '',
        }
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeAdresaHandler = this.changeAdresaHandler.bind(this);
        this.changeProsecnaOcena = this.changeProsecnaOcena.bind(this);

        this.updateClinic = this.updateClinic.bind(this);
}

componentDidMount(){
    ClinicService.getClinicById(this.state.id).then( (res) =>{
        let clinic = res.data;
        this.setState({
            naziv: clinic.naziv,
            adresa: clinic.adresa,
            prosecnaOcena: clinic.prosecnaOcena,
            
        });

    });
}

updateClinic = (e) =>{
        e.preventDefault();
        let clinic = {naziv: this.state.naziv, adresa: this.state.adresa, prosecnaOcena: this.state.prosecnaOcena
        }
        console.log('clinic => ' + JSON.stringify(clinic));
        ClinicService.updateClinic(clinic, this.state.id).then(res => {
            this.props.history.push('/klinike');
        });
   
}

changeNazivHandler= (event) =>{
    this.setState({naziv: event.target.value});
}

changeAdresaHandler= (event) =>{
    this.setState({adresa: event.target.value});
}

changeProsecnaOcena= (event) =>{
    this.setState({prosecnaOcena: event.target.value});
}

cancel(){
    this.props.history.push('/klinike');
}

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Edit Clinic</h3>
                            <div className="card-body">
                                <form>
                                <div className="form-group">
                                        <label>Naziv</label>
                                        <input placeholder="Naziv" name="naziv" className="form-control"
                                            value={this.state.naziv} onChange={this.changeNazivHandler}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Adresa</label>
                                        <input placeholder="Adresa" name="adresa" className="form-control"
                                            value={this.state.adresa} onChange={this.changeAdresaHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Prosecna Ocena</label>
                                        <input placeholder="Prosecna ocena" name="prosecnaOcena" className="form-control"
                                            value={this.state.prosecnaOcena} onChange={this.changeProsecnaOcena}/>
                                    </div>
        
                                    <button className="btn btn-success" onClick={this.updateClinic}>Edit</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default UpdateClinicComponent