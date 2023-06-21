<template>
  <div class="service-image-section section">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="service-image animation-shape-two">
            <img
              src="/images/service/home-6-services-image.png"
              alt="service image"
            />

            <ShapeWithAnimation addClassName="shape-1" dataDepth="8" />
            <ShapeWithAnimation addClassName="shape-2" dataDepth="-5" />
            <ShapeWithAnimation addClassName="shape-3" dataDepth="-8" />
            <ShapeWithAnimation addClassName="shape-4" dataDepth="4" />
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
