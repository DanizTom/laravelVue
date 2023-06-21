<template>
    <n-link to="/course/courses-grid-one" class="icon-box text-center bg-white">
        <div class="icon">
            <img :src="learner.iconSrc" :alt="learner.alt">
        </div>
        <div class="content">
            <h3 class="title fz-20">{{ learner.title }}</h3>
            <div class="desc">
                <p>{{ learner.text }}</p>
            </div>
            <span class="link">Start here <i class="far fa-long-arrow-right"></i></span>
        </div>
    </n-link>
</template>

<script>
    export default {
        props: ['learner']
    };
</script>