import React, { Component } from 'react'
import PacijentService from '../services/PacijentService';


class ViewPatientComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pacijenti: {}
        }
        
}

componentDidMount(){
    PacijentService.getPatientById(this.state.id).then(res => {
        this.setState({pacijenti: res.data});
    });
}
    

cancel(){
    this.props.history.push('/pacijenti');
}

    render(){
        return(
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center">View Patient details</h2>
                    <div className="card-body">
                        <div className="row">
                            <label style={{color:"red"}}>User : {this.state.pacijenti.user.id}</label>
                        </div><br></br>
                
                       
                    </div>
                </div>
            </div>
        )
    }

}

export default ViewPatientComponent