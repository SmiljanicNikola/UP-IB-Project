import React, {component} from 'react';
import axios from 'axios';
import AuthService from "../services/AuthService";

class Home extends React.Component{

    state = {};
    componentDidMount(){

        const config = {
            headers: {
                Authorization: 'Bearer ' + localStorage.getItem('accessToken')
            }
        };
        this.state = {
            user:{},
            uloga:AuthService.getRole(),
          };

        const currentUser = AuthService.getCurrentUser();
        const uloga = AuthService.getRole;

    var user = localStorage.getItem("user")
    var json = JSON.parse(user);
    axios.get('http://localhost:8097/korisnici' + "/" + currentUser.id,{
        headers: {
        'Authorization': `Bearer ${json.accessToken}`
        }}).then(res => {
                this.setState({ user: res.data
                                });
            })
            .catch(function (error) {
                console.log(error);
            })

    }

    render(){
        if(this.state.user){
            return(
                <center>
                <br></br><br></br><br></br>


                <h2> Pozdrav {this.state.user.firstname} {this.state.user.lastname}</h2>
                </center>
                
            )
        }

        return (
            <center>
            <br></br><br></br><br></br>
            <h2> You are not logged in</h2>
            </center>
            )
        }




    }
export default Home