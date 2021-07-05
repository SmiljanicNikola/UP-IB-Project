import axios from 'axios';

const USERS_REST_API_URL = "http://localhost:8097/korisnici";



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

   deleteUser(articleId){
    let user = localStorage.getItem("user")
    var json = JSON.parse(user);
    return axios.delete(USERS_REST_API_URL + '/' + articleId, {headers: {
        'Authorization': `Bearer ${json.accessToken}`,
        'Access-Control-Allow-Origin': '*',
        "Access-Control-Allow-Methods":"DELETE, POST, GET, OPTIONS",
        'Access-Control-Allow-Credentials': 'true',
        'Content-Type':  'application/json'
      }});
}

}


export default new UserService();
