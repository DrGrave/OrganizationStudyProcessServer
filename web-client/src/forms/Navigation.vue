<template>
    <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">СОУП</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <v-link href="/">Главная</v-link>
            </li>
            <li class="nav-item">
                <v-link href="/about">О системе</v-link>
            </li>
        </ul>

        <auth-form></auth-form>
    </div>
    </nav>
</template>

<script>
    import AuthForm from './AuthForm.vue'
    import VLink from './VLink.vue'

    module.exports = {
        components: {
            AuthForm, VLink
        }
    }
</script>