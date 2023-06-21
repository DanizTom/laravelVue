<template>
  <div
    class="intro1-section section-fluid cover"
    :style="{ backgroundImage: `url('/images/intro/intro1/bg.png')` }"
  >
    <div class="container">
      <div class="row row-cols-md-2 row-cols-1 max-mb-n30">
        <div class="col align-self-center max-mb-30">
          <div class="intro1-content text-center text-md-left">
            <span class="sub-title">Idana is the lifebuoy</span>
            <h2 class="title">
              Your successful life and career are our mission
            </h2>
            <div class="desc">
              <p>
                The right mentoring relationship can be a powerful tool for
                professional growth. Bark up the right tree.
              </p>
            </div>
            <!-- <a class="btn" href="/images/sample.pdf" target="_blank">
              <i class="fa fa-download mr-3"></i>
              Download free guide
            </a> -->
          </div>
        </div>

        <div class="col max-mb-30">
          <div class="intro1-course" style="visibility: hidden">
            <img
              class="popular-course-icon"
              src="/images/intro/intro1/intro-popular-course.png"
              alt="image"
            />

            <div class="course-2">
              <div class="thumbnail">
                <router-link to="/" class="image">
                  <img
                    src="/images/courses/370/course-2.jpg"
                    alt="Course Image"
                  />
                </router-link>
              </div>
              <div class="info">
                <span class="price">Free</span>
                <span class="date">Sep 23, 2020</span>
                <h3 class="title">
                  <router-link to="/"
                    >Customer-centric Info-Tech Strategies</router-link
                  >
                </h3>
                <div class="desc">
                  <p>
                    Now more than ever, corporations are investing heavily in
                    IT. The quality of these investments affects the daily…
                  </p>
                </div>
              </div>
            </div>
            <ShapeWithAnimation
              addClassName="intro1-scene"
              dataDepth="3"
              imgSrc="/images/shape-animation/shape-1.png"
            />
          </div>
        </div>
      </div>
    </div>

    <div class="section-bottom-shape">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 100 100"
        preserveAspectRatio="none"
        height="100"
      >
        <path d="M 0 0 L100 0 Q 50 200 0 0"></path>
      </svg>
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
.title a {
  color: #3f3a64 !important;
  font-weight: 600;
}
.title a:hover {
  color: #20ad96 !important;
}
.cover {
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
  height: 100%;
}
</style>
