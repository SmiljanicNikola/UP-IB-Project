import axios from 'axios'

const CLINICS_REST_API_URL = 'http://localhost:8080/klinike';

class ClinicService{
    getClinics(){
        return axios.get(CLINICS_REST_API_URL);
    }

    createClinic(clinic){
        return axios.post(CLINICS_REST_API_URL,clinic);
    }

    getClinicById(clinicId){
        return axios.get(CLINICS_REST_API_URL + '/' + clinicId)
    }

    updateClinic(clinic, clinicId){
        return axios.put(CLINICS_REST_API_URL + '/' + clinicId, clinic);
    }

    deleteClinic(clinicId){
        return axios.delete(CLINICS_REST_API_URL + '/' + clinicId);
    }
}


export default new ClinicService();
