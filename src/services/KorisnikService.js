import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8080/korisnici';

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


}


export default new KorisnikService();
