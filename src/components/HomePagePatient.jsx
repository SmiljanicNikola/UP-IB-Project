import React, { Component } from "react";
import { Redirect } from "react-router-dom";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import axios from 'axios';


export default class HomePagePatient extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        redirect: null,
        userReady: false,
        currentUser: { username: "" },
        user:{}
      };
    }

    render(){
        return(
            <div>
                <a href="/klinike">Klinike</a>
                <br/>
                <a href="/profile">Profil</a>
            </div>
        )
    }
}