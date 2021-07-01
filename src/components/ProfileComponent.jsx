import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import axios from 'axios';


export default class Profile extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        redirect: null,
        userReady: false,
        currentUser: { username: "" },
        user:{}

      };
    }
  
    componentDidMount() {
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
    }
  
    render() {
      if (this.state.redirect) {
        return <Redirect to={this.state.redirect} />
      }
  
      const { currentUser } = this.state;

      const user1 = this.state.user;
    //   var json1 = JSON.stringify(user);
      console.log(user1);

      
  
      return (
        <div className="container">
            <div className="profileBox">
                <strong>Ime: </strong>{this.state.user.firstname}<br/>
                <strong>Prezime: </strong>{this.state.user.lastname}<br/>
                <strong>Email: </strong>{this.state.user.email}<br/>
                <strong>Adresa: </strong>{this.state.user.adress}<br/>
                <strong>Grad: </strong>{this.state.user.city}<br/>
                <strong>Drzava: </strong>{this.state.user.country}<br/>
                <strong>Telefon: </strong>{this.state.user.phone}<br/>
                {/* <strong>Uloga: </strong>{this.state.user.roles}<br/> */}
                <a href="editProfile">Izmeni</a>
            </div>










          {/* {(this.state.userReady) ?
          <div>
          <header className="jumbotron">
            <h3>
              <strong>{currentUser.username}</strong> Profile
            </h3>
          </header>
          <p>
            <strong>Token:</strong>{" "}
            {currentUser.accessToken.substring(0, 20)} ...{" "}
            {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
          </p>
          <p>
            <strong>Id:</strong>{" "}
            {currentUser.id}
          </p>
  
          <strong>Authorities:</strong>
          <ul>
            {currentUser.roles &&
              currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
          </ul>
        </div>: null} */}
        </div>
      );
    }
  }