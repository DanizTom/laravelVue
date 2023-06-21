<template>
    <div class="section-padding-bottom" :style="{ backgroundColor: '#161821' }">
        <div class="container">

            <!-- Section Title Start -->
            <div class="section-title color-light text-center" data-aos="fade-up">
                <span class="sub-title">Wanna transform your life?</span>
                <h2 class="title fz-48">Latest Online <span>Courses</span></h2>
            </div>
            <!-- Section Title End -->

            <!-- Course Wrapper Start -->
            <div class="row row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
                <!-- Course Start -->
                <div class="col max-mb-30" data-aos="fade-up" v-for="(course, index) in courses" :key="index" >
                    <div class="course-4 dark-mode">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <n-link to="/course/course-details" class="image">
                                    <img :src="course.imgSrc" :alt="course.title">
                                </n-link>
                            </div>
                        </div>
                        <div class="info">
                            <span class="price">${{ course.price }}</span>
                            <div class="course-instructor">
                                <div class="instructor-avatar">
                                    <img :src="course.instructorImgSrc" :alt="course.instructorName">
                                </div>
                                <span class="instructor-name">{{ course.instructorName }}</span>
                            </div>
                            <h3 class="title">
                                <n-link to="/course/course-details">{{ course.title }}</n-link>
                            </h3>
                            <ul class="meta">
                                <li>
                                    <i class="far fa-file-alt"></i>
                                    {{ course.lesson }} Lessons
                                </li>
                                <li>
                                    <i class="far fa-user-alt"></i>
                                    {{ course.student }} Students
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Course End -->
            </div>
            <!-- Course Wrapper End -->

            <div class="row max-mt-40">
                <div class="text-center col-lg-7 mx-auto">
                    <n-link to="/course/courses-grid-one" class="btn btn-primary btn-hover-secondary"> 
                        View all courses
                        <i class="far fa-long-arrow-right ml-3"></i>
                    </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                courses: [
                    {
                        id: 1,
                        imgSrc: "/images/courses/370/course-11.jpg",
                        title: "Complete Fitness Trainer: Beginner to Advanced",
                        instructorImgSrc: "/images/courses/course-avatar2.jpeg",
                        instructorName: "Maya Parboti",
                        price: 49,
                        lesson: 32,
                        student: 50,
                    },
                    {
                        id: 2,
                        imgSrc: "/images/courses/370/course-12.jpg",
                        title: "Lazy Dancer Ballet Burn – 30 days programme",
                        instructorImgSrc: "/images/courses/course-avatar.jpeg",
                        instructorName: "Maggie Strickland",
                        price: 99,
                        lesson: 45,
                        student: 70,
                    },
                    {
                        id: 3,
                        imgSrc: "/images/courses/370/course-13.jpg",
                        title: "Open Programming Courses for Everyone: Python",
                        instructorImgSrc: "/images/courses/course-avatar2.jpeg",
                        instructorName: "Blanche Fields",
                        price: 39,
                        lesson: 16,
                        student: 57,
                    },
                    {
                        id: 4,
                        imgSrc: "/images/courses/370/course-14.jpg",
                        title: "The Ultimate Bodyweight Workout For Warriors",
                        instructorImgSrc: "/images/courses/course-avatar.jpeg",
                        instructorName: "Maggie Strickland",
                        price: 69,
                        lesson: 14,
                        student: 67,
                    },
                    {
                        id: 5,
                        imgSrc: "/images/courses/370/course-15.jpg",
                        title: "Use Your Health & Fitness Expertise to Earn A Living Online",
                        instructorImgSrc: "/images/courses/course-avatar2.jpeg",
                        instructorName: "Baraka Hisham",
                        price: 39,
                        lesson: 16,
                        student: 57,
                    },
                    {
                        id: 6,
                        imgSrc: "/images/courses/370/course-16.jpg",
                        title: "Calisthenics Masterclass for Beginners guys",
                        instructorImgSrc: "/images/courses/course-avatar.jpeg",
                        instructorName: "Maria Maya",
                        price: 69,
                        lesson: 14,
                        student: 67,
                    }
                ]
            }
        },
    };
</script>