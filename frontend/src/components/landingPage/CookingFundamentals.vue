<template>
    <div class="cooking-fundamentals-section section-padding">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title-five text-center" data-aos="fade-up">
                <h2 class="title">Healthy Cooking Fundamentals That Save Time, Money & Stress</h2>
            </div>
            <!-- Section Title End -->

            <div class="row row-cols-lg-4 row-cols-md-2 row-cols-sm-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" v-for="(feature, index) in CookingFeatures" :key="index">
                    <div class="coaching-box cooking-box text-center">
                        <div class="image">
                            <img :src="feature.imgSrc" :alt="feature.title">
                        </div>
                        <div class="content">
                            <h3 class="title">{{ feature.title }}</h3>
                            <p>{{ feature.desc }}</p>
                        </div>
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
                CookingFeatures: [
                    {
                        id: 1,
                        imgSrc: "/images/ketchen/ketchen-box-image-1.png",
                        title: "Online Coures",
                        desc: "You can learn any lesson on-the-go. You will be more confident creating your own healthy meals"
                    },
                    {
                        id: 2,
                        imgSrc: "/images/ketchen/ketchen-box-image-2.png",
                        title: "One to One",
                        desc: "This one-to-one course is made to help you learn & cook exactly everything you need"
                    },
                    {
                        id: 3,
                        imgSrc: "/images/ketchen/ketchen-box-image-3.png",
                        title: "Master Skills",
                        desc: "Your skills will be upgraded at any level you are. We will make a 30 minutes phone-assistance before start"
                    },
                    {
                        id: 4,
                        imgSrc: "/images/ketchen/ketchen-box-image-4.png",
                        title: "Recipes",
                        desc: "We create a special recipe plan based on your interest & health-situation to make sure you'll love it"
                    }
                ]
            }
        },
    };
</script>

<style lang="scss">
    .cooking-fundamentals-section {
        background-color: #f1f4f2;
    }
    .dark-mode {
        .cooking-fundamentals-section {
            background-color: $bg-dark-secondary;
        }
    }
</style>