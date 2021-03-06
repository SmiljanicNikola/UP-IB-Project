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
import RegistracijeZahtevi from './components/RegistracijeZahtevi';
// import { Link } from 'react-router-dom';
import AuthService from "./services/AuthService";
import PregledComponent from './components/PregledComponent';
import UpdateNurseComponent from './components/DoctorNurseComponents/UpdateNurseComponent';
import BlockUserComponent from './components/BlockUserComponent';
import MyAppointments from './components/MyAppointments';
import MyAppointmentsSestra from './components/MyAppointmentsSestra';

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
      userRole:'',
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      let user = localStorage.getItem("user")
      let json = JSON.parse(user);
      this.setState({
        currentUser: user,
        userRole: json.roles[0]

      });
    }
  }

  logOut() {
    AuthService.logout();
  }


  render() {
    const { currentUser } = this.state;
    const { userRole } = this.state;


    return (

      
      <div>
        
        <nav className="navbar navbar-expand navbar-dark bg-dark">
        
        <li className="">
            <a href="/home" className="navbar-brand">
                <strong>Home</strong>
                </a>

            </li>

          <div className="navbar-nav mr-auto">
          {!currentUser && (
            <li className="nav-item">

            <a href="/login" className="nav-link">
            <p>Login</p>
            </a>
            </li>)}

            {!currentUser && (
            <li className="nav-item">
            <a href="/registerPacijenta" className="nav-link">
            <p>Registracija</p>
            </a>
            </li>)}

          
            {currentUser && (
              <li style={{marginBottom: '17px'}} className="nav-item">
                <a style={{color:'red'}} href="/login" className="nav-link" onClick={this.logOut}>
                  <strong>Log out</strong>
                </a>
              </li>
            )}
          </div>

          
          {/*ODVAJANJE/////////////////////////////////////////*/}
          {/* LEKAAAR */}
          {currentUser && userRole=="LEKAR" ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/profile" className="nav-link">
                <p>Profil</p>
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
              <a href="/workcalendar" className="nav-link">
                <p>WorkCalendar</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/addAppointment" className="nav-link">
                <p>Dodaj Pregled</p>
                </a>
              </li>
            </div>
          ) 
          : (
            <div className="navbar-nav ml-auto">
             
            </div>
          )}


        {/* PACIJENT */}
          {currentUser && userRole=="PACIJENT" ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/profile" className="nav-link">
                <p>Profil</p>
                </a>
              </li>
              

              <li className="nav-item">
              <a href="/klinike" className="nav-link">
                <p>Klinike</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/pregledi" className="nav-link">
                <p>Pregledi</p>
                </a>
              </li>

            </div>
          ) 
          : (
            <div className="navbar-nav ml-auto">
             
            </div>
          )}


          {/* ADMINISTRATOR KLINIKE */}
          {currentUser && userRole=="ADMINISTRATOR KLINIKE" ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/profile" className="nav-link">
                <p>Profil</p>
                </a>
              </li>
              
              <li className="nav-item">
              <a href="/klinike" className="nav-link">
                <p>Klinike</p>
                </a>
              </li>
              <li className="nav-item">
              <a href="/korisnici" className="nav-link">
                <p>Korisnici</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/zahtevi" className="nav-link">
                <p>Zahtevi</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/doktori" className="nav-link">
                <p>Doktori</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/medicinskesestre" className="nav-link">
                <p>Medicinske Sestre</p>
                </a>
              </li>

              <li className="nav-item">
              <a href="/pregledi" className="nav-link">
                <p>Pregledi</p>
                </a>
              </li>

            </div>
          ) 
          : (
            <div className="navbar-nav ml-auto">
             
            </div>
          )}


          {/* MEDICINSKA SESTRA */}
          {currentUser && userRole=="MEDICINSKA SESTRA" ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/profile" className="nav-link">
                <p>Profil</p>
                </a>
              </li>
              <li className="nav-item">
              <a href="/workcalendarsestra" className="nav-link">
                <p>WorkCalendar</p>
                </a>
              </li>

            </div>
          ) 
          : (
            <div className="navbar-nav ml-auto">
             
            </div>
          )}


           {/* ADMINISTRATOR CENTRA */}
           {currentUser && userRole=="ADMINISTRATOR CENTRA" ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <a href="/profile" className="nav-link">
                <p>Profil</p>
                </a>
              </li>

              <li className="nav-item">
                <a href="/klinike" className="nav-link">
                <p>Klinike</p>
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
                          <Route path="/changePassword/:id" component={ChangePasswordComponent}></Route>
                          <Route path="/profile" component={ Profile }></Route>
                          <Route path="/login" component={Login}></Route>
                          <Route path="/registerPacijenta" component={RegistracijaPacijenta}></Route>
                          <Route path="/home" component={Home}></Route>
                          <Route path="/homePatient" component={HomePagePatient}></Route>
                          <Route path="/updateProfile/:id" component={EditProfileComponent}></Route>
                          <Route path="/viewAppointment/:id" component={ViewAppointmentComponent}></Route>
                          <Route path="/viewClinic/:id" component={ViewClinicComponent}></Route>
                          <Route path="/viewPatient/:id" component={ViewPatientComponent}></Route>

                          <PrivateRoute
                            exact
                            path="/zahtevi"
                            component={RegistracijeZahtevi}
                            roles={["ADMINISTRATOR KLINIKE"]}/>

                          <PrivateRoute
                            exact
                            path="/updateAppointment/:id"
                            component={UpdateAppointmentComponent}
                            roles={["ADMINISTRATOR KLINIKE"]}/>

                          <PrivateRoute
                            exact
                            path="/klinike"
                            component={ClinicComponent}
                            roles={["ADMINISTRATOR KLINIKE", "LEKAR", "PACIJENT", "ADMINISTRATOR CENTRA"]}
                          />

                            <PrivateRoute
                            exact
                            path="/workcalendar"
                            component={MyAppointments}
                            roles={["LEKAR"]}
                          />

                          <PrivateRoute
                          exact
                          path="/addAppointment"
                          component={DodavanjePregleda}
                          roles={["LEKAR","ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/pregledi"
                          component={PregledComponent}
                          roles={["LEKAR","ADMINISTRATOR KLINIKE", "PACIJENT"]}
                          />

                          <PrivateRoute
                          exact
                          path="/korisnici"
                          component={UserComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/updateClinic/:id"
                          component={UpdateClinicComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}/>

                          <PrivateRoute
                          exact
                          path="/updateDoctor/:id"
                          component={UpdateDoctorComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/workcalendarsestra"
                          component={MyAppointmentsSestra}
                          roles={["MEDICINSKA SESTRA"]}
                          />

                          <PrivateRoute
                          exact
                          path="/addClinic"
                          component={AddClinic}
                          roles={["ADMINISTRATOR CENTRA"]}
                          />

                          <PrivateRoute
                          exact
                          path="/blockUser/:id"
                          component={BlockUserComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/updateNurse/:id"
                          component={UpdateNurseComponent}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/addNurse"
                          component={CreateNurse}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/addPatient"
                          component={AddPatient}
                          roles={["ADMINISTRATOR KLINIKE"]}
                          />

                          <PrivateRoute
                          exact
                          path="/addDoctor"
                          component={CreateDoctor}
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