<template>
  <div class="testimonial-section section-padding bg-f8f8f8">
    <div
      class="container-fluid pl-80 pl-lg-15 pl-md-15 pl-sm-15 pl-xs-15 pr-80 pr-lg-15 pr-md-15 pr-sm-15 pr-xs-15"
    >
      <SectionHeader
        subTitle="GREAT LEADERS "
        title="Here's what people say about our coaches"
        alignment="text-center section-title-two"
      />

      <!--Testimonial Slider Start -->
      <div class="testimonial-slider-two" data-aos="fade-up">
        <swiper :options="swiperOption">
          <div
            class="swiper-slide"
            v-for="testimonial in testimonials"
            :key="testimonial.index"
          >
            <div class="testimonial-two testimonial-three max-mb-30">
              <div class="content">
                <h4 class="title">{{ testimonial.title }}</h4>
                <p>{{ testimonial.desc }}</p>
              </div>
              <div class="author-info">
                <div class="image">
                  <img :src="testimonial.imgSrc" :alt="testimonial.name" />
                </div>
                <div class="cite">
                  <h6 class="name">{{ testimonial.name }}</h6>
                  <span class="position">/ {{ testimonial.position }}</span>
                </div>
              </div>
            </div>
          </div>
        </swiper>
        <!-- swiper pagination -->
        <div class="swiper-pagination text-center"></div>
      </div>
      <!--Testimonial Slider End -->
    </div>
  </div>
</template>

<script>
export default {
  components: {
    SectionHeader: () => import('@/components/landingPage/SectionHeader'),
  },
  data() {
    return {
      swiperOption: {
        spaceBetween: 50,
        loop: true,
        speed: 1000,
        centeredSlides: true,
        autoHeight: true,
        pagination: {
          el: '.testimonial-slider-two .swiper-pagination',
          type: 'bullets',
          clickable: true,
        },
        // Responsive breakpoints
        breakpoints: {
          1200: {
            slidesPerView: 3,
          },
          992: {
            slidesPerView: 2,
          },
          300: {
            slidesPerView: 1,
          },
        },
      },

      testimonials: [
        {
          title: 'High level of efficiency and scientific teaching methods',
          desc: 'I am happy with their arrangement of lessons and subjects. They reflect a scientific investigation into effective methods to adopt for learners.',
          name: 'Florence Themes',
          position: 'Multimedia Admin',
          imgSrc: '/images/testimonial/70/testimonial-1.jpg',
        },
        {
          title:
            'Professional team of specialists and passionate mentors at reach',
          desc: 'I need to get a certification for English proficiency and MaxCoach is my best choice. Their tutors are smart and professional when dealing with students.',
          name: 'Madley Pondor',
          position: 'IT Specialist',
          imgSrc: '/images/testimonial/70/testimonial-2.jpg',
        },
        {
          title: 'Highly recommend their courses and teaching system',
          desc: 'I am happy with their arrangement of lessons and subjects. They reflect a scientific investigation into effective methods to adopt for learners.',
          name: 'Luvic Dubble',
          position: 'Private Tutor',
          imgSrc: '/images/testimonial/70/testimonial-3.jpg',
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
