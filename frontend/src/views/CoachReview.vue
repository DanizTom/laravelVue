<template>
  <v-app>
    <div class="form-style-5">
      <link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous"
      />
      <link rel="stylesheet" type="text/html" href="style.css" />
      <v-form id="demo" @submit="submitCoachReview" v-on:submit.prevent>
        <header class="">
          <h3 class="mb-4">
            Write a review for
            <strong
              >{{ currentCoach.firstname }} {{ currentCoach.lastname }}</strong
            >
          </h3>
        </header>

        <b-alert
          :show="dismissCountDown"
          dismissible
          fade
          variant="success"
          @dismiss-count-down="countDownChanged"
        >
          Review Submitted Successfully
        </b-alert>

        <b-alert
          :show="dismissCountDownError"
          dismissible
          fade
          variant="danger"
          @dismiss-count-down="countDownChangedError"
        >
          Please edit the already created review
        </b-alert>

        <v-textarea
          solo
          name="input-7-4"
          label="write review"
          v-model="review"
        ></v-textarea>

        <v-rating
          class="mb-4"
          v-model="rating"
          background-color="warning lighten-1"
          color="warning"
        ></v-rating>

        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading">
            <span
              v-show="loading"
              class="spinner-border spinner-border-sm"
            ></span>
            <span>Submit</span>
          </button>
        </div>
      </v-form>
    </div>
  </v-app>
</template>

<script>
import axios from 'axios';
import authHeader from '../services/auth-header';
import UserService from '../services/user.service';
import User from '../models/user';

import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  data() {
    return {
      user: '',
      coach: '',
      review: '',
      rating: 0,
      coachid: '',
      message: '',
      loading: false,
      dismissSecs: 5,
      dismissSecsError: 5,
      postbody: '',
      dismissCountDown: 0,
      dismissCountDownError: 0,
    };
  },
  name: 'coachreview',

  created() {
    this.coachid = this.$route.params.id;
    console.log('Coach id is ' + this.coachid);
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    currentCoach() {
      return this.coach;
    },
  },

  mounted: function () {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    //Display values in form textbox from the user in current local state of the browser
    this.user = this.$store.state.auth.user;
    console.log('client  id is ' + this.user.id);

    //get Coach properties
    UserService.getUserbyId(this.$route.params.id)
      .then((response) => {
        // JSON responses are automatically parsed.
        console.log(response.data);
        this.coach = response.data;
        console.log('Coach properties are :' + JSON.stringify(this.coach));
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },

  methods: {
    submitCoachReview() {
      console.log('Client  id is ' + this.user.id);
      console.log('Coach id is ' + this.coachid);
      this.loading = true;
      UserService.submitReviewByClient(
        this.coachid,
        this.user.id,
        this.review,
        this.rating
      ).then(
        (response) => {
          this.content = response.data;
          console.log('response is ' + this.content);
          setTimeout(() => {
            this.loading = false;
            this.showAlert();
          }, 2000);
          //this.$router.push('/profile')
        },
        (error) => {
          console.log(error.response.status);
          console.log('Error is ' + error.message);
          this.loading = false;
          this.showAlertError();
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      );
    },
    countDownChanged(dismissCountDown) {
      this.dismissCountDown = dismissCountDown;
    },
    showAlert() {
      this.dismissCountDown = this.dismissSecs;
    },
    countDownChangedError(dismissCountDownError) {
      this.dismissCountDownError = dismissCountDownError;
    },
    showAlertError() {
      this.dismissCountDownError = this.dismissSecsError;
    },
  },
};
</script>

<style scoped type="text/css">
.form-style-5 {
  text-align: center;
  max-width: 500px;
  width: 100%;
  padding: 10px 20px;
  background: #f4f7f8;
  margin: 10px auto;
  padding: 20px;
  border-radius: 8px;
  font-family: Georgia, 'Times New Roman', Times, serif;
}

.form-style-5 fieldset {
  border: none;
}

.form-style-5 legend {
  font-size: 1.4em;
  margin-bottom: 10px;
}

.form-style-5 label {
  display: block;
  margin-bottom: 8px;
}

.form-style-5 input[type='text'],
.form-style-5 input[type='date'],
.form-style-5 input[type='datetime'],
.form-style-5 input[type='email'],
.form-style-5 input[type='number'],
.form-style-5 input[type='search'],
.form-style-5 input[type='time'],
.form-style-5 input[type='url'],
.form-style-5 textarea,
.form-style-5 select {
  font-family: Georgia, 'Times New Roman', Times, serif;
  background: rgba(255, 255, 255, 0.1);
  border: none;
  border-radius: 4px;
  font-size: 15px;
  margin: 0;
  outline: 0;
  padding: 10px;
  width: 100%;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  background-color: #e8eeef;
  color: #8a97a0;
  -webkit-box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
  box-shadow: 0 1px 0 rgba(0, 0, 0, 0.03) inset;
  margin-bottom: 30px;
}

.form-style-5 input[type='text']:focus,
.form-style-5 input[type='date']:focus,
.form-style-5 input[type='datetime']:focus,
.form-style-5 input[type='email']:focus,
.form-style-5 input[type='number']:focus,
.form-style-5 input[type='search']:focus,
.form-style-5 input[type='time']:focus,
.form-style-5 input[type='url']:focus,
.form-style-5 textarea:focus,
.form-style-5 select:focus {
  background: #d2d9dd;
}

.form-style-5 select {
  -webkit-appearance: menulist-button;
  height: 35px;
}

.form-style-5 .number {
  background: #1abc9c;
  color: #fff;
  height: 30px;
  width: 30px;
  display: inline-block;
  font-size: 0.8em;
  margin-right: 4px;
  line-height: 30px;
  text-align: center;
  text-shadow: 0 1px 0 rgba(255, 255, 255, 0.2);
  border-radius: 15px 15px 15px 0px;
}

.form-style-5 input[type='submit'],
.form-style-5 input[type='button'] {
  position: relative;
  display: block;
  padding: 19px 39px 18px 39px;
  color: #fff;
  margin: 0 auto;
  background: #0080ff;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  width: 100%;
  border: 1px solid #0080ff;
  border-width: 1px 1px 3px;
  margin-bottom: 10px;
}

.form-style-5 input[type='submit']:hover,
.form-style-5 input[type='button']:hover {
  background: #0040ff;
}
</style>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
</style>
