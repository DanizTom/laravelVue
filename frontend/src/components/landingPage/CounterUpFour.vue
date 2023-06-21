<template>
    <div class="funfact-section section-padding" :class="addClassName" :style="bgImg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 mx-auto">
                    <div class="row row-cols-lg-4 row-cols-md-2 row-cols-1 max-mb-n30">
                        <div class="col max-mb-30" data-aos="fade-up" v-for="funfact in funfacts" :key="funfact.id">
                            <div class="funfact">
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
        props: ['addClassName', 'bgImg'],

        data () {
            return {
                funfacts: [
                    {
                        id: 1,
                        digit: "1.926",
                        text: "Finished Sessions"
                    },
                    {
                        id: 2,
                        digit: "3.092",
                        text: "Online Enrollment"
                    },
                    {
                        id: 3,
                        digit: "200",
                        text: "Subjects Taught"
                    },
                    {
                        id: 4,
                        digit: "150",
                        text: "Satisfaction rate"
                    }
                ]
            }
        }
    };
</script>