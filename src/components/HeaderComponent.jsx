import React, { Component } from 'react'

class HeaderComponent extends Component{
    constructor(props){
        super(props)

        this.state = {

        }
    }

    render(){
        return(
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div><a href="home" className="navbar-brand">  Home  </a></div>
                        <div><a href="klinike" className="navbar-brand">  Clinics  </a></div>
                        <div><a href="doktori" className="navbar-brand">  Doctors  </a></div>
                        <div><a href="medicinskesestre" className="navbar-brand">  Nurses  </a></div>
                        <div><a href="pacijenti" className="navbar-brand">  Patients  </a></div>
                        <div><a href="pregledi" className="navbar-brand">  Appointments  </a></div>
                        <div><a href="korisnici" className="navbar-brand">  Users  </a></div>
                        <div><a href="login" className="navbar-brand">  Login  </a></div>
                        <div><a href="register" className="navbar-brand">  Register  </a></div>
                        <div><a href="registerPacijenta" className="navbar-brand">  RegisterPatient  </a></div>
                        <div><a href="dodavanjePregleda" className="navbar-brand">  AddAppointment  </a></div>
                    </nav>
                </header>
            </div>
        )
      }
}

export default HeaderComponent