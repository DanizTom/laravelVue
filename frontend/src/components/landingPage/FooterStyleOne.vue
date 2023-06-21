<template>
  <div class="footer-section" :class="addBackgroundColor">
    <div class="container">
      <div class="row">
        <div class="col-xl-6 col-md-5 max-mb-50">
          <div class="footer-widget" :class="addClassName">
            <h4 class="footer-widget-title">Address</h4>
            <div class="footer-widget-content">
              <div class="content">
                <!--<p>Your address goes here</p>
                <p>0123456789 (9am - 5pm EST, Monday - Friday)</p>-->
                <p>
                  <a href="mailto:idanahealth@gmail.com"
                    >idanahealth@gmail.com</a
                  >
                </p>
              </div>
              <!-- <div class="footer-social-inline">
                <a href="https://www.facebook.com/" target="_blank">
                  <i class="fab fa-facebook-square"></i>
                </a>
                <a href="https://twitter.com/" target="_blank">
                  <i class="fab fa-twitter"></i>
                </a>
                <a href="https://www.instagram.com/" target="_blank">
                  <i class="fab fa-instagram"></i>
                </a>
                <a href="https://www.linkedin.com/" target="_blank">
                  <i class="fab fa-linkedin"></i>
                </a>
              </div> -->
            </div>
          </div>
        </div>

        <div class="col-xl-3 col-md-4 col-sm-7 max-mb-50">
          <div class="footer-widget" :class="addClassName">
            <h4 class="footer-widget-title">Explore</h4>
            <div class="footer-widget-content">
              <ul class="column-3">
                <!-- <li>
                  <router-link to="">Start here</router-link>
                </li> -->
                <!-- <li>
                  <router-link to="">Success story</router-link>
                </li> -->
                <!-- <li>
                  <router-link to="/blog/blog-grid">Blog</router-link>
                </li> -->
                <li>
                  <router-link to="/register">Courses</router-link>
                </li>
                <li>
                  <router-link to="/about-us">About us</router-link>
                </li>
                <li>
                  <router-link to="/contact-us">Contact us</router-link>
                </li>
              </ul>
            </div>
          </div>
        </div>

        <!-- <div class="col-xl-3 col-md-3 col-sm-5 col-12 max-mb-50">
          <div class="footer-widget" :class="addClassName">
            <h4 class="footer-widget-title">Information</h4>
            <div class="footer-widget-content">
              <ul>
                <li>
                  <router-link to="">Membership</router-link>
                </li>
                <li>
                  <router-link to="">Purchase guide</router-link>
                </li>
                <li>
                  <router-link to="">Privacy policy</router-link>
                </li>
                <li>
                  <router-link to="">Terms of service</router-link>
                </li>
              </ul>
            </div>
          </div>
        </div> -->
      </div>

      <!-- Footer Copyright Start -->
      <!-- <div class="row max-mt-20">
        <div class="col">
          <p class="copyright">
            &copy; {{ new Date().getFullYear() }} <b>Idana</b> Made with
            <i class="fa fa-heart text-danger"></i> by
            <a href="https://hasthemes.com/" target="_blank"
              ><b>HasThemes</b></a
            >
          </p>
        </div>
      </div> -->
      <!-- Footer Copyright End -->
    </div>

    <back-to-top class="scroll-top" bottom="30px">
      <i class="arrow-top fal fa-long-arrow-up"></i>
      <i class="arrow-bottom fal fa-long-arrow-up"></i>
    </back-to-top>
  </div>
</template>

<script>
export default {
  props: ['addClassName', 'addBackgroundColor'],
};
</script>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
@import '@/assets/scss/titles';
@import '@/assets/scss/header';
@import '@/assets/scss/intro';
@import '@/assets/scss/quote';
@import '@/assets/scss/testimonial';
@import '@/assets/scss/video';
@import '@/assets/scss/course';
@import '@/assets/scss/event';
@import '@/assets/scss/pages';
@import '@/assets/scss/blog';
@import '@/assets/scss/widget';
@import '@/assets/scss/footer';
@import '@/assets/scss/dark-mode';
</style>
