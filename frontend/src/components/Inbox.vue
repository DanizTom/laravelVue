<template>
  <div id="app">
    <v-app id="inspire">
      <link
        href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
        rel="stylesheet"
      />
      <div class="container">
        <div class="row">
          <!-- <a data-toggle="modal" data-target="#message-modal">asa</a> -->
          <div class="col-md-12">
            <div class="grid email">
              <div class="grid-body">
                <div class="row">
                  <!-- BEGIN INBOX MENU -->
                  <div class="col-md-3">
                    <h2 class="grid-title">
                      <i class="fa fa-inbox"></i> Inbox
                    </h2>
                    <a
                      class="btn btn-block btn-primary textWhite"
                      data-toggle="modal"
                      data-target="#compose-modal"
                      ><i class="fa fa-pencil"></i>&nbsp;&nbsp;NEW MESSAGE</a
                    >

                    <hr />

                    <div>
                      <ul class="nav nav-pills nav-stacked">
                        <li class="header">Folders</li>
                        <li class="active my-4">
                          <a href="#"
                            ><i class="fa fa-inbox ml-2"></i> Inbox (14)</a
                          >
                        </li>
                        <li class="my-4">
                          <a href="#"
                            ><i class="fa fa-mail-forward ml-2"></i> Sent</a
                          >
                        </li>
                      </ul>
                    </div>
                  </div>
                  <!-- END INBOX MENU -->

                  <!-- BEGIN INBOX CONTENT -->
                  <div class="col-md-9">
                    <!--<div class="row">
                      <div class="col-sm-6">
                        <label style="margin-right: 8px" class="">
                          <div
                            class="icheckbox_square-blue"
                            style="position: relative"
                          >
                            <input
                              type="checkbox"
                              id="check-all"
                              class="icheck"
                              style="
                                position: absolute;
                                top: -20%;
                                left: -20%;
                                display: block;
                                width: 140%;
                                height: 140%;
                                margin: 0px;
                                padding: 0px;
                                border: 0px;
                                opacity: 0;
                                background: rgb(255, 255, 255);
                              "
                            /><ins
                              class="iCheck-helper"
                              style="
                                position: absolute;
                                top: -20%;
                                left: -20%;
                                display: block;
                                width: 140%;
                                height: 140%;
                                margin: 0px;
                                padding: 0px;
                                border: 0px;
                                opacity: 0;
                                background: rgb(255, 255, 255);
                              "
                            ></ins>
                          </div>
                        </label>
                        <div class="btn-group">
                          <button
                            type="button"
                            class="btn btn-default dropdown-toggle"
                            data-toggle="dropdown"
                          >
                            Action <span class="caret"></span>
                          </button>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="#">Mark as read</a></li>
                            <li><a href="#">Mark as unread</a></li>
                            <li><a href="#">Mark as important</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Report spam</a></li>
                            <li><a href="#">Delete</a></li>
                          </ul>
                          <button v-on:click="sendMessage('hello')">
                            Send Message
                          </button>
                        </div>
                      </div>
                    </div>-->

                    <div class="padding"></div>

                    <div class="container">
                      <v-card>
                        <v-card-title>
                          Messages
                          <v-spacer></v-spacer>
                          <v-text-field
                            v-model="search"
                            label="Search"
                            single-line
                            hide-details
                          ></v-text-field
                          ><i class="fa fa-search"></i>
                        </v-card-title>
                        <v-data-table
                          :items-per-page="5"
                          :items="messages"
                          :search="search"
                          :loading="this.loading"
                          class="elevation-1"
                        >
                          <template v-slot:item="props">
                            <tr>
                              <td class="text-xs-left">
                                {{ props.item.subject }}
                              </td>
                              <td class="text-xs-left">
                                <!--<a
                                  data-toggle="modal"
                                  href="#message-modal"
                                  @click="openMessageDetailsModal(props.item)"
                                >
                                  <i class="fa fa-pencil"></i>&nbsp;&nbsp;{{
                                    props.item.message
                                  }}</a
                                >-->
                                <!--<b-button
                                  size="sm"
                                  v-b-modal="'myModal'"
                                  @click="sendInfo(props.item)"
                                >
                                  Saluta {{ props.item.fromemail }}
                                </b-button>-->
                                <a
                                  size="sm"
                                  v-b-modal="'myMessageModal'"
                                  @click="sendInfo(props.item)"
                                >
                                  <i class="fa fa-pencil"></i>&nbsp;&nbsp;{{
                                    props.item.message
                                  }}</a
                                >
                              </td>
                              <td class="text-xs-left">
                                {{ props.item.fromemail }}
                              </td>
                              <td class="text-xs-left">
                                {{ props.item.toemail }}
                              </td>
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
                  </div>
                  <!-- END INBOX CONTENT -->

                  <!--BEGIN MESSAGE DETAIL-->
                  <b-modal
                    id="myMessageModal"
                    tabindex="-1"
                    aria-hidden="false"
                    class="modal-wrapper"
                    size="lg"
                  >
                    <div>
                      <div>
                        <div class="modal-dialog" style="max-width: 400%">
                          <div class="modal-content">
                            <div
                              class="modal-header bg-blue arrange-horizontally"
                            >
                              <div
                                class="mail-view d-md-block col-md-12 bg-white"
                              >
                                <div class="row">
                                  <div class="col-md-14 mb-8 mt-4">
                                    <div class="btn-toolbar">
                                      <div class="btn-group">
                                        <button
                                          @click="openReplyPanel"
                                          type="button"
                                          class="btn btn-sm btn-outline-secondary"
                                          style="height: 25px"
                                        >
                                          <i
                                            class="mdi mdi-reply text-primary mr-1"
                                          ></i>
                                          Reply
                                        </button>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="message-body ml-4 mt-4">
                                  <div
                                    class="sender-details d-flex align-items-center"
                                  >
                                    <img
                                      class="img-sm rounded-circle mr-3"
                                      src="http://www.urbanui.com/dashflat/template/images/faces/face11.jpg"
                                      alt=""
                                    />
                                    <div class="details">
                                      <p class="msg-subject font-weight-bold">
                                        {{ modalMessageDetails.subject }}
                                      </p>
                                      <p class="sender-email">
                                        {{ modalMessageDetails.name }}
                                        <a
                                          href="#"
                                          class="text-primary font-weight-bold"
                                          >{{
                                            modalMessageDetails.fromemail
                                          }}</a
                                        >
                                        &nbsp;<i
                                          class="mdi mdi-account-multiple-plus"
                                        ></i>
                                      </p>
                                    </div>
                                  </div>
                                  <hr />
                                  <div class="message-content">
                                    <p>Hi Emily,</p>
                                    <p>
                                      Message is
                                      {{ modalMessageDetails.message }}
                                    </p>
                                  </div>
                                  <div
                                    v-if="!showReplyPanel"
                                    class="attachments-sections"
                                  >
                                    <!--<ul
                                      class="list-group ml-0 pl-0 list-group-flush"
                                    >
                                      <li class="list-group-item">
                                        <div class="thumb">
                                          <i class="mdi mdi-file-pdf"></i>
                                        </div>
                                        <div class="details">
                                          <p class="file-name">
                                            Seminar Reports.pdf
                                          </p>
                                          <div class="buttons">
                                            <p class="file-size">678Kb</p>
                                            <a
                                              href="#"
                                              class="view btn btn-outline-secondary mr-4"
                                              style="height: 25px"
                                              >View</a
                                            >
                                            <a
                                              href="#"
                                              class="view download btn btn-outline-primary"
                                              style="height: 25px"
                                              >Download</a
                                            >
                                          </div>
                                        </div>
                                      </li>
                                      <li class="list-group-item">
                                        <div class="thumb">
                                          <i class="mdi mdi-file-image"></i>
                                        </div>
                                        <div class="details">
                                          <p class="file-name">
                                            Product Design.jpg
                                          </p>
                                          <div class="buttons">
                                            <p class="file-size">1.96Mb</p>
                                            <a
                                              href="#"
                                              class="view btn btn-outline-secondary mr-4"
                                              style="height: 25px"
                                              >View</a
                                            >
                                            <a
                                              href="#"
                                              class="view download btn btn-outline-primary"
                                              style="height: 25px"
                                              >Download</a
                                            >
                                          </div>
                                        </div>
                                      </li>
                                    </ul>-->
                                  </div>

                                  <div class="mt-4" v-if="showReplyPanel">
                                    <hr />
                                    <form
                                      name="form"
                                      @submit.prevent="
                                        sendEmailReplyMessage(
                                          modalMessageDetails.subject,
                                          replymessage,
                                          modalMessageDetails.fromemail
                                        )
                                      "
                                      v-on:submit.prevent
                                    >
                                      <b-card>
                                        <div
                                          class="d-flex justify-space-between align-items-top"
                                        >
                                          <div class="mb-4">
                                            <div class="mb-4">
                                              <i
                                                class="mdi mdi-reply text-primary mr-1"
                                              ></i>
                                              Reply to
                                              <span
                                                class="bg-primary text-white rounded px-3 py-1"
                                                >{{
                                                  modalMessageDetails.fromemail
                                                }}</span
                                              >
                                            </div>
                                            <div class="ml-3 mt-6">
                                              <div class="form-group d-flex">
                                                <span class="mr-3"
                                                  >Subject</span
                                                >
                                                <input
                                                  type="text"
                                                  v-model="
                                                    modalMessageDetails.subject
                                                  "
                                                  name="subject"
                                                  class="subject"
                                                  placeholder="subject"
                                                  style="height: 30px"
                                                  disabled
                                                />
                                              </div>
                                            </div>
                                          </div>

                                          <div class="text-right">
                                            <button
                                              type="button"
                                              class="btn btn-sm btn-outline-primary"
                                              style="height: 25px"
                                              @click="showReplyPanel = false"
                                            >
                                              ×
                                            </button>
                                          </div>
                                        </div>
                                        <textarea
                                          name=""
                                          id=""
                                          cols="30"
                                          rows="6"
                                          v-model="replymessage"
                                        ></textarea>
                                        <div class="mt-4 mb-6">
                                          <div class="text-primary">
                                            Attachment
                                          </div>
                                          <input
                                            type="file"
                                            placeholder="Attachment"
                                            @change="uploadFile"
                                            ref="file"
                                          />
                                        </div>
                                        <div
                                          class="mt-4 d-flex justify-content-end"
                                        >
                                          <button
                                            @click="showReplyPanel = false"
                                            class="btn btn-outline-secondary mr-4"
                                          >
                                            Cancel
                                          </button>
                                          <button
                                            class="btn btn-primary pull-right textWhite"
                                            :disabled="loading"
                                          >
                                            <span
                                              v-show="loading"
                                              class="spinner-border spinner-border-sm"
                                            ></span>
                                            <span>Send</span>
                                          </button>
                                        </div>
                                      </b-card>
                                    </form>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </b-modal>
                  <!--END MESSAGE DETAIL-->

                  <!-- BEGIN COMPOSE MESSAGE -->
                  <div
                    class="modal fade"
                    id="compose-modal"
                    tabindex="-1"
                    role="dialog"
                    aria-hidden="true"
                  >
                    <div class="modal-wrapper">
                      <div class="modal-dialog">
                        <div class="modal-content">
                          <div
                            class="modal-header bg-blue arrange-horizontally"
                          >
                            <button
                              type="button"
                              class="close"
                              data-dismiss="modal"
                              aria-hidden="true"
                            >
                              ×
                            </button>
                            <h4 class="modal-title">
                              <i class="fa fa-envelope"></i> Compose New Message
                            </h4>
                          </div>
                          <form name="form" @submit="sendEmailMessage">
                            <div class="modal-body">
                              <div class="form-group">
                                <input
                                  type="email"
                                  v-model="email"
                                  name="email"
                                  placeholder="To"
                                  class="mb-4"
                                />
                              </div>
                              <div class="form-group">
                                <input
                                  type="text"
                                  v-model="subject"
                                  name="subject"
                                  placeholder="Subject"
                                />
                              </div>
                              <div class="form-group">
                                <textarea
                                  name="message"
                                  v-model="message"
                                  cols="30"
                                  rows="5"
                                  placeholder="Message"
                                  class="mb-4"
                                ></textarea>
                              </div>
                              <!--<div class="form-group">
                                <input type="file" name="attachment" />
                              </div>-->
                              <v-file-input
                                accept="*/*"
                                prepend-icon="mdi-link"
                                label="Attach File"
                                v-model="file"
                                @load="onFileUpload"
                              ></v-file-input>
                            </div>
                            <div class="modal-footer">
                              <button
                                type="button"
                                class="btn btn-secondary"
                                data-dismiss="modal"
                              >
                                Discard
                              </button>
                              <div class="form-group">
                                <button
                                  class="btn btn-primary pull-right textWhite"
                                  :disabled="loading"
                                >
                                  <span
                                    v-show="loading"
                                    class="spinner-border spinner-border-sm"
                                  ></span>
                                  <span>Send</span>
                                </button>
                              </div>
                            </div>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- END COMPOSE MESSAGE -->
                </div>
              </div>
            </div>
          </div>
          <!-- END INBOX -->
        </div>
      </div>
      <!-- websocket implemenation-->
      <!--<div class="col-md-6">
        <form class="form-inline">
          <div class="form-group">
            <label for="connect">WebSocket connection:</label>
            <button
              id="connect"
              class="btn btn-default"
              type="submit"
              :disabled="connected == true"
              @click.prevent="connect"
            >
              Connect
            </button>
            <button
              id="disconnect"
              class="btn btn-default"
              type="submit"
              :disabled="connected == false"
              @click.prevent="disconnect"
            >
              Disconnect
            </button>
          </div>
        </form>
        <div class="col-md-6">
          <form class="form-inline">
            <div class="form-group">
              <label for="name">What is your name?</label>
              <input
                type="text"
                id="name"
                class="form-control"
                v-model="send_message"
                placeholder="Your name here..."
              />
            </div>
            <button
              id="send"
              class="btn btn-default"
              type="submit"
              @click.prevent="send"
            >
              Send
            </button>
          </form>
        </div>
        <div class="row">
          <div class="col-md-12">
            <table id="conversation" class="table table-striped">
              <thead>
                <tr>
                  <th>Greetings</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="item in received_messages" :key="item">
                  <td>{{ item }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>-->
      <!-- websocket implemenation-->
    </v-app>
  </div>
</template>

<script>
import UserService from '../services/user.service';
import authHeader from '../services/auth-header';
import axios from 'axios';
export default {
  name: 'inbox',
  data: () => ({
    messages: [],
    id: '',
    user: '',
    search: '',
    loading: false,
    interval: null,
    //message attributes
    email: '',
    file: null,
    filedata: null,
    dismissSecs: 5,
    dismissCountDown: 0,
    showReplyPanel: false,
    replayText: '',
    replayFiles: null,
    active: false,
    dialogsubject: '',
    dialogmessage: '',
    dialogfromemail: '',
    dialogtoemail: '',
    modalMessageDetails: '',
    replymessage: '',
  }),
  beforeDestroy() {
    clearInterval(this.interval);
  },
  created() {
    this.user = this.$store.state.auth.user;
    if (this.loggedIn) {
      this.interval = setInterval(
        () =>
          UserService.getAllInboxMessagesById(
            this.user.usertype,
            this.user.id
          ).then(
            (response) => {
              this.messages = response.data;
              //this.loading = false;
              console.log(response.data);
            },
            (error) => {
              this.content =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          ),
        60000
      );
    }
  },
  mounted() {
    if (!this.user) {
      this.$router.push('/login');
    }
    this.user = this.$store.state.auth.user;
    console.log('Logged in user id is ' + this.user.id);

    if (this.loggedIn) {
      this.loading = true;
      UserService.getAllInboxMessagesById(
        this.user.usertype,
        this.user.id
      ).then(
        (response) => {
          this.messages = response.data;
          this.loading = false;
          console.log(response.data);
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

  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
    currentUser() {
      console.log('User is ' + this.$store.state.auth.user);
      return this.$store.state.auth.user;
    },
  },
  methods: {
    getEmailMessage() {
      UserService.getAllInboxMessagesById(
        this.user.usertype,
        this.user.id
      ).then(
        (response) => {
          this.messages = response.data;
          console.log(response.data);
        },
        (error) => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.toString();
        }
      );
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
      const id = this.user.id;
      formData.append('file', this.file);
      formData.append('id', id);
      formData.append('userType', this.user.usertype);
      formData.append('subject', this.subject);
      formData.append('message', this.message);
      formData.append('fromEmailId', this.user.email);
      formData.append('toEmailId', this.email);
      return formData;
    },

    sendEmailMessage(e) {
      e.preventDefault();
      var formDataFetched = this.gatherFormData();
      formDataFetched.forEach((el) => console.log(el));
      this.loading = true;
      axios
        .post(
          'http://localhost:9090/api/test/users/sendinboxemail',
          formDataFetched,
          { headers: authHeader() }
        )
        .then((response) => {
          console.log('uploaded the file response' + response);
        })
        .catch((e) => {
          console.log(e);
        })
        .finally(() => {
          this.loading = false;
          this.email = '';
          this.subject = '';
          this.message = '';
        });
    },

    gatherEmailReplyFormData(replysubject, replymessage, replytoemail) {
      const formData = new FormData();
      const id = this.user.id;
      formData.append('file', this.file);
      formData.append('id', id);
      formData.append('userType', this.user.usertype);
      formData.append('subject', replysubject);
      formData.append('message', replymessage);
      formData.append('fromEmailId', this.user.email);
      formData.append('toEmailId', replytoemail);
      return formData;
    },

    sendEmailReplyMessage(replysubject, replymessage, replytoemail) {
      this.showReplyPanel = false;
      //e.preventDefault();
      var formDataFetched = this.gatherEmailReplyFormData(
        replysubject,
        replymessage,
        replytoemail
      );
      formDataFetched.forEach((el) => console.log(el));
      this.loading = true;
      axios
        .post(
          'http://localhost:9090/api/test/users/sendinboxemail',
          formDataFetched,
          { headers: authHeader() }
        )
        .then((response) => {
          console.log('uploaded the file response' + response);
          this.replymessage = '';
        })
        .catch((e) => {
          console.log(e);
        })
        .finally(() => {
          this.loading = false;
        });
    },

    openReplyPanel() {
      this.showReplyPanel = true;
    },

    /*async sendReplay() {
      alert(this.replayText);
      this.replayText = '';
      this.showReplyPanel = false;
    },*/

    sendInfo(item) {
      this.modalMessageDetails = item;
      console.log('###this.modalMessageDetails##' + this.modalMessageDetails);
    },

    openMessageDetailsModal(properties) {
      console.log('message is ' + properties);
      this.active = true;
      console.log('active is ' + this.active);
      //this.dialogsubject = properties.subject;
      this.dialogmessage = properties;
      //this.dialogfromemail = properties.fromeail;
      //this.dialogtoemail = properties.toemail;
    },

    closeMessageDetailsModal() {
      this.active = false;
    },

    /* created: function () {
      console.log('Starting connection to WebSocket Server');
      this.connection = new WebSocket('ws://localhost:9090/api/web-socket');
      this.connection.onmessage = function (event) {
        console.log(event);
      };

      this.connection.onopen = function (event) {
        console.log(event);
        console.log('Successfully connected to the echo websocket server...');
      };
    },*/
    uploadFile() {
      this.replayFiles = this.$refs.file.files[0];
    },
    submitFile() {
      const formData = new FormData();
      formData.append('file', this.replayFiles);
      // const headers = { 'Content-Type': 'multipart/form-data' };
      // axios.post('https://httpbin.org/post', formData, { headers }).then((res) => {
      //   res.data.files; // binary representation of the file
      //   res.status; // HTTP status
      // });
    },
  },
};
</script>

<style scoped>
.subject {
  min-height: 35px !important;
}
body {
  margin-top: 20px;
  background: #eee;
}
/* EMAIL */
.email {
  padding: 20px 10px 15px 10px;
  font-size: 1em;
}

.email .btn.search {
  font-size: 0.9em;
}

.email h2 {
  margin-top: 0;
  padding-bottom: 8px;
}

.email .nav.nav-pills > li > a {
  border-top: 3px solid transparent;
}

.email .nav.nav-pills > li > a > .fa {
  margin-right: 5px;
}

.email .nav.nav-pills > li.active > a,
.email .nav.nav-pills > li.active > a:hover {
  background-color: #f6f6f6;
  border-top-color: #3c8dbc;
}

.email .nav.nav-pills > li.active > a {
  font-weight: 600;
}

.email .nav.nav-pills > li > a:hover {
  background-color: #f6f6f6;
}

.email .nav.nav-pills.nav-stacked > li > a {
  color: #666;
  border-top: 0;
  border-left: 3px solid transparent;
  border-radius: 0px;
}

.email .nav.nav-pills.nav-stacked > li.active > a,
.email .nav.nav-pills.nav-stacked > li.active > a:hover {
  background-color: #f6f6f6;
  border-left-color: #3c8dbc;
  color: #444;
}

.email .nav.nav-pills.nav-stacked > li.header {
  color: #777;
  text-transform: uppercase;
  position: relative;
  padding: 0px 0 10px 0;
}

.email table {
  font-weight: 600;
}

.email table a {
  color: #666;
}

.email table tr.read > td {
  background-color: #f6f6f6;
}

.email table tr.read > td {
  font-weight: 400;
}

.email table tr td > i.fa {
  font-size: 1.2em;
  line-height: 1.5em;
  text-align: center;
}

.email table tr td > i.fa-star {
  color: #f39c12;
}

.email table tr td > i.fa-bookmark {
  color: #e74c3c;
}

.email table tr > td.action {
  padding-left: 0px;
  padding-right: 2px;
}

.grid {
  position: relative;
  width: 100%;
  background: #fff;
  color: #666666;
  border-radius: 2px;
  margin-bottom: 25px;
  box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.1);
}

.grid .grid-header:after {
  clear: both;
}

.grid .grid-header span,
.grid .grid-header > .fa {
  display: inline-block;
  margin: 0;
  font-weight: 300;
  font-size: 1.5em;
  float: left;
}

.grid .grid-header span {
  padding: 0 5px;
}

.grid .grid-header > .fa {
  padding: 5px 10px 0 0;
}

.grid .grid-header > .grid-tools {
  padding: 4px 10px;
}

.grid .grid-header > .grid-tools a {
  color: #999999;
  padding-left: 10px;
  cursor: pointer;
}

.grid .grid-header > .grid-tools a:hover {
  color: #666666;
}

.grid .grid-body {
  padding: 15px 20px 15px 20px;
  font-size: 0.9em;
  line-height: 1.9em;
}

.grid .full {
  padding: 0 !important;
}

.grid .transparent {
  box-shadow: none !important;
  margin: 0px !important;
  border-radius: 0px !important;
}

.grid.top.black > .grid-header {
  border-top-color: #000000 !important;
}

.grid.bottom.black > .grid-body {
  border-bottom-color: #000000 !important;
}

.grid.top.blue > .grid-header {
  border-top-color: #007be9 !important;
}

.grid.bottom.blue > .grid-body {
  border-bottom-color: #007be9 !important;
}

.grid.top.green > .grid-header {
  border-top-color: #00c273 !important;
}

.grid.bottom.green > .grid-body {
  border-bottom-color: #00c273 !important;
}

.grid.top.purple > .grid-header {
  border-top-color: #a700d3 !important;
}

.grid.bottom.purple > .grid-body {
  border-bottom-color: #a700d3 !important;
}

.grid.top.red > .grid-header {
  border-top-color: #dc1200 !important;
}

.grid.bottom.red > .grid-body {
  border-bottom-color: #dc1200 !important;
}

.grid.top.orange > .grid-header {
  border-top-color: #f46100 !important;
}

.grid.bottom.orange > .grid-body {
  border-bottom-color: #f46100 !important;
}

.grid.no-border > .grid-header {
  border-bottom: 0px !important;
}

.grid.top > .grid-header {
  border-top-width: 4px !important;
  border-top-style: solid !important;
}

.grid.bottom > .grid-body {
  border-bottom-width: 4px !important;
  border-bottom-style: solid !important;
}
.nav {
  margin: 0 0 5px 0;
  padding: 20px;
  display: block;
}
.arrange-horizontally {
  display: table-cell;
}
.textWhite {
  color: #fff;
}
button {
  height: 30px !important;
}
</style>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
</style>
