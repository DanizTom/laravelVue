<template>
  <v-app>
    <v-row class="fill-height">
      <v-col>
        <h4 class="mt-3 ml-3">Calender of</h4>
        <v-sheet height="64">
          <v-toolbar flat color="white">
            <button
              @click.stop="dialog = true"
              class="btn btn-primary btn-hover-secondary"
            >
              New Event
            </button>
            <button
              @click.stop="dialog = true"
              class="btn btn-primary btn-hover-secondary ml-4"
              @click="setToday"
            >
              Today
            </button>
            <v-btn fab text small @click="prev">
              <v-icon small>mdi-chevron-left</v-icon>
            </v-btn>
            <v-btn fab text small @click="next">
              <v-icon small>mdi-chevron-right</v-icon>
            </v-btn>
            <v-toolbar-title>{{ title }}</v-toolbar-title>
            <div class="flex-grow-1"></div>
            <v-menu bottom right>
              <template v-slot:activator="{ on }">
                <v-btn outlined v-on="on">
                  <span>{{ typeToLabel[type] }}</span>
                  <v-icon right>mdi-menu-down</v-icon>
                </v-btn>
              </template>
              <v-list>
                <v-list-item @click="type = 'day'">
                  <v-list-item-title>Day</v-list-item-title>
                </v-list-item>
                <v-list-item @click="type = 'week'">
                  <v-list-item-title>Week</v-list-item-title>
                </v-list-item>
                <v-list-item @click="type = 'month'">
                  <v-list-item-title>Month</v-list-item-title>
                </v-list-item>
                <v-list-item @click="type = '4day'">
                  <v-list-item-title>4 days</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </v-toolbar>
        </v-sheet>

        <v-dialog v-model="dialog" max-width="500">
          <v-card>
            <v-container>
              <v-form @submit.prevent="addEvent">
                <v-text-field
                  filled
                  v-model="name"
                  type="text"
                  label="event name (required)"
                ></v-text-field>
                <v-text-field
                  v-model="details"
                  type="text"
                  label="detail"
                ></v-text-field>
                <v-text-field
                  v-model="start"
                  type="date"
                  label="start (required)"
                ></v-text-field>
                <v-text-field
                  v-model="end"
                  type="date"
                  label="end (required)"
                ></v-text-field>
                <v-text-field
                  v-model="color"
                  type="color"
                  label="color (click to open color menu)"
                ></v-text-field>
                <button
                  @click.stop="dialog = true"
                  class="btn btn-primary btn-hover-secondary"
                >
                  Create Event
                </button>
              </v-form>
            </v-container>
          </v-card>
        </v-dialog>

        <v-dialog v-model="dialogDate" max-width="500">
          <v-card>
            <v-container>
              <v-form @submit.prevent="addEvent">
                <v-text-field
                  v-model="name"
                  type="text"
                  label="event name (required)"
                ></v-text-field>
                <v-text-field
                  v-model="details"
                  type="text"
                  label="detail"
                ></v-text-field>
                <v-text-field
                  v-model="start"
                  type="date"
                  label="start (required)"
                ></v-text-field>
                <v-text-field
                  v-model="starttime"
                  type="time"
                  label="starttime (required)"
                ></v-text-field>
                <v-text-field
                  v-model="end"
                  type="date"
                  label="end (required)"
                ></v-text-field>
                <v-text-field
                  v-model="endtime"
                  type="time"
                  label="endtime (required)"
                ></v-text-field>
                <v-text-field
                  v-model="color"
                  type="color"
                  label="color (click to open color menu)"
                ></v-text-field>
                <button
                  type="submit"
                  @click.stop="dialog = false"
                  class="btn btn-primary btn-hover-secondary mr-4"
                >
                  Create Event
                </button>
              </v-form>
            </v-container>
          </v-card>
        </v-dialog>

        <v-sheet height="600" class="px-5 mx-5">
          <v-calendar
            ref="calendar"
            v-model="focus"
            color="activeDate"
            :events="events"
            :event-color="getEventColor"
            :event-margin-bottom="3"
            :now="today"
            :type="type"
            @click:event="showEvent"
            @click:more="viewDay"
            @click:date="setDialogDate"
            @change="updateRange"
          ></v-calendar>
          <v-menu
            v-model="selectedOpen"
            :close-on-content-click="false"
            :activator="selectedElement"
            full-width
            offset-x
          >
            <v-card color="grey lighten-4" :width="350" flat>
              <v-toolbar :color="selectedEvent.color" dark>
                <v-btn @click="deleteEvent(selectedEvent.id)" icon>
                  <v-icon>mdi-delete</v-icon>
                </v-btn>
                <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
                <div class="flex-grow-1"></div>
              </v-toolbar>

              <v-card-text>
                <form v-if="currentlyEditing !== selectedEvent.id">
                  {{ selectedEvent.details }}
                </form>
                <form v-else>
                  <textarea-autosize
                    v-model="selectedEvent.details"
                    type="text"
                    style="width: 100%"
                    :min-height="100"
                    placeholder="add note"
                  >
                  </textarea-autosize>
                </form>
              </v-card-text>

              <v-card-actions>
                <v-btn text color="secondary" @click="selectedOpen = false">
                  close
                </v-btn>
                <v-btn
                  v-if="currentlyEditing !== selectedEvent.id"
                  text
                  @click.prevent="editEvent(selectedEvent)"
                >
                  edit
                </v-btn>
                <v-btn
                  text
                  v-else
                  type="submit"
                  @click.prevent="updateEvent(selectedEvent)"
                >
                  Save
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-menu>
        </v-sheet>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
