<template>
  <div>
    <HeaderStyleTwo />
    <OffCanvasMobileMenu />
    <div class="col-md-12">
      <div class="card card-container">
        <img
          id="profile-img"
          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
          class="profile-img-card"
        />
        <form name="form" @submit="formSubmit" v-on:submit.prevent>
          <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
          >
            Email sent Successfully
          </b-alert>
          <div class="form-group">
            <p><b> Forgot your Password?</b></p>
            <p>
              Enter your email below, and we will send you instructions on how
              to reset it.
            </p>
            <div class="single-input">
              <label for="email">Email</label>
              <input
                v-model="email"
                v-validate="'required'"
                type="email"
                class="form-control"
                name="email"
              />
            </div>

            <div
              v-if="errors.has('email')"
              class="alert alert-danger"
              role="alert"
            >
              Email is required!
            </div>
          </div>
          <div class="form-group">
            <button
              class="btn btn-primary btn-hover-secondary btn-width-100"
              :disabled="loading"
            >
              <span
                v-show="loading"
                class="spinner-border spinner-border-sm"
              ></span>
              <span>Send Reset Link</span>
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import User from '../models/user';
import Vue from 'vue';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import UserService from '../services/user.service';
import axios from 'axios';

// Install BootstrapVue
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);

export default {
  name: 'ForgotPassword',
  components: {
    HeaderStyleTwo: () => import('@/components/landingPage/HeaderStyleTwo'),
    OffCanvasMobileMenu: () =>
      import('@/components/landingPage/OffCanvasMobileMenu'),
    // EventItemGridStyle: () => import('@/components/landingPage/EventItemGridStyle'),
  },

  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: '',
      email: '',
      dismissSecs: 5,
      dismissCountDown: 0,
    };
  },

  methods: {
    /* handlePasswordReset() {
                this.loading = true;
                this.$validator.validateAll().then(isValid => {
                    if (!isValid) {
                        this.loading = false;
                        return;
                    }
                    if (this.email != null) {
                        UserService.forgotpassword(this.email).then(
                            response => {
                                this.content = response.data;
                                setTimeout(() => {
                                    this.loading = false;
                                    this.showAlert()
                                }, 2000);
                            },
                            error => {
                                this.loading = false;
                                this.content =
                                    (error.response && error.response.data) ||
                                    error.message ||
                                    error.toString();
                            },
                        );
                    }
                });
            },*/

    formSubmit(e) {
      e.preventDefault();
      let currentObj = this;
      this.loading = true;
      axios
        .post('http://localhost:9090/api/test/forgot', { email: this.email })
        .then(function (response) {
          currentObj.output = response.data;
        })
        .catch(function (error) {
          this.loading = false;
          currentObj.output = error;
        });
      setTimeout(() => {
        this.loading = false;
        this.showAlert();
      }, 2000);
    },
    countDownChanged(dismissCountDown) {
      this.dismissCountDown = dismissCountDown;
    },
    showAlert() {
      this.dismissCountDown = this.dismissSecs;
    },
  },
};
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #ffff;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>

<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
</style>
