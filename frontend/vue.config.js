module.exports = {
  css: {
    loaderOptions: {
      scss: {
        additionalData: `@import "~@/assets/scss/_variables.scss";`,
      },
    },
  },
  //Setting for Production deployment
  /*devServer: {
                disableHostCheck: true,
                proxy: "http://143.198.115.162:9090/"
    }*/
};
