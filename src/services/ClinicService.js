import axios from 'axios'

const CLINICS_REST_API_URL = 'http://localhost:8080/klinike';

class ClinicService{
    getClinics(){
        return axios.get(CLINICS_REST_API_URL);
    }

    createClinic(clinic){
        return axios.post(CLINICS_REST_API_URL);
    }
}


export default new ClinicService();
