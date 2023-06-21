import axios from 'axios';
import authHeader from './auth-header';

/*const API_URL = 'http://localhost:8080/api/test/';->settings to connect to Azure DB*/

const API_URL = 'http://localhost:9090/api/test/';

//const API_URL_UpdateUser = 'http://localhost:8080/api/auth/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }

  putUpdatedUser(user) {
    return axios.put(API_URL + 'users/' + user.id, user, {
      headers: authHeader(),
    });
  }

  forgotpassword(email) {
    return axios.post(API_URL + 'forgot', { params: email });
  }

  uploadImage(formData, user) {
    return axios.post(API_URL + 'users/uploadimage/' + user.id, formData, {
      headers: authHeader(),
    });
  }

  getAllCoaches() {
    return axios.get(API_URL + 'users/' + 'coach', { headers: authHeader() });
  }

  getAllClients() {
    return axios.get(API_URL + 'users/' + 'client', { headers: authHeader() });
  }

  getUserbyId(id) {
    return axios.get(API_URL + 'users/userid/' + id, { headers: authHeader() });
  }

  getCoachProfileById(id) {
    return axios.get(API_URL + 'users/coachprofile/' + id, {
      headers: authHeader(),
    });
  }

  getClientProfileById(id) {
    return axios.get(API_URL + 'users/clientprofile/' + id, {
      headers: authHeader(),
    });
  }

  getCoachPublicProfileById(id) {
    return axios.get(API_URL + 'users/coachpublicprofile/' + id, {
      headers: authHeader(),
    });
  }

  getClientPublicProfileById(id) {
    return axios.get(API_URL + 'users/clientpublicprofile/' + id, {
      headers: authHeader(),
    });
  }

  isCoachReviewByClientIdAvailable(coachid, clientid) {
    return axios.get(
      API_URL +
        'users/coachpublicprofile/reviewavailable/' +
        coachid +
        '/' +
        clientid,
      { headers: authHeader() }
    );
  }

  getCoachReviewByCoachIdAndClientId(coachid, clientid) {
    return axios.get(
      API_URL + 'users/coachpublicprofile/review/' + coachid + '/' + clientid,
      { headers: authHeader() }
    );
  }

  submitReviewByClient(coachid, clientid, review, rating) {
    return axios.post(
      API_URL + 'users/coachreview',
      { coachid: coachid, clientid: clientid, review: review, rating: rating },
      { headers: authHeader() }
    );
  }

  editReviewByClient(coachid, clientid, review, rating) {
    return axios.put(
      API_URL + 'users/coachreview',
      { coachid: coachid, clientid: clientid, review: review, rating: rating },
      { headers: authHeader() }
    );
  }

  sendEmail(data) {
    return axios.post(
      API_URL + 'users/sendemail',
      {
        coachId: data.get('coachId'),
        clientId: data.get('clientId'),
        fromEmailId: data.get('fromEmailId'),
        message: data.get('message'),
        name: data.get('name'),
        toEmailId: data.get('toEmailId'),
        file: data.get('file'),
      },
      { headers: authHeader() }
    );
  }

  getAllInboxMessagesById(usertype, id) {
    return axios.get(
      API_URL + 'users/getinboxmessages/' + usertype + '/' + id,
      {
        headers: authHeader(),
      }
    );
  }
}

export default new UserService();
