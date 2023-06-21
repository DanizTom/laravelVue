<template>
    <div class="testimonial-section" :style="{ backgroundColor: '#161821' }">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title color-light text-center" data-aos="fade-up">
                <span class="sub-title">Why Do People Love Us?</span>
                <h2 class="title fz-48">We Are Optimists Who Love <br> To <span>Work Together</span></h2>
            </div>
            <!-- Section Title End -->

            <div class="row">
                <div class="col-lg-8 offset-lg-2">
                    <div class="testimonial-slider-wrap">
                        <div class="testimonial-slider-8" data-aos="fade-up">
                            <swiper :options="swiperOptions">
                                <div class="swiper-slide" v-for="(testimonial, index) in testimonials" :key="index">
                                    <div class="static-testimonial testimonial-home-8">
                                        <div class="testimonial-image">
                                            <img :src="testimonial.image" :alt="testimonial.name">
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
                            <div class="swiper-pagination theme-color text-center"></div>
                        </div>

                        <ShapeWithAnimation addClassName="shape-1" data-depth="3" imgSrc="/images/shape-animation/shape-2.svg" />
                        <ShapeWithAnimation addClassName="shape-2" data-depth="4" imgSrc="/images/shape-animation/shape-1.png" />
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
                swiperOptions: {
                    slidesPerView : 1,
                    slidesPerGroup: 1,
                    effect: 'coverflow',
                    loop: true,
                    speed: 1000,
                    spaceBetween : 30,
                    pagination: {
                        el: '.swiper-pagination',
                        type: "bullets",
                        clickable: true,
                    }
                },

                testimonials: [
                    {
                        id: 1,
                        text: "I am happy with their arrangement of lessons and subjects. They reflect a scientific investigation into effective methods to adopt for learners.",
                        name: "HasThemes",
                        position: "Freelancer",
                        image: "/images/testimonial/200/testimonial-avata-01.jpg"
                    },
                    {
                        id: 2,
                        text: "I need to get a certification for English proficiency and MaxCoach is my best choice. Their tutors are smart and professional when dealing with students.",
                        name: "Maya Moni",
                        position: "Frontend Developer",
                        image: "/images/testimonial/200/testimonial-avata-02.jpg"
                    },
                    {
                        id: 3,
                        text: "I need to get a certification for English proficiency and MaxCoach is my best choice. Their tutors are smart and professional when dealing with students.",
                        name: "Madley Pondor",
                        position: "Multimedia Admin",
                        image: "/images/testimonial/200/testimonial-avata-03.jpg"
                    }
                ]
            }
        },
    };
</script>