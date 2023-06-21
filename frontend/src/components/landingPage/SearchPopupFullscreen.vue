<template>
    <div id="fullscreen-search" class="fullscreen-search">
        <div class="fullscreen-search-close">
            <button class="toggle" @click="toggleClass('removeClass', 'open')">
                <i class="icon-top"></i>
                <i class="icon-bottom"></i>
            </button>
        </div>
        <div class="fullscreen-search-form">
            <form action="#">
                <input type="text" placeholder="Search...">
            </form>
        </div>
    </div>    
</template>

<script>
    export default {
        methods: {
            // offcanvas search close
            toggleClass(addRemoveClass, className) {
                const el = document.querySelector('#fullscreen-search');
                if (addRemoveClass === 'addClass') {
                    el.classList.add(className);
                } else {
                    el.classList.remove(className);
                }
            }
        }
    };
</script>