<template>
	<main-page>
		<div class="container">

    		<div class="starter-template">
        		<h1> {{ title }} </h1>
        		<p> {{ message }} </p>
    		</div>

		</div>
	</main-page>
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