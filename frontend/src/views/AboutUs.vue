<template>
  <div class="about-page-wrapper-01">
    <HeaderStyleTwo />

    <OffCanvasMobileMenu />

    <!-- <PageBannerOne
      bgImg="backgroundImage: url('/images/page-banner/about-us-01-hero-bg.jpg')"
      title="Grow strong to take up the challenges of life. The top lessons for getting you back on track."
    /> -->
    <img src="/images/page-banner/about-us.png" alt="" />

    <AboutUsOne />

    <AboutVideoOne addClassName="pt-0" />

    <!-- <TestimonialStyleTwo /> -->

    <CallToActionOne addClassName="bg-f8f8f8 pt-0" />

    <!-- <TeamStyleTwo /> -->

    <NewsletterOne />

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
    // PageBannerOne: () => import('@/components/landingPage/PageBannerOne'),
    AboutUsOne: () => import('@/components/landingPage/AboutUsOne'),
    AboutVideoOne: () => import('@/components/landingPage/AboutVideoOne'),
    // TestimonialStyleTwo: () =>
    //   import('@/components/landingPage/TestimonialStyleTwo'),
    NewsletterOne: () => import('@/components/landingPage/NewsletterOne'),
    // TeamStyleTwo: () => import('@/components/landingPage/TeamStyleTwo'),
    CallToActionOne: () => import('@/components/landingPage/CallToActionOne'),
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
