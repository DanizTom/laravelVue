<template>
  <div class="popup-mobile-menu popup-mobile-visiable" id="offcanvas-menu">
    <div
      class="mobile-menu-overlay"
      @click="mobiletoggleClass('removeClass', 'show-mobile-menu')"
    ></div>
    <div class="inner custom-scrollbar">
      <div class="mobile-header">
        <div class="logo">
          <router-link to="/">
            <img src="/Logo.png" height="80px" alt="site logo" />
          </router-link>
        </div>
        <button
          class="mobile-close-btn"
          @click="mobiletoggleClass('removeClass', 'show-mobile-menu')"
        ></button>
      </div>
      <div class="menu-content">
        <MobileNavigation />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {
    MobileNavigation: () => import('@/components/landingPage/MobileNavigation'),
  },

  methods: {
    // offcanvas menu close
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
