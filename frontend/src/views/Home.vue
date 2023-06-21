<template>
  <div class="main-container home-one-wrapper">
    <HeaderStyleTwo class="header-fluid" />
    <OffCanvasMobileMenu />
    <HeroBanner />
    <OnlineCoachingLessons />
    <TeacherQuote />
    <CounterupWithTestimonial />
    <VideoStyleOne />
    <!-- <CurrentSignatureCourse /> -->
    <BlogStyleOne />
    <!-- <BrandLogoCarousel /> -->
    <FooterStyleOne
      addClassName="light-color"
      addBackgroundColor="bg-navy-blue"
    />
  </div>
</template>

<script>
export default {
  components: {
    HeaderStyleTwo: () => import('@/components/landingPage/HeaderStyleTwo'),
    OffCanvasMobileMenu: () =>
      import('@/components/landingPage/OffCanvasMobileMenu'),
    HeroBanner: () => import('@/components/landingPage/HeroBanner'),
    OnlineCoachingLessons: () =>
      import('@/components/landingPage/OnlineCoachingLessons'),
    TeacherQuote: () => import('@/components/landingPage/TeacherQuote'),
    CounterupWithTestimonial: () =>
      import('@/components/landingPage/CounterupWithTestimonial'),
    VideoStyleOne: () => import('@/components/landingPage/VideoStyleOne'),
    // CurrentSignatureCourse: () =>
    //   import('@/components/landingPage/CurrentSignatureCourse'),
    BlogStyleOne: () => import('@/components/landingPage/BlogStyleOne'),
    // BrandLogoCarousel: () =>
    //   import('@/components/landingPage/BrandLogoCarousel'),
    FooterStyleOne: () => import('@/components/landingPage/FooterStyleOne'),
  },
};
</script>
<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
@import '@/assets/scss/titles';
@import '@/assets/scss/header';
@import '@/assets/scss/intro';
@import '@/assets/scss/quote';
@import '@/assets/scss/testimonial';
@import '@/assets/scss/video';
@import '@/assets/scss/course';
@import '@/assets/scss/event';
@import '@/assets/scss/pages';
@import '@/assets/scss/blog';
@import '@/assets/scss/widget';
@import '@/assets/scss/footer';
@import '@/assets/scss/dark-mode';
</style>
