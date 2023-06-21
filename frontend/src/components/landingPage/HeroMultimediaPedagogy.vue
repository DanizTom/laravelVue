<template>
    <div class="intro4-section section-fluid" :style="{backgroundImage: `url('/images/intro/intro4/bg-1.jpg')`}">
        <div class="container">
            <div class="row">
                <!-- Intro One Content Start -->
                <div class="col-12">
                    <div class="intro4-content headline-active text-center">
                        <vue-typed-js class="justify-content-center"
                            :strings="['Positively', 'Intensively', 'Extensively']" 
                            :loop="true" 
                            :typeSpeed="150"
                            :showCursor="false">
                            <h1 class="title ah-headline">Expand Your Possibilities <span class="typing"></span></h1>
                        </vue-typed-js>
                        <p>Reach out to the most competent & passionate mentors</p>
                        <n-link to="/contact-us" class="btn btn-light btn-hover-primary">
                            Free consultation
                        </n-link>
                        <a href="https://www.youtube.com/watch?v=eS9Qm4AOOBY" target="_blank" class="btn btn-outline-light btn-hover-primary video-popup">
                            <i class="fas fa-play mr-3"></i> 
                            How we work 
                        </a>
                    </div>
                </div>
                <!-- Intro One Content End -->
            </div>
        </div>

        <!-- Section Bottom Shape Start -->
        <div class="section-bottom-shape fill-color-gray">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none" height="100">
                <path class="elementor-shape-fill" d="M 0 0 L0 100 L100 100 L100 0 Q 50 200 0 0"></path>
            </svg>
        </div>
        <!-- Section Bottom Shape End -->
    </div>
</template>