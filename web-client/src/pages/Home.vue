<template>
	<div class="container">

    	<div class="starter-template">
        	<h1> {{ title }} </h1>
        	<p> {{ message }} </p>
    	</div>

	</div>

</template>

<script>
module.exports = {
    data(){
        return {
            title: 'Главная',
            message: 'Здароу пользователь'
        }
    }
}
</script>