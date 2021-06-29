import logo from './logo.svg';
import './App.css';
import React, { Component }  from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import UserComponent from './components/UserComponent';
import HeaderComponent from './components/HeaderComponent';
import PatientComponent from './components/PatientComponent';
import FooterComponent from './components/FooterComponent';
import RegisterUser from './components/RegisterUser';
import ClinicComponent from './components/ClinicComponent';
import Login from './components/Login';
import LoginComponent from './components/LoginComponent';
import RegistracijaPacijenta from './components/RegistracijaPacijenta';
import DodavanjePregleda from './components/DodavanjePregleda';
import Home from './components/Home';




function App() {
  return (
    <div>
        <Router>
              <HeaderComponent/>
                <div className="container">
                    <Switch> 
                          <Route path="/klinike" exact component={ClinicComponent}></Route>
                          <Route path="/korisnici" component={UserComponent}></Route>
                          <Route path="/pacijenti" component={PatientComponent}></Route>
                          <Route path="/register" component={ RegisterUser }></Route>
                          <Route path="/login" component={Login}></Route>
                          <Route path="/registerPacijenta" component={RegistracijaPacijenta}></Route>
                          <Route path="/dodavanjePregleda" component={DodavanjePregleda}></Route>
                          <Route path="/home" component={Home}></Route>
                    </Switch>
                </div>
              <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
