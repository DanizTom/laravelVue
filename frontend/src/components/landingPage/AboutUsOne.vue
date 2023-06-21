<template>
  <div
    class="about-section section-padding-top-190 section-padding-bottom"
    :class="addClassName"
  >
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6 order-lg-1 order-2">
          <div class="about-content mt-sm-50 mt-xs-50">
            <span class="sub-title"
              >Get to know about <strong>IDANA</strong></span
            >
            <h2 class="title">
              Your successful career is our <span>lifelong commitment.</span> It
              is the one that takes you to the top of the world.
            </h2>
            <!-- <div class="sub-title"><span> Here is how Idana works?</span></div> -->
            <!-- <div class="step">
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
            </div> -->
          </div>
        </div>

        <div class="col-lg-6 order-lg-1 order-1">
          <div class="about-image">
            <div class="about-image-one">
              <img src="/images/about/about01/about1.png" alt="about-01" />
            </div>
            <!-- <div class="about-image-two">
              <img src="/images/about/about01/about2.jpg" alt="about-02" />
            </div> -->

            <!-- Animation Shape Start -->
            <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="4"
              imgSrc="/images/shape-animation/about-shape-1.png"
            />
            <ShapeWithAnimation
              addClassName="shape-3"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-2.png"
            />
            <ShapeWithAnimation
              addClassName="shape-4"
              dataDepth="4"
              imgSrc="/images/shape-animation/shape-1.png"
            />
            <!-- Animation Shape End -->
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
