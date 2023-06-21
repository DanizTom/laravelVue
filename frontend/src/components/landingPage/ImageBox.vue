<template>
    <div class="register-image mb-sm-50 mb-xs-50">

        <img :src="imgProps" alt="image">

        <div class="shape shape-1 scene">
            <span data-depth="3">
                <img :src="shapeOne" alt="shape image" class="svgInject">
            </span>
        </div>
        <div class="shape shape-2 scene">
            <span data-depth="-3">
                <img :src="shapeTwo" alt="image">
            </span>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['imgProps', 'shapeOne', 'shapeTwo']
    };
</script>