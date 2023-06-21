<template>
  <div
    id="video-section-1"
    class="section-padding-top position-relative bg-pattern bg-f8f8f8"
    :style="{
      backgroundImage: `url('/images/bg/background-pattern-grid-line.png')`,
    }"
  >
    <div class="container">
      <div class="about-me-video-wrapper">
        <client-only>
          <silent-box :image="videos[0]">
            <template v-slot:silentbox-item>
              <div class="about-me-video video-popup">
                <img
                  class="image"
                  src="/images/about/about-me/video-about-us-2.jpg"
                  alt="image"
                />
                <img
                  class="icon"
                  src="/images/icons/icon-youtube-play.png"
                  alt="icon"
                />
              </div>
            </template>
          </silent-box>
        </client-only>
        <!-- Animation Shape Start -->
        <ShapeWithAnimation
          addClassName="shape-1"
          dataDepth="3"
          imgSrc="/images/shape-animation/shape-2.svg"
        />
        <ShapeWithAnimation
          addClassName="shape-2"
          dataDepth="-3"
          imgSrc="/images/shape-animation/shape-3.png"
        />
        <ShapeWithAnimation addClassName="shape-3" dataDepth="4" />
        <ShapeWithAnimation
          addClassName="shape-4"
          dataDepth="4"
          imgSrc="/images/shape-animation/shape-1.png"
        />
        <!-- Animation Shape End -->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      videos: [
        {
          src: 'https://www.youtube.com/watch?v=9No-FiEInLA',
          thumbnail: '',
        },
      ],
    };
  },

  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },
};
</script>

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
