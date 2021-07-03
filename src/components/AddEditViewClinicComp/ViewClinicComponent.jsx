import React, { Component } from 'react'
import ClinicService from '../../services/ClinicService';


class ViewClinicComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            klinike: {}
        }
        
}

componentDidMount(){
    ClinicService.getClinicById(this.state.id).then(res => {
        this.setState({klinike: res.data});
    });
}
    

cancel(){
    this.props.history.push('/klinike');
}

    render(){
        return(
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center">View Clinic details</h2>
                    <div className="card-body">
                        <div className="row">
                            <label style={{color:"red"}}>Naziv : {this.state.klinike.naziv}</label>
                        </div><br></br>
                        <div className="row">
                            <label style={{color:"red"}}>adresa : {this.state.klinike.adresa}</label>
                        </div><br></br>
                        <div className="row">
                            <label style={{color:"red"}}>Prosecna Ocena : {this.state.klinike.prosecnaOcena}</label>
                        </div><br></br>
                       
                    </div>
                </div>
            </div>
        )
    }

}

export default ViewClinicComponent