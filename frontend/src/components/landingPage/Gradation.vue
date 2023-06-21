<template>
    <div class="gradation-process-section section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="gradation-title-wrapper mb-50">
                        <!-- Section Title Start -->
                        <div class="section-title text-left mb-0" data-aos="fade-up">
                            <span class="sub-title">Make it <strong>MaxCoach</strong></span>
                            <h2 class="title">4 Steps to Earn <span> the Honour CFDR <br> Certification</span> from courses</h2>
                        </div>
                        <!-- Section Title End -->

                        <div class="gradation-sub-heading" data-aos="fade-up">
                            <h3 class="heading"><mark>04</mark> Steps</h3>
                        </div>
                    </div>

                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ht-gradation style-01">
                        <div class="item item-1" data-aos="fade-up" v-for="gradation in gradationData.slice(0, 4)" :key="gradation.id">
                            <div class="line"></div>
                            <div class="circle-wrap">
                                <div class="mask">
                                    <div class="wave-pulse wave-pulse-1"></div>
                                    <div class="wave-pulse wave-pulse-2"></div>
                                    <div class="wave-pulse wave-pulse-3"></div>
                                </div>
                                <h6 class="circle">{{ gradation.circle }}</h6>
                            </div>

                            <div class="content-wrap">
                                <h5 class="heading">{{ gradation.heading }}</h5>
                                <div class="text">{{ gradation.text }}</div>
                            </div>
                        </div>
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
                gradationData: [
                    {
                        id: 1,
                        circle: "1",
                        heading: "Register for a CFDR preliminary categorized class",
                        text: "CFDR preliminary classes whose names are ended with 101CF. Finishing these classes will bring you the basic knowledge and skills."
                    },
                    {
                        id: 2,
                        circle: "2",
                        heading: "Finished all obligatory subjects in CFDR program",
                        text: "Learners have to finish these subjects within the period of 3 years. Early completion will reward them with a faster certifying process."
                    },
                    {
                        id: 3,
                        circle: "3",
                        heading: "Submit all essential documents & related proof of completion",
                        text: "We need to verify your participation in all subjects included and collect all the scores as well as assessment to grade your certificate."
                    },
                    {
                        id: 4,
                        circle: "4",
                        heading: "Receive printed certification via postal & e-version via emails",
                        text: "We'll send your certificate by postal line in one week after the verification process and also email an electronic version to your inbox."
                    }
                ]
            }
        }
    };
</script>