<template>
    <div class="sidebar-widget-wrapper">
        <div class="sidebar-widget">
            <h3 class="sidebar-widget-title">Search</h3>
            <div class="sidebar-widget-content">
                <div class="sidebar-widget-search">
                    <form>
                        <input type="text" placeholder="Search...">
                        <button><i class="fas fa-search"></i></button>
                    </form>
                </div>
            </div>
        </div>
        <div class="sidebar-widget">
            <h3 class="sidebar-widget-title mb-2">Popular posts</h3>
            <div class="sidebar-widget-content">
                <ul class="sidebar-widget-list-post">
                    <li v-for="blog in blog.slice(0, 5)" :key="blog.id">
                        <n-link to="/blog/blog-details">{{ blog.title }}</n-link>
                    </li>
                </ul>
            </div>
        </div>
        <div class="sidebar-widget">
            <h3 class="sidebar-widget-title">Popular tags</h3>
            <div class="sidebar-widget-content">
                <div class="tagcloud">
                    <n-link to="" v-for="tag in tag" :key="tag.id">{{ tag }}</n-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['blog', 'tag']
    };
</script>