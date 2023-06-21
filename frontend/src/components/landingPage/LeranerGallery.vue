<template>
    <div class="learners-section bg-pattern bg-f8f8f8" :style="{ backgroundImage: `url('/images/bg/background-pattern-grid-line.png')` }">
        <div class="container mt-minus-125">
            <div class="row row-cols-lg-3 row-cols-md-2 row-cols-sm-1 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="learner in learners" :key="learner.id">
                    <LearnGalleryItem :learner="learner" />
                </div>
            </div>

            <div class="row max-mt-40">
                <div class="text-center col-lg-7 mx-auto">
                    <n-link to="/contact-us" class="link link-lg">
                        Explore the most appropriate courses and certificate that you desire will be the sweet ultimate reward. <mark>Let’s get started <i class="far fa-long-arrow-right"></i></mark>
                    </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            LearnGalleryItem: () => import('@/components/LearnGalleryItem'),
        },

        data () {
            return {
                learners: [
                    {
                        id: 1,
                        iconSrc: "/images/learner/learner-01.png",
                        alt: "icon",
                        title: "Customize Freely to Your Preferences",
                        text: "Learners are given the right to arrange and customize their study schedule and timetable based on preferences.",
                    },
                    {
                        id: 2,
                        iconSrc: "/images/learner/learner-02.png",
                        alt: "icon",
                        title: "Cloud Storage or Download Lessons to Devices",
                        text: "You can store online lessons via online cloud or download to your device and revise lessons on the way.",
                    },
                    {
                        id: 3,
                        iconSrc: "/images/learner/learner-03.png",
                        alt: "icon",
                        title: "Multimedia Study Materials & Info Channels",
                        text: "We provide study materials with various formats: video, audio, slides, doc, prints, books and applications.",
                    }
                ]
            }
        }
    };
</script>