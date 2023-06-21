<template>

    <div class="col-md-12">
        <div class="card card-container">
            <img
                    id="profile-img"
                    src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
                    class="profile-img-card"
            />
            <form name="form" @submit="formSubmit" v-on:submit.prevent>
                <div class="form-group">
                    <p>Enter your new password below.</p>
                    <label for="Password">Password</label>
                    <input
                            v-model="password"
                            v-validate="'required'"
                            type="password"
                            class="form-control"
                            name="password"
                    />
                    <div
                            v-if="errors.has('password')"
                            class="alert alert-danger"
                            role="alert"
                    >Password is required!
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" :disabled="loading">
                        <span v-show="loading" class="spinner-border spinner-border-sm"></span>
                        <span>Submit</span>
                    </button>
                </div>
            </form>
        </div>
    </div>

</template>

<script>
    import User from '../models/user';
    import Vue from 'vue'
    import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
    import UserService from '../services/user.service';
    import axios from 'axios';


    // Install BootstrapVue
    Vue.use(BootstrapVue)
    // Optionally install the BootstrapVue icon components plugin
    Vue.use(IconsPlugin)


    export default {
        name: 'ResetPassword',

        data() {
            return {
                user: new User('', ''),
                loading: false,
                message: '',
                password: '',
            };
        },

        methods: {
            formSubmit(e) {
                e.preventDefault();
                let currentObj = this;
                axios.post('http://localhost:8080/api/test/reset',{password: this.password, token:this.$route.query.token})
                    .then(function (response) {
                        currentObj.output = response.data;
                    })
                    .catch(function (error) {
                        currentObj.output = error;
                    });
            }
        }
    }
</script>

<style scoped>
    label {
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        background-color: #f7f7f7;
        padding: 20px 25px 30px;
        margin: 0 auto 25px;
        margin-top: 50px;
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    }

    .profile-img-card {
        width: 96px;
        height: 96px;
        margin: 0 auto 10px;
        display: block;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        border-radius: 50%;
    }
</style>