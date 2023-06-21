<template>
    <div class="instagram-section section-padding section-padding-bottom-sm-0">
        <div class="container-fluid">
            <!-- Instagram Section Title Start -->
            <div class="instagram-section-title-two text-center">
                <h2 class="title">Follow me on instagram</h2>
                <span class="sub-title"><a href="#">@nytcooking</a></span>
            </div>
            <!-- Instagram Section Title End -->
            
            <div class="row">
                <div class="col-12">
                    <div class="mc-intagram-list instagram-grid">
                        <div class="instagram-grid-wrap instagram-grid-5">
                            <InstagramPost :instagram="instagram" v-for="instagram in data" :key="instagram.id"  />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import data from '~/data/instagram';

    export default {
        components: {
            InstagramPost: () => import('@/components/InstagramPost'),
        },

        data () {
            return {
                data
            }
        },
    };
</script>