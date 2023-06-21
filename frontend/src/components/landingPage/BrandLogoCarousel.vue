<template>
  <div class="brand-section section-padding">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="brand-wrapper">
            <div class="brand-list">
              <div class="brand-carousel" data-aos="fade-up">
                <swiper :options="swiperOption">
                  <div
                    class="swiper-slide brand"
                    v-for="brand in brands"
                    :key="brand.id"
                  >
                    <router-link to="/">
                      <img :src="brand.logo" :alt="brand.alt" />
                    </router-link>
                  </div>
                </swiper>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      swiperOption: {
        loop: true,
        speed: 1000,
        autoplay: true,
        // Responsive breakpoints
        breakpoints: {
          992: {
            slidesPerView: 6,
          },
          768: {
            slidesPerView: 4,
          },
          576: {
            slidesPerView: 3,
          },
          320: {
            slidesPerView: 2,
          },
        },
      },

      brands: [
        {
          id: 1,
          logo: '/images/brand/client-logo-01.png',
          alt: 'brand logo',
        },
        {
          id: 2,
          logo: '/images/brand/client-logo-02.png',
          alt: 'brand logo',
        },
        {
          id: 3,
          logo: '/images/brand/client-logo-03.png',
          alt: 'brand logo',
        },
        {
          id: 4,
          logo: '/images/brand/client-logo-04.png',
          alt: 'brand logo',
        },
        {
          id: 5,
          logo: '/images/brand/client-logo-05.png',
          alt: 'brand logo',
        },
        {
          id: 6,
          logo: '/images/brand/client-logo-06.png',
          alt: 'brand logo',
        },
        {
          id: 7,
          logo: '/images/brand/client-logo-07.png',
          alt: 'brand logo',
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
