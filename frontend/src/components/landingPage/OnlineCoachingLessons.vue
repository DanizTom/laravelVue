<template>
  <div class="section">
    <div class="container">
      <div class="section-title text-center">
        <span class="sub-title">WHY IDANA</span>
        <h2 class="title">
          <span> IDANA</span> is here for <br />
          helping you have a <br />
          <span>satisfying career</span> and
          <span>well-balanced life</span>
        </h2>
      </div>

      <div class="row row-cols-xl-4 row-cols-sm-2 row-cols-1 no-gutters">
        <div class="col" v-for="item in items" :key="item.id">
          <router-link
            to="/register"
            class="icon-box text-center"
            data-vivus-hover
          >
            <div class="icon">
              <img :src="item.icon" :alt="item.alt" />
            </div>
            <div class="content">
              <h3 class="title">{{ item.title }}</h3>
              <div class="desc">
                <p>{{ item.desc }}</p>
              </div>
              <span class="link">
                Start here
                <i class="fas fa-arrow-right"></i>
              </span>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          id: 1,
          icon: '/images/svg/linea-basic-flag2.svg',
          alt: 'icon',
          title: 'Life Mentoring',
          desc: 'Get some soul healing and guidance for your future career and vocational directions.',
        },
        {
          id: 2,
          icon: '/images/svg/linea-basic-gear.svg',
          alt: 'icon',
          title: 'Self Development',
          desc: 'Develop skills for career of various majors including computer science & language competence.',
        },
        {
          id: 3,
          icon: '/images/svg/linea-basic-life-buoy.svg',
          alt: 'icon',
          title: 'Ask Consultancy',
          desc: "Make a reservation with our special consultant to learn what's best for your dream career.",
        },
        {
          id: 4,
          icon: '/images/svg/linea-basic-display.svg',
          alt: 'icon',
          title: 'Remote Learning',
          desc: 'Learn from anywhere in the world on desktop, tablet or mobile phone with an Internet connection.',
        },
      ],
    };
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
