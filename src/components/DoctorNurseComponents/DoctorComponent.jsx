import React from 'react'
import DoctorService from '../../services/DoctorService'


class DoctorComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            doctors:[]
        }
        
        this.editDoctor = this.editDoctor.bind(this);
        this.addDoctor = this.addDoctor.bind(this);

    }

    componentDidMount(){
        DoctorService.getDoctors().then((response) =>{
            this.setState({doctors:response.data})
        });

        
    }

    addDoctor(){
        this.props.history.push('/addDoctor');

    }

    editDoctor(id){
        this.props.history.push(`updateDoctor/${id}`);
    }
   
    render(){
        return (
            <div>
                <h1 className="text-center">Doctors List</h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    

                </div>
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
                                    <td>{doctor.id}</td>
                                    <td>{doctor.user.firstname}</td>
                                    <td>{doctor.user.lastname}</td>
                                    <td>{doctor.user.username}</td>
                                    <td>{doctor.user.adress}</td>
                                    <td>{doctor.clinic.naziv}</td>
                                    <td>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.editDoctor(doctor.id)} className="btn btn-info">Update</button>
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>
                <br></br>
                <button className="btn btn-success" onClick={this.addDoctor}>Add doctor</button>

            </div>
        )
    }

}

export default DoctorComponent

