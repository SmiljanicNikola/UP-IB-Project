import axios from 'axios';

const USERS_REST_API_URL = 'http://localhost:8097/korisnici';
const PACIJENTI_REST_API_URL = 'http://localhost:8097/pacijenti';
const PACIJENT_REST_API_URL = 'http://localhost:8097/api/auth/patient/signup';

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

    getPatientById(patientId){
        return axios.get(PACIJENTI_REST_API_URL + '/' + patientId)
    }

}


export default new PacijentService();
