<template>
    <div class="funfact-section bg-pattern" :style="{ backgroundImage: `url('/images/bg/background-pattern-grid-line-02.png')` }">
        <div class="container funfact-border">
            <div class="row">
                <div class="col-lg-12 mx-auto">
                    <div class="row row-cols-lg-4 row-cols-md-2 row-cols-1">
                        <div class="col" data-aos="fade-up" v-for="counter in counters" :key="counter.id">
                            <div class="funfact funfact-style-two max-mb-50">
                                <h2 class="title">{{ counter.title }}</h2>
                                <div class="number"><span class="counter">{{ counter.count }}</span></div>
                                <h6 class="text">{{ counter.text }}</h6>
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
                counters: [
                    {
                        id: 1,
                        title: "Successfully trained",
                        count: "1790",
                        text: "Enrolled Learners"
                    },
                    {
                        id: 2,
                        title: "Proudly Received",
                        count: "19",
                        text: "Countrywide Awards"
                    },
                    {
                        id: 3,
                        title: "Firmly Established",
                        count: "24",
                        text: "local branches"
                    },
                    {
                        id: 4,
                        title: "Getting Featured on",
                        count: "1090",
                        text: "Blog Posts"
                    }
                ]
            }
        }
    };
</script>