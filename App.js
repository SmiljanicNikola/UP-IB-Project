import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import UserComponent from './components/UserComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import RegisterUser from './components/RegisterUser';


function App() {
  return (
    <div>
        <Router>
              <HeaderComponent/>
                <div className="container">
                    <Switch> 
                          <Route path="/" exact component={UserComponent}></Route>
                          <Route path="/korisnici" component={UserComponent}></Route>
                          <Route path="/register" component={ RegisterUser }></Route>
                    </Switch>
                </div>
              <FooterComponent/>
        </Router>
    </div>
  );
}

export default App;
