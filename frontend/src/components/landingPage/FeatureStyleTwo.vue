<template>
    <div class="section-padding">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title-two text-center" data-aos="fade-up">
                <span class="sub-title">Let’s Dream Big Together</span>
                <h2 class="title">We are pioneers of the digital approach, using leading-edge technology to simplify procedures and apply executive coaching in the new age of digitalization.</h2>
            </div>
            <!-- Section Title End -->

            <!-- Feature Wrapper Start -->
            <div class="row row-cols-xl-3 row-cols-md-2 row-cols-1 max-mb-n60">
                <div class="col max-mb-60" data-aos="fade-up" v-for="feature in features" :key="feature.index">
                    <div class="icon-box-list">
                        <div class="icon">
                            <inline-svg :src="feature.icon" alt="icon" />
                        </div>
                        <div class="content">
                            <h3 class="title">{{ feature.title }}</h3>
                            <div class="desc">
                                <p>{{ feature.desc }}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Feature Wrapper End -->

            <div class="row max-mt-50">
                <div class="col text-center">
                    <n-link to="/course/courses-grid-one" class="btn btn-outline-primary learn-more-btn btn-hover-secondary margin-15">Learn more</n-link>
                    <n-link to="/contact-us" class="btn btn-primary btn-hover-secondary margin-15"> Get started today</n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                features: [
                    {
                        icon: "/images/svg/linea-basic-lightbulb.svg",
                        title: "One to One",
                        desc: "Getting the necessary clarity about the current state to help you improve your game."
                    },
                    {
                        icon: "/images/svg/linea-basic-map.svg",
                        title: "Anywhere",
                        desc: "Access to valuable and portable program which allow you to setup and live anywhere you want."
                    },
                    {
                        icon: "/images/svg/linea-basic-clockwise.svg",
                        title: "On Time",
                        desc: "Punctuality is our top priority because it's an essential criteria to assess a program quality."
                    },
                    {
                        icon: "/images/svg/linea-basic-laptop.svg",
                        title: "Online Coures",
                        desc: "Online business coaching now offers you a very powerful way to empower your business into success."
                    },
                    {
                        icon: "/images/svg/linea-basic-life-buoy.svg",
                        title: "Consulting",
                        desc: "You will get a clear sense of direction for your business, thorough assessment and faster results."
                    },
                    {
                        icon: "/images/svg/linea-basic-gear.svg",
                        title: "Self Development",
                        desc: "Business Coaching often keep your focus and develop you both in a professional and personal way."
                    }
                ]
            }
        }
    };
</script>