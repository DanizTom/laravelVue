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
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-7 col-lg-4 mb-5 mb-lg-0 wow fadeIn">
            <div class="card border-0 shadow">
              <img
                class="mx-auto"
                height="300px"
                width="300px"
                style="object-fit: cover; border-radius: 50%"
                v-if="user.profpic !== null"
                :src="`data:image/png;base64,${user.profpic}`"
                alt="coach public profile picture"
              />

              <img
                class="mx-auto"
                height="300px"
                width="300px"
                v-else
                src="https://img.icons8.com/ios/100/000000/no-camera--v1.png"
              />

              <div class="card-body p-1-9 p-xl-5">
                <div class="mb-4">
                  <h3 class="h4 mb-0">
                    {{ user.firstname }} {{ user.lastname }}
                  </h3>
                  <!--<span class="text-primary">CEO &amp; Founder</span>-->
                </div>
                <ul class="list-unstyled pl-0 mb-4">
                  <li class="mb-4">
                    <a href="#!"
                      ><i
                        class="far fa-envelope display-25 me-3 text-secondary"
                      ></i>
                      {{ user.email }}</a
                    >
                  </li>
                  <li class="mb-4">
                    <a href="#!"
                      ><i
                        class="fas fa-mobile-alt display-25 me-3 text-secondary"
                      ></i
                      >{{ user.mobile }}</a
                    >
                  </li>
                  <li>
                    <a href="#!"
                      ><i
                        class="fas fa-map-marker-alt display-25 me-3 text-secondary"
                      ></i
                      >{{ user.city }} {{ user.state }}</a
                    >
                  </li>
                </ul>
                <ul class="social-icon-style2 ps-0">
                  <li>
                    <a
                      v-if="
                        user.facebook != null && user.facebook.includes('http')
                      "
                      target="_blank"
                      :href="user.facebook"
                      class="rounded-3"
                      ><i class="fab fa-facebook-f"></i
                    ></a>
                  </li>
                  <li>
                    <a
                      v-if="
                        user.twitter != null && user.twitter.includes('http')
                      "
                      target="_blank"
                      :href="user.twitter"
                      class="rounded-3"
                      ><i class="fab fa-twitter"></i
                    ></a>
                  </li>
                  <li>
                    <a
                      v-if="
                        user.youtube != null && user.youtube.includes('http')
                      "
                      target="_blank"
                      :href="user.youtube"
                      class="rounded-3"
                      ><i class="fab fa-youtube"></i
                    ></a>
                  </li>
                  <li>
                    <a
                      v-if="
                        user.linkedin != null && user.linkedin.includes('http')
                      "
                      target="_blank"
                      :href="user.linkedin"
                      class="rounded-3"
                      ><i class="fab fa-linkedin-in"></i
                    ></a>
                  </li>
                </ul>
                <div class="mt-3 mb-3">
                  <button
                    class="btn btn-primary btn-hover-secondary"
                    @click="sendMessageToCoach(id)"
                  >
                    <i class="fa mr-2 fa-envelope"></i> Send message
                  </button>
                </div>
                <div>
                  <button
                    class="btn btn-primary btn-hover-secondary"
                    @click="navigateToCalendarScheduling()"
                  >
                    <i class="fa mr-2 fa-calendar"></i> Schedule Meeting
                  </button>
                </div>
                <!--<button
                  class="btn btn-primary btn-hover-secondary"
                  @click="openStripePayment()"
                >
                  <i class="fa mr-2 fa-envelope"></i> Pay Now
                </button>-->
                <br />
                <div><StripePayment></StripePayment></div>
              </div>
            </div>
          </div>
          <div class="col-lg-8">
            <div class="ps-lg-1-6 ps-xl-5">
              <div class="mb-5 wow fadeIn">
                <div class="text-start mb-1-6 wow fadeIn">
                  <h2 class="h1 mb-0 text-primary">About Me</h2>
                </div>
                <p>
                  {{ user.aboutme }}
                </p>
              </div>
              <div class="mb-5 wow fadeIn">
                <div class="text-start mb-1-6 wow fadeIn">
                  <h2 class="mb-0 text-primary">Education & Experience</h2>
                </div>
                <div class="row mt-n4">
                  <div class="col-sm-6 col-xl-4 cards mt-4">
                    <div class="card text-center border-0 rounded-3">
                      <div class="card-body">
                        <i
                          class="ti-bookmark-alt custom-icon-box medium rounded-3 mb-4"
                        ></i>
                        <h3 class="h5 mb-3">Education and Career</h3>
                        <p class="mb-0">
                          {{ user.education }}
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-xl-4 mt-4">
                    <div class="card text-center border-0 rounded-3">
                      <div class="card-body">
                        <i
                          class="ti-medall-alt custom-icon-box medium rounded-3 mb-4"
                        ></i>
                        <h3 class="h5 mb-3">Experience</h3>
                        <p class="mb-0">
                          {{ user.experience }}
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--<div class="wow fadeIn">
                <div class="text-start mb-1-6 wow fadeIn">
                  <h2 class="mb-0 text-primary">Skills</h2>
                </div>
                <p class="mb-4">
                     <ul v-for="Skill in user.skills" :key="Skill">
                    <v-chip class="ma-2" color="green" outlined>
                      {{ Skill }}
                    </v-chip>
                  </ul>
                </p>
              </div>-->
              <div class="text-start mb-1-6 wow fadeIn">
                <h2 class="mb-0 text-primary">Skills</h2>
              </div>
              <!--<div class="pa-4">
                <v-chip-group active-class="primary--text" column>
                  <v-chip v-for="Skill in user.skills" :key="Skill">
                    {{ Skill }}
                  </v-chip>
                </v-chip-group>
              </div>-->
              <div class="pa-4">
                <v-col cols="12" sm="7" md="6" lg="5">
                  <v-sheet rounded="xl">
                    <div class="pa-4">
                      <v-chip-group active-class="primary--text" column>
                        <v-chip v-for="Skill in user.skills" :key="Skill">
                          {{ Skill }}
                        </v-chip>
                      </v-chip-group>
                    </div>
                  </v-sheet>
                </v-col>
              </div>

              <div class="wow fadeIn">
                <div class="text-start mb-1-6 wow fadeIn">
                  <h2 class="mb-0 text-primary">Reviews</h2>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="my-2">
                      <v-col class="text-left">
                        <button
                          v-if="isCoachReviewAvailableByClientId === false"
                          large
                          class="btn btn-primary btn-hover-secondary"
                          @click="navigateToSubmitCoachReview(id)"
                        >
                          Write a review
                        </button>
                      </v-col>
                    </div>
                    <div class="text-xs-center">
                      <v-card-text
                        v-for="coachreview in coachreviews"
                        :key="coachreview.clientid"
                      >
                        <div class="left">
                          <span>
                            <img
                              src="https://bootdey.com/img/Content/avatar/avatar1.png"
                              class="profile-pict-img img-fluid"
                              alt=""
                              width="10%"
                              height="10%"
                            />
                          </span>
                        </div>
                        {{ coachreview.review }}<br />
                        <v-rating
                          background-color="warning lighten-1"
                          color="warning"
                          v-model="coachreview.rating"
                          readonly="true"
                        ></v-rating>
                        <button
                          v-if="coachreview.clientid === parseInt(clientid)"
                          class="btn btn-primary btn-hover-secondary"
                          @click="navigateToEditCoachReview(id)"
                        >
                          Edit your Review
                        </button>
                      </v-card-text>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </v-app>
  </div>
