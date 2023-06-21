<template>
  <div class="shape scene" :class="addClassName">
    <span :data-depth="dataDepth">
      <img :src="imgSrc" alt="shape image" />
    </span>
  </div>
</template>

<script>
import Parallax from 'parallax-js';

export default {
  props: ['addClassName', 'imgSrc', 'dataDepth'],

  mounted() {
    var scene = document.querySelectorAll('.scene');
    if (scene) {
      scene.forEach((el) => {
        new Parallax(el);
      });
    }
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
