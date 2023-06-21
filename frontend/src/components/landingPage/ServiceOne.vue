<template>
    <div class="service-section section-padding bg-pattern" :style="{ backgroundImage: `url('/images/bg/background-pattern-grid-line.png')` }">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <div class="row">
                        <div class="col-12 grid-item">
                            <div class="single-service" :style="{ backgroundImage: `url('/images/service/home-6-service-image-01.png')` }">
                                <div class="service-content">
                                    <h3 class="title">Graphic Design</h3>
                                    <p>Have a passion for graphics and arts? Show your talents with confidence and self-assertiveness.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 grid-item">
                            <div class="single-service" :style="{ backgroundImage: `url('/images/service/home-6-service-image-03.png')` }">
                                <div class="service-content">
                                    <h3 class="title">Idea Discussion</h3>
                                    <p>Get teamed up with the specialists who work and teach coding for years at famous universities.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 max-mt-100">
                    <div class="row">
                        <div class="col-12 grid-item">
                            <div class="single-service" :style="{ backgroundImage: `url('/images/service/home-6-service-image-02.png')` }">
                                <div class="service-content">
                                    <h3 class="title">Business Administration</h3>
                                    <p>Learners are encouraged to study the mechanism and structure of system administration.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 grid-item">
                            <div class="single-service" :style="{ backgroundImage: `url('/images/service/home-6-service-image-04.png')` }">
                                <div class="service-content">
                                    <h3 class="title">Web Development</h3>
                                    <p>Learn to start building a webpage from scratch. You decide your own pace, course and speed.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 pl-85 pl-md-15 pl-sm-15 pl-xs-15">
                    <div class="service-content">
                        <!-- Section Title Start -->
                        <div class="section-title text-left mb-30" data-aos="fade-up">
                            <span class="sub-title">Together We Can Create</span>
                            <h2 class="title fz-48">Services We <span>Can Provide</span> For My Clients.</h2>
                        </div>
                        <!-- Section Title End -->

                        <ul class="maxcoach-list">
                            <li class="item" v-for="item in serviceFeatures" :key="item.id">
                                <div class="icon">
                                    <i class="fas fa-check"></i>
                                </div>
                                <div class="text">{{ item }}</div>
                            </li>
                        </ul>

                        <n-link to="/contact-us" class="btn btn-primary btn-hover-secondary"> Get started for free</n-link>
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
                serviceFeatures: [
                    "Select & customize courses to your preferences",
                    "Change the tutor and make arrangements",
                    "Participate in events to join others",
                    "Get the desired certificate delivered at house"
                ]
            }
        }
    };
</script>