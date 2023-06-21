<template>
  <div class="section-padding course-3-wrapper">
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Stimulated to learn?</span>
        <h2 class="title">Featured Online Courses</h2>
      </div>
      <!-- Section Title End -->

      <!-- Courses Wrapper Start -->
      <div class="row row-cols-lg-2 row-cols-1 max-mb-n30">
        <div
          class="col max-mb-30"
          data-aos="fade-up"
          v-for="course in courseData.coursePostItem.slice(0, 6)"
          :key="course.id"
        >
          <CourseItemStyleThree :course="course" />
        </div>
      </div>
      <!-- Courses Wrapper End -->

      <div class="row max-mt-50">
        <div class="col text-center">
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
  components: {
    CourseItemStyleThree: () => import('@/components/CourseItemStyleThree'),
  },

  data() {
    return {
      courseData,
    };
  },
};
</script>
