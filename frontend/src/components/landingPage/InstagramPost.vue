<template>
    <div class="item-grid grid-style--1">
        <div class="thumb">
            <n-link to="/">
                <img :src="instagram.imgSrc" :alt="instagram.alt">
            </n-link>
            <div class="item-info">
                <div class="inner">
                    <n-link to="">
                        <i class="fas fa-heart"></i>
                        {{ instagram.like }}
                    </n-link>
                    <n-link to="">
                        <i class="fas fa-comment-dots"></i>
                        {{ instagram.comment }}
                    </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['instagram']
    };
</script>