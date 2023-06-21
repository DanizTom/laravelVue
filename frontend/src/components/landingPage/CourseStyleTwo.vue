<template>
    <div class="course-section section-fluid section-padding conttent">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title-two text-center" data-aos="fade-up">
                <span class="sub-title">Let’s Dream Big Together</span>
                <h2 class="title fz-48">Explore How can I help you</h2>
            </div>
            <!-- Section Title End -->

            <div class="row row-cols-xl-4 row-cols-lg-2 row-cols-md-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" v-for="course in courses" :key="course.index" data-aos="fade-up">
                    <div class="course-6">
                        <div class="thumbnail">
                            <n-link to="/course/course-details" class="image">
                                <img :src="course.imgSrc" :alt="course.alt">
                                <div class="course-overlay-bg"></div>
                            </n-link>
                        </div>
                        <div class="info">
                            <div class="course-caption-main">
                                <span class="price">{{ course.price }}</span>
                                <h3 class="title">
                                    <n-link to="/course/course-details">
                                        {{ course.title }}
                                    </n-link>
                                </h3>
                            </div>
                            <div class="course-caption-collapse">
                                <ul class="meta">
                                    <li>
                                        <i class="far fa-file-alt"></i>
                                        {{ course.lessons }}
                                    </li>
                                    <li>
                                        <i class="far fa-user-alt"></i>
                                        {{ course.students }}
                                    </li>
                                </ul>
                                <div class="desc">
                                    <p>{{ course.desc }}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row max-mt-70">
                <div class="text-center col-xl-4 col-lg-7 mx-auto">
                    <n-link to="/course/courses-grid-one" class="link link-lg">
                        Take the control of their life back and start doing things to make their dream come true. 
                        <mark>View all courses 
                            <i class="far fa-long-arrow-right"></i>
                        </mark>
                    </n-link>
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
                        imgSrc: "/images/courses/385/course-1.jpg",
                        alt: "Course Image",
                        price: "$40.00",
                        title: "Learning to Write as a Professional Author",
                        lessons: "20 Lessons",
                        students: "51 Students",
                        desc: "The purpose of this course is to provide the advanced writing techniques commonly used for inspiring readers and…"
                    },
                    {
                        imgSrc: "/images/courses/385/course-2.jpg",
                        alt: "Course Image",
                        price: "Free",
                        title: "Customer-centric Info-Tech Strategies",
                        lessons: "40 Lessons",
                        students: "80 Students",
                        desc: "The purpose of this course is to provide the advanced writing techniques commonly used for inspiring readers and…"
                    },
                    {
                        imgSrc: "/images/courses/385/course-3.jpg",
                        alt: "Course Image",
                        price: "$19.00",
                        title: "Open Programming Courses for Everyone: Python",
                        lessons: "16 Lessons",
                        students: "57 Students",
                        desc: "The purpose of this course is to provide the advanced writing techniques commonly used for inspiring readers and…"
                    },
                    {
                        imgSrc: "/images/courses/385/course-4.jpg",
                        alt: "Course Image",
                        price: "$26.00",
                        title: "Academic Listening and Note-taking",
                        lessons: "20 Lessons",
                        students: "51 Students",
                        desc: "The purpose of this course is to provide the advanced writing techniques commonly used for inspiring readers and…"
                    }
                ]
            }
        }
    };
</script>