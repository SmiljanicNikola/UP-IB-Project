import React from 'react'
import NurseService from '../../services/NurseService'


class NurseComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            nurses:[]
        }
        
        this.editNurse = this.editNurse.bind(this);
        this.addNurse = this.addNurse.bind(this);

    }

    componentDidMount(){
        NurseService.getNurses().then((response) =>{
            this.setState({nurses:response.data})
        });

        
    }

    addNurse(){
        this.props.history.push('/addNurse');

    }

    editNurse(id){
        this.props.history.push(`updateNurse/${id}`);
    }
   
    render(){
        return (
            <div>
                <h1 className="text-center">Nurse List</h1>
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
                            this.state.nurses.map(
                                nurse=>
                                <tr key = {nurse.id}>
                                    <td>{nurse.id}</td>
                                    <td>{nurse.user.firstname}</td>
                                    <td>{nurse.user.lastname}</td>
                                    <td>{nurse.user.username}</td>
                                    <td>{nurse.user.adress}</td>
                                    <td>{nurse.clinic.naziv}</td>
                                    <td>
                                       
                                        <button style={{marginLeft: "10px"}} onClick={ () => this.editNurse(nurse.user.id)} className="btn btn-info">Update</button>
                                        
                                    </td>
                                </tr>
                            )

                        }
                    </tbody>

                </table>
                <br></br>
                <center>
                <button className="btn btn-success" onClick={this.addNurse}>Add Nurse</button>
                </center>
                <br></br>
                <hr></hr>

            </div>
        )
    }

}

export default NurseComponent

