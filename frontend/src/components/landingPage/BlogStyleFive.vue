<template>
    <div class="blog-section section-padding" :style="{ backgroundColor: '#161821' }">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title color-light text-center" data-aos="fade-up">
                <span class="sub-title">Wanna transform your life?</span>
                <h2 class="title fz-48">Latest From <span>The Blog</span></h2>
            </div>
            <!-- Section Title End -->
            <div class="row">
                <div class="col-lg-6">
                    <!-- Blog Start -->
                    <div class="blog-4" data-aos="fade-up">
                        <div class="thumbnail">
                            <n-link to="/blog/blog-details" class="image">
                                <img src="/images/blog/570/blog-1.jpg" alt="Blog Image">
                            </n-link>
                            <div class="post-overlay-content">
                                <ul class="meta">
                                    <li>
                                        <n-link to="/blog/blog-details" class="category">Gym Coaching</n-link>
                                    </li>
                                    <li>
                                        <i class="far fa-calendar"></i>Apr 06, 2020
                                    </li>
                                    <li>
                                        <i class="far fa-eye"></i>70 views
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="info">
                            <h3 class="title">
                                <n-link to="/blog/blog-details">10 Essential Bodyweight Exercises</n-link>
                            </h3>
                            <div class="desc">
                                <p>Essential bodyweight exercises are crucial to a well-rounded training routine because they’re versatile and can be done anywhere…</p>
                            </div>
                            <n-link to="/blog/blog-details" class="blog-btn link link-lg"> 
                                <mark>Read more <i class="far fa-long-arrow-right"></i> </mark>
                            </n-link>
                        </div>
                    </div>
                    <!-- Blog End -->
                </div>
                <div class="col-lg-6">
                    <div class="blog-list-wrap">
                        <div class="single-blog-list">
                            <div class="thumbnail">
                                <n-link to="/blog/blog-details" class="image">
                                    <img src="/images/blog/200/blog-1.jpg" alt="Blog Image">
                                </n-link>
                            </div>
                            <div class="info">
                                <ul class="meta">
                                    <li><i class="far fa-calendar"></i>May 15, 2020</li>
                                    <li><i class="far fa-eye"></i>52 views</li>
                                </ul>
                                <h3 class="title">
                                    <n-link to="/blog/blog-details">How to Keep Workouts Fresh in the New Year</n-link>
                                </h3>
                            </div>
                        </div>

                        <div class="single-blog-list">
                            <div class="thumbnail">
                                <n-link to="/blog/blog-details" class="image">
                                    <img src="/images/blog/200/blog-2.jpg" alt="Blog Image">
                                </n-link>
                            </div>
                            <div class="info">
                                <ul class="meta">
                                    <li><i class="far fa-calendar"></i>Jun 18, 2020</li>
                                    <li><i class="far fa-eye"></i>98 views</li>
                                </ul>
                                <h3 class="title">
                                    <n-link to="/blog/blog-details">Approved Foods to Support a Healthy Immune System</n-link>
                                </h3>
                            </div>
                        </div>

                        <div class="single-blog-list">
                            <div class="thumbnail">
                                <n-link to="/blog/blog-details" class="image">
                                    <img src="/images/blog/200/blog-3.jpg" alt="Blog Image">
                                </n-link>
                            </div>
                            <div class="info">
                                <ul class="meta">
                                    <li><i class="far fa-calendar"></i>Dec 26, 2020</li>
                                    <li><i class="far fa-eye"></i>85 views</li>
                                </ul>
                                <h3 class="title">
                                    <n-link to="/blog/blog-details">Self-care And Stress Management</n-link>
                                </h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>