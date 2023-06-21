<template>
  <header
    class="header-section header-shadow"
    :class="{ 'is-sticky': isSticky }"
  >
    <div class="header-inner">
      <div class="container position-relative">
        <div class="row justify-content-between align-items-center">
          <!-- Header Logo Start -->
          <div class="col-xl-3 col-auto">
            <div class="header-logo">
              <router-link to="/">
                <!-- <h1 class="text-secondary ml-4">Idana</h1> -->
                <img height="100" src="/Logo.png" />
              </router-link>
            </div>
          </div>
          <!-- Header Logo End -->

          <!-- Header Main Menu Start -->
          <div
            class="col d-none d-xl-block position-static"
            style="padding: 0px 12px"
          >
            <Navigation />
          </div>
          <!-- Header Main Menu End -->

          <!-- Header Right Start -->
          <div class="col-xl-3 col-auto">
            <div class="header-right">
              <div class="inner">
                <!-- <ColorMode /> -->

                <!-- Header Login Start -->
                <!-- <div class="header-login">
                  <router-link to="/course/profile">
                    <i class="far fa-user-circle"></i>
                  </router-link>
                </div> -->
                <!-- Header Login End -->

                <!-- Header Search Start -->
                <!-- <div class="header-search">
                  <button
                    class="header-search-toggle"
                    @click="isHidden = !isHidden"
                  >
                    <i class="far fa-search"></i>
                  </button>
                  <div class="header-search-form" v-show="!isHidden">
                    <form>
                      <input type="text" placeholder="Search..." />
                      <button>
                        <i class="fas fa-search"></i>
                      </button>
                    </form>
                  </div>
                </div> -->
                <!-- Header Search End -->

                <!-- Header Mobile Menu Toggle Start -->
                <div class="header-mobile-menu-toggle d-xl-none ml-sm-2">
                  <button
                    class="toggle"
                    @click="mobiletoggleClass('addClass', 'show-mobile-menu')"
                  >
                    <i class="icon-top"></i>
                    <i class="icon-middle"></i>
                    <i class="icon-bottom"></i>
                  </button>
                </div>
                <!-- Header Mobile Menu Toggle End -->
              </div>
            </div>
          </div>
          <!-- Header Right End -->
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  components: {
    Navigation: () => import('@/components/landingPage/Navigation'),
    // ColorMode: () => import('@/components/landingPage/ColorMode'),
  },

  data() {
    return {
      isSticky: false,
      isHidden: true,
      $colorMode: false,
    };
  },

  mounted() {
    window.addEventListener('scroll', () => {
      let scrollPos = window.scrollY;
      if (scrollPos >= 200) {
        this.isSticky = true;
      } else {
        this.isSticky = false;
      }
    });
  },

  methods: {
    // offcanvas mobilemenu
    mobiletoggleClass(addRemoveClass, className) {
      const el = document.querySelector('#offcanvas-menu');
      if (addRemoveClass === 'addClass') {
        el.classList.add(className);
      } else {
        el.classList.remove(className);
      }
    },
  },
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
