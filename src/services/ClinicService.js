import axios from 'axios'

const CLINICS_REST_API_URL = 'http://localhost:8095/klinike';

class ClinicService{
    getClinics(){
        return axios.get(CLINICS_REST_API_URL);
    }
}


export default new ClinicService();