</template>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://js.stripe.com/v3/"></script>

<script>
import axios from 'axios';
import authHeader from '../services/auth-header';
import UserService from '../services/user.service';
import User from '../models/user';

import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import Vuetify from '../../node_modules/vuetify';
import CoachCalendar from '../components/CoachCalendar.vue';
import StripePayment from '../components/StripePayment.vue';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  name: 'coachpublicprofile',

  data() {
    return {
      user: '',
      firstname: '',
      lastname: '',
      email: '',
      age: '',
      message: '',
      imageUrl: '',
      activetab: 1,
      response: [],
      errors: [],
      id: '',
      coachreviews: [],
      src: '',
      clientid: '',
      isCoachReviewAvailableByClientId: false,
      loading: false,
    };
  },

  components: {
    CoachCalendar,
    StripePayment,
  },

  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },

  mounted() {
    console.log('*mounted', this.$refs);
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    this.imageUrl = 'data:image/png;base64,';
    // this.user = this.$store.state.auth.user;
    UserService.getCoachPublicProfileById(this.$route.params.id)
      .then((response) => {
        // JSON responses are automatically parsed.
        console.log(response.data);
        this.user = response.data;
        //this.ratings = ["He is a good coach", "he is good in Maths"]
        this.src = response.data.profpic;
        console.log('Image is ---' + this.src);
        this.coachreviews = response.data.coachReviewsByCoachId;
        console.log('coachreviews is ---' + JSON.stringify(this.coachreviews));
      })
      .catch((e) => {
        this.errors.push(e);
      });
    UserService.isCoachReviewByClientIdAvailable(
      this.$route.params.id,
      this.clientid
    )
      .then((response) => {
        // JSON responses are automatically parsed.
        console.log(response.data);
        this.isCoachReviewAvailableByClientId = response.data;
        console.log(
          'isCoachReviewAvailableByClientId is ' +
            this.isCoachReviewAvailableByClientId
        );
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
  created() {
    this.id = this.$route.params.id;
    console.log(this.id);
    this.clientid = this.$store.state.auth.user.id;
    console.log('this.clientid is ' + this.clientid);
  },
  methods: {
    navigateToSubmitCoachReview(coachid) {
      console.log('coachid for profile is', coachid);
      let routeData = this.$router.resolve({
        name: 'coachreview',
        params: { id: coachid },
      });
      window.open(routeData.href, '_blank');
    },
    navigateToEditCoachReview(coachid) {
      console.log('coachid for profile is', coachid);
      let routeData = this.$router.resolve({
        name: 'coacheditreview',
        params: { id: coachid },
      });
      window.open(routeData.href, '_blank');
    },

    sendMessageToCoach(coachid) {
      console.log('coachid for profile is', coachid);
      let routeData = this.$router.resolve({
        name: 'sendmessage',
        params: { id: coachid },
      });
      window.open(routeData.href, '_blank');
    },

    navigateToCalendarScheduling() {
      let routeData = this.$router.resolve({
        name: 'coachcalendar',
      });
      window.open(routeData.href, '_blank');
    },

    openStripePayment() {
      let routeData = this.$router.resolve({
        name: 'stripePayment',
      });
      window.open(routeData.href, '_blank');
    },
  },
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
