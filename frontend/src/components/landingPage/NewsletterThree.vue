<template>
    <div class="newsletter-section" :style="{ backgroundColor: '#4d7468' }">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-4">
                    <div class="newsletter-content-wrap">
                        <div class="newsletter-icon">
                            <img src="/images/icons/icon-paper-plane.png" alt="icon">
                        </div>
                        <div class="newsletter-title">
                            <h3 class="title">Newsletter to get in touch</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="newsletter-form-area">
                        <form>
                            <input type="email" name="email" placeholder="Your e-mail">
                            <button class="form-submit">
                                <i class="far fa-long-arrow-right"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>