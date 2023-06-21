<template>
  <div class="section-padding-bottom position-relative bg-f5f5f5">
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Join MaxCoach at best</span>
        <h2 class="title">Latest Online <span>Courses</span></h2>
      </div>
      <!-- Section Title End -->

      <!-- Courses Wrapper Start -->
      <div class="courses-slider" data-aos="fade-up">
        <swiper :options="swiperOptions">
          <div
            class="swiper-slide mb-30"
            v-for="course in courseData.coursePostItem.slice(0, 5)"
            :key="course.id"
          >
            <CourseItem :course="course" />
          </div>
        </swiper>
        <div class="swiper-pagination text-center"></div>
      </div>
      <!-- Courses Wrapper End -->

      <div class="row max-mt-70">
        <div class="text-center col-lg-7 mx-auto">
          <n-link to="/contact-us" class="link link-lg">
            Get the most dedicated consultation for your life-changing course.
            Earn a certification for your effort and passion
            <mark>Get Free Guide <i class="far fa-long-arrow-right"></i></mark>
          </n-link>
        </div>
      </div>
    </div>

    <!-- Section Bottom Shape Start -->
    <div class="section-bottom-shape">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 100 100"
        preserveAspectRatio="none"
        height="100"
      >
        <path
          class="elementor-shape-fill"
          d="M 0 0 L0 100 L100 100 L100 0 Q 50 200 0 0"
        ></path>
      </svg>
    </div>
    <!-- Section Bottom Shape End -->
  </div>
</template>

<script>
import courseData from '@/data/courses';

export default {
  data() {
    return {
      courseData,

      swiperOptions: {
        spaceBetween: 30,
        loop: true,
        speed: 1000,
        autoHeight: true,
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
        // Responsive breakpoints
        breakpoints: {
          992: {
            slidesPerView: 3,
          },
          300: {
            slidesPerView: 1,
          },
        },
      },
    };
  },
};
</script>
