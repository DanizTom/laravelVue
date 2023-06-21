<template>
  <div class="cta-section section section-padding">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="cta-content animation-shape-three text-center">
            <span class="sub-title"
              >Start today for getting <span>Online Certification</span></span
            >
            <h2 class="title">
              You can be your own guiding star with our help!
            </h2>
            <n-link
              to="/contact-us"
              class="btn btn-primary btn-hover-secondary btn-width-300"
              >Get started now</n-link
            >

            <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
            <ShapeWithAnimation addClassName="shape-2" dataDepth="4" />
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
