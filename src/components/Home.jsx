import React, {component} from 'react';
import axios from 'axios';

class Home extends React.Component{

    state = {};
    componentDidMount(){

        const config = {
            headers: {
                Authorization: 'Bearer ' + localStorage.getItem('accessToken')
            }
        };

        const id=12;
        axios.get('http://localhost:8080/korisnik/id', config).then(
            res => {
                this.setState({
                    username: res.data
                })
            },
            err =>{
                console.log(err)
            }
        )
    }

    render(){
        if(this.state.username){
            return(
                <h2> Hi {this.state.user.firstname} {this.state.user.lastname}</h2>
            )
        }

        return (
            <h2> You are not logged in</h2>
            )
        }




    }
export default Home