import React from 'react'
import ClinicService from '../services/ClinicService'


class ClinicComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            clinics:[]
        };
        this.onSort = this.onSort.bind(this)

        this.addClinic = this.addClinic.bind(this);
        this.editClinic = this.editClinic.bind(this);
        this.deleteClinic = this.deleteClinic.bind(this);
        this.viewClinic = this.viewClinic.bind(this);
    }

    componentDidMount(){
        ClinicService.getClinics().then((response) =>{
            this.setState({clinics:response.data})
        });
    }

    addClinic(){
        this.props.history.push('/addClinic');
    }

    viewClinic(id){
        this.props.history.push(`viewClinic/${id}`);
    }

    deleteClinic(id){
        ClinicService.deleteClinic(id).then(res => {
            this.setState({clinics: this.state.clinics.filter(clinics => clinics.id !== id)});
        });
    }
    editClinic(id){
        this.props.history.push(`/updateClinic/${id}`);
    }

    onSort(event, sortKey){
        const data = this.state.clinics;
        data.sort((a,b) => a[sortKey].localeCompare(b[sortKey]))
        this.setState({data})
      }

    onSort2(event, sortKey){
    const data = this.state.clinics;
    data.sort((a,b) => a[sortKey].toString().localeCompare(b[sortKey]))
    this.setState({data})
    }

    render(){
        return (
            <div>
                <br></br>
                <h1 className="text-center"> Clinic List </h1>
            
                <div className="row">
                    

                </div>
                <br></br>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th onClick={e => this.onSort(e, 'naziv')}>Naziv</th>
                            <th onClick={e => this.onSort(e, 'adresa')}>Adresa</th>
                            <th onClick={e => this.onSort2(e, 'prosecnaOcena')}>Prosecna Ocena</th>

                            <td></td>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            this.state.clinics.map(
                                clinic=>
                                <tr key = {clinic.id}>
                                    <td> {clinic.id}</td>
                                    <td> {clinic.naziv}</td>
                                    <td>{clinic.adresa}</td>
                                    <td>{clinic.prosecnaOcena}</td>
                                    <td>
                                        <button onClick={ () => this.editClinic(clinic.id)} className="btn btn-info">Update</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.deleteClinic(clinic.id)} className="btn btn-danger">Delete</button>
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.viewClinic(clinic.id)} className="btn btn-info">View</button>
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>
                <br>
                </br>
                <center>
                <button className="btn btn-success" onClick={this.addClinic}>Add clinic</button>
                </center>
                <br>
                </br>
                <hr></hr>

            </div>
        )
    }

}

export default ClinicComponent

