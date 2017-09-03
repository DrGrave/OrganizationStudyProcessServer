<template lang="pug">
    main-page
        .container
            .starter-template(v-if='!$root.user')
                h1  {{ title }} 
                p  {{ message }}
            subject-list(v-if='$root.user&&$root.user!="load"')
</template>

<script>
import MainPage from '../MainPage.vue'
import SubjectList from '../forms/SubjectList.vue'

export default {
	components: {
      MainPage, SubjectList
    },
    data(){
        return {
            title: 'Главная',
            message: 'Здароу пользователь'
        }
    }
}
</script>