import React, { Component } from 'react'
import PregledService from '../../services/PregledService';
import DoctorService from '../../services/DoctorService';
import NurseService from '../../services/NurseService';


class DodavanjePregleda extends React.Component {
    constructor(props){
        super(props)

        this.state = {
            doctors:[],
            nurses:[],
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


componentDidMount(){
    DoctorService.getDoctors().then((response) =>{
        this.setState({doctors:response.data})
    });

    NurseService.getNurses().then((response) =>{
        this.setState({nurses:response.data})
    });

    
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
                                        <input placeholder="DateAndTime" name="DateAndTime" type="DateTime" className="form-control"
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
                </div><br></br>
                <hr></hr>

                <center>

                <div style={{width:700+'px'}}>
                <h1 className="text-center">Doctors List</h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                
                </div>
                <center>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Firstname</td>
                            <td>Lastname</td>
                            <td>Username</td>
                            <td>Adress</td>
                            <td>Clinic name</td>  
                            <td>Actions</td>                      
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.doctors.map(
                                doctor=>
                                <tr key = {doctor.id}>
                                    <td style={{backgroundColor:'red'}}><strong>{doctor.id}</strong></td>
                                    <td>{doctor.user.firstname}</td>
                                    <td>{doctor.user.lastname}</td>
                                    <td>{doctor.user.username}</td>
                                    <td>{doctor.user.adress}</td>
                                    <td>{doctor.clinic.naziv}</td>
                                    <td>
                                        
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table> </center>
                <br></br>
                <center>
                </center>
            </div>
            </center>
            <br></br><br></br>
            <hr></hr>



            <br></br>
            <center>
            <div style={{width:700+'px'}}>
                <h1 className="text-center">Nurse List</h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    

                </div>
                <center>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td >Id</td>
                            <td>Firstname</td>
                            <td>Lastname</td>
                            <td>Username</td>
                            <td>Adress</td>
                            <td>Clinic name</td>  
                            <td>Actions</td>                         
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.nurses.map(
                                nurse=>
                                <tr key = {nurse.id}>
                                    <td style={{backgroundColor:'red'}}><strong>{nurse.id}</strong></td>
                                    <td>{nurse.user.firstname}</td>
                                    <td>{nurse.user.lastname}</td>
                                    <td>{nurse.user.username}</td>
                                    <td>{nurse.user.adress}</td>
                                    <td>{nurse.clinic.naziv}</td>
                                    <td>
                                                                               
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>
                </center>
                <br></br>
                <center>
                </center>
                <br></br>
                <hr></hr>

            </div>
            </center>
            </div>
        )
    }

}

export default DodavanjePregleda