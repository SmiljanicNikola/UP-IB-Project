import React from 'react'
import PacijentService from '../services/PacijentService'


class PatientComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            patients:[]
        }

    }

    componentDidMount(){
        PacijentService.getPacijente().then((response) =>{
            this.setState({patients:response.data})
        });
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
                            <td>User Id</td>
                            <td>LBO</td>                           
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.patients.map(
                                patient=>
                                <tr key = {patient.id}>
                                    <td>{patient.id}</td>
                                    <td>{patient.user}</td>
                                    <td>{patient.lbo}</td>
                            
                                </tr>
                            )

                        }
                    </tbody>

                </table>


            </div>
        )
    }

}

export default PatientComponent

