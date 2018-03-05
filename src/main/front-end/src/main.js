// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Axios from 'axios'
import App from './App'
import router from './router'
import lodash from 'lodash'
import VueLodash from 'vue-lodash'
import AccountType from './components/forms/AccountType'
import Account from './components/forms/Account'
import Expense from './components/forms/Expense'
import ExpenseCategory from './components/forms/ExpenseCategory'
import ExpenseSubcategory from './components/forms/ExpenseSubcategory'
import Icon from './components/forms/Icon'
import Income from './components/forms/Income'
import IncomeCategory from './components/forms/IncomeCategory'
import Payee from './components/forms/Payee'
import PaymentMethod from './components/forms/PaymentMethod'

require('bootstrap')

Vue.config.productionTip = false
Vue.use(VueLodash, lodash)
Vue.component('payee', Payee)
Vue.component('paymentmethod', PaymentMethod)
Vue.component('account', Account)
Vue.component('accounttype', AccountType)
Vue.component('expense', Expense)
Vue.component('expensecategory', ExpenseCategory)
Vue.component('expensesubcategory', ExpenseSubcategory)
Vue.component('icon', Icon)
Vue.component('income', Income)
Vue.component('incomecategory', IncomeCategory)

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
  config.headers.common['x-auth-token'] = token ? `${token}` : ''
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
