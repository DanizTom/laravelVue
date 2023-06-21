<template>
  <div>
    <HeaderStyleTwo />
    <OffCanvasMobileMenu />
    <b-tabs card lazy>
      <b-tab title="Client Login" active>
        <div class="login-register-section section-padding-bottom">
          <div class="container">
            <div class="row">
              <div class="col-12">
                <div class="row">
                  <div class="col-md-4 offset-md-4">
                    <div class="login-form-wrapper">
                      <img
                        id="profile-img"
                        src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                        class="profile-img-card"
                      />
                      <form
                        class="login-form"
                        id="signup-form"
                        name="form"
                        @submit.prevent="handleLogin"
                      >
                        <div class="single-input mb-30">
                          <label for="username">Username</label>
                          <input
                            v-model="user.username"
                            v-validate="'required'"
                            type="text"
                            id="username"
                            name="username"
                            placeholder="Username"
                          />
                          <div
                            v-if="errors.has('username')"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Username is required!
                          </div>
                        </div>
                        <div class="single-input mb-30">
                          <label for="password">Password</label>
                          <input
                            v-model="user.password"
                            v-validate="'required'"
                            type="password"
                            id="password"
                            name="password"
                            placeholder="Password"
                          />
                          <div
                            v-if="errors.has('password')"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Password is required!
                          </div>
                        </div>
                        <input
                          type="hidden"
                          ref="my_input"
                          class="form-control"
                          value="client"
                        />
                        <div class="single-input mb-30">
                          <div class="text-right">
                            <div class="lost-your-password-wrap">
                              <router-link
                                to="/forgotpassword"
                                class="lost-your-password"
                              >
                                Lost your password?
                              </router-link>
                            </div>
                          </div>
                        </div>
                        <div class="single-input">
                          <button
                            :disabled="loading"
                            class="btn btn-primary btn-hover-secondary btn-width-100"
                          >
                            <span
                              v-if="loading"
                              class="spinner-border spinner-border-sm"
                            ></span>
                            <span v-else>Log In</span>
                          </button>
                        </div>
                        <br />
                        <div class="single-input">
                          <a
                            class="btn btn-outline-dark btn-width-100"
                            @click="handleSignInGoogle"
                            role="button"
                            style="text-transform: none"
                          >
                            <img
                              width="20px"
                              style="margin-bottom: 3px; margin-right: 5px"
                              alt="Google sign-in"
                              src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png"
                            />
                            Login with Google
                          </a>
                        </div>

                        <div class="form-group">
                          <div
                            v-if="message.message == 'Error: Unauthorized'"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Invalid credentials. <br />
                            Please try again.
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--<div>
          <input
            type="hidden"
            ref="my_input"
            class="form-control"
            value="client"
          />
          <div id="GoogleSignIn" v-if="!isSignedIn">
            <h3>Google Signin</h3>
            <button @click="handleSignInGoogle">login</button>
          </div>
        </div>-->
      </b-tab>

      <b-tab title="Coach Login">
        <div class="login-register-section section-padding-bottom">
          <div class="container">
            <div class="row">
              <div class="col-12">
                <div class="row">
                  <div class="col-md-4 offset-md-4">
                    <div class="login-form-wrapper">
                      <img
                        id="profile-img"
                        src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                        class="profile-img-card"
                      />
                      <form
                        class="login-form"
                        id="signup-form"
                        name="form"
                        @submit.prevent="handleLogin"
                      >
                        <div class="single-input mb-30">
                          <label for="username">Username</label>
                          <input
                            v-model="user.username"
                            v-validate="'required'"
                            type="text"
                            id="username"
                            name="username"
                            placeholder="Username"
                          />
                          <div
                            v-if="errors.has('username')"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Username is required!
                          </div>
                        </div>
                        <div class="single-input mb-30">
                          <label for="password">Password</label>
                          <input
                            v-model="user.password"
                            v-validate="'required'"
                            type="password"
                            id="password"
                            name="password"
                            placeholder="Password"
                          />
                          <div
                            v-if="errors.has('password')"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Password is required!
                          </div>
                        </div>
                        <input
                          type="hidden"
                          ref="my_input"
                          class="form-control"
                          value="coach"
                        />
                        <div class="single-input mb-30">
                          <div class="text-right">
                            <div class="lost-your-password-wrap">
                              <router-link
                                to="/forgotpassword"
                                class="lost-your-password"
                              >
                                Lost your password?
                              </router-link>
                            </div>
                          </div>
                        </div>
                        <div class="single-input">
                          <button
                            :disabled="loading"
                            class="btn btn-primary btn-hover-secondary btn-width-100"
                          >
                            <span
                              v-if="loading"
                              class="spinner-border spinner-border-sm"
                            ></span>
                            <span v-else>Log In</span>
                          </button>
                        </div>
                        <div class="form-group">
                          <div
                            v-if="message.message == 'Error: Unauthorized'"
                            class="alert alert-danger"
                            role="alert"
                          >
                            Invalid credentials. <br />
                            Please try again.
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </b-tab>
    </b-tabs>

    <FooterStyleOne />
  </div>
