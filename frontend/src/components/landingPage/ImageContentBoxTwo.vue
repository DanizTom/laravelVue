<template>
  <div class="download-app-section section-padding-top">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-7">
          <div class="download-app-image mb-sm-50 mb-xs-50">
            <img src="/images/others/home-5-image-02.png" alt="image" />

            <!-- Animation Shape Start -->
            <ShapeWithAnimation
              addClassName="shape-1"
              dataDepth="3"
              imgSrc="/images/shape-animation/shape-2.svg"
            />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="-3"
              imgSrc="/images/shape-animation/cta-shape-01.png"
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
        <div class="col-lg-5">
          <div class="download-app-content">
            <!-- Section Title Start -->
            <div class="section-title text-left mb-30" data-aos="fade-up">
              <span class="sub-title">What are you looking for?</span>
              <h2 class="title fz-48">
                Learn on your <span>mobile</span> anytime!
              </h2>
            </div>
            <!-- Section Title End -->

            <p>
              Save lessons for later and revise or write notes at any time and
              on multiple devices on your way. Never interfere with activities
              of enjoyment or other precious moments.
            </p>
            <n-link to="/" class="btn btn-primary btn-hover-secondary mt-30"
              >Download Our App</n-link
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
