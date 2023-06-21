<template>
  <div class="section-padding">
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Begin your journey at maxcoach</span>
        <h2 class="title fz-48">Signature <span>Courses</span></h2>
      </div>
      <!-- Section Title End -->

      <!-- Course Wrapper Start -->
      <div class="row row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
        <div
          class="col max-mb-30"
          data-aos="fade-up"
          v-for="course in courseData.coursePostItem.slice(0, 6)"
          :key="course.id"
        >
          <CourseItem :course="course" />
        </div>
      </div>
      <!-- Course Wrapper End -->

      <div class="row max-mt-40">
        <div class="text-center col-lg-7 mx-auto">
          <n-link
            to="/course/courses-grid-one"
            class="btn btn-primary btn-hover-secondary"
          >
            View all courses
            <i class="far fa-long-arrow-right ml-3"></i>
          </n-link>
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
