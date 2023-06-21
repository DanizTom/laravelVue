<template>
  <div
    class="teaching-section section section-padding-top section-padding-bottom-70 bg-f5f5f5"
  >
    <div class="container">
      <div class="row align-items-center">
        <div class="col-xl-8">
          <div class="testimonial-area mb-md-50 mb-sm-30 mb-xs-30">
            <div class="row">
              <div class="col-md-6">
                <!-- Static Testimonial Start -->
                <div class="static-testimonial">
                  <div class="testimonial-image">
                    <img
                      src="/images/testimonial/140/home-4-testimonial-avatar-01.png"
                      alt="image"
                    />
                  </div>
                  <div class="testimonial-content">
                    <p>
                      I love their flexibility. Even when my request is too
                      complicated to handle. they could still suggest something
                      useful for me.
                    </p>
                  </div>
                  <div class="author-info">
                    <div class="cite">
                      <h6 class="name">Florence Themes</h6>
                      <span class="position">/ Multimedia Admin</span>
                    </div>
                  </div>
                </div>
                <!-- Static Testimonial End -->
                <div class="testimonial-modern-heading">
                  <h2 class="title">
                    "Best out of the best in the online coaching field ..."
                  </h2>
                </div>
              </div>
              <div class="col-md-6 pr-100 pr-md-15 pr-sm-15 pr-xs-15">
                <div class="testimonial-rating-area">
                  <div class="rating-number">
                    <h2>4.9/5.0</h2>
                  </div>
                  <div class="testimonial-rating">
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                    <span class="fa fa-star"></span>
                  </div>
                  <div class="rating-content">
                    <p>by 700+ Students for 3200+ Sales</p>
                  </div>
                </div>
                <!-- Static Testimonial Start -->
                <div class="static-testimonial">
                  <div class="testimonial-image">
                    <img
                      src="/images/testimonial/100/home-4-testimonial-avatar-02.png"
                      alt="image"
                    />
                  </div>
                  <div class="testimonial-content">
                    <p>
                      Excellent guiding instructions. They are all great mentors
                      at life & career
                    </p>
                  </div>
                  <div class="author-info">
                    <div class="cite">
                      <h6 class="name">Fannie Moreno</h6>
                      <span class="position">/ Developer</span>
                    </div>
                  </div>
                </div>
                <!-- Static Testimonial End -->
              </div>
            </div>

            <!-- Animation Shape Start -->
            <ShapeWithAnimation
              addClassName="shape-1"
              dataDepth="3"
              imgSrc="/images/shape-animation/shape-2.svg"
            />
            <ShapeWithAnimation
              addClassName="shape-2"
              dataDepth="-3"
              imgSrc="/images/shape-animation/shape-3.png"
            />
            <ShapeWithAnimation addClassName="shape-3" dataDepth="4" />
            <ShapeWithAnimation
              addClassName="shape-4"
              dataDepth="4"
              imgSrc="/images/shape-animation/nwesletter-shape-2.png"
            />
            <!-- Animation Shape End -->
          </div>
        </div>
        <div class="col-xl-4">
          <div class="teaching-content">
            <!-- Section Title Start -->
            <div class="section-title text-left mb-15" data-aos="fade-up">
              <span class="sub-title">Together expand and grow</span>
              <h2 class="title fz-48">Enjoy <span>Our Companionship</span></h2>
            </div>
            <!-- Section Title End -->
            <p>
              As learners, people can enjoy great companionship from MaxCoach
              mentors and educators. We can help you develop and grow at your
              best.
            </p>
            <n-link
              to="/course/courses-grid-one"
              class="btn btn-primary btn-hover-secondary mt-30"
            >
              Get trial courses
            </n-link>
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
