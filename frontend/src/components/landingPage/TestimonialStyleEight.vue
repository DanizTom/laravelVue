<template>
  <div class="testimonial-section health-section-bg section-padding">
    <div class="container-fluid">
      <div class="row align-items-center">
        <div class="col-lg-6 col-12 order-2 order-lg-1">
          <div class="health-testimonial-wrapper">
            <div class="health-testimonial">
              <div class="testimonial-quote">
                <img src="/images/icons/testimonial-quote.png" alt="image" />
              </div>
              <div class="testimonial-content">
                <h2>
                  I’m now kinder to myself and am happier, not just because I
                  lost weight, but because I learned to appreciate and take care
                  of myself.
                </h2>
                <div class="cite">
                  <h6 class="name">Maggie Strickland</h6>
                  <span class="position">Marketer in Seattle</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-12 order-1 order-lg-2">
          <div class="health-testimonial-image-wrapper">
            <div class="health-testimonial-slider">
              <swiper :options="swiperOption">
                <div
                  class="health-testimonial-image swiper-slide"
                  v-for="image in images"
                  :key="image.index"
                >
                  <img :src="image.imgSrc" :alt="image.alt" />
                </div>
              </swiper>
              <!-- pagination class -->
              <div class="swiper-pagination text-center"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Animation Shape Start -->
    <ShapeWithAnimation
      addClassName="shape-1"
      dataDepth="3"
      imgSrc="/images/shape-animation/health-coaching-shape-04.png"
    />
    <ShapeWithAnimation
      addClassName="shape-2"
      dataDepth="3"
      imgSrc="/images/shape-animation/health-coaching-shape-03.png"
    />
    <ShapeWithAnimation
      addClassName="shape-3"
      dataDepth="3"
      imgSrc="/images/shape-animation/health-coaching-shape-01.png"
    />
    <ShapeWithAnimation
      addClassName="shape-4"
      dataDepth="3"
      imgSrc="/images/shape-animation/health-coaching-shape-02.png"
    />
    <!-- Animation Shape Start -->
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
        speed: 1000,
        spaceBetween: 30,
        effect: 'coverflow',
        pagination: {
          el: '.swiper-pagination',
          type: 'bullets',
          clickable: true,
        },
      },

      images: [
        {
          imgSrc:
            '/images/testimonial/695/health-coaching-testimonial-image-01.jpg',
          alt: 'image',
        },
        {
          imgSrc:
            '/images/testimonial/695/health-coaching-testimonial-image-02.jpg',
          alt: 'image',
        },
        {
          imgSrc:
            '/images/testimonial/695/health-coaching-testimonial-image-03.jpg',
          alt: 'image',
        },
      ],
    };
  },
};
</script>
