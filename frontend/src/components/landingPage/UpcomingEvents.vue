<template>
    <div class="event-section section position-relative section-padding">
        <div class="container">
            <SectionHeader subTitle="Get in contact now" title="Upcoming <span>Events</span>" alignment="text-center" />

            <div class="row row-cols-lg-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="event in information" :key="event.index">
                    <EventItem :event="event"  />
                </div>
            </div>

            <div class="row max-mt-70">
                <div class="text-center col-lg-7 mx-auto">
                    <n-link to="/event/event" class="link link-lg">
                        Excited about our event?
                        <mark>
                            View all events 
                            <i class="far fa-long-arrow-right"></i>
                        </mark>
                    </n-link>
                </div>
            </div>
        </div>

        <!-- Section Bottom Shape Start -->
        <div class="section-bottom-shape-two">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none" height="315">
                <path class="elementor-shape-fill" d="M 50 0 S75 0 100 100 L100 0"></path>
            </svg>
        </div>
        <!-- Section Bottom Shape End -->
    </div>
</template>

<script>
    export default {
        components: {
            SectionHeader: () => import('@/components/SectionHeader'),
            EventItem: () => import('@/components/EventItem'),
        },

        data () {
            return {
                information: [
                    {
                        location: "Texas, US",
                        title: "Storytelling Workshop",
                        date: "22",
                        month: "Nov"
                    },
                    {
                        location: "New York, US",
                        title: "Painting Art Contest 2020",
                        date: "15",
                        month: "Dec"
                    },
                    {
                        location: "Hamburg, Germany",
                        title: "International Art Fair 2020",
                        date: "14",
                        month: "Jan"
                    },
                    {
                        location: "Illinois, US",
                        title: "Street Performance: Call for Artist",
                        date: "18",
                        month: "Mar"
                    },
                    {
                        location: "Illinois, US",
                        title: "Consumer Food Safety Education Conference",
                        date: "27",
                        month: "Jul"
                    },
                    {
                        location: "Dubai",
                        title: "How meditation improve your mental health?",
                        date: "12",
                        month: "Aug"
                    }
                ]
            }
        }
    };
</script>