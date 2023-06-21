<template>
    <div class="event max-mb-30">
        <div class="thumbnail">
            <n-link to="/event/event-details" class="image">
                <img :src="event.imgSrc" :alt="event.title + ' Thumbnail'">
            </n-link>
            <div class="event-overlay-background"></div>
            <div class="event-overlay-content">
                <n-link to="/event/event-details" class="btn btn-md btn-light btn-hover-light theme-color">Get ticket</n-link>
            </div>
        </div>
        <div class="info">
            <span class="date">{{ event.date }}</span>
            <h3 class="title">
                <n-link to="/event/event-details">{{ event.title }}</n-link>
            </h3>
            <ul class="event-location">
                <li>
                    <i class="far fa-map-marker-alt"></i>
                    {{ event.location }}
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['event']
    };
</script>
