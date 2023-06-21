<template>
  <div>
    <div class="login-register-section pt-4 section-padding-bottom">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="row">
              <div class="col-md-8 offset-md-2">
                <div class="login-form-wrapper">
                  <form
                    class="login-form"
                    @submit.prevent="updateUserwithNewMethod"
                  >
                    <div class="row">
                      <div class="col-12">
                        <h3>{{ currentUser.username }}'s Profile</h3>
                      </div>
                      <div class="col-md-6 single-input mb-10">
                        <label>First name</label>
                        <input
                          v-model="user.firstname"
                          placeholder="Enter your first name"
                          type="text"
                        />
                      </div>
                      <div class="col-md-6 single-input mb-10">
                        <label>Last name</label>
                        <input
                          v-model="user.lastname"
                          placeholder="Enter your last name"
                          type="text"
                        />
                      </div>
                      <div class="col-md-6 single-input mb-10">
                        <label>Email address</label>
                        <input
                          v-model="user.email"
                          placeholder="Enter your email address"
                          type="text"
                        />
                      </div>
                      <div class="col-md-6 single-input mb-30">
                        <label>Age</label>
                        <input
                          v-model="user.age"
                          placeholder="What is your age?"
                          type="number"
                        />
                      </div>
                      <div class="col-md-6 offset-md-3 single-input">
                        <button
                          @click="updateUserwithNewMethod"
                          class="btn btn-primary btn-hover-secondary btn-width-100"
                        >
                          Save Changes
                        </button>
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
  </div>
</template>

<script>
import UserService from '../services/user.service';
import User from '../models/user';

import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  data() {
    return {
      user: new User('', '', '', '', ''),
      id: '',
      firstname: '',
      lastname: '',
      email: '',
      age: '',
      message: '',
    };
  },
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    //Display values in form textbox from the user in current local state of the browser
    // this.user = this.$store.state.auth.user;
  },

  methods: {
    updateUserwithNewMethod() {
      UserService.putUpdatedUser(this.user).then(
        (response) => {
          this.content = response.data;
          //this.$router.push('/profile')
        },
        (error) => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      );
    },
  },
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
</style>
