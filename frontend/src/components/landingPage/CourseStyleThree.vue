<template>
    <div class="course-section section-padding-top-250 section-padding-bottom">
        <div class="container">
            <div class="row align-items-center mb-xs-40">
                <div class="col-lg-8 col-md-9">
                    <!-- Section Title Start -->
                    <div class="section-title text-left" data-aos="fade-up">
                        <span class="sub-title">Change your life</span>
                        <h2 class="title playfair-font">
                            I have learnt over the years that have <br> brought me much <span>happiness</span> and <span>success.</span>
                        </h2>
                    </div>
                    <!-- Section Title End -->
                </div>
                <div class="col-lg-4 col-md-3 text-md-right text-left">
                    <n-link to="/course/courses-grid-one" class="btn btn-off-white btn-hover-secondary">
                        View all courses
                    </n-link>
                </div>
            </div>

            <div class="row row-25 row-cols-lg-3 row-cols-md-2 row-cols-sm-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="course in courses" :key="course.index">
                    <div class="course-5">
                        <div class="thumbnail">
                            <n-link to="/course/course-details" class="image">
                                <img :src="course.imgSrc" :alt="course.title">
                            </n-link>
                        </div>
                        <div class="info">
                            <h3 class="title">
                                <n-link to="/course/course-details">
                                    {{ course.title }}
                                </n-link>
                            </h3>
                            <span class="price">{{ course.price }}</span>
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
                courses: [
                    {
                        imgSrc: "/images/courses/360/course-1.jpg",
                        title: "Health And Wellness Coaching Certification",
                        price: "$40.00",
                    },
                    {
                        imgSrc: "/images/courses/360/course-2.jpg",
                        title: "Ketogenic Diet Ketosis Nutrition Health Coach Certification",
                        price: "$65.00",
                    },
                    {
                        imgSrc: "/images/courses/360/course-3.jpg",
                        title: "Life Mastery – Be Happy, Healthy And Successful Simplified",
                        price: "$30.00",
                    },
                    {
                        imgSrc: "/images/courses/360/course-4.jpg",
                        title: "Vegan Nutrition Health Coach Certification",
                        price: "$36.00",
                    },
                    {
                        imgSrc: "/images/courses/360/course-5.jpg",
                        title: "Innovating for Dementia, Aging Assessment, and Intervention",
                        price: "$44.00",
                    },
                    {
                        imgSrc: "/images/courses/360/course-6.jpg",
                        title: "Meat and Vegan nutrition for everyday living",
                        price: "$50.00",
                    }
                ]
            }
        }
    };
</script>