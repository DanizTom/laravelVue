<template>
    <div class="register-content">
        <!-- Section Title Start -->
        <div class="section-title text-left mb-30" data-aos="fade-up">
            <span class="sub-title">Why hesitate to register?</span>
            <h2 class="title fz-48">Learn At Your <br> Own <span>Pace</span></h2>
        </div>
        <!-- Section Title End -->

        <ul class="maxcoach-list">
            <li class="item" v-for="list in lists" :key="list.id">
                <div class="icon">
                    <i class="fas fa-check"></i>
                </div>
                <div class="text">{{ list }}</div>
            </li>
        </ul>

        <n-link to="/" class="btn btn-primary btn-hover-secondary"> Get started for free</n-link>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                lists: [
                    "Select & customize courses to your preferences",
                    "Change the tutor and make arrangements",
                    "Participate in events to join others",
                    "Get the desired certificate delivered at house",
                ]
            }
        }
    };
</script>

<style lang="scss">

</style>