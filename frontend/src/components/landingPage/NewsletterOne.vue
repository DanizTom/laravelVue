<template>
  <div class="section-padding position-relative">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="newsletter-content">
            <h2 class="title">Sign up for our <span>Newsletters</span></h2>
            <p>
              Enter your email address to register to our newsletter
              subscription <br class="d-none d-md-block" />delivered on a
              regular basis!
            </p>
            <div class="newsletter-form">
              <form>
                <input type="email" placeholder="Your E-mail" />
                <button class="btn btn-primary btn-hover-secondary">
                  Subscribe
                </button>
              </form>
            </div>

            <!-- Animation Shape Start -->
            <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-1.png"
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
button:hover {
  background-color: #3f3a64 !important;
  font-weight: 600;
  border-color: transparent;
}
button {
  background-color: #20ad96 !important;
  border-color: #20ad96;
}
</style>
