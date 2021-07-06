import React from 'react'
import PregledService from '../services/PregledService'


class PregledComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            pregledi:[]
        }

        this.addAppointment = this.addAppointment.bind(this);
        this.editAppointment = this.editAppointment.bind(this);
        this.deleteAppointment = this.deleteAppointment.bind(this);
        this.viewAppointment = this.viewAppointment.bind(this);
    }

    componentDidMount(){
        PregledService.getAppointments().then((response) =>{
            this.setState({pregledi:response.data})
        });
    }

    viewAppointment(id){
        this.props.history.push(`viewAppointment/${id}`);
    }

    deleteAppointment(id){
        PregledService.deleteAppointment(id).then(res => {
            this.setState({pregledi: this.state.pregledi.filter(pregledi => pregledi.id !== id)});
        });
    }
    editAppointment(id){
        this.props.history.push(`/updateAppointment/${id}`);
    }
    addAppointment(){
        this.props.history.push('/addAppointment');
    }


    render(){
        return (
            <div>
                <h1 className="text-center"> Appointment List </h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    
<br></br>
                </div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Date And Time</td>
                            <td>Appointment Lenght</td>
                            <td>Doctor name</td>
                            <td>Doctor lastname</td>
                            <td>Nurse name</td>
                            <td>Nurse lastname</td>

                            <td>Price</td>
                            <td>Actions</td>

                           
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.pregledi.map(
                                appointment=>
                                <tr key = {appointment.id}>
                                    <td> {appointment.dateAndTime}</td>
                                    <td>{appointment.appointmentLenght}</td>
                                    <td>{appointment.doctor.user.firstname}</td>
                                    <td>{appointment.doctor.user.lastname}</td>
                                    <td>{appointment.nurse.user.firstname}</td>
                                    <td>{appointment.nurse.user.lastname}</td>
                                    <td>{appointment.price}</td>
                                    <td>
                                        <button onClick={ () => this.editAppointment(appointment.id)} className="btn btn-info">Update</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAppointment(appointment.id)} className="btn btn-danger">Delete</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.viewAppointment(appointment.id)} className="btn btn-info">View</button>

                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>
                <br></br>
            <center>
            <button className="btn btn-success" onClick={this.addAppointment}>Add appointment</button>
            </center>
            <br></br>
            <hr></hr>
            </div>
        )
    }

}

export default PregledComponent

