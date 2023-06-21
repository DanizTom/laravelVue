<template>
  <div
    class="blog-section section-padding bg-pattern-one bg-f5f5f5"
    :style="{ backgroundImage: `url('/images/bg/maxcoach-shape-03.png')` }"
  >
    <div class="container blog-shape-animation">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">study with your favorite tutors</span>
        <h2 class="title">1-1 COACHING INCLUDES</h2>
      </div>
      <!-- Section Title End -->
      <div class="row isotope-grid">
        <!-- <div class="grid-sizer col-1"></div> -->
        <div class="col-xl-3 col-md-3 grid-item" data-aos="fade-up">
          <div class="blog-2 mt-150 mt-md-0 mt-sm-0 mt-xs-0 mb-30">
            <div class="thumbnail">
              <img src="/images/blog/270/blog-01.png" alt="Blog Image" />
            </div>
            <div class="info">
              <!-- <router-link to="/blog/blog-details" class="category"
                >Online Education</router-link
              > -->
              <h3 class="title">
                <ul>
                  <li>
                    One 1-hour deep dive into your business and goals of life
                  </li>
                  <li>
                    A clear plan of what we will cover based on your specific
                    business and needs of life
                  </li>
                  <li>Weekly tasks that are specific and actionable</li>
                </ul>
              </h3>
              <!-- <ul class="meta">
                <li><i class="far fa-calendar"></i>Dec 11, 2019</li>
                <li><i class="fas fa-eye"></i>47 views</li>
              </ul> -->
            </div>
          </div>
        </div>
        <div class="col-xl-6 col-md-6 plr-40 grid-item" data-aos="fade-up">
          <div class="blog-2 mb-30">
            <div class="thumbnail overlay-thumb">
              <router-link to="/" class="image">
                <img src="/images/blog/270/blog-3.png" alt="Blog Image" />
              </router-link>
            </div>
            <div class="info content-absolute">
              <router-link to="/" class="category"
                >Learning Strategies</router-link
              >
              <h3 class="title">
                <router-link to="/"
                  >Clearly identify the life bettering activities to focus on !
                </router-link>
              </h3>

              <!-- <ul class="meta">
                <li><i class="far fa-calendar"></i>Dec 11, 2019</li>
                <li><i class="fas fa-eye"></i>32 views</li>
              </ul> -->
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-md-3 grid-item" data-aos="fade-up">
          <div class="blog-2 mt-50 mt-sm-0 mt-xs-0 mb-30">
            <div class="thumbnail">
              <router-link to="/" class="image">
                <img src="/images/blog/270/blog-02.png" alt="Blog Image" />
              </router-link>
            </div>
            <div class="info">
              <h3 class="title">
                <ul>
                  <li>
                    Develop systems to become more organized and leverage your
                    time
                  </li>
                  <li>Create a business and life that reflects your values</li>
                  <li>Discover a whole new level of success</li>
                </ul>
              </h3>
              <!-- <ul class="meta">
                <li><i class="far fa-calendar"></i>Dec 11, 2019</li>
                <li><i class="fas fa-eye"></i>32 views</li>
              </ul> -->
            </div>
          </div>
        </div>
      </div>
      <!-- 
      <div class="row max-mt-70">
        <div class="text-center col-lg-7 mx-auto">
          <router-link to="/blog/blog-details" class="link link-lg">
            Get into details now?
            <mark>
              View all posts
              <i class="fad fa-long-arrow-right"></i>
            </mark>
          </router-link>
        </div>
      </div> -->

      <!-- Animation Shape Start -->
      <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
      <ShapeWithAnimation
        addClassName="shape-2"
        dataDepth="-3"
        imgSrc="/images/shape-animation/shape-3.png"
      />
      <ShapeWithAnimation
        addClassName="shape-3"
        dataDepth="3"
        imgSrc="/images/shape-animation/shape-2.svg"
      />
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
h3 a {
  color: #333333;
}
h3 a:hover {
  color: #20ad96;
}
.title ul li {
  margin: 30px 0px;
}
</style>
