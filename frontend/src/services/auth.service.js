
import axios from 'axios';
import { auth } from '../main.js';

const API_URL = 'http://localhost:9090/api/auth/';
//const API_URL = 'https://www.idana.pro:9090/api/auth/'; -> Settings for Production Deployment

class AuthService {
  login(user) {
    return axios
      .post(API_URL + 'signin', {
        username: user.username,
        password: user.password,
      })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  //Supporting only login through Google
  sociallogin(user) {
    console.log("user in sociallogin method " + JSON.stringify(user));
    return axios
      .post(API_URL + 'social/signin', {
        username: user.username,
        email: user.email,
        usertype: user.usertype,
        uid: user.uid
      })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }
        return response.data;
      });
  }

  /*sociallogout() {
    const auth = getAuth();
    signOut(auth).then(() => {
      console.log("Google auth logout successfull !!");
      localStorage.removeItem('idToken');
    }).catch((error) => {
      // An error happened.
      console.log("Google auth logout Failed  !!" + error);
    });
  }*/

  sociallogout() {
    auth.signOut().then((result) => {
      console.log("Google auth logout successfull !!");
      console.log("auth=====" + JSON.stringify(auth));
      localStorage.removeItem('authDomain');
    })
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(user) {
    return axios.post(API_URL + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password,
      usertype: user.usertype,
    });
  }

  //Not USED
  /*updateuser(user) {
        return axios.put('http://localhost:8080/api/test/' + 'users/'+ user.id, {
            username: user.username,
            email: user.email,
            password: user.password,
            firstname: user.firstname,
            lastname:user.lastname,
            id:user.id,
            age:user.age
        });
    }*/
}

export default new AuthService();
