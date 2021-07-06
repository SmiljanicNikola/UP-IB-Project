import React from 'react'
import PacijentService from '../services/PacijentService'


class PatientComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            patients:[]
        }
        this.viewPatient = this.viewPatient.bind(this);
        this.sortByLBOAsc=()=>{

            let sortedPatientsAsc;
            sortedPatientsAsc= this.state.patients.sort((a,b)=>{
               return parseInt(a.lbo)  - parseInt(b.lbo);
            })
  
            this.setState({
                patients:sortedPatientsAsc
            })

        }


        this.sortByLBODsc=()=>{

            let sortedPatientsDsc;
            sortedPatientsDsc= this.state.patients.sort((a,b)=>{
               return parseInt(b.lbo)  - parseInt(a.lbo);
            })
  
            this.setState({
                patients:sortedPatientsDsc
            })
        }


        this.sortByAdresaAsc=()=>{

            let sortByAdresaAsc;
            sortByAdresaAsc= this.state.patients.sort((a,b)=>{
               return (a.user.adress)  - (b.user.adress);
            })
  
            this.setState({
                patients:sortByAdresaAsc
            })

        }


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
        data.sort((ASC) => [sortKey].localeCompare([sortKey]))
        this.setState({data})
      }

    onSort2(event, sortKey){
    const data = this.state.patients;
    data.sort((a,b) => a[sortKey].toString().localeCompare(b[sortKey]))
    this.setState({data})
    }


    sortAscending = () => {
        const { lastnames } = this.state;
        lastnames.sort((a, b) => a - b)    
        this.setState({ lastnames })
      }
    
      sortDescending = () => {
        const { prices } = this.state;
        prices.sort((a, b) => a - b).reverse()
        this.setState({ prices })
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
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Adresa</th>
                            <th>LBO <button onClick={this.sortByLBOAsc}>ASC</button> <button onClick={this.sortByLBODsc}>DESC</button></th>  
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

