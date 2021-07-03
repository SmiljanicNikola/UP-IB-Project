import React from 'react'
import ClinicService from '../services/ClinicService'


class ClinicComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            clinics:[]
        }

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

    render(){
        return (
            <div>
                <h1 className="text-center"> Clinic List</h1>
            
                <div className="row">
                    

                </div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Naziv</td>
                            <td>Adresa</td>
                            <td>Prosecna Ocena</td>
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

                <button className="btn btn-success" onClick={this.addClinic}>Add clinic</button>


            </div>
        )
    }

}

export default ClinicComponent

