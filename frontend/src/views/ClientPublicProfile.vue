<template>
  <div class="container">
    <div class="text-center mt-4">
      <div class="top-header">
        <a class="image-link" href="#"
          ><img
            class="image"
            height="200px"
            width="200px"
            style="object-fit: cover; border-radius: 50%"
            v-if="user.profpic !== null"
            :src="`data:image/png;base64,${user.profpic}`"
          />
          <img
            class="image"
            height="200px"
            width="200px"
            style="object-fit: cover; border-radius: 50%"
            v-else
            src="https://img.icons8.com/ios/100/000000/no-camera--v1.png"
          />
        </a>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="cards px-5 pb-4" style="padding-top: 100px">
          <h3 class="mt-4 text-center text-primary">
            {{ user.firstname }} {{ user.lastname }}
          </h3>
          <hr />
          <div class="d-flex align-items-baseline mt-5 mb-5">
            <h5 class="text-secondary">
              <i class="fas fa-envelope mr-2"></i>Email :
            </h5>
            <h5 class="ml-4">{{ user.email }}</h5>
            <p></p>
          </div>
          <div class="d-flex align-items-baseline mt-5 mb-5">
            <h5 class="text-secondary">
              <i class="fas fa-address-card mr-2"></i> Full Name :
            </h5>
            <h5 class="ml-4">{{ user.firstname }} {{ user.lastname }}</h5>
            <p></p>
          </div>
          <div class="d-flex align-items-baseline mt-5 mb-5">
            <h5 class="text-secondary">
              <i class="fas fa-id-badge mr-2"></i>
              Age :
            </h5>
            <h5 class="ml-4">{{ user.age }}</h5>
            <p></p>
          </div>
          <div class="d-flex align-items-baseline mt-5 mb-5">
            <h5 class="text-secondary">
              <i class="fas fa-home mr-2"></i>
              City :
            </h5>
            <h5 class="ml-4">{{ user.city }}</h5>
            <p></p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
import axios from 'axios';
import authHeader from '../services/auth-header';
import UserService from '../services/user.service';
import User from '../models/user';

import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import Vuetify from '../../node_modules/vuetify';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  name: 'clientpublicprofile',
  data() {
    return {
      user: '',
      firstname: '',
      lastname: '',
      email: '',
      age: '',
      activetab: 1,
      response: [],
      errors: [],
      id: '',
      src: '',
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },

  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  },
  created() {
    this.id = this.$route.params.id;
    console.log(this.id);
    this.clientid = this.$store.state.auth.user.id;
    console.log('this.clientid is ' + this.clientid);
  },

  mounted: function () {
    UserService.getClientPublicProfileById(this.$route.params.id)
      .then((response) => {
        // JSON responses are automatically parsed.
        console.log(response.data);
        this.user = response.data;
        this.src = response.data.profpic;
        console.log('Image is ---' + this.src);
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
};
</script>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
.cards {
  box-shadow: 0 14px 59px rgba(0, 0, 0, 0.12);
}
</style>
