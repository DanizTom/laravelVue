<template>
  <div class="page-banner-section section-padding-200 bg-cover" :style="bgImg">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="page-banner-title">
            <h1 class="title">{{ title }}</h1>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['bgImg', 'title'],
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
.bg-cover {
  background-repeat: no-repeat !important;
  background-size: cover;
  background-position: center;
  height: 100%;
}
</style>
