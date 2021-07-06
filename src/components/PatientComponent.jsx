import React from 'react'
import PacijentService from '../services/PacijentService'


class PatientComponent extends React.Component{

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

    onSort(event, sortKey){
        const data = this.state.patients;
        data.sort((a,b) => a[sortKey].localeCompare(b[sortKey]))
        this.setState({data})
      }

    onSort2(event, sortKey){
    const data = this.state.patients;
    data.sort((a,b) => a[sortKey].toString().localeCompare(b[sortKey]))
    this.setState({data})
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
                            <th>Id</th>
                            <th onClick={e => this.onSort('ASC')}>Firstname</th>
                            <th>Lastname</th>
                            <th>Adresa</th>
                            <th onClick={e => this.onSort2(e, 'lbo')}>LBO</th>  
                            <th></th>                         
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.patients.map(
                                patient=>
                                <tr key = {patient.id}>
                                    <td>{patient.id}</td>
                                    <td> {patient.user.firstname} </td>
                                    <td> {patient.user.lastname} </td>
                                    <td> {patient.user.adress} </td>
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

export default PatientComponent

