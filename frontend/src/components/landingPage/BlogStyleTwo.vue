<template>
    <div class="blog-section section-padding blog-2-wrapper" :style="{ backgroundColor: '#f5f1ed' }">
        <div class="container">
            <div class="row row-25 row-cols-lg-3 row-cols-md-2 row-cols-1">
                <div class="col max-mb-30" data-aos="fade-up">
                    <div class="blog-list-post-wrapper">
                        <!-- Section Title Start -->
                        <div class="section-title text-left mt-25 mb-25">
                            <span class="sub-title">Enjoyable insights</span>
                            <h2 class="title">Most Viewed <span> Best Blogs</span></h2>
                        </div>
                        <!-- Section Title End -->
                        <ul class="blog-list-post">
                            <li>
                                <n-link to="/blog/blog-details">Become a Better Blogger: Content Planning</n-link>
                            </li>
                            <li>
                                <n-link to="/blog/blog-details">Promoting Your Online Business on Pinterest</n-link>
                            </li>
                            <li>
                                <n-link to="/blog/blog-details">Gamification and Game-Based Learning</n-link>
                            </li>
                            <li>
                                <n-link to="/blog/blog-details">Designing an Online Course from Expert’s Perspective</n-link>
                            </li>
                            <li>
                                <n-link to="/blog/blog-details">Why Online Courses Are the Future of Education</n-link>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col max-mb-30" data-aos="fade-up">
                    <div class="blog-2">
                        <div class="thumbnail">
                            <n-link to="/blog/blog-details" class="image">
                                <img src="/images/blog/340/blog-01.jpg" alt="Blog Image">
                            </n-link>
                        </div>
                        <div class="info">
                            <n-link to="/blog/blog-details" class="category">Artist</n-link>
                            <h3 class="title">
                                <n-link to="/blog/blog-details">10 Essential Bodyweight Exercises</n-link>
                            </h3>
                            <ul class="meta">
                                <li>
                                    <i class="far fa-calendar"></i>
                                    Apr 06, 2020
                                </li>
                                <li>
                                    <i class="far fa-eye"></i>
                                    70 views
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col max-mb-30" data-aos="fade-up">
                    <div class="blog-2">
                        <div class="thumbnail">
                            <n-link to="/blog/blog-details" class="image">
                                <img src="/images/blog/340/blog-02.jpg" alt="Blog Image">
                            </n-link>
                        </div>
                        <div class="info">
                            <n-link to="/blog/blog-details" class="category">Artist</n-link>
                            <h3 class="title">
                                <n-link to="/blog/blog-details">Pocket-Sized Notebooks Hold Miniature Paintings</n-link>
                            </h3>
                            <ul class="meta">
                                <li>
                                    <i class="far fa-calendar"></i>
                                    Apr 06, 2020
                                </li>
                                <li>
                                    <i class="far fa-eye"></i>
                                    64 views
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>