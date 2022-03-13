import axios from 'axios';

const DOCTORS_REST_API_URL = 'http://localhost:8097/doktori';
const USERS_REST_API_URL = 'http://localhost:8097/korisnici';
const ADD_DOCTOR_REST_API_URL = 'http://localhost:8097/api/auth/doctor/signup';

class DoctorService{
    
    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    createDoctor(doctor){
        return axios.post(ADD_DOCTOR_REST_API_URL, doctor);
    }

    getDoctors(){
        return axios.get(DOCTORS_REST_API_URL);
    }

    getDoctorById(doctorId){
        return axios.get(DOCTORS_REST_API_URL + '/' + doctorId)
    }

}

export default new DoctorService();
