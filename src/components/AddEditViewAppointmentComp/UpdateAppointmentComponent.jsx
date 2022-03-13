import React, { Component } from 'react'
import PregledService from '../../services/PregledService';


class UpdateAppointmentComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dateAndTime: '',
            appointmentLenght: '',
            doctor: '',
            nurse:'',
            price:'',
        }
        this.changeDateAndTime = this.changeDateAndTime.bind(this);
        this.changeAppointmentLenght = this.changeAppointmentLenght.bind(this);
        this.changeDoctorHandler = this.changeDoctorHandler.bind(this);
        this.changeNurseHandler = this.changeNurseHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);

        this.updateAppointment = this.updateAppointment.bind(this);
}

componentDidMount(){
    PregledService.getAppointmentById(this.state.id).then( (res) =>{
        let appointment = res.data;
        this.setState({
            dateAndTime: appointment.dateAndTime,
            appointmentLenght: appointment.appointmentLenght,
            doctor: appointment.doctor,
            nurse: appointment.nurse,
            price: appointment.price    
        });
    });
}

updateAppointment = (e) =>{
        e.preventDefault();
        let appointment = {dateAndTime: this.state.dateAndTime, appointmentLenght: this.state.appointmentLenght, doctor: this.state.doctor,
        nurse: this.state.nurse, price: this.state.price
        }
        console.log('appointment => ' + JSON.stringify(appointment));
        PregledService.updateAppointment(appointment, this.state.id).then(res => {
            this.props.history.push('/pregledi');
        });
   
}

changeDateAndTime= (event) =>{
    this.setState({dateAndTime: event.target.value});
}

changeAppointmentLenght= (event) =>{
    this.setState({appointmentLenght: event.target.value});
}

changeDoctorHandler= (event) =>{
    this.setState({doctor: event.target.value});
}

changeNurseHandler= (event) =>{
    this.setState({nurse: event.target.value});
}

changePriceHandler= (event) =>{
    this.setState({price: event.target.value});
}


cancel(){
    this.props.history.push('/artikli');
}

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Edit appointment</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Date And Time</label>
                                        <input placeholder="Date And Time" name="dateAndTime" className="form-control"
                                            value={this.state.dateAndTime} onChange={this.changeDateAndTime}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Appointment Lenght</label>
                                        <input placeholder="Appointment Lenght" name="appointmentLenght" className="form-control"
                                            value={this.state.appointmentLenght} onChange={this.changeAppointmentLenght}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Doctor Id</label>
                                        <input placeholder="Doctor Id" name="doctorId" className="form-control"
                                            value={this.state.doctor.id} onChange={this.changeDoctorHandler}/>      
                                    </div>

                                    <div className="form-group">
                                        <label>Nurse Id</label>
                                        <input placeholder="Doctor Id" name="nurseId" className="form-control"
                                            value={this.state.nurse.id} onChange={this.changeNurseHandler}/>      
                                    </div>

                                    <div className="form-group">
                                        <label>Price</label>
                                        <input placeholder="Price" name="price" className="form-control"
                                            value={this.state.price} onChange={this.changePriceHandler}/>       
                                    </div>
        
                                    <button className="btn btn-success" onClick={this.updateAppointment}>Edit</button>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default UpdateAppointmentComponent