import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import UserComponent from './components/UserComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import RegisterUser from './components/RegisterUser';
import ClinicComponent from './components/ClinicComponent';
import Login from './components/Login';
import LoginComponent from './components/LoginComponent';
import RegistracijaPacijenta from './components/RegistracijaPacijenta';
import DodavanjePregleda from './components/DodavanjePregleda';




function App() {
  return (
    <div>
        <Router>
              <HeaderComponent/>
                <div className="container">
                    <Switch> 
                          <Route path="/klinike" exact component={ClinicComponent}></Route>
                          <Route path="/korisnici" component={UserComponent}></Route>
                          <Route path="/register" component={ RegisterUser }></Route>
                          <Route path="/login" component={ Login }></Route>
                          <Route path="/llogin2" component={ LoginComponent }></Route>
                          <Route path="/registerPacijenta" component={RegistracijaPacijenta}></Route>
                          <Route path="/dodavanjePregleda" component={DodavanjePregleda}></Route>


                    </Switch>
                </div>
              <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
