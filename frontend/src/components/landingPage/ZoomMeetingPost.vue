<template>
    <div class="zoom-event">
        <div class="thumbnail">
            <n-link to="/" class="image">
                <img :src="post.imgSrc" :alt="post.title + ' Thumbnail'">
            </n-link>
        </div>
        <div class="info">
            <h3 class="title">
                <n-link to="/">{{ post.title }}</n-link>
            </h3>
            <div class="zoom-id">
                <span class="label">Meeting ID: </span>
                <span class="value theme-color">{{ post.meetingID }}</span>
            </div>
            <ul class="meta">
                <li>
                    <i class="far fa-calendar"></i>
                    {{ post.date }} <span class="time">{{ post.time }}</span>
                </li>
                <li>
                    <i class="far fa-clock"></i>
                    {{ post.duration }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['post']
    };
</script>