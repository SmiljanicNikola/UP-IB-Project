import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8097/korisnici';

class KorisnikService{
    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    getUserById(userId){
        return axios.get(USERS_REST_API_URL + '/' + userId)
    }

    updateKorisnik(korisnik, korisnikId){
        return axios.put(USERS_REST_API_URL + '/' + korisnikId, korisnik);
    }

    getKorisnikById(korisnikId){
        return axios.get(USERS_REST_API_URL + '/' + korisnikId)
    }


}


export default new KorisnikService();