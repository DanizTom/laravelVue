<template>
  <div class="cta-section section-padding" :class="addClassName">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="cta-content text-center">
            <h2 class="title">OUR <span>MISSION</span></h2>
            <p class="text-secondary px-5" style="font-size: 20px">
              Our goal is to stimulate thought and reflection. It can provide an
              opportunity for people to see things in a new light. This can
              assist them in developing their abilities, making sense of their
              situation, and making clear decisions about what to do next.
            </p>

            <!-- Animation Shape Start -->
            <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="4"
              imgSrc="/images/shape-animation/cta-shape-01.png"
            />
            <ShapeWithAnimation
              addClassName="shape-3"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-2.png"
            />
            <!-- Animation Shape End -->
          </div>
        </div>
      </div>
    </div>
    <div class="container" style="margin-top: 60px">
      <div class="row">
        <div class="col-12">
          <div class="cta-content text-center">
            <h2 class="title">ABOUT <span>IDANA</span></h2>
            <p class="text-secondary px-5" style="font-size: 20px">
              Idana's experience combines world-class coaching, AI technology,
              and behavioral science experts to deliver change on a large scale,
              enhancing individual resilience, adaptability, and effectiveness.
              <br />
              We believe that well-being and peak performance are inextricably
              linked. And that by providing tailored assistance and improving
              mental fitness, you can maximize your personal and professional
              potential. Our major priority is to shape the lives of people.
              <br />
              That is why we help them to grow personally and professionally.
              Team building is something that is necessary for a successful
              business to flourish. So, our mentorship will help you to
              accompany your team to the road of success.
            </p>

            <!-- Animation Shape Start -->
            <!-- <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="4"
              imgSrc="/images/shape-animation/cta-shape-01.png"
            />
            <ShapeWithAnimation
              addClassName="shape-3"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-2.png"
            /> -->
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
</style>
<style scoped>
a:hover {
  background-color: #3f3a64 !important;
  font-weight: 700;
  font-size: 14px;
  border-color: transparent;
  color: white;
}
a {
  background-color: #20ad96 !important;
  border-color: #20ad96;
  color: white;
  padding-top: 15px;
  font-weight: 700;
  font-size: 14px;
}
</style>
