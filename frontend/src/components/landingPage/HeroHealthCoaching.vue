<template>
    <div class="intro7-section-wrap intro7-slider">
        <swiper :options="swiperOption">
            <div class="swiper-slide" v-for="hero in heroItems" :key="hero.index">
                <div class="intro7-section" >
                    <div class="intro7-section-bg bg-cover" :style="{backgroundImage: `url('${hero.bgImgSrc}')`}"></div>
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <div class="intro7-content text-center">
                                    <span class="sub-title">{{ hero.subTitle }}</span>
                                    <h1 class="title" v-html="hero.title"></h1>
                                    <n-link to="/contact-us" class="btn btn-primary-two btn-hover-secondary">Get started today</n-link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </swiper>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                swiperOption: {
                    loop: true,
                    speed: 1500,
                    spaceBetween: 30,
                    autoplay: {
                        delay: 7000,
                    },
                },

                heroItems: [
                    {
                        subTitle: "Change your life",
                        title: "Health Coaching <br> Just Got <span>Easier!</span>",
                        bgImgSrc: "/images/intro/intro7/hero-slider-slide-bg-01.jpg",
                    },
                    {
                        subTitle: "Spread Health and Happiness",
                        title: "Spark the <span>Change,</span> first for you, then for others",
                        bgImgSrc: "/images/intro/intro7/hero-slider-slide-bg-02.jpg",
                    }
                ]
            }
        }
    };
</script>