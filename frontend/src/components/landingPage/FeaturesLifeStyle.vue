<template>
    <div class="lifestyle-section section section-padding-top section-padding-bottom-200">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title text-center" data-aos="fade-up">
                <span class="sub-title">Together We Can Create</span>
                <h2 class="title playfair-font">Inspring you to live a <span>healthier</span> lifestyle.</h2>
            </div>
            <!-- Section Title End -->

            <div class="row row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="feature in features" :key="feature.index">
                    <div class="health-icon-box text-center">
                        <div class="icon">
                            <img :src="feature.imgSrc" alt="feature.title">
                        </div>
                        <div class="content">
                            <h3 class="title">{{ feature.title }}</h3>
                            <div class="desc">
                                <p>{{ feature.desc }}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row max-mt-50">
                <div class="col text-center">
                    <n-link to="/about-us-one" class="btn btn-off-white btn-hover-secondary margin-15">Learn more </n-link>
                    <n-link to="/contact-us" class="btn btn-primary-two btn-hover-secondary margin-15"> Get started today </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                features: [
                    {
                        title: "Workout Routines",
                        desc: "Research confirm physical routines can improve health during all stage of life",
                        imgSrc: "/images/health/health-coaching-box-image-01.png"
                    },
                    {
                        title: "Nutrition Strategies",
                        desc: "Good food is a life's great pleasures. And for most, good meals are at the heart of family life and celebrations",
                        imgSrc: "/images/health/health-coaching-box-image-02.png"
                    },
                    {
                        title: "Support & Motivation",
                        desc: "Living a healthy lifestyle is a key component to wellness means taking care of you from inside out.",
                        imgSrc: "/images/health/health-coaching-box-image-03.png"
                    }
                ]
            }
        }
    };
</script>