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
                <div><a href="klinike" className="navbar-brand">  Klinike  </a></div>
                <div><a href="" className="navbar-brand">  Pregledi  </a></div>
                <div><a href="korisnici" className="navbar-brand">  Korisnici  </a></div>
                <div><a href="login" className="navbar-brand">  Login  </a></div>
                <div><a href="register" className="navbar-brand">  Register  </a></div>
                <div><a href="registerPacijenta" className="navbar-brand">  RegisterPacijenta  </a></div>
                <div><a href="dodavanjePregleda" className="navbar-brand">  DodavanjePregleda  </a></div>

                </nav>
                </header>
            </div>


        )
    }

}export default HeaderComponent