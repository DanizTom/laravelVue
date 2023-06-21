<template>
    <div class="event-section section-padding">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title text-center" data-aos="fade-up">
                <span class="sub-title">Upcoming Events</span>
                <h2 class="title playfair-font">It's time to take care of <span>your health</span> now!</h2>
            </div>
            <!-- Section Title End -->

            <div class="row">
                <div class="col-lg-6">
                    <!-- Single Event Classic Start -->
                    <div class="single-event-classic" v-for="event in data.healthCoaching.slice(0, 1)" :key="event.id">
                        <div class="event-image">
                            <n-link to="/event/event" class="image">
                                <img :src="event.imgSrc" :alt="event.title">
                            </n-link>
                        </div>
                        <div class="event-info">
                            <div class="event-date">
                                <div class="event-date-day">{{ event.date }}</div>
                                <div class="event-date-month">{{ event.month }}</div>
                            </div>
                            <div class="event-caption">
                                <h3 class="title">
                                    <n-link to="/event/event">{{ event.title }}</n-link>
                                </h3>
                                <div class="event-location">
                                    <i class="far fa-map-marker-alt"></i>
                                    {{ event.location }}
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Single Event Classic End -->
                </div>
                <div class="col-lg-5 offset-lg-1">
                    <div class="event-classic-list-wrapper max-mb-n30">
                        <!-- Single Event List Start -->
                        <div class="single-event-classic-list max-mb-30" v-for="event in data.healthCoaching.slice(1, 4)" :key="event.id">
                            <div class="event-image">
                                <n-link to="/event/event" class="image">
                                    <img :src="event.imgSrc" :alt="event.title">
                                </n-link>
                                <div class="event-date">{{ event.date }}</div>
                            </div>
                            <div class="event-info">
                                <h3 class="title">
                                    <n-link to="/event/event">{{ event.title }}</n-link>
                                </h3>
                                <div class="event-location">
                                    <i class="far fa-map-marker-alt"></i>
                                    {{ event.location }}
                                </div>
                            </div>
                        </div>
                        <!-- Single Event List End -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import data from '~/data/event.json'

    export default {
        data () {
            return {
                data
            }
        }
    };
</script>