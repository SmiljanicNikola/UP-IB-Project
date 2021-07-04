import axios from 'axios';

const ROLE_REST_API_URL = 'http://localhost:8097/role';


class RoleService{
    getRoles(){
        return axios.get(ROLE_REST_API_URL);
    }


}


export default new RoleService();
