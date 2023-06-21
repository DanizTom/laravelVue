<template>
  <div class="main-container">
    <HeaderStyleTwo />
    <OffCanvasMobileMenu />
    <div class="page-title-section section-padding-top-0">
      <div class="page-breadcrumb">
        <div class="container">
          <ul class="breadcrumb">
            <li>
              <router-link to="/">Home</router-link>
            </li>
            <li class="current">Login Register</li>
          </ul>
        </div>
      </div>

      <div class="page-title">
        <div class="container">
          <h1 class="title">Login Register</h1>
        </div>
      </div>
    </div>

    <!--Login Register section start-->
    <div class="login-register-section section-padding-bottom">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="row">
              <div class="col-md-5 col-lg-5 col-xl-5">
                <!-- Login Form Start -->
                <div class="login-form-wrapper">
                  <h3 class="title">Login</h3>
                  <form class="login-form">
                    <div class="single-input mb-30">
                      <label for="username">Username or email</label>
                      <input
                        type="text"
                        id="username"
                        name="username"
                        placeholder="Username or email"
                      />
                    </div>
                    <div class="single-input mb-30">
                      <label for="password">Password</label>
                      <input
                        type="text"
                        id="password"
                        name="password"
                        placeholder="Password"
                      />
                    </div>
                    <div class="single-input mb-30">
                      <div class="row">
                        <div class="col-sm-6 remember-me-wrap">
                          <div class="checkbox-input">
                            <input
                              type="checkbox"
                              name="login-form-remember"
                              id="login-form-remember"
                            />
                            <label for="login-form-remember">Remember me</label>
                          </div>
                        </div>
                        <div class="col-sm-6 lost-your-password-wrap">
                          <a class="lost-your-password">
                            Lost your password?
                          </a>
                        </div>
                      </div>
                    </div>
                    <div class="single-input">
                      <button
                        class="btn btn-primary btn-hover-secondary btn-width-100"
                      >
                        Log In
                      </button>
                    </div>
                  </form>
                </div>
                <!-- Login Form End -->
              </div>
              <div class="offset-xl-1 col-md-6 col-lg-6 col-xl-5">
                <!-- Register Form Start -->
                <div class="login-form-wrapper mt-sm-50 mt-xs-50">
                  <h3 class="title">Register</h3>
                  <form class="register-form">
                    <div class="single-input mb-30">
                      <label for="usernameOne">Username</label>
                      <input
                        type="text"
                        id="usernameOne"
                        name="username"
                        placeholder="Username"
                      />
                    </div>
                    <div class="single-input mb-30">
                      <label for="email">Email</label>
                      <input
                        type="text"
                        id="email"
                        name="username"
                        placeholder="Email"
                      />
                    </div>
                    <div class="single-input mb-30">
                      <label for="passwordOne">Password</label>
                      <input
                        type="text"
                        id="passwordOne"
                        name="password"
                        placeholder="Password"
                      />
                      <p class="description">
                        The password must be at least twelve characters long,
                        contain upper and lower case letters, contain numbers,
                        contain symbols like ! " ? $ % ^ &amp;
                      </p>
                    </div>
                    <div class="single-input">
                      <button
                        class="btn btn-primary btn-hover-secondary btn-width-100"
                      >
                        Register
                      </button>
                    </div>
                  </form>
                </div>
                <!-- Register Form End -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--Login Register section end-->

    <FooterStyleOne />
  </div>
</template>

<script>
import eventData from '@/data/event';

export default {
  components: {
    HeaderStyleTwo: () => import('@/components/landingPage/HeaderStyleTwo'),
    OffCanvasMobileMenu: () =>
      import('@/components/landingPage/OffCanvasMobileMenu'),
    // EventItemGridStyle: () => import('@/components/landingPage/EventItemGridStyle'),
    FooterStyleOne: () => import('@/components/landingPage/FooterStyleOne'),
  },

  data() {
    return {
      eventData,
      options: [
        'Popularity',
        'Latest',
        'Price: low to high',
        'Price: high to low',
      ],
      placeholderItem: 'Default',
    };
  },

  computed: {
    getSelectorPlaceholder: function () {
      return this.placeholderItem;
    },
  },

  head() {
    return {
      title: 'Login Register',
    };
  },
};
</script>
<style scoped>
button:hover {
  background-color: #3f3a64 !important;
  font-weight: 600;
  border-color: transparent;
}
button {
  background-color: #20ad96 !important;
  border-color: #20ad96;
}
a {
  color: #696969;
}
</style>
