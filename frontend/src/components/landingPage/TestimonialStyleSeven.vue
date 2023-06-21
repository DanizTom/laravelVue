<template>
  <div class="testimonial-section section-padding-top bg-f8f8f8">
    <div class="container">
      <SectionHeader
        subTitle="People are praising Idana"
        title="What make they <span>love us?</span>"
        alignment="text-center"
      />

      <div class="h5-testimonial-slider" data-aos="fade-up">
        <swiper :options="swiperOption">
          <div
            class="swiper-slide"
            v-for="testimonial in testimonials"
            :key="testimonial.index"
          >
            <div class="static-testimonial h5-testimonial mb-30">
              <div class="testimonial-image">
                <img :src="testimonial.imgSrc" :alt="testimonial.alt" />
              </div>
              <div class="testimonial-content">
                <p>{{ testimonial.text }}</p>
              </div>
              <div class="author-info">
                <div class="cite">
                  <h6 class="name">{{ testimonial.name }}</h6>
                  <span class="position">/ {{ testimonial.position }}</span>
                </div>
              </div>
            </div>
          </div>
        </swiper>
        <div class="swiper-pagination text-center"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {
    SectionHeader: () => import('@/components/SectionHeader'),
  },

  data() {
    return {
      swiperOption: {
        loop: true,
        speed: 1000,
        spaceBetween: 30,
        autoHeight: true,
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
        breakpoints: {
          992: {
            slidesPerView: 3,
          },
          768: {
            slidesPerView: 2,
          },
          300: {
            slidesPerView: 1,
          },
        },
      },

      testimonials: [
        {
          imgSrc: '/images/testimonial/140/testimonial-avata-01.jpg',
          alt: 'image',
          text: 'I love their flexibility. Even when my request is too complicated to handle. they could still suggest something useful for me.',
          name: 'Florence Themes',
          position: 'Multimedia Admin',
        },
        {
          imgSrc: '/images/testimonial/140/testimonial-avata-02.jpg',
          alt: 'image',
          text: 'I am free to learn at my own pace, follow my own schedule and choose subject I like. Great study portal for people like me.',
          name: 'Mina Hollace',
          position: 'Freelancer',
        },
        {
          imgSrc: '/images/testimonial/140/testimonial-avata-03.jpg',
          alt: 'image',
          text: 'I love their flexibility. Even when my request is too complicated to handle. they could still suggest something useful for me.',
          name: 'Madley Pondor',
          position: 'IT Specialist',
        },
        {
          imgSrc: '/images/testimonial/140/testimonial-avata-04.jpg',
          alt: 'image',
          text: 'I am free to learn at my own pace, follow my own schedule and choose subject I like. Great study portal for people like me.',
          name: 'Luvic Dubble',
          position: 'Private Tutor',
        },
      ],
    };
  },
};
</script>
