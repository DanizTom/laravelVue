<template>
  <div class="intro2-section">
    <div class="container">
      <div class="row row-cols-lg-2 row-cols-1 max-mb-n30">
        <!-- Intro One Content Start -->
        <div class="col align-self-center max-mb-30">
          <div class="intro2-content text-center text-md-left">
            <h2 class="title">Distant learning for further expansion</h2>
            <div class="desc">
              <p>
                Learning is a life-long journey that in fact we never find the
                terminate stop. Stop searching, enjoy the process.
              </p>
            </div>
            <a
              class="btn btn-primary btn-hover-secondary"
              href="/images/sample.pdf"
              target="_blank"
            >
              <i class="far fa-download mr-3"></i>
              Download free guide
            </a>
            <n-link to="/contact-us" class="link link-lg">
              Have questions?​
              <mark>Get Free Form <i class="far fa-long-arrow-right"></i></mark>
            </n-link>
          </div>
        </div>
        <!-- Intro One Content End -->

        <!-- Intro One Course Start -->
        <div class="col max-mb-30">
          <div class="contact-image intro2-image">
            <img src="/images/others/contact.jpg" alt="image" />

            <!-- Animation Shape Start -->
            <ShapeWithAnimation
              addClassName="shape-1"
              dataDepth="4"
              imgSrc="/images/shape-animation/about-shape-1.png"
            />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="-4"
              imgSrc="/images/shape-animation/about-shape-1.png"
            />
            <ShapeWithAnimation addClassName="shape-3" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-4"
              dataDepth="4"
              imgSrc="/images/shape-animation/shape-1.png"
            />
            <ShapeWithAnimation
              addClassName="shape-5"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-2.png"
            />
            <!-- Animation Shape End -->
          </div>
        </div>
        <!-- Intro One Course End -->
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
