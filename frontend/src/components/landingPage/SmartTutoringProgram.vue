<template>
  <div class="learners-section section section-padding">
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Idana available courses</span>
        <h2 class="title">
          Access <span>Smart Tutoring</span> Program For Benefits.
        </h2>
      </div>
      <!-- Section Title End -->

      <!-- Feature Wrapper Start -->
      <div class="row row-30 row-cols-xl-3 row-cols-sm-2 row-cols-1 max-mb-n30">
        <div
          class="col max-mb-30"
          data-aos="fade-up"
          v-for="learner in learners"
          :key="learner.id"
        >
          <n-link
            to="/course/courses-grid-one"
            class="icon-box icon-box-left text-left"
          >
            <div class="icon">
              <img :src="learner.imgSrc" :alt="learner.icon" />
            </div>
            <div class="content">
              <h3 class="title">{{ learner.title }}</h3>
              <div class="desc">
                <p>{{ learner.text }}</p>
              </div>
              <span class="link"
                >Start here <i class="far fa-long-arrow-right"></i
              ></span>
            </div>
          </n-link>
        </div>
      </div>
      <!-- Feature Wrapper End -->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      learners: [
        {
          id: 1,
          imgSrc: '/images/learner/h2-learner-01.png',
          icon: 'icon',
          title: 'Customize Preferences',
          text: 'Learners are given the right to arrange and customize their study schedule and timetable based on preferences.',
        },
        {
          id: 2,
          imgSrc: '/images/learner/learner-02.png',
          icon: 'icon',
          title: 'Cloud Storage',
          text: 'You can store online lessons via online cloud or download to your device and revise lessons on the way.',
        },
        {
          id: 3,
          imgSrc: '/images/learner/h2-learner-02.png',
          icon: 'icon',
          title: 'Multimedia Channels',
          text: 'We provide study materials with various formats: video, audio, slides, doc, prints, books and applications.',
        },
      ],
    };
  },
};
</script>
