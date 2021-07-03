import axios from 'axios';

const USERS_REST_API_URL = "http://localhost:8080/korisnici";



class UserService{

    getUsers(){
        console.log(localStorage.getItem("user"))
        let user = localStorage.getItem("user")
        var json = JSON.parse(user);
        console.log(json.accessToken)

        return axios.get(USERS_REST_API_URL, {
            headers: {
              'Authorization': `Bearer ${json.accessToken}`
            }
        });
    };

    getOneUser(id){
        let user = localStorage.getItem("user")
        var json = JSON.parse(user);
        return axios.get(USERS_REST_API_URL +  "/9", {
            headers: {
                'Authorization': `Bearer ${json.accessToken}`
              }
        })
    }

    loadData(id) {
        axios.get(USERS_REST_API_URL + "/9")
                 .then(response => {
                     console.log(response)
                     console.log("bla")
                 });
   }

}


export default new UserService();
