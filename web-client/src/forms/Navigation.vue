<template lang="pug">
nav.navbar.navbar-toggleable-md.navbar-inverse.bg-inverse.fixed-top
    button.navbar-toggler.navbar-toggler-right(type='button', data-toggle='collapse', data-target='#navbarsExampleDefault', aria-controls='navbarsExampleDefault', aria-expanded='false', aria-label='Toggle navigation')
        span.navbar-toggler-icon
    v-link.navbar-brand(href='/') СОУП
    #navbarsExampleDefault.collapse.navbar-collapse
        ul.navbar-nav.mr-auto
            li.nav-item
                v-link(href='/') Главная
            li.nav-item
                v-link(href='/about') О системе
        user-info(v-if='$root.user')
        auth-form(v-if='!$root.user')
</template>

<script>
    import AuthForm from './AuthForm.vue'
    import UserInfo from './UserInfo.vue'
    import VLink from './VLink.vue'

    module.exports = {
        components: {
            UserInfo, AuthForm, VLink
        }
    }
</script>