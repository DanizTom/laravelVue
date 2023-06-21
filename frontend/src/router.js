import Vue from 'vue';
import Router from 'vue-router';
//import Home from './views/Home.vue';
//import Login from './views/Login.vue';
//import Register from './views/Register.vue';

Vue.use(Router);
//const sendmessage = () => import('./components/SendMessage.vue');
export const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      // component: Home,
      component: () => import('./views/Home.vue'),
    },
    {
      path: '/home',
      //component: Home,
      component: () => import('./views/Home.vue'),
    },
    {
      path: '/login',
      //component: Login,
      component: () => import('./views/Login.vue'),
    },
    {
      path: '/register',
      //component: Register,
      component: () => import('./views/Register.vue'),
    },
    {
      path: '/profile',
      name: 'profile',
      // lazy-loaded
      component: () => import('./views/Profile.vue'),
    },
    {
      path: '/coachprofile',
      name: 'coachprofile',
      // lazy-loaded
      component: () => import('./views/CoachProfile.vue'),
    },
    {
      path: '/clientprofile',
      name: 'clientprofile',
      // lazy-loaded
      component: () => import('./views/ClientProfile.vue'),
    },
    {
      path: '/coachpublicprofile/:id',
      name: 'coachpublicprofile',
      //component: CoachPublicProfile,
      component: () => import('./views/CoachPublicProfile.vue'),
    },
    {
      path: '/clientpublicprofile/:id',
      name: 'clientpublicprofile',
      //component: ClientPublicProfile,
      component: () => import('./views/ClientPublicProfile.vue'),
    },
    {
      path: '/admin',
      name: 'admin',
      // lazy-loaded
      component: () => import('./views/BoardAdmin.vue'),
    },
    {
      path: '/mod',
      name: 'moderator',
      // lazy-loaded
      component: () => import('./views/BoardModerator.vue'),
    },
    {
      path: '/user',
      name: 'user',
      // lazy-loaded
      component: () => import('./views/BoardUser.vue'),
    },
    {
      path: '/clientdashboard',
      name: 'clientdashboard',
      // lazy-loaded
      component: () => import('./views/BoardClientDashboard.vue'),
    },
    {
      path: '/coachdashboard',
      name: 'coachdashboard',
      // lazy-loaded
      component: () => import('./views/BoardCoachDashboard.vue'),
    },
    {
      path: '/forgotpassword',
      name: 'forgotpassword',
      // lazy-loaded
      component: () => import('./views/ForgotPassword.vue'),
    },

    {
      path: '/reset',
      name: 'reset',
      // lazy-loaded
      component: () => import('./views/ResetPassword.vue'),
    },
    {
      path: '/coachreview/:id',
      name: 'coachreview',
      // lazy-loaded
      component: () => import('./views/CoachReview.vue'),
    },
    {
      path: '/coacheditreview/:id',
      name: 'coacheditreview',
      // lazy-loaded
      component: () => import('./views/CoachEditReview.vue'),
    },
    {
      path: '/calendar',
      name: 'calendar',
      // lazy-loaded
      component: () => import('./components/Calendar.vue'),
    },
    {
      path: '/coachcalendar/:id',
      name: 'coachcalendar',
      // lazy-loaded
      component: () => import('./components/CoachCalendar.vue'),
    },
    /*{
             path: '/contactform/:id',
             name: 'contactform',
             // lazy-loaded
             component: () => import('./components/ContactForm.vue')
           },*/
    {
      path: '/contactform',
      name: 'contactform',
      // lazy-loaded
      component: () => import('./components/ContactForm.vue'),
    },

    {
      path: '/sendmessage/:id',
      name: 'sendmessage',
      // lazy-loaded
      component: () => import('./components/SendMessage.vue'),
    },

    {
      path: '/inbox',
      name: 'inbox',
      // lazy-loaded
      component: () => import('./components/Inbox.vue'),
    },
    {
      path: '/contact-us',
      name: 'contactUs',
      // lazy-loaded
      component: () => import('./views/ContactUs.vue'),
    },
    {
      path: '/login-register',
      name: 'loginRegister',
      // lazy-loaded
      component: () => import('./views/LoginRegister.vue'),
    },
    {
      path: '/about-us',
      name: 'aboutUs',
      // lazy-loaded
      component: () => import('./views/AboutUs.vue'),
    },

    {
      path: '/stripepayment',
      name: 'stripePayment',
      // lazy-loaded
      component: () => import('./components/StripePayment.vue'),
    },
    {
      path: '/payment-success',
      name: 'paymentSuccess',
      // lazy-loaded
      component: () => import('./views/PaymentSuccess.vue'),
    },
    {
      path: '/payment-cancel',
      name: 'paymentCancel',
      // lazy-loaded
      component: () => import('./views/PaymentCancel.vue'),
    },
  ],
});
