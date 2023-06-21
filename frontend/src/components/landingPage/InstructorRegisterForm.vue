<template>
    <form class="become-teacher-form">
        <div class="learn-press-message success">
            Please <n-link to="/login-register">login</n-link> to send your request!
        </div>
        <div class="row">
            <div class="col-md-6 col-12 mb-15">
                <input type="text" placeholder="Your Name *" name="name">
            </div>
            <div class="col-md-6 col-12 mb-15">
                <input type="email" placeholder="Email *" name="email">
            </div>
            <div class="col-md-12 col-12 mb-15">
                <input type="text" placeholder="Your phone number" name="phone">
            </div>
            <div class="col-12 mb-15">
                <textarea name="message" placeholder="Your Message"></textarea>
            </div>
            <div class="col-12 text-center">
                <button class="btn btn-primary btn-hover-secondary">Get the learning program</button>
            </div>
        </div>
    </form>
</template>