<template>
  <div
    class="about-video-section section position-relative section-padding-top section-padding-bottom-160"
  >
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-7">
          <!-- About Me Video Wrapper Start -->
          <div
            class="about-me-video-wrapper about-us-one-video pr-55 pr-sm-0 pr-xs-0"
          >
            <!-- About Me Video Start -->
            <client-only>
              <silent-box :image="videos[0]">
                <template v-slot:silentbox-item>
                  <div class="about-me-video video-popup">
                    <img
                      class="image"
                      src="/images/video/home-2-popup-video-poster.jpg"
                      alt="video poster"
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
            <!-- About Me Video End -->

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
          <!-- About Me Video Wrapper End -->
        </div>

        <div class="col-lg-4">
          <div
            class="about-content max-width-100 pl-60 pl-md-20 pl-sm-0 pl-xs-0 mt-sm-50 mt-xs-50"
          >
            <span class="sub-title"
              >Get started <strong>effortlessly</strong></span
            >
            <h2 class="title">Enjoy Our <span>Companionship</span></h2>
            <p>
              Spend some time to visit our website or head office and discover
              our current courses, enrollment procedure, and registration
              deadline. We're opening new classes every beginning of each month.
            </p>
            <n-link to="/" class="link link-lg">
              <mark
                >Download free guidebook <i class="far fa-long-arrow-right"></i
              ></mark>
            </n-link>
          </div>
        </div>
      </div>
    </div>

    <!-- Section Bottom Shape Start -->
    <div class="section-bottom-shape-two">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 100 100"
        preserveAspectRatio="none"
        height="315"
      >
        <path
          class="elementor-shape-fill"
          d="M 50 0 S75 0 100 100 L100 0"
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
