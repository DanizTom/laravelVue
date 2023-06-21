<template>
  <div
    id="video-section-1"
    class="bg-pattern position-relative video-section-1"
    :style="{
      'background-color': '#f5f1ed',
      backgroundImage: `url('/images/bg/background-pattern-grid-line.png')`,
    }"
  >
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title"
          >The combination of all senses into learning</span
        >
        <h2 class="title">
          Learn with all your<span class="ml-3">SENSES</span>
        </h2>
      </div>
      <!-- Section Title End -->

      <!-- About Me Video Wrapper Start -->
      <div class="about-me-video-wrapper">
        <div class="about-me-video video-popup">
          <img
            class="image"
            src="/images/about/about-me/video.png"
            alt="image"
          />
          <!-- <img
                class="icon"
                src="/images/icons/icon-youtube-play.png"
                alt="icon"
              /> -->
        </div>
        <!-- <silent-box :image="videos[0]">
          <template v-slot:silentbox-item>
            <div class="about-me-video video-popup">
              <img
                class="image"
                src="/images/about/about-me/video.png"
                alt="image"
              />
              <img
                class="icon"
                src="/images/icons/icon-youtube-play.png"
                alt="icon"
              />
            </div>
          </template>
        </silent-box> -->
        <!-- Animation Shape Start -->
        <ShapeWithAnimation
          addClassName="shape-1"
          dataDepth="3"
          imgSrc="/images/shape-animation/shape-2.svg"
        ></ShapeWithAnimation>
        <ShapeWithAnimation
          addClassName="shape-2"
          dataDepth="-3"
          imgSrc="/images/shape-animation/shape-3.png"
        ></ShapeWithAnimation>
        <ShapeWithAnimation
          addClassName="shape-3"
          dataDepth="3"
        ></ShapeWithAnimation>
        <ShapeWithAnimation
          addClassName="shape-4"
          dataDepth="4"
          imgSrc="/images/shape-animation/shape-1.png"
        ></ShapeWithAnimation>
      </div>
    </div>

    <!-- Section Bottom Shape Start -->
    <div class="section-bottom-shape">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 100 100"
        preserveAspectRatio="none"
        height="100"
      >
        <path
          class="elementor-shape-fill"
          d="M 0 0 L0 100 L100 100 L100 0 Q 50 200 0 0"
        ></path>
      </svg>
    </div>
    <!-- Section Bottom Shape End -->
  </div>
</template>

<script>
export default {
  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },
  data() {
    return {
      videos: [
        {
          src: '',
          thumbnail: '',
        },
      ],
    };
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
<style lang="scss">
#silentbox-overlay {
  &__close-button {
    width: 60px !important;
    height: 60px !important;
    right: 50px !important;
    top: 50px !important;
    background-color: $primary !important;
    transition-delay: 3s;
    .icon {
      width: 60px !important;
      height: 60px !important;
      margin: 0 !important;
      left: 0 !important;
      top: 0 !important;
      transform: none;
      &:after,
      &:before {
        left: 25% !important;
        width: 50% !important;
      }
    }
  }
  &__embed {
    @media #{$large-mobile} {
      height: 50% !important;
    }
  }
}
#silentbox-gallery {
  text-align: center;
  .silentbox-item {
    width: 100%;
  }
}
</style>