</template>

<script>
import User from '../models/user';
import Vue from 'vue';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import {
  getAuth,
  signInWithPopup,
  signOut,
  GoogleAuthProvider,
  TwitterAuthProvider,
} from 'firebase/auth';

//const provider = new GoogleAuthProvider();
const provider = new GoogleAuthProvider();
provider.setCustomParameters({ prompt: 'select_account' });
const auth = getAuth();

Vue.component('font-awesome-icon', FontAwesomeIcon);

// Install BootstrapVue
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);

export default {
  components: {
    HeaderStyleTwo: () => import('@/components/landingPage/HeaderStyleTwo'),
    OffCanvasMobileMenu: () =>
      import('@/components/landingPage/OffCanvasMobileMenu'),
    // EventItemGridStyle: () => import('@/components/landingPage/EventItemGridStyle'),
    FooterStyleOne: () => import('@/components/landingPage/FooterStyleOne'),
  },
  name: 'Login',

  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: '',
      usertypevalue: '',
      coach: 'coach',
      client: 'client',
      isSignedIn: false,
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      if (this.$store.state.auth.user.usertype == 'coach') {
        this.$router.push('/coachprofile');
      } else {
        this.$router.push('/clientprofile');
      }
    }
  },
  methods: {
    handleLogin() {
      this.usertypeValue = this.$refs.my_input.value;
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.username && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            () => {
              if (this.$store.state.auth.user.usertype == 'coach') {
                this.$router.push('/coachprofile');
              } else {
                this.$router.push('/clientprofile');
              }
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    },

    //Login with google account
    //TOD: provide fucntionality to update password after login with google account
    handleSignInGoogle() {
      this.usertypeValue = this.$refs.my_input.value;
      console.log('usertypeValue is ' + this.usertypeValue);
      signInWithPopup(auth, provider)
        .then((result) => {
          this.isSignedIn = true;
          const credential = GoogleAuthProvider.credentialFromResult(result);
          console.log('credential are ' + JSON.stringify(credential));
          const token = credential.accessToken;
          console.log('result is ' + token);
          console.log('result ' + JSON.stringify(result));
          const user = result.user;
          console.log('Current User is :' + JSON.stringify(user));

          // The signed-in user info.
          const customUser = {
            usertype: this.usertypeValue, //this needs to come from ref.usertype from the input above
            email: result.user.email,
            uid: result.user.uid,
            username: result.user.email,
          };

          console.log('Current CUSTOM User is :' + JSON.stringify(customUser));

          this.$store.dispatch('auth/sociallogin', customUser).then(
            () => {
              if (customUser.usertype == 'coach') {
                this.$router.push('/coachprofile');
              } else {
                this.$router.push('/clientprofile');
              }
            },
            (error) => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
@import '@/assets/scss/titles';
@import '@/assets/scss/header';
@import '@/assets/scss/intro';
@import '@/assets/scss/quote';
@import '@/assets/scss/testimonial';
@import '@/assets/scss/video';
@import '@/assets/scss/course';
@import '@/assets/scss/event';
@import '@/assets/scss/pages';
@import '@/assets/scss/blog';
@import '@/assets/scss/widget';
@import '@/assets/scss/footer';
@import '@/assets/scss/dark-mode';
</style>
<style scoped>
button:hover {
  background-color: #3f3a64 !important;
  font-weight: 600;
  border-color: transparent;
}
button {
  background-color: #20ad96 !important;
  border-color: #20ad96;
}
a {
  color: #696969;
}
label {
  display: block;
  margin-top: 10px;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
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
.alert-danger {
  margin: 15px 0px;
  padding: 15px;
}
</style>
