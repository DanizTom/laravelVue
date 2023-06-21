<template>
  <div>
    <div class="main-container">
      <HeaderStyleTwo />
      <OffCanvasMobileMenu />
      <b-tabs card lazy>
        <b-tab title="Client Sign Up" active>
          <div class="login-register-section section-padding-bottom">
            <div class="container">
              <div class="row">
                <div class="col-12">
                  <div class="row">
                    <div
                      class="offset-md-4 offset-lg-4 offset-xl-4 col-md-4 col-lg-4 col-xl-4"
                    >
                      <!-- Register Form Start -->
                      <div class="login-form-wrapper mt-sm-50 mt-xs-50">
                        <img
                          id="profile-img"
                          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                          class="profile-img-card"
                        />
                        <form
                          class="register-form"
                          name="form"
                          @submit.prevent="handleRegister"
                        >
                          <div v-if="!successful">
                            <div class="single-input mb-30">
                              <label for="username">Username</label>
                              <input
                                v-model="user.username"
                                v-validate="'required|min:3|max:20'"
                                type="text"
                                id="usernameOne"
                                name="username"
                                placeholder="Username"
                              />
                              <div
                                v-if="submitted && errors.has('username')"
                                class="alert-danger"
                              >
                                {{ errors.first('username') }}
                              </div>
                            </div>
                            <div class="single-input mb-30">
                              <label for="email">Email</label>
                              <input
                                v-model="user.email"
                                v-validate="'required|email|max:50'"
                                type="email"
                                id="email"
                                name="username"
                                placeholder="Email"
                              />
                              <div
                                v-if="submitted && errors.has('email')"
                                class="alert-danger"
                              >
                                {{ errors.first('email') }}
                              </div>
                            </div>
                            <div class="single-input mb-30">
                              <label for="passwordOne">Password</label>
                              <input
                                v-model="user.password"
                                v-validate="'required|min:6|max:40'"
                                type="password"
                                id="passwordOne"
                                name="password"
                                placeholder="Password"
                              />
                              <p class="description">
                                The password must be at least twelve characters
                                long, contain upper and lower case letters,
                                contain numbers, contain symbols like ! " ? $ %
                                ^ &amp;
                              </p>
                              <div
                                v-if="submitted && errors.has('password')"
                                class="alert-danger"
                              >
                                {{ errors.first('password') }}
                              </div>
                            </div>
                            <div class="previous-field">
                              <input
                                type="hidden"
                                ref="my_input"
                                class="form-control"
                                value="client"
                              />
                              <input
                                type="hidden"
                                name="usertype"
                                :value="client"
                              />
                            </div>
                            <div class="single-input">
                              <button
                                class="btn btn-primary btn-hover-secondary btn-width-100"
                              >
                                Sign Up
                              </button>
                            </div>
                          </div>
                        </form>
                        <div
                          v-if="message"
                          class="alert"
                          :class="successful ? 'alert-success' : 'alert-danger'"
                        >
                          {{ message }}
                        </div>
                      </div>
                      <!-- Register Form End -->
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </b-tab>

        <b-tab title="Coach Sign Up">
          <div class="login-register-section section-padding-bottom">
            <div class="container">
              <div class="row">
                <div class="col-12">
                  <div class="row">
                    <div
                      class="offset-md-4 offset-lg-4 offset-xl-4 col-md-4 col-lg-4 col-xl-4"
                    >
                      <!-- Register Form Start -->
                      <div class="login-form-wrapper mt-sm-50 mt-xs-50">
                        <img
                          id="profile-img"
                          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                          class="profile-img-card"
                        />
                        <form
                          class="register-form"
                          name="form"
                          @submit.prevent="handleRegister"
                        >
                          <div v-if="!successful">
                            <div class="single-input mb-30">
                              <label for="username">Username</label>
                              <input
                                v-model="user.username"
                                v-validate="'required|min:3|max:20'"
                                type="text"
                                id="usernameOne"
                                name="username"
                                placeholder="Username"
                              />
                              <div
                                v-if="submitted && errors.has('username')"
                                class="alert-danger"
                              >
                                {{ errors.first('username') }}
                              </div>
                            </div>
                            <div class="single-input mb-30">
                              <label for="email">Email</label>
                              <input
                                v-model="user.email"
                                v-validate="'required|email|max:50'"
                                type="email"
                                id="email"
                                name="username"
                                placeholder="Email"
                              />
                              <div
                                v-if="submitted && errors.has('email')"
                                class="alert-danger"
                              >
                                {{ errors.first('email') }}
                              </div>
                            </div>
                            <div class="single-input mb-30">
                              <label for="passwordOne">Password</label>
                              <input
                                v-model="user.password"
                                v-validate="'required|min:6|max:40'"
                                type="password"
                                id="passwordOne"
                                name="password"
                                placeholder="Password"
                              />
                              <p class="description">
                                The password must be at least twelve characters
                                long, contain upper and lower case letters,
                                contain numbers, contain symbols like ! " ? $ %
                                ^ &amp;
                              </p>
                              <div
                                v-if="submitted && errors.has('password')"
                                class="alert-danger"
                              >
                                {{ errors.first('password') }}
                              </div>
                            </div>
                            <div class="previous-field">
                              <input
                                type="hidden"
                                ref="my_input"
                                class="form-control"
                                value="coach"
                              />
                              <input
                                type="hidden"
                                name="usertype"
                                :value="coach"
                              />
                            </div>
                            <div class="single-input">
                              <button
                                class="btn btn-primary btn-hover-secondary btn-width-100"
                              >
                                Sign Up
                              </button>
                            </div>
                          </div>
                        </form>
                        <div
                          v-if="message"
                          class="alert"
                          :class="successful ? 'alert-success' : 'alert-danger'"
                        >
                          {{ message }}
                        </div>
                      </div>
                      <!-- Register Form End -->
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
  </div>
</template>

<script>
import User from '../models/user';

export default {
  name: 'Register',
  components: {
    HeaderStyleTwo: () => import('@/components/landingPage/HeaderStyleTwo'),
    OffCanvasMobileMenu: () =>
      import('@/components/landingPage/OffCanvasMobileMenu'),
    // EventItemGridStyle: () => import('@/components/landingPage/EventItemGridStyle'),
    FooterStyleOne: () => import('@/components/landingPage/FooterStyleOne'),
  },

  data() {
    return {
      user: new User('', '', '', ''),
      submitted: false,
      successful: false,
      message: '',
      usertypevalue: '',
      coach: 'coach',
      client: 'client',
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
      //this.usertypeValue = this.$refs.my_input.value
    },
  },
  mounted() {
    if (this.loggedIn) {
      if (this.$store.state.auth.user.usertype == 'coach') {
        this.$router.push('/coachprofile');
      } else {
        this.$router.push('/clientprofile');
      }
    }
  },
  methods: {
    handleRegister() {
      //capture usertype value based on the form type (coach/Q) filled by user.
      this.usertypeValue = this.$refs.my_input.value;
      this.message = '';
      this.submitted = true;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          //set user's type based on the value added by the user
          this.user.usertype = this.usertypeValue;
          this.$store.dispatch('auth/register', this.user).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
            },
            (error) => {
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
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
.nav .nav-tabs .card-header-tabs .nav-tabs .nav-link.active {
  background-color: #3f3a64 !important;
  font-weight: 600;
  border-color: transparent;
  color: white !important;
}
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
  padding: 10px;
}
</style>
