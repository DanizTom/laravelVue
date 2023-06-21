<template>
    <div class="section section-padding">
        <div class="container">
            <SectionHeader subTitle="Wanna transform your life?" title="Glad to <span>Help You</span> Learn" alignment="text-center" />

            <div class="row row-cols-xl-4 row-cols-sm-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="feature in features" :key="feature.title">
                    <n-link to="/course/courses-grid-one" class="icon-box icon-box-left text-left" data-vivus-hover>
                        <div class="icon">
                            <inline-svg class="svgInject" :src="feature.icon" alt="icon" />
                        </div>
                        <div class="content">
                            <h3 class="title">{{ feature.title }}</h3>
                            <div class="desc">
                                <p>{{ feature.text }}</p>
                            </div>
                        </div>
                    </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            SectionHeader: () => import('@/components/SectionHeader'),
        },

        data () {
            return {
                features: [
                    {
                        id: 1,
                        title: "Idea Discussion",
                        text: "Get some soul healing and guidance for your future career and vocational directions.",
                        icon: "/images/svg/linea-basic-flag2.svg"
                    },
                    {
                        id: 2,
                        title: "Web Development",
                        text: "Get teamed up with the specialists who work and teach coding for years at famous universities.",
                        icon: "/images/svg/linea-basic-gear.svg"
                    },
                    {
                        id: 3,
                        title: "System Administration",
                        text: "Learners are encouraged to study the mechanism and structure of system administration.",
                        icon: "/images/svg/linea-basic-life-buoy.svg"
                    },
                    {
                        id: 4,
                        title: "Graphic Design",
                        text: "Have a passion for graphics and arts? Show your talents with confidence and self-assertiveness.",
                        icon: "/images/svg/linea-basic-display.svg"
                    }
                ]
            }
        }
    };
</script>