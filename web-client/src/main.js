import Vue from 'vue'
import routes from './routes'

var user = null;

if(localStorage.getItem("user")){
	user = JSON.parse(localStorage.getItem("user"));
	console.log(user);
}

const app = new Vue({
  el: '#app',
  data: {
  	user: user,
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
