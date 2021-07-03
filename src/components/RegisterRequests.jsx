import React from 'react'
import PacijentService from '../services/PacijentService'


class RegisterRequests extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            patients:[]
        }
        this.viewPatient = this.viewPatient.bind(this);

    }

    componentDidMount(){
        PacijentService.getPacijente().then((response) =>{
            this.setState({patients:response.data})
        });

        
    }
    viewPatient(id){
        this.props.history.push(`viewPatient/${id}`);
    }
   
    render(){
        return (
            <div>
                <h1 className="text-center"> Lista pacijenata</h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
                    

                </div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>User</td>
                            <td>LBO</td>  
                            <td></td>                         
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.patients.map(
                                patient=>
                                <tr key = {patient.id}>
                                    <td>{patient.id}</td>
                                    <td> {patient.user.id} | {patient.user.firstname} | {patient.user.firstname} | {patient.user.username} </td>
                                    <td>{patient.lbo}</td>
                                    <td>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.viewPatient(patient.id)} className="btn btn-info">View</button>
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>


            </div>
        )
    }

}

export default RegisterRequests

