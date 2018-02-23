// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Axios from 'axios'
import App from './App'
import router from './router'
import lodash from 'lodash'
import VueLodash from 'vue-lodash'

Vue.config.productionTip = false
Vue.use(VueLodash, lodash)

// authorizationservice.checkAuth()

// Bootstrap Axios
Axios.defaults.baseURL = window.AXIOS_BASE_URL ? window.AXIOS_BASE_URL : '/api/'
Axios.defaults.headers.common.Accept = 'application/json'
Axios.defaults.headers.common['x-auth-token'] = sessionStorage.getItem('auth_token')
Axios.interceptors.response.use(
  response => response,
  (error) => {
    return Promise.reject(error)
  })
Axios.interceptors.request.use(function (config) {
  const token = sessionStorage.getItem('auth_token')
  config.headers.Authorization = token ? `${token}` : ''
  return config
})
Vue.$http = Axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
