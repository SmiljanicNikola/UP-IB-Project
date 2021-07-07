import React from 'react'
import PregledService from '../services/PregledService'
import { Redirect } from "react-router-dom";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import axios from 'axios';



class MyAppointments extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            redirect: null,
            userReady: false,
            currentUser: { username: "" },
            user:{},
            uloga:AuthService.getRole(),
            appointments:[],
        }

    }

    componentDidMount(){
        

        const currentUser = AuthService.getCurrentUser();


        var user = localStorage.getItem("user")
        var json = JSON.parse(user);
        axios.get('http://localhost:8097/korisnici' + "/" + currentUser.id,{
            headers: {
            'Authorization': `Bearer ${json.accessToken}`
            }}).then(res => {
                    this.setState({ user: res.data });
                })
                .catch(function (error) {
                    console.log(error);
                })
    
          
      
          if (!currentUser) this.setState({ redirect: "/home" });
          this.setState({ currentUser: currentUser, userReady: true })
          this.setState({ user: user, userReady: true })

            PregledService.getAppointments().then((response) =>{
                this.setState({appointments:response.data})
                this.setState({ appointments: this.state.appointments.filter(appointments => appointments.nurse.user.id == currentUser.id)});
            });
    }


    render(){
        return (
            
            <div>
                <br></br>
                <h1 className="text-center"> Work calendar </h1>
                {/* <button className="btn btn-primary" >Login</button>
                <button className="btn btn-primary" onClick={this.addUser}>Register</button> */}
                <div className="row">
            
                </div>
                <br></br><br></br>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Date And Time</td>
                            <td>Duration</td>
                            <td>Username</td>
                            <td>Firstname</td>
                            <td>Lastname</td>
                           
                        </tr>
                    </thead>

                    <tbody>
                        
                        {
                            this.state.appointments.map(
                                appointment=>
                                <tr key = {appointment.id}>
                                    <td> {appointment.dateAndTime}</td>
                                    <td>{appointment.appointmentLenght}</td>
                                    <td>{appointment.nurse.user.username}</td>
                                    <td>{appointment.nurse.user.firstname}</td>
                                    <td>{appointment.nurse.user.lastname}</td>

                                </tr>
                            )

                        }
                    </tbody>

                </table>

            </div>
        )
    }

}

export default MyAppointments