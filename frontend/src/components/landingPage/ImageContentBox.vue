<template>
    <div class="register-section section section-padding">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-xl-4 col-lg-5 order-2 order-lg-1">
                    <RegisterContentBox />
                </div>
                <div class="col-xl-8 col-lg-7 order-1 order-lg-2">
                    <ImageBox imgProps= "/images/others/home-5-image-01.png" shapeOne="/images/shape-animation/shape-2.svg"  shapeTwo="/images/shape-animation/shape-3.png" />
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        components: {
            RegisterContentBox: () => import('@/components/RegisterContentBox'),
            ImageBox: () => import('@/components/ImageBox'),
        },
    };
</script>