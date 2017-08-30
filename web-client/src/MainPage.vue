<template lang="pug">
    div
        navigation
        slot
</template>

<script>
import Navigation from './forms/Navigation.vue'

export default {
    components: {
        Navigation
    }
}

</script>

<style>
    .starter-template {
        padding: 5rem 2rem;
    }
</style>