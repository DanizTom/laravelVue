<template>
    <div class="intro6-section section" :style="{ backgroundColor: '#1f1f52' }">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="intro6-content text-center">
                        <h1 class="title">Learn At Your Own Pace!</h1>
                        <p>Get teamed up with people of the same will.</p>
                        <a class="btn btn-primary btn-hover-light" href="/images/sample.pdf" target="_blank">
                            Download free guidebook 
                            <i class="far fa-long-arrow-right ml-3"></i>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row align-items-end mb-minus-90">
                <div class="col-md-2 d-none d-md-block">
                    <div class="intro-left-image rellax" 
                        data-rellax-speed="2" 
                        data-rellax-xs-speed="1" 
                        data-rellax-mobile-speed="2" 
                        data-rellax-tablet-speed="2">
                        <img src="/images/intro/intro6/home-6-hero-left-person.png" alt="image">
                    </div>
                </div>
                <div class="col-md-8 col-12">
                    <div class="about-me-video-wrapper">
                        <client-only>
                            <silent-box :image="videos[0]">
                                <template v-slot:silentbox-item>
                                    <div  class="about-me-video video-popup h6-intro-video">
                                        <img class="image" src="/images/video/home-6-hero-poster-final.jpg" alt="image">
                                        <img class="icon" src="/images/icons/icon-youtube-play.png" alt="icon">
                                    </div>
                                </template>
                            </silent-box>
                        </client-only>
                    </div>
                </div>
                <div class="col-md-2 d-none d-md-block">
                    <div class="intro-right-image rellax" 
                        data-rellax-speed="2" 
                        data-rellax-xs-speed="1" 
                        data-rellax-mobile-speed="2" 
                        data-rellax-tablet-speed="2">
                        <img src="/images/intro/intro6/home-6-hero-right-person.png" alt="image">
                    </div>
                </div>
            </div>
        </div>

        <!-- Section Bottom Shape Start -->
        <div class="section-bottom-shape-four">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1000 100" preserveAspectRatio="none">
                <path class="elementor-shape-fill" opacity="0.33" d="M473,67.3c-203.9,88.3-263.1-34-320.3,0C66,119.1,0,59.7,0,59.7V0h1000v59.7 c0,0-62.1,26.1-94.9,29.3c-32.8,3.3-62.8-12.3-75.8-22.1C806,49.6,745.3,8.7,694.9,4.7S492.4,59,473,67.3z"></path>
                <path class="elementor-shape-fill" opacity="0.66" d="M734,67.3c-45.5,0-77.2-23.2-129.1-39.1c-28.6-8.7-150.3-10.1-254,39.1 s-91.7-34.4-149.2,0C115.7,118.3,0,39.8,0,39.8V0h1000v36.5c0,0-28.2-18.5-92.1-18.5C810.2,18.1,775.7,67.3,734,67.3z"></path>
                <path class="elementor-shape-fill" d="M766.1,28.9c-200-57.5-266,65.5-395.1,19.5C242,1.8,242,5.4,184.8,20.6C128,35.8,132.3,44.9,89.9,52.5C28.6,63.7,0,0,0,0 h1000c0,0-9.9,40.9-83.6,48.1S829.6,47,766.1,28.9z"></path>
            </svg>
        </div>
        <!-- Section Bottom Shape End -->
    </div>
</template>

<script>
    import Rellax from "rellax";

    export default {
        data() {
            return {
                videos: [
                    {
                        src: 'https://www.youtube.com/watch?v=eS9Qm4AOOBY',
                        thumbnail: ""
                    }
                ],
            }
        },

        mounted () {
            var rellax = new Rellax(".rellax");
        },
    };
</script>