import Vue from 'vue'
import routes from './routes'
import MainPage from './MainPage.vue'

new Vue({
	el: '#app',
	render (h) {
      return h(MainPage)
    },
    template: '<MainPage/>',
    components: { MainPage }
})