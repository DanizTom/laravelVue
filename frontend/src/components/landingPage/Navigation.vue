<template>
  <nav class="site-main-menu">
    <ul>
      <li>
        <router-link to="/">
          <span class="menu-text">Home</span>
        </router-link>
      </li>
      <li>
        <router-link to="/about-us">
          <span class="menu-text">About Us</span>
        </router-link>
      </li>
      <li>
        <router-link to="/contact-us">
          <span class="menu-text">Contact Us</span>
        </router-link>
      </li>
      <li>
        <router-link to="/register">
          <span class="menu-text">Sign Up</span>
        </router-link>
      </li>
      <li>
        <router-link to="/login">
          <span class="menu-text">Login</span>
        </router-link>
      </li>
    </ul>
  </nav>
</template>
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
