<template>
  <div class="google-map-area" id="support">
    <GmapMap
      :center="{ lat: 52.4829, lng: -1.89346 }"
      :zoom="15"
      map-type-id="terrain"
    >
    </GmapMap>
  </div>
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
<style lang="scss" scoped>
.vue-map-container {
  height: 500px;
  // res
  @media #{$small-mobile} {
    height: 350px;
  }
}
</style>
