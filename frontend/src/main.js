import Vue from 'vue';
import '@/assets/scss/style.scss';
import App from './App.vue';
import { router } from './router';
import store from './store';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import VeeValidate from 'vee-validate';
import Vuex from 'vuex';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import Vuetify from '../node_modules/vuetify';
import colors from '../node_modules/vuetify/lib/util/colors';
import BootstrapVue from '../node_modules/bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import '../node_modules/vuetify/dist/vuetify.min.css';
import '../node_modules/vuetify/dist/vuetify.css';
import { initializeApp } from 'firebase/app';
import { getFirestore, collection, query, where, getDocs } from "firebase/firestore";

import { getAuth } from "firebase/auth";
import VueTextareaAutosize from '../node_modules/vue-textarea-autosize';
import Multiselect from 'vue-multiselect';
//import createTransport from '../node_modules/nodemailer/lib/nodemailer.js';

import {
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt,
} from '@fortawesome/free-solid-svg-icons';
import AOS from 'aos';
import 'aos/dist/aos.css';
import VueAwesomeSwiper from 'vue-awesome-swiper';
import 'swiper/swiper.scss';
import VueSilentbox from 'vue-silentbox';
import BackToTop from 'vue-backtotop';
import * as VueGoogleMaps from 'vue2-google-maps';
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyCGM-62ap9R-huo50hJDn05j3x-mU9151Y',
  },
});
library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);
Vue.use(BackToTop);
Vue.use(VueSilentbox);
Vue.use(VueAwesomeSwiper);
Vue.use(VueTextareaAutosize);
Vue.config.productionTip = false;

Vue.use(VeeValidate);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('multiselect', Multiselect);
Vue.use(BootstrapVue);
Vue.use(Vuex);

//const vuetifyOptions = {}
Vue.use(Vuetify);

const firebaseConfig = {
  apiKey: 'AIzaSyC9kuR4ROsxynWxnQRuDTAw2Ok4T1FRZVE',
  authDomain: 'idana3-e8406.firebaseapp.com',
  projectId: 'idana3-e8406',
  storageBucket: 'idana3-e8406.appspot.com',
  messagingSenderId: '1013899700274',
  appId: '1:1013899700274:web:a2153bf5e4ed9bcde0b42b',
  measurementId: 'G-MFPVVYKP65',
};

const firebaseApp = initializeApp(firebaseConfig);
export const db = getFirestore(firebaseApp);
export const auth = getAuth(firebaseApp);

/*let nodemailer = require('nodemailer');
var transOptions = {
  service: 'gmail',
  auth: {
    user: 'idanahealth@gmail.com',
    pass: 'Idana1234%'
  }
};
export const transporter = nodemailer.createTransport(transOptions);*/

const veutifynew = new Vuetify({
  theme: {
    themes: {
      light: {
        primary: colors.blue,
        secondary: colors.grey.darken1,
        accent: colors.shades.black,
        error: colors.red.accent3,
      },
      dark: {
        primary: colors.blue.lighten3,
      },
    },
  },
});

new Vue({
  created() {
    AOS.init({ disable: 'phone', once: true, offset: 10 });
  },
  router,
  store,
  vuetify: veutifynew,
  //vuetify: new Vuetify(vuetifyOptions),
  render: (h) => h(App),
}).$mount('#app');
