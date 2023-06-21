<template>
  <div id="app">
    <v-app id="inspire">
      <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css"
        integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA="
        crossorigin="anonymous"
      />
      <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/ti-icons@0.1.2/css/themify-icons.css"
      />
      <h1>Payment Successful</h1>
    </v-app>
  </div>
</template>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://js.stripe.com/v3/"></script>

<script>
import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  name: 'paymentSuccess',

  data() {
    return {};
  },

  computed: {
    /*     currentUser() {
      return this.$store.state.auth.user;
    }, */
  },

  mounted() {},
  created() {},
  methods: {},
};
</script>

<style scoped>
body {
  margin-top: 20px;
}
.custom-icon-box.medium {
  font-size: 20px;
  width: 50px;
  height: 50px;
  line-height: 50px;
}
.custom-icon-box {
  font-size: 30px;
  margin-bottom: 33px;
  display: inline-block;
  color: #ffffff;
  height: 65px;
  width: 65px;
  line-height: 65px;
  background-color: #3f3a64;
  text-align: center;
  border-radius: 0.3rem;
}
.social-icon-style2 li a {
  display: inline-block;
  font-size: 14px;
  text-align: center;
  color: #ffffff;
  background-color: #3f3a64;
  height: 41px;
  line-height: 41px;
  width: 41px;
}
.rounded-3 {
  border-radius: 0.3rem !important;
}

.social-icon-style2 {
  margin-bottom: 0;
  display: inline-block;
  padding-left: 10px;
  list-style: none;
}

.social-icon-style2 li {
  vertical-align: middle;
  display: inline-block;
  margin-right: 5px;
}

a,
a:active,
a:focus {
  color: #616161;
  text-decoration: none;
  transition-timing-function: ease-in-out;
  -ms-transition-timing-function: ease-in-out;
  -moz-transition-timing-function: ease-in-out;
  -webkit-transition-timing-function: ease-in-out;
  -o-transition-timing-function: ease-in-out;
  transition-duration: 0.2s;
  -ms-transition-duration: 0.2s;
  -moz-transition-duration: 0.2s;
  -webkit-transition-duration: 0.2s;
  -o-transition-duration: 0.2s;
}

.text-secondary,
.text-secondary-hover:hover {
  color: #3385ff !important;
}
.display-25 {
  font-size: 1.4rem;
}

p {
  margin: 0 0 20px;
}

.mb-1-6,
.my-1-6 {
  margin-bottom: 1.6rem;
}

.profile-message-btn .btn {
  color: #ffffff;
  border-color: #20ad96;
  background-color: #20ad96;
  height: 41px;
  line-height: 30px;
  width: 180px;
  position: relative;
  margin-bottom: 30px;
  margin-top: 30px;
  text-align: center;
  display: block;
}

.btn:hover {
  background: #3f3a64;
  border-color: #3f3a64;
}
.card:hover {
  box-shadow: 0 14px 59px rgba(0, 0, 0, 0.12);
  cursor: pointer;
}
</style>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/elements';
</style>
