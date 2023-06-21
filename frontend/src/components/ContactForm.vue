<template>
  <div class="container">
    <div class="contact-form">
      <form @submit.prevent="sendEmail">
        <h4 class="my-4">Contact Form</h4>
        <label>Name</label>
        <input
          type="text"
          class="mb-4"
          v-model="name"
          name="name"
          placeholder="Your Name"
        />
        <label>Email</label>
        <input
          type="email"
          v-model="email"
          name="email"
          placeholder="Your Email"
          class="mb-4"
        />
        <label>Message</label>
        <textarea
          name="message"
          v-model="message"
          cols="30"
          rows="5"
          placeholder="Message"
          class="mb-4"
        >
        </textarea>

        <input
          type="submit"
          class="btn btn-secondary send-button"
          value="Send"
        />
      </form>
    </div>
  </div>
</template>

<script>
import emailjs from 'emailjs-com';

export default {
  name: 'contactform',
  data() {
    return {
      name: '',
      email: '',
      message: '',
    };
  },
  methods: {
    sendEmail(e) {
      try {
        emailjs.sendForm(
          'service_x5pzeha',
          'template_icvtuyr',
          e.target,
          'user_PCvLUSGmNGb5bpI1B0l4m',
          {
            name: this.name,
            email: this.email,
            message: this.meessage,
          }
        );
        console.log('it works!!!');
      } catch (error) {
        console.log({ error });
      }
      // Reset form field
      this.name = '';
      this.email = '';
      this.message = '';
    },
  },
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/variables';
@import '@/assets/scss/common';
@import '@/assets/scss/spacing';
@import '@/assets/scss/elements';
.contact-form {
  width: 100%;
  max-width: 600px;
  margin: auto;
}
.send-button {
  width: 220px;
  display: block;
  margin: 10px auto;
}
</style>
