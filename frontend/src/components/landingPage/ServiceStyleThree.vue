<template>
  <div
    class="service-section section-padding service-shape-animation health-service"
  >
    <div class="container">
      <!-- Section Title Start -->
      <div class="section-title text-center" data-aos="fade-up">
        <span class="sub-title">Do not wait for Tomorrow!</span>
        <h2 class="title playfair-font">
          Health Coaches look at <span>exercise, eating, wellness,</span> <br />
          and <span>food</span> not just as calories and weight loss, but <br />
          also on mental, physical, and spiritual terms.
        </h2>
      </div>
      <!-- Section Title End -->

      <div class="row">
        <div class="col-lg-10 offset-lg-1">
          <div class="row max-mb-n30">
            <div
              class="col-lg-6 col-md-6"
              v-for="service in healthServices"
              :key="service.index"
            >
              <div class="single-health-service max-mb-30">
                <div class="icon">
                  <img :src="service.imgSrc" :alt="service.title" />
                </div>
                <div class="content">
                  <h3 class="title">{{ service.title }}</h3>
                  <div class="description">
                    <ul>
                      <li v-for="list in service.lists" :key="list.index">
                        {{ list }}
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Animation Shape Start -->
      <ShapeWithAnimation
        addClassName="shape-1"
        dataDepth="3"
        imgSrc="/images/service-shape-image/health-coaching-service-image-01.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-2"
        dataDepth="3"
        imgSrc="/images/service-shape-image/health-coaching-service-image-02.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-3"
        dataDepth="3"
        imgSrc="/images/service-shape-image/health-coaching-service-image-03.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-4"
        dataDepth="3"
        imgSrc="/images/service-shape-image/health-coaching-service-image-04.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-5"
        dataDepth="-3"
        imgSrc="/images/service-shape-image/health-coaching-service-image-05.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-6"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-service-image-06.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-7"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-service-image-07.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-8"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-service-image-08.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-9"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-service-image-09.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-10"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-service-image-10.jpg"
      />
      <ShapeWithAnimation
        addClassName="shape-11"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-shape-01.png"
      />
      <ShapeWithAnimation
        addClassName="shape-12"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-shape-02.png"
      />
      <ShapeWithAnimation
        addClassName="shape-13"
        dataDepth="4"
        imgSrc="/images/service-shape-image/health-coaching-shape-03.png"
      />
      <!-- Animation Shape End -->
    </div>
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
      healthServices: [
        {
          imgSrc: '/images/health/health-coaching-service-icon-01.png',
          title: 'Healthy daily life',
          lists: [
            'Movement is key to a healthy life',
            'Plan your meals everyday',
            'Have a bed time routine',
          ],
        },
        {
          imgSrc: '/images/health/health-coaching-service-icon-02.png',
          title: 'Fitness & performance',
          lists: [
            'Eat the right food and portion',
            'Get enough sleep everyday',
            'Work your full-range of motion',
          ],
        },
        {
          imgSrc: '/images/health/health-coaching-service-icon-03.png',
          title: 'Exercise Program',
          lists: [
            'Enjoy the physically activities you choose',
            'Mixing up the exercises to keep them interesting',
            'Exercise is about being healthy and having fun',
          ],
        },
        {
          imgSrc: '/images/health/health-coaching-service-icon-04.png',
          title: 'Improving Health',
          lists: [
            'Exercises can boost your mental health',
            'Take care your mental, emotional well-being',
            'Balance all aspects of your life',
          ],
        },
      ],
    };
  },
};
</script>
