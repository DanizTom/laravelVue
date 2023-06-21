<template>
    <div class="blog">
        <div class="thumbnail">
            <n-link to="/blog/blog-details" class="image">
                <img :src="blog.imgSrc" :alt="blog.alt">
            </n-link>
        </div>
        <div class="info">
            <n-link to="/blog/blog-details" class="category">{{ blog.category }}</n-link>
            <h3 class="title">
                <n-link to="/blog/blog-details">{{ blog.title }}</n-link>
            </h3>
            <ul class="meta">
                <li><i class="far fa-calendar"></i>{{ blog.date }}</li>
                <li><i class="far fa-eye"></i>{{ blog.view }}</li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['blog']
    };
</script>