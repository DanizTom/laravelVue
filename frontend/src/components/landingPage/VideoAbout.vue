<template>
  <div id="video-section-1" class="position-relative bg-f5f5f5 section-padding">
    <div class="container">
      <!-- About Me Video Wrapper Start -->
      <div class="about-me-video-wrapper text-center">
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
        <ShapeWithAnimation addClassName="shape-3" dataDepth="3" />
        <ShapeWithAnimation
          addClassName="shape-4"
          dataDepth="4"
          imgSrc="/images/shape-animation/shape-1.png"
        />
        <!-- Animation Shape End -->
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
          src: 'https://www.youtube.com/watch?v=9No-FiEInLA',
          thumbnail: '',
        },
      ],
    };
  },
};
</script>
