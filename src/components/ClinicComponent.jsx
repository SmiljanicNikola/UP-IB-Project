import React from 'react'
import ClinicService from '../services/ClinicService'


class ClinicComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            clinics:[]
        }

        this.addClinic = this.addClinic.bind(this);
    }

    componentDidMount(){
        ClinicService.getClinics().then((response) =>{
            this.setState({clinics:response.data})
        });
    }

    addClinic(){
        this.props.history.push('/register');
    }


    render(){
        return (
            <div>
                <h1 className="text-center"> Lista Klinika</h1>
            
                <div className="row">
                    

                </div>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Naziv</td>
                            <td>Adresa</td>
                            <td>Prosecna Ocena</td>
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
                                </tr>
                            )

                        }
                    </tbody>

                </table>


            </div>
        )
    }

}

export default ClinicComponent

