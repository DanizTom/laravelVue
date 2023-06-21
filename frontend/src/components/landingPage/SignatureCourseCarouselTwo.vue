<template>
    <div class="section-padding section-fluid-two">
        <div class="container">
            <!-- Section Title Start -->
            <div class="section-title-four text-center" data-aos="fade-up">
                <span class="sub-title">Upcoming events</span>
                <h2 class="title fz-48">Stimulated to take part in? </h2>
            </div>
            <!-- Section Title End -->

            <!-- Event Wrapper Start -->
            <div class="event-slider" data-aos="fade-up">
                <swiper :options="swiperOptions">
                    <div class="swiper-slide" v-for="event in events" :key="event.id">
                        <div class="event primary-three mb-30">
                            <div class="thumbnail">
                                <n-link to="/event/event-details" class="image">
                                    <img :src="event.imgSrc" :alt="event.alt">
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
                    </div>
                </swiper>
                <div class="swiper-pagination text-center"></div>
            </div>
            <!-- Event Wrapper End -->

            <div class="row max-mt-40">
                <div class="text-center col-lg-7 mx-auto">
                    <n-link to="/event/event-details" class="link link-lg primary-three">
                        We love to see you at our events.​​ <mark>Check out events <i class="far fa-long-arrow-right"></i></mark>
                    </n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            SectionHeader: () => import('@/components/SectionHeader'),
        },

        data () {
            return {
                swiperOptions: {
                    spaceBetween: 30,
                    loop: true,
                    speed: 1000,
                    autoHeight: true,
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true
                    },
                    // Responsive breakpoints
                    breakpoints: {
                        1200:{
                            slidesPerView : 4
                        },
                        992:{
                            slidesPerView : 3
                        },
                        768:{
                            slidesPerView : 2
                        },
                        300:{
                            slidesPerView : 1
                        }
                    }
                },

                events: [
                    {
                        id: 1,
                        imgSrc: "/images/event/370/event1.jpg",
                        alt: "event image",
                        date: "Nov 22, 2020",
                        title: "Storytelling Workshop 2020",
                        location: "Texas, US"
                    },
                    {
                        id: 2,
                        imgSrc: "/images/event/370/event2.jpg",
                        alt: "event image",
                        date: "Oct 10, 2020",
                        title: "Painting Art Contest 2020",
                        location: "New York, US"
                    },
                    {
                        id: 3,
                        imgSrc: "/images/event/370/event3.jpg",
                        alt: "event image",
                        date: "Dec 25, 2020",
                        title: "International Art Fair 2020",
                        location: "Hamburg, Germany"
                    },
                    {
                        id: 4,
                        imgSrc: "/images/event/370/event4.jpg",
                        alt: "event image",
                        date: "Dec 25, 2020",
                        title: "Consumer Food Safety",
                        location: "Illinois, US"
                    }
                ]
            }
        }
    };
</script>