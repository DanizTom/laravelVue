<template>
  <!-- theme toggler start -->
  <button class="button theme-color-toggler" @click="toggleTheme()">
    <img
      v-if="colorMode === false"
      class="themeSwitchIcon"
      src="@/assets/images/icons/light.svg"
      alt="light icon"
    />
    <img
      v-else
      class="themeSwitchIcon"
      src="@/assets/images/icons/dark.svg"
      alt="dark icon"
    />
  </button>
  <!-- theme toggler end -->
</template>

<script>
export default {
  data() {
    return {
      colorMode: true,
    };
  },
  methods: {
    toggleTheme() {
      if (this.colorMode) {
        this.colorMode = false;
      } else {
        this.colorMode = true;
      }
      console.log(this.colorMode);
    },
  },
};
</script>
<style scoped>
.themeSwitchIcon:hover {
  fill: #20ad96;
}
</style>
