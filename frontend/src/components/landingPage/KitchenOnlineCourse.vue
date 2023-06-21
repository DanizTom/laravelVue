<template>
    <div class="section-padding section-fluid-two">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title-four text-center" data-aos="fade-up">
                <span class="sub-title">Made Fresh Weekly</span>
                <h2 class="title">Latest Online Courses</h2>
            </div>
            <!-- Section Title End -->

            <!-- Course Wrapper Start -->
            <div class="row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="(post, index) in kitchenOnlineCourses" :key="index">
                    <div class="course-7 course-fluid">
                        <div class="thumbnail">
                            <n-link to="/course/course-details" class="image">
                                <img :src="post.imgSrc" :alt="post.title">
                            </n-link>
                        </div>
                        <div class="info">
                            <span class="price">{{ post.price }}</span>
                            <h3 class="title">
                                <n-link to="/course/course-details">{{ post.title }}</n-link>
                            </h3>
                            <ul class="meta">
                                <li><i class="far fa-file-alt"></i>{{ post.lessons }} Lessons</li>
                                <li><i class="far fa-user-alt"></i>{{ post.students }} Students</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Course Wrapper End -->

            <div class="row max-mt-40">
                <div class="text-center col-lg-7 mx-auto">
                    <n-link to="/course/courses-grid-one" class="btn btn-primary-three btn-hover-secondary-three"> 
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
                kitchenOnlineCourses: [
                    {
                        "id": 1,
                        "imgSrc": "/images/courses/330/kitchen-course-1.jpg",
                        "price": "$13.00",
                        "title": "Reboot Family’s Eating Habit in a Practical & Real LifeWay",
                        "lessons": 4,
                        "students": 51
                    },
                    {
                        "id": 2,
                        "imgSrc": "/images/courses/330/kitchen-course-2.jpg",
                        "price": "$19.00",
                        "title": "Ketogenic Diet Ketosis Nutrition Health Coach Certification",
                        "lessons": 11,
                        "students": 59
                    },
                    {
                        "id": 3,
                        "imgSrc": "/images/courses/330/kitchen-course-3.jpg",
                        "price": "$35.00",
                        "title": "Gluten-Free & Paleo Family Meals For Diet Persons",
                        "lessons": 7,
                        "students": 28
                    },
                    {
                        "id": 4,
                        "imgSrc": "/images/courses/330/kitchen-course-4.jpg",
                        "price": "$99.00",
                        "title": "Professional Cooking Class For Senior Chefs",
                        "lessons": 14,
                        "students": 51
                    },
                    {
                        "id": 5,
                        "imgSrc": "/images/courses/330/kitchen-course-5.jpg",
                        "price": "$25.00",
                        "title": "Master The Art of Indian Cooking – Indian Culinary World",
                        "lessons": 5,
                        "students": 33
                    },
                    {
                        "id": 6,
                        "imgSrc": "/images/courses/330/kitchen-course-6.jpg",
                        "price": "$44.00",
                        "title": "Life Mastery – Be Happy, Healthy And Successful Simplified",
                        "lessons": 9,
                        "students": 51
                    },
                    {
                        "id": 7,
                        "imgSrc": "/images/courses/330/kitchen-course-7.jpg",
                        "price": "$25.00",
                        "title": "How to Make the Perfect Cup – Become a Coffee Expert",
                        "lessons": 8,
                        "students": 43
                    },
                    {
                        "id": 8,
                        "imgSrc": "/images/courses/330/kitchen-course-8.jpg",
                        "price": "$19.00",
                        "title": "Get Your Dream Body – Weight Loss & Nutrition",
                        "lessons": 8,
                        "students": 66
                    },
                ]
            }
        },
    };
</script>