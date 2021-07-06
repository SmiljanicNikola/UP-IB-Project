import logo from './logo.svg';
import './App.css';
import React, { Component }  from 'react';
import { Switch, Route, Link, BrowserRouter} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
// import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
// import { Switch, Route } from 'react-router-dom';
import UserComponent from './components/UserComponent';
import HeaderComponent from './components/HeaderComponent';
import PatientComponent from './components/PatientComponent';
import FooterComponent from './components/FooterComponent';
import RegisterUser from './components/RegisterUser';
import Profile from './components/ProfileComponent';
import ClinicComponent from './components/ClinicComponent';
import AddPatient from './components/AddPatient';
import Login from './components/Login';
import {PrivateRoute}  from "./components/PrivateRoute";
import LoginComponent from './components/LoginComponent';
import RegistracijaPacijenta from './components/RegistracijaPacijenta';
import DodavanjePregleda from './components/AddEditViewAppointmentComp/DodavanjePregleda';
import ViewAppointmentComponent from './components/AddEditViewAppointmentComp/ViewAppointmentComponent';
import UpdateAppointmentComponent from './components/AddEditViewAppointmentComp/UpdateAppointmentComponent';
import Home from './components/Home';
import HomePagePatient from './components/HomePagePatient';
import UpdateClinicComponent from './components/AddEditViewClinicComp/UpdateClinicComponent';
import AddClinic from './components/AddEditViewClinicComp/AddClinic';
import ViewClinicComponent from './components/AddEditViewClinicComp/ViewClinicComponent';
import ViewPatientComponent from './components/ViewPatientComponent';
import DoctorComponent from './components/DoctorNurseComponents/DoctorComponent';
import CreateDoctor from './components/DoctorNurseComponents/CreateDoctor';
import NurseComponent from './components/DoctorNurseComponents/NurseComponent';
import CreateNurse from './components/DoctorNurseComponents/CreateNurse';
import UpdateDoctorComponent from './components/DoctorNurseComponents/UpdateDoctorComponent';
import EditProfileComponent from './components/EditProfileComponent';
import ChangePasswordComponent from './components/ChangePasswordComponent';

// import { Link } from 'react-router-dom';
import AuthService from "./services/AuthService";
import PregledComponent from './components/PregledComponent';




class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
      uloga: AuthService.getRole,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showModeratorBoard: user.roles.includes("PACIJENT"),
        showAdminBoard: user.roles.includes("LEAKR"),
      });
    }
  }

  logOut() {
    AuthService.logout();
  }


  render() {
    const { currentUser } = this.state;

    return (

      
      <div>

        <nav className="navbar navbar-expand navbar-dark bg-dark">
        <li className="">
            <a href="/home" className="navbar-brand">
                <strong>Home</strong>
                </a>

            </li>

          <div className="navbar-nav mr-auto">

            <li className="nav-item">

            <a href="/login" className="nav-link">
            <p>Login</p>
            </a>
            </li>
            <li className="nav-item">

            <a href="/registerPacijenta" className="nav-link">
            <p>Registracija</p>
            </a>
            </li>

          
            {currentUser && (
              <li className="nav-item">
                <a href="/korisnici" className="nav-link">
                  Users
                </a>
              </li>
            )}
          </div>

          
          {/*ODVAJANJE/////////////////////////////////////////*/}
          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
              <a href="/profile" className="nav-link">
                <strong>{currentUser.username }</strong>
                </a>
              </li>
              

              <li className="nav-item">
              <a href="/klinike" className="nav-link">
                <p>Klinike</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/doktori" className="nav-link">
                <p>Doktori</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/medicinskesestre" className="nav-link">
                <p>Sestre</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/pacijenti" className="nav-link">
                <p>Pacijenti</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/pregledi" className="nav-link">
                <p>Pregledi</p>
                </a>
              </li>

              <li style={{marginRight: 300+'px'}} className="nav-item">
                <a style={{color: 'red'}} href="/login" className="nav-link" onClick={this.logOut}>
                  <strong>Log out</strong>
                </a>
              </li>
            </div>





          ) 
          : (
            <div className="navbar-nav ml-auto">
             
            </div>
          )}
          
        </nav>

        <div className="container">
                <BrowserRouter>
                    <Switch> 
                          {/* <Route path="/klinike" exact component={ClinicComponent}></Route> */}
                          <Route path="/doktori" component={DoctorComponent}></Route>
                          <Route path="/medicinskesestre" component={NurseComponent}></Route>

                          <Route path="/pacijenti" component={PatientComponent}></Route>
                          <Route path="/header" component={HeaderComponent}></Route>


                          <Route path="/updateAppointment/:id" component={UpdateAppointmentComponent}></Route>
                          <Route path="/updateClinic/:id" component={UpdateClinicComponent}></Route>
                          <Route path="/updateDoctor/:id" component={UpdateDoctorComponent}></Route>
                          <Route path="/changePassword/:id" component={ChangePasswordComponent}></Route>

                          <Route path="/register" component={ RegisterUser }></Route>
                          <Route path="/profile" component={ Profile }></Route>
                          <Route path="/login" component={Login}></Route>
                          <Route path="/registerPacijenta" component={RegistracijaPacijenta}></Route>


                          <Route path="/addAppointment" component={DodavanjePregleda}></Route>
                          <Route path="/addClinic" component={AddClinic}></Route>
                          <Route path="/addDoctor" component={CreateDoctor}></Route>
                          <Route path="/addNurse" component={CreateNurse}></Route>
                          <Route path="/addPatient" component={AddPatient}></Route>



                          <Route path="/home" component={Home}></Route>
                          <Route path="/homePatient" component={HomePagePatient}></Route>

                          <Route path="/updateProfile/:id" component={EditProfileComponent}></Route>
                          <Route path="/viewAppointment/:id" component={ViewAppointmentComponent}></Route>
                          <Route path="/viewClinic/:id" component={ViewClinicComponent}></Route>
                          <Route path="/viewPatient/:id" component={ViewPatientComponent}></Route>
                          <PrivateRoute
                            exact
                            path="/klinike"
                            component={ClinicComponent}
                            roles={["ADMINISTRATOR KLINIKE", "LEKAR"]}
                          />
                          <PrivateRoute
                          exact
                          path="/pregledi"
                          component={PregledComponent}
                          roles={["LEKAR","ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/korisnici"
                          component={UserComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                    </Switch>
                </BrowserRouter>
              </div>
            </div>
    );
  }
}


export default App;