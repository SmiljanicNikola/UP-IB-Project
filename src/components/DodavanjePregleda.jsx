import React, { Component } from 'react'
import PregledService from '../services/PregledService';


class DodavanjePregleda extends Component {
    constructor(props){
        super(props)

        this.state = {
            appointmentLenght: '',
            DateAndTime: '',
            price: '',
            doctorId:'',
            nurseId:''
        }

        this.changeAppointmentLenght = this.changeAppointmentLenght.bind(this);
        this.changeDateAndTime = this.changeDateAndTime.bind(this);
        this.changePrice = this.changePrice.bind(this);
        this.changeDoctorId = this.changeDoctorId.bind(this);
        this.changeNurseId = this.changeNurseId.bind(this);

        this.saveAppointment = this.saveAppointment.bind(this);
    
    }

    saveAppointment = (e) =>{
        e.preventDefault();
        let appointment = {appointmentLenght: this.state.appointmentLenght, DateAndTime: this.state.DateAndTime, price: this.state.price,
            doctorId: this.state.doctorId, nurseId: this.state.nurseId
            }
            console.log('appointment => ' + JSON.stringify(appointment));

            PregledService.createAppointment(appointment).then(res=>{
                this.props.history.push('/pregledi')
            });
    }

    changeAppointmentLenght= (event) =>{
        this.setState({appointmentLenght: event.target.value});
    }

    changeDateAndTime= (event) =>{
        this.setState({DateAndTime: event.target.value});
    }

    changePrice= (event) =>{
        this.setState({price: event.target.value});
    }

    changeDoctorId= (event) =>{
        this.setState({doctorId: event.target.value});
    }

    changeNurseId= (event) =>{
        this.setState({nurseId: event.target.value});
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Dodavanje pregleda</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Appointment lenght</label>
                                        <input placeholder="Appointment lenght" name="appointmentLenght" className="form-control"
                                            value={this.state.appointmentLenght} onChange={this.changeAppointmentLenght}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Date and time</label>
                                        <input placeholder="DateAndTime" name="DateAndTime" className="form-control"
                                            value={this.state.DateAndTime} onChange={this.changeDateAndTime}/>
                                    </div>

                                    <div className="form-group">
                                        <label>Price</label>
                                        <input placeholder="Price" name="price" className="form-control"
                                            value={this.state.price} onChange={this.changePrice}/>    
                                    </div>

                                    <div className="form-group">
                                        <label>Doctor Id</label>
                                        <input placeholder="Doctor Id" name="doctorId" className="form-control"
                                            value={this.state.doctorId} onChange={this.changeDoctorId}/>   
                                    </div>

                                    <div className="form-group">
                                        <label>Nurse Id</label>
                                        <input placeholder="Nurse Id" name="nurseId" className="form-control"
                                            value={this.state.nurseId} onChange={this.changeNurseId}/>
                                    </div>
        
                                    <button className="btn btn-success" onClick={this.saveAppointment}>Save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default DodavanjePregleda