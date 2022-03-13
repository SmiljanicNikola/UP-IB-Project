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
        user:{},
        uloga:AuthService.getRole(),
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

    editProfile(id){
      this.props.history.push(`/updateProfile/${id}`);
    }

    changePassword(id){
      this.props.history.push(`/changePassword/${id}`);
    }
  
    render() {

      if(this.state.user.prviput == false){
        this.changePassword(this.state.user.id)
      }
      if (this.state.redirect) {
        return <Redirect to={this.state.redirect} />
      }
      
      const { currentUser } = this.state;

      const user1 = this.state.user;
    //   var json1 = JSON.stringify(user);
      console.log(user1.email);

      return (
        <div className="container">

          <div>
            <div className="card col-md-6 offset-md-3">
                    <h2 className="text-center"><i>Logged user details:</i></h2><br></br>
                    <div className="card-body">
                      <center>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Ime:</strong> : {this.state.user.firstname}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Prezime:</strong> {this.state.user.lastname}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Email:</strong> {this.state.user.username}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Adresa:</strong> {this.state.user.adress}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Grad:</strong> {this.state.user.city}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Drzava:</strong> {this.state.user.country}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Telefon:</strong> {this.state.user.phone}</label>
                    </div><br></br>
                    <div className="row">
                        <label style={{color:"black"}}><strong>Uloga:</strong> {this.state.uloga}</label>
                    </div><br></br>
                    </center>
                  
                    <br></br>
                  <center><button onClick={ () => this.editProfile(this.state.user.id)} className="btn btn-info">Update</button> <button onClick={ () => this.changePassword(this.state.user.id)} className="btn btn-danger">Change Password</button></center>
                </div>
            </div>
          </div>    
        </div>
      );
    }
  }