<template>
  <div class="section section-padding">
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Learn at your Pace</span>
        <h2 class="title">Current Signature Courses</h2>
      </div>
      <!-- Section Title End -->

      <!-- Course Wrapper Start -->
      <div class="row row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
        <div
          class="col max-mb-30"
          data-aos="fade-up"
          v-for="course in courseData.coursePostItem.slice(0, 3)"
          :key="course.is"
        >
          <div class="course-2">
            <div class="thumbnail">
              <router-link to="/course/course-details" class="image">
                <img :src="course.image" :alt="course.alt" />
              </router-link>
            </div>
            <div class="info">
              <span class="price">{{ course.price }}</span>
              <span class="date">{{ course.date }}</span>
              <h3 class="title">
                <router-link to="/course/course-details">{{
                  course.title
                }}</router-link>
              </h3>
            </div>
          </div>
        </div>
      </div>
      <!-- Course Wrapper End -->

      <div class="row max-mt-70">
        <div class="text-center col-lg-7 mx-auto">
          <router-link to="/" class="link link-lg">
            Get the most dedicated consultation for your life-changing course.
            Earn a certification for your effort and passion
            <mark>Get Free Guide <i class="fa fa-arrow-right"></i></mark>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import courseData from '@/data/courses';

export default {
  data() {
    return {
      courseData,
    };
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
