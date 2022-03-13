import axios from 'axios';

const NURSES_REST_API_URL = 'http://localhost:8097/medicinskesestre';
const USERS_REST_API_URL = 'http://localhost:8097/korisnici';
const ADD_NURSE_REST_API_URL = 'http://localhost:8097/api/auth/nurse/signup';

class NurseService{
    
    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    createNurse(nurse){
        return axios.post(ADD_NURSE_REST_API_URL, nurse);
    }

    getNurses(){
        return axios.get(NURSES_REST_API_URL);
    }

    getNurseById(nurseId){
        return axios.get(NURSES_REST_API_URL + '/' + nurseId)
    }

}


export default new NurseService();
