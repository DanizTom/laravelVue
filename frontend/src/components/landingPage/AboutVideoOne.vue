<template>
  <div
    class="about-video-section section-padding-top section-padding-bottom-160"
    :class="addClassName"
  >
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-8">
          <div
            class="about-me-video-wrapper about-us-one-video pr-55 pr-sm-0 pr-xs-0"
          >
            <!-- About Me Video Start -->
            <div class="about-me-video video-popup">
              <img class="image" src="/images/video/A22.png" alt="image" />
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
                    src="/images/video/about-video.jpg"
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
        </div>

        <div class="col-lg-4">
          <div class="about-content mt-sm-50 mt-xs-50">
            <span class="sub-title">Here is how Idana works?</span>
            <h2 class="title">
              Upgrade Your Skills <span>Upgrade Your Life</span>
            </h2>
            <div class="step">
              <ul>
                <li>
                  <i class="fas fa-arrow-right"></i>
                  Login/Signup
                </li>
                <li><i class="fas fa-arrow-right"></i> Take an assessmenet</li>
                <li><i class="fas fa-arrow-right"></i>Hire your coach</li>
                <li><i class="fas fa-arrow-right"></i>Start your session</li>
                <li>
                  <i class="fas fa-arrow-right"></i> Invest your time See
                  yourself at top of the excellent career
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['addClassName'],

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
.step ul {
  list-style: none;
}

.step ul i {
  color: $secondary;
  margin-right: 10px;
}
.step ul li {
  font-size: 18px;
  margin: 15px 0px;
  color: $secondary;
  font-weight: 600;
}
</style>
