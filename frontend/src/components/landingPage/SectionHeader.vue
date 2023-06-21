<template>
  <div>
    <div class="section-title" :class="alignment" data-aos="fade-up">
      <span class="sub-title" v-html="subTitle">{{ subTitle }}</span>
      <h2 class="title fz-48" v-html="title">{{ title }}</h2>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    subTitle: {
      type: String,
      required: true,
    },
    title: {
      type: String,
      required: true,
    },
    alignment: {
      type: String,
      required: true,
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
