<template>
    <div class="newsletter-section section-fluid section-padding-0">
        <div class="container">
            <div class="newsletter-bg-image bg-cover" :style="{backgroundImage: `url('/images/bg/subscribe-section-bg.png')`}">
                <div class="row align-items-center">
                    <div class="col-md-4">
                        <div class="newsletter-content-wrap center-text">
                            <div class="newsletter-icon">
                                <img src="/images/icons/icon-paper-plane.png" alt="icon">
                            </div>
                            <div class="newsletter-title text-dark">
                                <h3 class="title">Newsletter to get in touch</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="newsletter-form-area dark-from">
                            <form>
                                <input type="email" name="email" placeholder="Your e-mail">
                                <button class="form-submit"><i class="far fa-long-arrow-right"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
