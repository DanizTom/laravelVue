<template>
    <div class="blog-section section-padding bg-f5f5f5">
        <div class="container">
            <SectionHeader subTitle="Consider registering our courses?" title="Trending on <span>Our Blogs</span>" alignment="text-center" />

            <div class="row row-cols-lg-3 row-cols-md-2 row-cols-1 max-mb-n30">
                <div class="col max-mb-30" data-aos="fade-up" v-for="blog in blogData.blogs.slice(0, 3)" :key="blog.id">
                    <BlogPostCaptionBottom :blog="blog" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import blogData from '~/data/blog'

    export default {
        components: {
            SectionHeader: () => import('@/components/SectionHeader'),
            BlogPostCaptionBottom: () => import('@/components/BlogPostCaptionBottom')
        },
        data () {
            return {
                blogData
            }
        }
    };
</script>