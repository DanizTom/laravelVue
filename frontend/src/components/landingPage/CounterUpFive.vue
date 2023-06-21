<template>
    <div class="funfact-section" :style="{ backgroundColor: '#0e0f15' }">
        <div class="container funfact-border bg-pattern" :style="{ backgroundImage: `url('/images/bg/background-pattern-grid-line-03.png')` }">
            <div class="row">
                <div class="col-lg-12 mx-auto">
                    <div class="row row-cols-lg-4 row-cols-md-2 row-cols-1 max-mb-n30">
                        <div class="col max-mb-50" data-aos="fade-up" v-for="funfact in funfacts" :key="funfact.id">
                            <div class="funfact funfact-3">
                                <div class="icon maxcoach-solid-icon">
                                    <img class="svgInject" :src="funfact.icon" alt="icon">
                                </div>
                                <div class="number"><span class="counter">{{ funfact.digit }}</span></div>
                                <h6 class="text">{{ funfact.text }}</h6>
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
                funfacts: [
                    {
                        id: 1,
                        digit: "1.926",
                        text: "Finished Sessions",
                        icon: "/images/svg/linea-basic-clock.svg"
                    },
                    {
                        id: 2,
                        digit: "3.092",
                        text: "Online Enrollment",
                        icon: "/images/svg/linea-basic-eye.svg"
                    },
                    {
                        id: 3,
                        digit: "200",
                        text: "Subjects Taught",
                        icon: "/images/svg/linea-basic-cup.svg"
                    },
                    {
                        id: 4,
                        digit: "150",
                        text: "Satisfaction rate",
                        icon: "/images/svg/linea-basic-star.svg"
                    }
                ]
            }
        }
    };
</script>