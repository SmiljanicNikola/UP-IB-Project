import axios from 'axios'
const USERSZAIZMENUBEZPASS_REST_API_URL = 'http://localhost:8097/korisnicii';
const USERS_REST_API_URL = 'http://localhost:8097/korisnici';
const KORISNIKBLOCK_REST_API_URL = 'http://localhost:8097/korisnici/blokiraj';


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
    updateeKorisnik(korisnik, korisnikId){
        return axios.put(USERSZAIZMENUBEZPASS_REST_API_URL + '/' + korisnikId, korisnik);
    }

    blockUserById(user, korisnikId){
        return axios.put(KORISNIKBLOCK_REST_API_URL + '/' + korisnikId, user);

    }

    getKorisnikById(korisnikId){
        return axios.get(USERS_REST_API_URL + '/' + korisnikId)
    }


}


export default new KorisnikService();
