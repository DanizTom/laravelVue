<template>
  <div id="app">
    <v-app id="inspire">
      <link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous"
      />
      <link
        href="https://cdn.jsdelivr.net/npm/@mdi/font@4.x/css/materialdesignicons.min.css"
        rel="stylesheet"
      />
      <div class="container">
        <v-card>
          <v-card-title>
            Clients
            <v-spacer></v-spacer>
            <v-text-field
              v-model="search"
              label="Search"
              single-line
              hide-details
            ></v-text-field>
          </v-card-title>
          <v-data-table
            :items-per-page="5"
            :headers="headers"
            :items="users"
            :search="search"
            :loading="this.loading"
            class="elevation-1"
          >
            <template v-slot:item="props">
              <tr>
                <td @click="navigateToClientPublicProfile(props.item.id)">
                  <vue-avatar
                    :username="props.item.username"
                    :src="`data:image/gif;base64,` + props.item.clientProfpic"
                  ></vue-avatar>
                </td>
                <!--<td class=ps.item.firstname }} {{ props.item.lastname }}</td>-->
                <td class="text-xs-left">{{ props.item.firstname }}</td>
                <td class="text-xs-left">{{ props.item.lastname }}</td>
                <td class="text-xs-left">{{ props.item.email }}</td>
                <td class="text-xs-left">{{ props.item.clientCity }}</td>
              </tr>
            </template>
            <v-alert
              slot="no-results"
              :value="true"
              color="error"
              icon="warning"
            >
              Your search for "{{ search }}" found no results.
            </v-alert>
          </v-data-table>
        </v-card>
      </div>
    </v-app>
  </div>
</template>

<script>
import UserService from '../services/user.service';
import { MultiSelect } from 'vue-search-select';
import Vue from 'vue';
import vSelect from 'vue-select';
import VueAvatar from '@lossendae/vue-avatar';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import { BCardText } from 'bootstrap-vue';
import { BTabs } from 'bootstrap-vue';
import 'vuetify/dist/vuetify.min.css';
import Vuetify from '../../node_modules/vuetify';
import VueMaterial from 'vue-material';
import 'vue-material/dist/vue-material.min.css';
import Avatar from 'vue-avatar-component';
Vue.use(Avatar);
Vue.component('vue-avatar-component', Avatar);

Vue.component('b-card-text', BCardText);
Vue.component('v-select', vSelect);
library.add(faCoffee);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('vue-avatar', VueAvatar);
Vue.use(VueMaterial);

export default {
  name: 'boardcoachdashboard',
  data() {
    return {
      response: [],
      users: [],
      search: '',
      content: '',
      loading: false,
      headers: [
        {
          text: 'Profile',
          align: 'left',
          sortable: false,
          value: 'avataar',
        },
        {
          text: 'FirstName',
          align: 'left',
          sortable: false,
          value: 'firstname',
        },
        {
          text: 'LastName',
          align: 'left',
          sortable: false,
          value: 'lastname',
        },
        { text: 'Email', value: 'email' },
        { text: 'City', value: 'city' },
      ],
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.loading = true;
      UserService.getAllClients().then(
        (response) => {
          this.users = response.data;
          this.loading = false;
          //this.content = response.data;
        },
        (error) => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      );
    }
  },

  methods: {
    navigateToClientPublicProfile(id) {
      console.log('Id for profile is', id);
      let routeData = this.$router.resolve({
        name: 'clientpublicprofile',
        params: { id: id },
      });
      window.open(routeData.href, '_blank');
    },
  },

  components: {
    MultiSelect,
  },
};
</script>
