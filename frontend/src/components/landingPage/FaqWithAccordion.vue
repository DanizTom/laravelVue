<template>
    <div class="faq-section section section-padding-bottom position-relative">
        <div class="container">
            <div class="row row-cols-lg-2 row-cols-1 align-items-center">
                <div class="col">
                    <div class="faq-left-image">
                        <img src="/images/about/about03/about-us-03-image-01.png" alt="about">

                        <!-- Animation Shape Start -->
                        <div class="shape shape-1 scene">
                            <span data-depth="3">
                                <img src="/images/shape-animation/shape-2.svg" alt="" class="svgInject">
                            </span>
                        </div>
                        <!-- Animation Shape End -->
                    </div>
                </div>
                <div class="col">
                    <div class="faq-content-area">
                        <!-- Section Title Start -->
                        <div class="section-title text-left mb-50" data-aos="fade-up">
                            <span class="sub-title">Everything <strong>MaxCoach</strong></span>
                            <h2 class="title fz-48">Construct A <span>Stunning</span> Career Perspective</h2>
                        </div>
                        <!-- Section Title End -->

                        <AccordionStyleOne />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            AccordionStyleOne: () => import('@/components/AccordionStyleOne'),
        },
    };
</script>