<template lang="pug">
    main-page
        .container
            .starter-template
                h1  {{ title }} 
                p  {{ message }} 
</template>

<script>
import MainPage from '../MainPage.vue'

export default {
	components: {
      MainPage
    },
    data(){
        return {
            title: 'Главная',
            message: 'Здароу пользователь'
        }
    }
}
</script>