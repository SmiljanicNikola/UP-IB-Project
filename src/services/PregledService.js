import axios from 'axios'

const APPOINTMENTS_REST_API_URL = 'http://localhost:8097/pregledi';

class PregledService{
    
    getAppointments(){
        return axios.get(APPOINTMENTS_REST_API_URL);
    }

    createAppointment(appointment){
        return axios.post(APPOINTMENTS_REST_API_URL, appointment);
    }

    getAppointmentById(appointmentId){
        return axios.get(APPOINTMENTS_REST_API_URL + '/' + appointmentId)
    }

    updateAppointment(appointment, appointmentId){
        return axios.put(APPOINTMENTS_REST_API_URL + '/' + appointmentId, appointment);
    }

    deleteAppointment(appointmentId){
        return axios.delete(APPOINTMENTS_REST_API_URL + '/' + appointmentId);
    }
}


export default new PregledService();
