import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from "bootstrap-vue"
import router from './js/routes'
import vuetify from './vuetify.js'

Vue.config.productionTip = false
Vue.use(BootstrapVue)

new Vue({
  el: '#app',
  template: '<App/>',
  router,
  vuetify,
  components: {App},
  render: h => h(App),
}).$mount('#app')
