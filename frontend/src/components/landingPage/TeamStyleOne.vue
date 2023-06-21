<template>
  <div class="team-section section-padding-bottom" data-aos="fade-up">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-7">
          <div class="team-image-wrap">
            <div class="team-image">
              <img src="/images/team/home-3-team-image.png" alt="team" />
            </div>
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
            <ShapeWithAnimation
              addClassName="shape-5"
              dataDepth="5"
              imgSrc="/images/shape-animation/cta-shape-01.png"
            />
            <!-- Animation Shape End -->
          </div>
        </div>
        <div class="col-lg-5">
          <div class="about-content team-content mt-sm-50 mt-xs-50">
            <span class="sub-title"
              >Everything in <strong>MaxCoach</strong></span
            >
            <h2 class="title">We’re Here To <span>Transform</span> You!</h2>
            <p>
              As learners, people can enjoy great companionship from MaxCoach
              mentors and educators. We can help you develop and grow at your
              best.
            </p>
            <n-link to="/contact-us" class="btn btn-primary btn-hover-secondary"
              >Get Free Guide</n-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },
};
</script>
