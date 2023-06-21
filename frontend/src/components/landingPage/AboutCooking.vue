<template>
  <div class="cooking-about-section section-padding">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="cooking-about-slider">
            <swiper :options="swiperOptions">
              <div class="swiper-slide">
                <div class="cooking-about-area">
                  <div class="slide-image maxcoach-image">
                    <svg
                      class="image-frame"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <path
                        stroke="#BAD2DE"
                        stroke-width="2"
                        fill="none"
                        d="M386.030035,488.81143 C373.595816,488.437799 363.766055,487.34952 355.221231,486.40405 C347.412451,485.540022 340.668294,484.796172 333.99778,484.810981 C305.201413,484.874911 278.759269,486.081653 254.985173,487.166863 C231.658467,488.231651 210.90449,489.179931 193.020614,488.811191 C131.114472,487.534776 94.1406728,484.882428 82.115496,480.794963 L1,488.70867 L1,1.97325001 L52.9888668,9.82062614 C78.9518751,6.47880224 120.955768,4.81097882 179,4.81097882 C187.259705,4.81097882 195.43365,4.7949173 203.494372,4.77907764 C258.976038,4.6700538 309.088322,4.56626245 344.855201,9.80043989 C355.108391,11.3009068 367.189568,9.09377152 381.305656,6.48659928 C390.646953,4.76130753 400.889323,2.86849373 412.094354,1.80651754 C423.342547,0.740450573 442.31123,0.731456338 469.000012,1.77241485 L469.005761,488.82159 C428.358877,489.255382 400.700297,489.252251 386.030035,488.81143 Z"
                      ></path>
                    </svg>
                    <svg
                      class="image-pattern"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <defs>
                        <pattern
                          id="pattern_b29a159"
                          patternUnits="userSpaceOnUse"
                          width="100%"
                          height="100%"
                        >
                          <image
                            xlink:href="/images/ketchen/ketchen-modern-slide-image-1.jpg"
                            x="0"
                            y="0"
                            width="100%"
                            height="100%"
                            preserveAspectRatio="xMinYMin slice"
                          ></image>
                        </pattern>
                      </defs>
                      <g stroke-width="0" fill="url(#pattern_b29a159)">
                        <path
                          d="M0,0.810978821 L53,8.81097882 C79,5.47764549 121,3.81097882 179,3.81097882 C244.169633,3.81097882 304,2.81097882 345,8.81097882 C361.968282,11.2941421 383.984123,3.46623196 412,0.810978821 C423.408973,-0.270326274 442.742306,-0.270326274 470,0.810978821 L470,489.810979 C428.795464,490.255562 400.795464,490.255562 386,489.810979 C362.23049,489.096738 347.953625,485.780001 334,485.810979 C276.934768,485.937668 229.119825,490.555717 193,489.810979 C131.262618,488.538043 94.2626177,485.871376 82,481.810979 L0,489.810979 L0,0.810978821 Z"
                        ></path>
                      </g>
                    </svg>
                  </div>
                  <div class="slide-content">
                    <div class="slide-decorate-text">01</div>
                    <div class="slide-layers">
                      <h3 class="title">Eat Well Guidance</h3>
                      <p>
                        I create an environment that will support you in
                        achieving the goals you have set for yourself for being
                        successful in the kitchen. You will love your kitchen
                        like never before! I’m here to hold your hand as you
                        learn the skills needed to feel confident and competent.
                      </p>
                      <n-link
                        to="/about-us-one"
                        class="btn btn-primary-three btn-hover-secondary-three"
                        >Show me how</n-link
                      >
                    </div>
                  </div>
                </div>
              </div>

              <div class="swiper-slide">
                <div class="cooking-about-area">
                  <div class="slide-image maxcoach-image">
                    <svg
                      class="image-frame"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <path
                        stroke="#BAD2DE"
                        stroke-width="2"
                        fill="none"
                        d="M386.030035,488.81143 C373.595816,488.437799 363.766055,487.34952 355.221231,486.40405 C347.412451,485.540022 340.668294,484.796172 333.99778,484.810981 C305.201413,484.874911 278.759269,486.081653 254.985173,487.166863 C231.658467,488.231651 210.90449,489.179931 193.020614,488.811191 C131.114472,487.534776 94.1406728,484.882428 82.115496,480.794963 L1,488.70867 L1,1.97325001 L52.9888668,9.82062614 C78.9518751,6.47880224 120.955768,4.81097882 179,4.81097882 C187.259705,4.81097882 195.43365,4.7949173 203.494372,4.77907764 C258.976038,4.6700538 309.088322,4.56626245 344.855201,9.80043989 C355.108391,11.3009068 367.189568,9.09377152 381.305656,6.48659928 C390.646953,4.76130753 400.889323,2.86849373 412.094354,1.80651754 C423.342547,0.740450573 442.31123,0.731456338 469.000012,1.77241485 L469.005761,488.82159 C428.358877,489.255382 400.700297,489.252251 386.030035,488.81143 Z"
                      ></path>
                    </svg>
                    <svg
                      class="image-pattern"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <defs>
                        <pattern
                          id="pattern_a7bc2be"
                          patternUnits="userSpaceOnUse"
                          width="100%"
                          height="100%"
                        >
                          <image
                            xlink:href="/images/ketchen/ketchen-modern-slide-image-2.jpg"
                            x="0"
                            y="0"
                            width="100%"
                            height="100%"
                            preserveAspectRatio="xMinYMin slice"
                          ></image>
                        </pattern>
                      </defs>
                      <g stroke-width="0" fill="url(#pattern_a7bc2be)">
                        <path
                          d="M0,0.810978821 L53,8.81097882 C79,5.47764549 121,3.81097882 179,3.81097882 C244.169633,3.81097882 304,2.81097882 345,8.81097882 C361.968282,11.2941421 383.984123,3.46623196 412,0.810978821 C423.408973,-0.270326274 442.742306,-0.270326274 470,0.810978821 L470,489.810979 C428.795464,490.255562 400.795464,490.255562 386,489.810979 C362.23049,489.096738 347.953625,485.780001 334,485.810979 C276.934768,485.937668 229.119825,490.555717 193,489.810979 C131.262618,488.538043 94.2626177,485.871376 82,481.810979 L0,489.810979 L0,0.810978821 Z"
                        ></path>
                      </g>
                    </svg>
                  </div>
                  <div class="slide-content">
                    <div class="slide-decorate-text">02</div>
                    <div class="slide-layers">
                      <h3 class="title">Master cooking skills</h3>
                      <p>
                        The goal of MaxCoach Kitchen Coach is to educate,
                        motivate and inspire by teaching you how to prepare,
                        cook, and eat the best plant-based food in the world!
                        The food philosophy of the MaxCoach Kitchen Coach is:
                        Prepare food that is fresh & fantastic tasting.
                      </p>
                      <n-link
                        to="/about-us-one"
                        class="btn btn-primary-three btn-hover-secondary-three"
                      >
                        Go cooking now
                      </n-link>
                    </div>
                  </div>
                </div>
              </div>

              <div class="swiper-slide">
                <div class="cooking-about-area">
                  <div class="slide-image maxcoach-image">
                    <svg
                      class="image-frame"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <path
                        stroke="#BAD2DE"
                        stroke-width="2"
                        fill="none"
                        d="M386.030035,488.81143 C373.595816,488.437799 363.766055,487.34952 355.221231,486.40405 C347.412451,485.540022 340.668294,484.796172 333.99778,484.810981 C305.201413,484.874911 278.759269,486.081653 254.985173,487.166863 C231.658467,488.231651 210.90449,489.179931 193.020614,488.811191 C131.114472,487.534776 94.1406728,484.882428 82.115496,480.794963 L1,488.70867 L1,1.97325001 L52.9888668,9.82062614 C78.9518751,6.47880224 120.955768,4.81097882 179,4.81097882 C187.259705,4.81097882 195.43365,4.7949173 203.494372,4.77907764 C258.976038,4.6700538 309.088322,4.56626245 344.855201,9.80043989 C355.108391,11.3009068 367.189568,9.09377152 381.305656,6.48659928 C390.646953,4.76130753 400.889323,2.86849373 412.094354,1.80651754 C423.342547,0.740450573 442.31123,0.731456338 469.000012,1.77241485 L469.005761,488.82159 C428.358877,489.255382 400.700297,489.252251 386.030035,488.81143 Z"
                      ></path>
                    </svg>
                    <svg
                      class="image-pattern"
                      width="470px"
                      height="491px"
                      viewBox="0 0 470 491"
                      version="1.1"
                      xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink"
                    >
                      <defs>
                        <pattern
                          id="pattern_493262e"
                          patternUnits="userSpaceOnUse"
                          width="100%"
                          height="100%"
                        >
                          <image
                            xlink:href="/images/ketchen/ketchen-modern-slide-image-3.jpg"
                            x="0"
                            y="0"
                            width="100%"
                            height="100%"
                            preserveAspectRatio="xMinYMin slice"
                          ></image>
                        </pattern>
                      </defs>
                      <g stroke-width="0" fill="url(#pattern_493262e)">
                        <path
                          d="M0,0.810978821 L53,8.81097882 C79,5.47764549 121,3.81097882 179,3.81097882 C244.169633,3.81097882 304,2.81097882 345,8.81097882 C361.968282,11.2941421 383.984123,3.46623196 412,0.810978821 C423.408973,-0.270326274 442.742306,-0.270326274 470,0.810978821 L470,489.810979 C428.795464,490.255562 400.795464,490.255562 386,489.810979 C362.23049,489.096738 347.953625,485.780001 334,485.810979 C276.934768,485.937668 229.119825,490.555717 193,489.810979 C131.262618,488.538043 94.2626177,485.871376 82,481.810979 L0,489.810979 L0,0.810978821 Z"
                        ></path>
                      </g>
                    </svg>
                  </div>
                  <div class="slide-content">
                    <div class="slide-decorate-text">03</div>
                    <div class="slide-layers">
                      <h3 class="title">Help you love the dish</h3>
                      <p>
                        All of our classes are created with you in mind. We want
                        to help you develop your skills so you can competently
                        and confidently prepare delicious, nutritious meals for
                        yourself, your family, and friends. You are going to
                        learn all you need to know about health & vibrant
                        living.
                      </p>
                      <n-link
                        to="/about-us-one"
                        class="btn btn-primary-three btn-hover-secondary-three"
                      >
                        Get started today
                      </n-link>
                    </div>
                  </div>
                </div>
              </div>
            </swiper>
            <div class="swiper-pagination text-center"></div>
          </div>
        </div>
      </div>
    </div>
    <!-- Animation Shape Start -->
    <ShapeWithAnimation
      addClassName="shape-1"
      data-depth="3"
      imgSrc="/images/shape-animation/kitchen-shape-apple.png"
    />
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
      swiperOptions: {
        watchSlidesVisibility: true,
        loop: true,
        speed: 1000,
        spaceBetween: 30,
        pagination: {
          el: '.swiper-pagination',
          type: 'bullets',
          clickable: true,
        },
      },
    };
  },
};
</script>
