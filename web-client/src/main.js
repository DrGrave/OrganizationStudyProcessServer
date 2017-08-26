/*import Vue from 'vue'
import MainPage from './MainPage.vue'

new Vue({
	el: '#app',
	render (h) {
      return h(MainPage)
    },
    template: '<MainPage/>',
    components: { MainPage },
    currentRoute: window.location.pathname
})

window.addEventListener('popstate', () => {
    console.log("WORL");
});*/

import Vue from 'vue'
import routes from './routes'


const app = new Vue({
  el: '#app',
  data: {
    currentRoute: window.location.pathname
  },
  computed: {
    ViewComponent () {
      const matchingView = routes[this.currentRoute]
      return matchingView
        ? require('./pages/' + matchingView + '.vue')
        : require('./pages/404.vue')
    }
  },
  render (h) {
    return h(this.ViewComponent)
  }
})

window.addEventListener('popstate', () => {
  app.currentRoute = window.location.pathname
})
