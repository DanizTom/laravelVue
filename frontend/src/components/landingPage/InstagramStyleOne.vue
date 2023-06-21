<template>
    <div class="instagram-section section-padding section-padding-bottom-sm-0 bg-f8f8f8">
        <div class="container">
            <!-- Instagram Section Title Start -->
            <div class="instagram-section-title text-center max-mb-70">
                <h2 class="title">
                    <n-link to="/">@health_coaching</n-link>
                </h2>
                <span class="sub-title">Follow me on instagram</span>
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