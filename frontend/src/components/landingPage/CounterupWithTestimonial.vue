<template>
  <div
    class="section-padding bg-pattern fix counterup-testimonial"
    :style="{
      'background-color': '#f5f1ed',
      backgroundImage: `url('/images/bg/background-pattern-grid-line.png')`,
    }"
  >
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title"
          >maximize your potentials and possibilities</span
        >
        <h2 class="title">
          Learn the secrets to <span>Life Success</span>, <br />these people
          have got the key.
        </h2>
      </div>
      <!-- Section Title End -->

      <!-- Funfact Wrapper Start -->
      <div class="row max-mb-20">
        <div class="col-lg-9 mx-auto">
          <div class="row row-cols-md-3 row-cols-1 max-mb-n30">
            <!-- Funfact Start -->
            <div class="col max-mb-30" data-aos="fade-up">
              <div class="funfact">
                <div class="number"><span class="counter">50</span> +</div>
                <h6 class="text">Registered Enrolls</h6>
              </div>
            </div>
            <!-- Funfact End -->
            <!-- Funfact Start -->
            <div class="col max-mb-30" data-aos="fade-up">
              <div class="funfact">
                <div class="number">
                  <span class="counter">100</span>
                </div>
                <h6 class="text">Finished sessions</h6>
              </div>
            </div>
            <!-- Funfact End -->
            <!-- Funfact Start -->
            <div class="col max-mb-30" data-aos="fade-up">
              <div class="funfact">
                <div class="number"><span class="counter">80</span> %</div>
                <h6 class="text">Satisfaction rate</h6>
              </div>
            </div>
            <!-- Funfact End -->
          </div>
        </div>
      </div>
      <!-- Funfact Wrapper End -->

      <!--Testimonial Slider Start -->
      <!-- <div class="testimonial-slider" data-aos="fade-up">
        <swiper :options="swiperOption">
          <div
            class="swiper-slide"
            v-for="testimonial in testimonialItems"
            :key="testimonial.id"
          >
            <div class="testimonial">
              <div class="image">
                <img :src="testimonial.image" :alt="testimonial.alt" />
              </div>
              <div class="content">
                <p>{{ testimonial.text }}</p>
                <h6 class="name">{{ testimonial.name }}</h6>
                <span class="position">{{ testimonial.position }}</span>
              </div>
            </div>
          </div>
        </swiper>
      </div> -->
      <!--Testimonial Slider End -->
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      swiperOption: {
        spaceBetween: 50,
        loop: true,
        speed: 1000,
        autoplay: true,
        // Responsive breakpoints
        breakpoints: {
          992: {
            slidesPerView: 2,
          },
          300: {
            slidesPerView: 1,
          },
        },
      },

      testimonialItems: [
        {
          id: 1,
          image: '/images/testimonial/70/testimonial-1.jpg',
          alt: 'image',
          text: 'I am happy with their arrangement of lessons and subjects. They reflect a scientific investigation into effective methods to adopt for learners.',
          name: 'Luvic Dubble',
          position: 'Private Tutor',
        },
        {
          id: 2,
          image: '/images/testimonial/70/testimonial-3.jpg',
          alt: 'image',
          text: "I'm a very strict person so I require everything to be organized and neat. Then, I'll be able to make things right and shine. MaxCoach guys just got me.",
          name: 'Mina Hollace',
          position: 'IT Specialist',
        },
        {
          id: 3,
          image: '/images/testimonial/70/testimonial-2.jpg',
          alt: 'image',
          text: 'I am free to learn at my own pace, follow my own schedule and choose the subject I want to learn from the syllabus. Great study portal for people like me.',
          name: 'Florence Themes',
          position: 'Multimedia Admin',
        },
      ],
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
