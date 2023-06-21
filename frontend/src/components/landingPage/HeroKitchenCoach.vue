<template>
  <div class="intro11-slider-wrap">
    <div class="intro11-slider">
      <swiper :options="swiperOption">
        <div
          class="swiper-slide"
          v-for="(hero, index) in heroItems"
          :key="index"
        >
          <div class="intro11-section section-fluid-two">
            <div class="container">
              <div class="row align-items-center">
                <!-- Intro Content Start -->
                <div class="col-md-6">
                  <div class="intro11-content text-left">
                    <span class="sub-title">{{ hero.subTitle }}</span>
                    <h2 class="title">{{ hero.title }}</h2>
                    <n-link
                      to="/contact-us"
                      class="btn btn-primary-three btn-hover-secondary-three"
                    >
                      Get started today
                    </n-link>
                  </div>
                </div>
                <!-- Intro Content End -->

                <!-- Intro Image Start -->
                <div class="col-md-6">
                  <div class="intro-image">
                    <img :src="hero.imgSrc" alt="intro image" />
                  </div>
                </div>
                <!-- Intro Image End -->
              </div>
            </div>
          </div>
        </div>
      </swiper>
      <div class="home11-slider-prev swiper-button-prev main-slider-nav">
        <i class="fal fa-angle-left"></i>
      </div>
      <div class="home11-slider-next swiper-button-next main-slider-nav">
        <i class="fal fa-angle-right"></i>
      </div>
    </div>

    <!-- Animation Shape Start -->
    <ShapeWithAnimation
      addClassName="shape-1"
      data-depth="3"
      imgSrc="/images/intro/intro11/maxcoach-shape-15.png"
    />
    <ShapeWithAnimation
      addClassName="shape-2"
      data-depth="3"
      imgSrc="/images/intro/intro11/kitchen-shape-strawberry.png"
    />
    <ShapeWithAnimation
      addClassName="shape-3"
      data-depth="3"
      imgSrc="/images/shape-animation/maxcoach-shape-16.png"
    />
    <!-- Animation Shape End -->
  </div>
</template>

<script>
export default {
  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },

  data() {
    return {
      swiperOption: {
        loop: true,
        speed: 1500,
        spaceBetween: 30,
        autoplay: false,
        navigation: {
          nextEl: '.home11-slider-next',
          prevEl: '.home11-slider-prev',
        },
      },

      heroItems: [
        {
          subTitle: 'Family Nutrition',
          title: 'Take Your Food to The Next Level With These Methods',
          imgSrc:
            '/images/intro/intro11/kitchen-hero-slider-slide-01-image.jpg',
        },
        {
          subTitle: 'Life Mastery',
          title: 'Be Happy, Healthy And Successful Simplified',
          imgSrc:
            '/images/intro/intro11/kitchen-hero-slider-slide-02-image.jpg',
        },
        {
          subTitle: 'Cook with me!',
          title: 'The truth about dieting for weight loss, healthy eating',
          imgSrc:
            '/images/intro/intro11/kitchen-hero-slider-slide-03-image.jpg',
        },
      ],
    };
  },
};
</script>
