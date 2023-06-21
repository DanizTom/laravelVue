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
            Coaches
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
                <td
                  @click="navigateToCoachPublicProfile(props.item.id)"
                  style="width: 30%"
                >
                  <div class="col-sm-9">
                    <!--<vue-avatar
                      :username="props.item.username"
                      :src="`data:image/gif;base64,` + props.item.coachProfpic"
                    ></vue-avatar>-->
                    <a class="image-link" href="#"
                      ><img
                        class="image"
                        height="200px"
                        width="200px"
                        style="object-fit: cover; border-radius: 50%"
                        v-if="props.item.coachProfpic !== null"
                        :src="`data:image/png;base64,${props.item.coachProfpic}`"
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
                    <h4 class="search-result-item-heading">
                      <a href="#"
                        >{{ props.item.firstname }} {{ props.item.lastname }}
                      </a>
                    </h4>
                    <p class="info">{{ props.item.coachCity }}</p>
                    <p class="description">{{ props.item.aboutme }}</p>
                  </div>
                </td>
                <!--<td class="text-xs-left" style="width: 30%">
                  {{ props.item.coachSkills }}
                </td>-->
                <td class="text-xs-left" style="width: 30%">
                  <!--<ul v-for="Skill in props.item.coachSkills" :key="Skill">
                    <v-chip class="ma-2" color="blue" outlined>
                      {{ Skill }}
                    </v-chip>
                  </ul>-->
                  <v-col cols="12" sm="7" md="6" lg="18">
                    <v-chip-group active-class="primary--text" column>
                      <v-chip
                        color="blue"
                        outlined
                        v-for="Skill in props.item.coachSkills"
                        :key="Skill"
                      >
                        {{ Skill }}
                      </v-chip>
                    </v-chip-group>
                  </v-col>
                </td>
                <td class="text-xs-left" style="width: 30%">
                  {{ props.item.email }}
                </td>
                <!--<td class="text-xs-left">{{ props.item.coachCity }}</td>-->
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
        <v-content>
          <Calendar />
        </v-content>
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

//Debugging
import Avatar from 'vue-avatar-component';
//import Calendar from '../components/Calendar.vue';
Vue.use(Avatar);
Vue.component('vue-avatar-component', Avatar);

Vue.component('b-card-text', BCardText);
Vue.component('v-select', vSelect);
library.add(faCoffee);
Vue.component('font-awesome-icon', FontAwesomeIcon);
Vue.component('vue-avatar', VueAvatar);
Vue.use(VueMaterial);

export default {
  name: 'boardclientdashboard',
  data() {
    return {
      response: [],
      users: [],
      search: '',
      imageUrl: '',
      content: '',
      loading: false,
      headers: [
        {
          text: 'Profile',
          align: 'left',
          sortable: false,
        },
        { text: 'Skills', value: 'coachSkills' },
        { text: 'Email', value: 'email' },
      ],
    };
  },

  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    this.imageUrl = 'data:image/png;base64,';
    if (this.loggedIn) {
      this.loading = true;
      UserService.getAllCoaches().then(
        (response) => {
          this.users = response.data;
          //this.content = response.data;
          this.loading = false;
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
    navigateToCoachPublicProfile(id) {
      console.log('Id for profile is', id);
      let routeData = this.$router.resolve({
        name: 'coachpublicprofile',
        params: { id: id },
      });
      window.open(routeData.href, '_blank');
    },
  },

  components: {
    MultiSelect,
    //Calendar
  },
};
</script>
