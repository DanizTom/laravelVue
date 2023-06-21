<template>
    <div class="service-section section-padding bg-f8f8f8">
        <div class="container">
            <!-- Section Title Start -->
            <SectionHeader subTitle="Let’s Dream Big Together" title="Explore How can I help you" alignment="text-center section-title-two" />
            <!-- Section Title End -->

            <div class="service-slider" data-aos="fade-up">
                <swiper :options="swiperOptions">
                    <div class="swiper-slide" v-for="service in services" :key="service.index">
                        <n-link to="/course/courses-grid-one" class="service">
                            <div class="image">
                                <img :src="service.imgSrc" :alt="service.alt">
                            </div>
                            <div class="content">
                                <h3 class="title">{{ service.title }}</h3>
                                <p>{{ service.desc }}</p>
                                <div class="button-wrap">
                                    <span class="link">
                                        Discover now 
                                        <i class="far fa-long-arrow-right"></i>
                                    </span>
                                </div>
                            </div>
                        </n-link>
                    </div>
                </swiper>
                <!-- pagination claas -->
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

        data () {
            return {
                swiperOptions: {
                    loop: true,
                    speed: 1000,
                    autoHeight: true,
                    spaceBetween: 30,
                    slidesPerView: 3,
                    watchSlidesVisibility: true,
                    pagination: {
                        el: '.service-slider .swiper-pagination',
                        type: "bullets",
                        clickable: true,
                    },
                    breakpoints: {
                        1200: {
                            slidesPerView: 3
                        },
                        768: {
                            slidesPerView: 2
                        },
                        320: {
                            slidesPerView: 1
                        }
                    }
                },

                services: [
                    {
                        title: "Consultative Training",
                        imgSrc: "/images/service/business-service-1.jpg",
                        alt: "image",
                        desc: "With a coach addressing multiple issues that are off balance, affecting your business in various unconsidered ways.",
                    },
                    {
                        title: "Real Deal Coaching",
                        imgSrc: "/images/service/business-service-2.jpg",
                        alt: "image",
                        desc: "Brings an exceptionally powerful opportunity. Being able to accept, to work with that opportunity.",
                    },
                    {
                        title: "Advisor Training Program",
                        imgSrc: "/images/service/business-service-3.jpg",
                        alt: "image",
                        desc: "Getting high quality, entrepreneur mindset driven online business coaching, is what is needed.",
                    }
                ]
            }
        }
    };
</script>