<template>
    <div class="brook-search-popup" id="search-popup">
        <div class="search-overlay" @click="toggleClass('removeClass', 'search-popup-open')"></div>
        <div class="inner">
            <div class="search-header">
                <div class="logo">
                    <n-link to="/">
                        <img src="img/logo/brook-black.png" alt="brand logo">
                    </n-link>
                </div>
                <a href="javascript:void(0)" class="search-close" id="search-close-trigger" @click="toggleClass('removeClass', 'search-popup-open')"></a>
            </div>
            <div class="search-content">
                <form>
                    <label>
                        <input type="search" placeholder="Enter search keyword…">
                    </label>
                    <button class="search-submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        methods: {
            // offcanvas search close
            toggleClass(addRemoveClass, className) {
                const el = document.querySelector('#search-popup');
                if (addRemoveClass === 'addClass') {
                    el.classList.add(className);
                } else {
                    el.classList.remove(className);
                }
            }
        }
    };
</script>