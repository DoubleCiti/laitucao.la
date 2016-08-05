import Vue from 'vue'
import VueResource from 'vue-resource'
import App from './App.vue'

/* eslint-disable no-new */
Vue.use(VueResource);
Vue.http.headers.common['Access-Control-Allow-Origin'] = '*'

new Vue({
  el: 'body',
  components: { App }
});
