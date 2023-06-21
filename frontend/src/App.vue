<template>
  <div id="app">
    <link
      rel="stylesheet"
      href="//use.fontawesome.com/releases/v5.0.7/css/all.css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/@mdi/font@4.x/css/materialdesignicons.min.css"
      rel="stylesheet"
    />
    <nav class="navbar navbar-expand navbar-dark bg-dark" v-if="currentUser">
      <div class="navbar-nav mr-auto">
        <li v-if="showAdminBoard" class="nav-item">
          <router-link to="/admin" class="nav-link">Admin Board</router-link>
        </li>
        <li v-if="showModeratorBoard" class="nav-item">
          <router-link to="/mod" class="nav-link">Moderator Board</router-link>
        </li>

        <li v-if="currentUser" class="nav-item">
          <router-link
            v-if="currentUser && currentUser.usertype == 'client'"
            to="/clientdashboard"
            class="nav-link"
            >Dashboard</router-link
          >
          <router-link
            v-else-if="currentUser && currentUser.usertype == 'coach'"
            to="/coachdashboard"
            class="nav-link"
            >Dashboard</router-link
          >
        </li>
      </div>

      <div
        v-if="currentUser && currentUser.usertype == 'coach'"
        class="navbar-nav ml-auto"
      >
        <li class="nav-item">
          <router-link to="/coachprofile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/inbox" class="nav-link">
            <i class="fas fa-envelope-square"></i>
            Inbox
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" />LogOut
          </a>
        </li>
      </div>
      <div
        v-if="currentUser && currentUser.usertype == 'client'"
        class="navbar-nav ml-auto"
      >
        <li class="nav-item">
          <router-link to="/clientprofile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>

        <li class="nav-item">
          <router-link to="/inbox" class="nav-link">
            <i class="fas fa-envelope-square"></i>
            Inbox
          </router-link>
        </li>

        <li class="nav-item">
          <a class="nav-link" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" />LogOut
          </a>
        </li>
      </div>
    </nav>

    <div>
      <router-view />
    </div>

    <!-- <v-footer color="primary lighten-1" padless>
      <v-row justify="center" no-gutters>
        <v-btn
          v-for="link in links"
          :key="link"
          color="white"
          text
          rounded
          class="my-2"
        >
          {{ link }}
        </v-btn>
        <v-btn
          color="white"
          text
          rounded
          class="my-2"
          @click="navigateToContactForm()"
          >Contact Us
        </v-btn>

        <v-col class="primary lighten-2 py-4 text-center white--text" cols="12">
          {{ new Date().getFullYear() }} — <strong>Idana</strong>
        </v-col>
      </v-row>
    </v-footer> -->
  </div>
</template>

<script>
import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import SessionCheck from './services/sessioncheck';
import { getAuth } from 'firebase/auth';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  data: () => ({
    links: ['Team', 'Blog'],
    id: '',
  }),
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }

      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MODERATOR');
      }

      return false;
    },
  },
  mounted() {
    // this.id = this.$store.state.auth.user.id;
    // console.log('Id of the logged in user is ' + this.id);
    // SessionCheck.activityWatcher(this.currentUser);
    SessionCheck.activityWatcher();
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$store.dispatch('auth/sociallogout');
      this.$router.push('/login');
    },
    navigateToContactForm() {
      let routeData = this.$router.resolve({
        name: 'contactform',
      });
      window.open(routeData.href, '_blank');
    },
  },
};
</script>
<style>
a:hover {
  text-decoration: none !important;
}
.v-application .activeDate {
  background-color: #20ad96 !important;
  border-color: #20ad96 !important;
  color: white !important;
}
</style>
