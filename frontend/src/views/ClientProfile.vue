<template>
  <div class="container">
    <div v-if="!contentLoading" class="main-body">
      <div class="row">
        <div class="col-lg-4 md-pr-5">
          <div class="card">
            <div class="card-body">
              <div class="d-flex flex-column align-items-center text-center">
                <img
                  height="200px"
                  width="200px"
                  style="object-fit: cover; border-radius: 50%"
                  v-if="imageploaded === 'false'"
                  src="https://img.icons8.com/ios/100/000000/no-camera--v1.png"
                />
                <img
                  height="200px"
                  width="200px"
                  style="object-fit: cover; border-radius: 50%"
                  v-else
                  :src="imageUrl + userProfile.profpic"
                />
                <div class="fileInput mt-4">
                  <v-file-input
                    solo
                    accept="image/*"
                    prepend-icon=""
                    prepend-inner-icon="mdi-camera"
                    label="Select Photo"
                    v-model="file"
                    @change="addphoto"
                  ></v-file-input>
                </div>
                <div class="mt-3">
                  <h4>
                    {{ userProfile.firstname }} {{ userProfile.lastname }}
                  </h4>
                  <p class="text-secondary mb-1">Full Stack Developer</p>
                  <p class="text-muted font-size-sm">
                    {{ userProfile.state }} {{ userProfile.city }}
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-8">
          <form id="demo" @submit="updateUser" v-on:submit.prevent>
            <v-expansion-panels multiple v-model="panel">
              <v-expansion-panel>
                <v-expansion-panel-header class="panel-header">
                  General Info
                </v-expansion-panel-header>
                <v-expansion-panel-content>
                  <div class="row">
                    <div class="single-input col-md-6 mb-15">
                      <label>First Name</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.firstname"
                        placeholder="Enter your first name"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>Last Name</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.lastname"
                        placeholder="Enter your last name"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>Email</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.email"
                        placeholder="What is your email address?"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>Phone</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.homephone"
                        placeholder="Enter your phone number"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>Mobile</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.mobile"
                        placeholder="Enter your phone number"
                      />
                    </div>
                  </div>
                </v-expansion-panel-content>
              </v-expansion-panel>
              <v-expansion-panel>
                <v-expansion-panel-header class="panel-header">
                  Demographic</v-expansion-panel-header
                >
                <v-expansion-panel-content>
                  <div class="row">
                    <div class="single-input col-md-6 mb-15">
                      <label>City</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.city"
                        placeholder="From which city you are?"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>State</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.state"
                        placeholder="What is your state?"
                      />
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>ZipCode</label>
                      <input
                        type="text"
                        class="form-control"
                        v-model="userProfile.zipcode"
                        placeholder="Enter your zip/postal code"
                      />
                    </div>
                  </div>
                  <div class="row">
                    <div class="single-input col-md-6 mb-15">
                      <label>Address1</label>
                      <textarea
                        v-model="userProfile.address1"
                        placeholder="What is your address?"
                        name=""
                        id=""
                        rows="4"
                      ></textarea>
                    </div>
                    <div class="single-input col-md-6 mb-15">
                      <label>Address2</label>
                      <textarea
                        v-model="userProfile.address2"
                        placeholder="What is your 2nd address?"
                        name=""
                        id=""
                        rows="4"
                      ></textarea>
                    </div>
                  </div>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
            <div class="col-md-6 singel-input offset-md-3 mt-30">
              <button
                class="btn btn-primary btn-hover-secondary btn-width-100"
                :disabled="loading"
                @click="updateUser"
              >
                <span
                  v-show="loading"
                  class="spinner-border spinner-border-sm"
                ></span>
                <span>Save Changes</span>
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import authHeader from '../services/auth-header';
import UserService from '../services/user.service';

import Vue from 'vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

Vue.component('font-awesome-icon', FontAwesomeIcon);

export default {
  data() {
    return {
      panel: [0],
      user: '',
      userProfile: '',
      previewImage: null,
      file: null,
      image: null,
      imageUrl: null,
      imageploaded: 'false',
      message: '',
      loading: false,
      dismissSecs: 5,
      dismissCountDown: 0,
      contentLoading: true,
      //showDismissibleAlert: false
    };
  },
  name: 'clientprofile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },

    getfullname() {
      if (this.user.firstname == null && this.user.lastname == null) {
        return '';
      } else {
        return this.user.firstname + ' ' + this.user.lastname;
      }
    },
  },
  async mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    await this.getClientProfile(this.$store.state.auth.user.id);

    //Display values in form textbox from the user in current local state of the browser
    //this.user = this.$store.state.auth.user;
    // this.currentClientProfile();
  },

  methods: {
    addphoto() {
      this.onUpload();
    },
    updateUser() {
      this.loading = true;
      //this.onUpload();
      UserService.putUpdatedUser(this.userProfile).then(
        (response) => {
          this.content = response.data;
          setTimeout(() => {
            this.loading = false;
            this.showAlert();
          }, 2000);
          this.onUpload();
        },
        (error) => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      );
    },

    async getClientProfile(id) {
      console.log('Client id is ' + id);
      await UserService.getClientProfileById(id).then(
        (response) => {
          this.userProfile = response.data;
          this.imageUrl = 'data:image/png;base64,';
          if (this.userProfile.profpic !== null) {
            this.imageploaded = 'true';
          }
          this.contentLoading = false;
          setTimeout(() => {
            this.loading = false;
            this.showAlert();
          }, 2000);
        },
        (error) => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
          this.contentLoading = false;
        }
      );
    },

    onUpload() {
      if (this.file != null) {
        const reader = new FileReader();
        reader.readAsDataURL(this.file);
        reader.onload = (e) => {
          this.image = e.target.result;
          console.log(this.image);
        };
        let formData = new FormData();
        formData.append('file', this.file);
        axios
          .post(
            'http://localhost:9090/api/test/users/uploadimage/' +
              this.userProfile.id,
            formData,
            { headers: authHeader() }
          )
          .then((response) => {
            console.log('uploaded the image');
            this.content = response.data;
            this.imageploaded = 'true';
            console.log('this.imageploaded' + this.imageploaded);
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },

    countDownChanged(dismissCountDown) {
      this.dismissCountDown = dismissCountDown;
    },
    showAlert() {
      this.dismissCountDown = this.dismissSecs;
    },
  },
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
.panel-header {
  font-size: 20px;
  text-align: left;
}
</style>

<style scoped type="text/css">
.fileInput {
  width: 150px;
}
.list-group-item {
  border-left: 4px solid #20ad96;
}
</style>
