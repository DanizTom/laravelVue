<template>
  <div
    class="learn-section section-padding fix"
    :style="{ backgroundColor: '#161821' }"
  >
    <div class="container">
      <div
        class="row row-cols-lg-2 row-cols-md-2 row-cols-1 align-items-center"
      >
        <div class="col">
          <div class="learn-image">
            <img
              src="/images/learner/gym-coaching-intro-image.png"
              alt="learner"
            />

            <ShapeWithAnimation
              addClassName="shape-1"
              data-depth="-3"
              imgSrc="/images/shape-animation/maxcoach-shape-11.png"
            />
            <ShapeWithAnimation addClassName="shape-2" data-depth="4" />
            <ShapeWithAnimation
              addClassName="shape-3"
              data-depth="4"
              imgSrc="/images/shape-animation/maxcoach-shape-10.png"
            />
          </div>
        </div>
        <div class="col">
          <div class="learn-content">
            <!-- Section Title Start -->
            <div
              class="section-title color-light text-left mb-30"
              data-aos="fade-up"
            >
              <span class="sub-title">What you'll learn</span>
              <h2 class="title fz-48">
                Stay At Home <br />
                <span>Become Your</span> Strongest Self
              </h2>
            </div>
            <!-- Section Title End -->

            <ul class="maxcoach-list color-light">
              <li class="item">
                <div class="icon">
                  <i class="fas fa-check"></i>
                </div>
                <div class="text">Choose the right exercises</div>
              </li>
              <li class="item">
                <div class="icon">
                  <i class="fas fa-check"></i>
                </div>
                <div class="text">Combine fitness, nutrition and lifestyle</div>
              </li>
              <li class="item">
                <div class="icon">
                  <i class="fas fa-check"></i>
                </div>
                <div class="text">
                  Demonstrate the correct postures and techniques
                </div>
              </li>
              <li class="item">
                <div class="icon">
                  <i class="fas fa-check"></i>
                </div>
                <div class="text">Achieve a specific goal</div>
              </li>
            </ul>

            <n-link to="/" class="btn btn-primary btn-hover-secondary">
              Get start for free</n-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  components: {
    ShapeWithAnimation: () =>
      import('@/components/landingPage/ShapeWithAnimation'),
  },
};
</script>
