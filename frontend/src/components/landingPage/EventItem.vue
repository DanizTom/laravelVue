<template>
    <div class="event-list-box">
        <div class="event-caption">
            <div class="left-box">
                <div class="event-location">
                    <i class="far fa-map-marker-alt"></i>
                    {{ event.location }}
                </div>
                <h3 class="title">{{ event.title }}</h3>
            </div>
            <div class="right-box">
                <div class="event-date">
                    <div class="event-date-day">{{ event.date }}</div>
                    <div class="event-date-month">{{ event.month }}</div>
                </div>
                <div class="event-button">
                    <button class="btn btn-primary btn-hover-secondary btn-xs">Get ticket</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['event']
    };
</script>