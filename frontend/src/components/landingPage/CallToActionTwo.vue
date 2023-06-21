<template>
  <div class="cta-section bg-f5f5f5">
    <div class="container animation-shape">
      <div class="row">
        <div class="col-12">
          <div class="cta-content-area">
            <div class="section-title text-center mb-0" data-aos="fade-up">
              <span class="sub-title secondary-color max-mb-30"
                >New horizon is calling</span
              >
              <h2 class="title heading-color max-mb-30">
                Take your interest and register an online class <br />
                today to enjoy life fully
              </h2>
              <button class="btn btn-primary btn-hover-secondary">
                Get started for free
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Animation Shape Start -->
      <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-2" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-3" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-4" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-5" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-6" dataDepth="4" />
      <!-- Animation Shape End -->
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