///Refrence: https://github.com/jsfanatik/vuestacks-calendar-vue-firebase/blob/master/src/components/Calendar.vue
import { db } from '../main';
import UserService from '../services/user.service';
import authHeader from '../services/auth-header';
export default {
  name: 'coachcalendar',
  data: () => ({
    today: new Date().toISOString().substr(0, 10),
    focus: new Date().toISOString().substr(0, 10),
    type: 'month',
    // type: 'day',
    typeToLabel: {
      month: 'Month',
      week: 'Week',
      day: 'Day',
      '4day': '4 Days',
    },
    id: null,
    name: null,
    details: null,
    start: null,
    end: null,
    starttime: null,
    endtime: null,
    color: '#1976D2', // default event color
    currentlyEditing: null,
    selectedEvent: {},
    selectedElement: null,
    selectedOpen: false,
    events: [],
    dialog: false,
    dialogDate: false,
    coachid: '',
    user: '',
    clientemailid: '',
    clientname: '',
    coach: '',
    coachemailid: '',
  }),
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
    this.getEvents();
    this.coachid = this.$route.params.id;
    console.log('coach Id to whom calendar belongs: ' + this.coachid);

    //client properties needed for sending email
    this.user = this.$store.state.auth.user;
    console.log('client  id is ' + this.user.id);
    this.clientemailid = this.user.email;
    this.clientname = this.user.firstname + ' ' + this.user.lastname;
    console.log('clientemailid is ' + this.clientemailid);

    //get Coach properties
    UserService.getUserbyId(this.$route.params.id)
      .then((response) => {
        console.log(response.data);
        this.coach = response.data;
        console.log('Coach properties are :' + this.coach);
        this.coachemailid = this.coach.email;
        console.log('Coach email is ' + this.coachemailid);
      })
      .catch((e) => {
        this.errors.push(e);
      });
  },
  computed: {
    currentUser() {
      console.log('User is ' + this.$store.state.auth.user);
      return this.$store.state.auth.user;
    },

    title() {
      const { start, end } = this;
      if (!start || !end) {
        return '';
      }
      const startMonth = this.monthFormatter(start);
      const endMonth = this.monthFormatter(end);
      const suffixMonth = startMonth === endMonth ? '' : endMonth;
      const startYear = start.year;
      const endYear = end.year;
      const suffixYear = startYear === endYear ? '' : endYear;
      const startDay = start.day + this.nth(start.day);
      const endDay = end.day + this.nth(end.day);

      switch (this.type) {
        case 'month':
          return `${startMonth} ${startYear}`;
        case 'week':
        case '4day':
          return `${startMonth} ${startDay} ${startYear} - ${suffixMonth} ${endDay} ${suffixYear}`;
        case 'day':
          return `${startMonth} ${startDay} ${startYear}`;
      }
      return '';
    },
    monthFormatter() {
      return this.$refs.calendar.getFormatter({
        timeZone: 'UTC',
        month: 'long',
      });
    },
  },
  methods: {
    async getEvents() {
      let snapshot = await db.collection('calEvent').get(this.coachid);
      console.log('snapshot length is ' + snapshot.docs.length);
      const events = [];
      snapshot.forEach((doc) => {
        let appData = doc.data();
        console.log(doc.data());
        appData.id = doc.id;
        if (doc.data().id == this.coachid) {
          console.log('appData  is ' + appData);
          events.push(appData);
        }
      });
      this.events = events;
    },
    setDialogDate({ date }) {
      this.dialogDate = true;
      this.focus = date;
    },
    viewDay({ date }) {
      this.focus = date;
      this.type = 'day';
    },
    getEventColor(event) {
      return event.color;
    },
    setToday() {
      this.focus = this.today;
    },
    prev() {
      this.$refs.calendar.prev();
    },
    next() {
      this.$refs.calendar.next();
    },
    async addEvent() {
      if (this.name && this.start && this.end) {
        await db.collection('calEvent').add({
          id: this.coachid,
          name: this.name,
          details: this.details,
          start: this.start + ' ' + this.starttime,
          end: this.end + ' ' + this.endtime,
          color: this.color,
        });
        await Promise.all([this.getEvents(), setTimeout(50000)]);
        // this.getEvents();
        (this.name = ''),
          (this.details = ''),
          (this.start = ''),
          (this.end = ''),
          (this.starttime = ''),
          (this.endtime = ''),
          (this.color = '');
      } else {
        alert('You must enter event name, start, and end time');
      }
      //send email to the coach
      let currentObj = this;
      //data to be used for sending email
      const data = {
        coachId: this.coachid,
        clientId: this.user.id,
        message: 'New Calender event created',
        fromEmailId: this.clientemailid,
        name: this.clientname,
        //toEmailId: this.coachemailid,
        toEmailId: 'pushirattan@gmail.com',
      };
      //send email to the coach about new calendar event
      UserService.sendEmail(data)
        .then(function (response) {
          currentObj.output = response.data;
        })
        .catch(function (error) {
          currentObj.output = error;
        });
    },
    editEvent(ev) {
      this.currentlyEditing = ev.id;
    },
    async updateEvent(ev) {
      await db.collection('calEvent').doc(this.currentlyEditing).update({
        details: ev.details,
      });
      (this.selectedOpen = false), (this.currentlyEditing = null);
    },
    async deleteEvent(ev) {
      await db.collection('calEvent').doc(ev).delete();
      (this.selectedOpen = false), this.getEvents();
    },
    showEvent({ nativeEvent, event }) {
      const open = () => {
        this.selectedEvent = event;
        this.selectedElement = nativeEvent.target;
        setTimeout(() => (this.selectedOpen = true), 10);
      };
      if (this.selectedOpen) {
        this.selectedOpen = false;
        setTimeout(open, 10);
      } else {
        open();
      }
      nativeEvent.stopPropagation();
    },
    updateRange({ start, end, starttime, endtime }) {
      this.start = start;
      this.end = end;
      this.starttime = starttime;
      this.endtime = endtime;
    },
    nth(d) {
      return d > 3 && d < 21
        ? 'th'
        : ['th', 'st', 'nd', 'rd', 'th', 'th', 'th', 'th', 'th', 'th'][d % 10];
    },
  },
};
</script>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
button {
  height: 40px !important;
}
</style>
