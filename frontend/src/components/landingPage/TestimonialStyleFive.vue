<template>
  <div class="testimonial-section" :class="addClassName" :style="bgImg">
    <div class="container animation-shape">
      <div class="row">
        <div class="col-lg-12">
          <div class="testimonial-slider-three">
            <swiper :options="swiperOption">
              <div
                class="swiper-slide"
                v-for="testimonial in testimonials"
                :key="testimonial.id"
              >
                <div class="testimonial-four">
                  <div class="content">
                    <h3 class="title">{{ testimonial.text }}</h3>
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
          </div>
        </div>
      </div>

      <!-- Animation Shape Start -->
      <ShapeWithAnimation addClassName="shape-1" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-2" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-3" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-4" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-5" dataDepth="4" />
      <ShapeWithAnimation addClassName="shape-6" dataDepth="4" />
      <!-- Animation Shape End -->
    </div>
  </div>
</template>

<script>
export default {
  props: ['addClassName', 'bgImg'],

  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },

  data() {
    return {
      swiperOption: {
        slidesPerView: 1,
        speed: 1000,
        loop: true,
      },

      testimonials: [
        {
          name: 'Uzzal Hossain',
          position: 'Front-end Developer',
          text: 'I am happy with their arrangement of lessons and subjects. They reflect a scientific investigation.',
        },
        {
          name: 'Hossain Uzzal',
          position: 'Vue JS Developer',
          text: "I'm a very strict person so I require everything to be organized and neat. MaxCoach guys just got me.",
        },
      ],
    };
  },
};
</script>
