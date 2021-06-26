import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8080/korisnici';
const PACIJENTI_REST_API_URL = 'http://localhost:8080/pacijenti';
const PACIJENT_REST_API_URL = 'http://localhost:8080/api/auth/patient/signup';

class PacijentService{
    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    createPacijent(pacijent){
        return axios.post(PACIJENT_REST_API_URL, pacijent);
    }

    getPacijente(){
        return axios.get(PACIJENTI_REST_API_URL);
    }

}


export default new PacijentService();
