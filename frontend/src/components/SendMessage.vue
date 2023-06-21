<template>
  <div class="container">
    <div class="message">
      <h4 class="my-4">Send your message</h4>
      <form name="form" @submit.prevent="sendEmailMessage" v-on:submit.prevent>
        <b-alert
          :show="dismissCountDown"
          dismissible
          fade
          variant="success"
          @dismiss-count-down="countDownChanged"
        >
          Email sent Successfully
        </b-alert>
        <label>Name</label>
        <input
          class="mb-4"
          type="text"
          v-model="name"
          name="name"
          placeholder="Your Name"
        />
        <label>Email</label>
        <input
          type="email"
          v-model="clientemailid"
          :disabled="true"
          name="email"
          placeholder="Your Email"
          class="mb-4"
        />
        <label>Message</label>
        <textarea
          name="message"
          v-model="message"
          cols="30"
          rows="5"
          placeholder="Message"
          class="mb-4"
        >
        </textarea>
        <label>Subject</label>
        <input
          type="text"
          v-model="subject"
          name="subject"
          placeholder="Subject"
        />

        <!--<input
        Email sent Successfully
      </b-alert>
      <label>Name</label>
      <input type="text" v-model="name" name="name" placeholder="Your Name" />
      <label>Email</label>
      <input
        type="email"
        v-model="email"
        name="email"
        placeholder="Your Email"
      />
      <label>Subject</label>
      <input
        type="text"
        v-model="subject"
        name="subject"
        placeholder="Subject"
      />

      <label>Message</label>
      <textarea
        name="message"
        v-model="message"
        cols="30"
        rows="5"
        placeholder="Message"
      >
      </textarea>

     <input
        type="file"
        @change="onFileUpload"
        name="file"
        placeholder="Atatch File"
      />-->

        <v-file-input
          accept="*/*"
          prepend-icon="mdi-link"
          label="Attach File"
          v-model="file"
          @load="onFileUpload"
        ></v-file-input>

        <!-- <input type="submit" value="Send" />-->
        <div class="form-group">
          <button class="btn btn-primary btn-block mb-4" :disabled="loading">
            <span
              v-show="loading"
              class="spinner-border spinner-border-sm"
            ></span>
            <span>Send</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import authHeader from '../services/auth-header';
import UserService from '../services/user.service';
import axios from 'axios';
// import Stomp from 'webstomp-client';
//import NodeMailerService from '../services/nodemailer.service';
export default {
  name: 'sendmessage',
  data() {
    return {
      user: '',
      subject: '',
      message: '',
      name: '',
      email: '',
      coach: '',
      coachid: '',
      coachemailid: '',
      clientemailid: '',
      file: null,
      filedata: null,
      dismissSecs: 5,
      dismissCountDown: 0,
      loading: false,
    };
  },
  computed: {
    currentUser() {
      console.log('User is ' + this.$store.state.auth.user);
      return this.$store.state.auth.user;
    },
  },

  mounted: function () {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    //current logged-in client properties
    this.user = this.$store.state.auth.user;
    console.log('client  id is ' + this.user.id);
    this.clientemailid = this.user.email;
    console.log('clientemailid is ' + this.clientemailid);

    //get Coach properties
    UserService.getUserbyId(this.$route.params.id)
      .then((response) => {
        // JSON responses are automatically parsed.
        console.log(response.data);
        this.coach = response.data;
        console.log('Coach properties are :' + this.coach);
        this.coachid = this.coach.id;
        this.coachemailid = this.coach.email;
        console.log('Coach id is ' + this.coachid);
        console.log('Coach email is ' + this.coachemailid);
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
  methods: {
    sendEmailMessage_OLD(e) {
      e.preventDefault();
      let currentObj = this;
      this.loading = true;
      const clientid = this.user.id;
      const data = {
        coachId: this.coachid,
        clientId: clientid,
        subject: this.subject,
        message: this.message,
        name: this.name,
        fromEmailId: this.clientemailid,
        toEmailId: this.coachemailid,
      };
      UserService.sendEmail(data)
        .then(function (response) {
          currentObj.output = response.data;
        })
        .catch(function (error) {
          this.loading = false;
          currentObj.output = error;
        });
      setTimeout(() => {
        this.loading = false;
        this.showAlert();
      }, 2000);
      //NodeMailerService.sendMessage();
    },

    onFileUpload() {
      if (this.file != null) {
        const reader = new FileReader();
        reader.readAsDataURL(this.file);
        reader.onload = (e) => {
          this.file = e.target.result;
          console.log(this.file);
        };
      }
    },

    gatherFormData() {
      const formData = new FormData();
      const clientId = this.user.id;
      formData.append('file', this.file);
      formData.append('coachId', this.coachid);
      formData.append('clientId', clientId);
      formData.append('subject', this.subject);
      formData.append('message', this.message);
      formData.append('name', this.name);
      formData.append('fromEmailId', this.clientemailid);
      formData.append('toEmailId', this.coachemailid);
      return formData;
    },

    sendEmailMessage(e) {
      e.preventDefault();
      var formDataFetched = this.gatherFormData();
      formDataFetched.forEach((el) => console.log(el));
      axios
        .post(
          'http://localhost:9090/api/test/users/sendemail',
          formDataFetched,
          { headers: authHeader() }
        )
        .then((response) => {
          console.log('uploaded the file response' + response);
        })
        .catch((e) => {
          console.log(e);
        });
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

<style scoped></style>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
.message {
  width: 100%;
  max-width: 600px;
  margin: auto;
}
</style>
