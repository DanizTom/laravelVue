<template>
    <div class="course box-shadow">
        <div class="thumbnail">
            <n-link to="/course/course-details" class="image">
                <img :src="course.image" :alt="course.title + 'Thumbnail'">
            </n-link>
        </div>
        <div class="info">
            <span class="price">{{ course.price }}</span>
            <h3 class="title">
                <n-link to="/course/course-details">{{ course.title }}</n-link>
            </h3>
            <ul class="meta">
                <li>
                    <i class="far fa-file-alt"></i>
                    {{ course.lessons }}
                </li>
                <li>
                    <i class="far fa-user-alt"></i>
                    {{ course.students }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['course']
    };
</script>