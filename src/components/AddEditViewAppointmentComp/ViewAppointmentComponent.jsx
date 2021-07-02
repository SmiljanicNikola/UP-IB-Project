import React, { Component } from 'react'
import PregledService from '../../services/PregledService';


class ViewAppointmentComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pregledi: {}
        }
        
}

componentDidMount(){
    PregledService.getAppointmentById(this.state.id).then(res => {
        this.setState({pregledi: res.data});
    });
}
    

cancel(){
    this.props.history.push('/pregledi');
}

    render(){
        return(
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center">View Appointment details</h2>
                    <div className="card-body">
                        <div className="row">
                            <label style={{color:"red"}}>Date and time : {this.state.pregledi.dateAndTime}</label>
                        </div><br></br>
                        <div className="row">
                            <label style={{color:"red"}}>Appointment Lenght : {this.state.pregledi.appointmentLenght}</label>
                        </div><br></br>
                        <div className="row">
                            <label style={{color:"red"}}>Price : {this.state.pregledi.price}</label>
                        </div><br></br>
                       
                    </div>
                </div>
            </div>
        )
    }

}

export default ViewAppointmentComponent