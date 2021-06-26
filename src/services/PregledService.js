import axios from 'axios'

const APPOINTMENTS_REST_API_URL = 'http://localhost:8080/pregledi';

class PregledService{
    getAppointments(){
        return axios.get(APPOINTMENTS_REST_API_URL);
    }

    createAppointment(appointment){
        return axios.post(APPOINTMENTS_REST_API_URL, appointment);
    }
}


export default new PregledService();