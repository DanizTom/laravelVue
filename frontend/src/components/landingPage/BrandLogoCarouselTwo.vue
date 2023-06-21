<template>
    <div class="brand-section section-padding-bottom">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="brand-wrapper">
                        <div class="brand-list">
                            <div class="brand-carousel" data-aos="fade-up">
                                <swiper :options="swiperOption">
                                    <div class="swiper-slide brand brand-colored" v-for="brand in brands" :key="brand.id">
                                        <n-link to="/">
                                            <img :src="brand.logo" :alt="brand.alt">
                                        </n-link>
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
        data () {
            return {
                swiperOption: {
                    loop: true,
                    speed: 1000,
                    autoplay: true,
                    // Responsive breakpoints
                    breakpoints: {
                        992:{
                            slidesPerView : 6
                        },
                        768:{
                            slidesPerView : 4
                        },
                        576:{
                            slidesPerView : 3
                        },
                        300:{
                            slidesPerView : 2
                        }
                    }
                },

                brands: [
                    {
                        id: 1,
                        logo: "/images/brand/client-logo-colored-01.png",
                        alt: "brand logo",
                    },
                    {
                        id: 2,
                        logo: "/images/brand/client-logo-colored-02.png",
                        alt: "brand logo",
                    },
                    {
                        id: 3,
                        logo: "/images/brand/client-logo-colored-03.png",
                        alt: "brand logo",
                    },
                    {
                        id: 4,
                        logo: "/images/brand/client-logo-colored-04.png",
                        alt: "brand logo",
                    },
                    {
                        id: 5,
                        logo: "/images/brand/client-logo-colored-05.png",
                        alt: "brand logo",
                    },
                    {
                        id: 6,
                        logo: "/images/brand/client-logo-colored-06.png",
                        alt: "brand logo",
                    },
                    {
                        id: 7,
                        logo: "/images/brand/client-logo-07.png",
                        alt: "brand logo",
                    }
                ]
            }
        }
    };
</script>