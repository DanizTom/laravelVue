<template>
    <div class="section-padding">
        <div class="container">
            <!-- Section Title Start -->
            <SectionHeader alignment="text-center" subTitle="Start Learning Coding Languages" title="Build Your Dream <span>TODAY</span>" />
            <!-- Section Title End -->

            <!-- Feature Wrapper Start -->
            <div class="row row-cols-xl-4 row-cols-sm-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="course in courses" :key="course.title">
                    <n-link to="/course/courses-grid-one" class="icon-box h5-icon-box text-center">
                        <div class="icon">
                            <img :src="course.imgSrc" :alt="course.alt">
                        </div>
                        <div class="content">
                            <h3 class="title">{{ course.title }}</h3>
                            <div class="desc">
                                <p>{{ course.desc }}</p>
                            </div>
                            <span class="link">
                                Start here 
                                <i class="far fa-long-arrow-right"></i>
                            </span>
                        </div>
                    </n-link>
                </div>
            </div>
            <!-- Feature Wrapper End -->

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
                courses: [
                    {
                        title: "Idea Discussion",
                        desc: "Get teamed up with the specialists who work and teach coding for years at famous universities.",
                        imgSrc: "/images/learner/home-5-image-box-01.png",
                        alt: "icon"
                    },
                    {
                        title: "Web Development",
                        desc: "Learn to start building a webpage from scratch. You decide your own pace, course and speed.",
                        imgSrc: "/images/learner/home-5-image-box-02.png",
                        alt: "icon"
                    },
                    {
                        title: "System Administration",
                        desc: "Learners are encouraged to study the mechanism and structure of system administration.",
                        imgSrc: "/images/learner/home-5-image-box-03.png",
                        alt: "icon"
                    },
                    {
                        title: "Graphic Design",
                        desc: "Have a passion for graphics and arts? Show your talents with confidence and self-assertiveness.",
                        imgSrc: "/images/learner/home-5-image-box-04.png",
                        alt: "icon"
                    }
                ]
            }
        }
    };
</script>