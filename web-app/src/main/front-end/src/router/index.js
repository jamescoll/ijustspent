import Vue from 'vue'
import Router from 'vue-router'
import Starter from '@/components/Starter'
import BTable from '@/components/homecards/BTable'
import BEdit from '@/components/homecards/BEdit'
import BChart from '@/components/homecards/BChart'
import Login from '@/components/login/Login'
import SignUp from '@/components/login/SignUp'
import About from '@/components/homecards/About'
import Account from '@/components/forms/Account'
import Expense from '@/components/forms/Expense'
import Income from '@/components/forms/Income'
import Payee from '@/components/forms/Payee'
import ExpenseSubcategory from '@/components/forms/ExpenseSubcategory'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  scrollBehavior: () => ({y: 0}),
  routes: [
    {
      path: '/',
      name: 'starter',
      component: Starter
    },
    {
      path: '/budgettable',
      name: 'budgettable',
      component: BTable,
      meta: {requiresAuth: true}
    },
    {
      path: '/budgetedit',
      name: 'budgetedit',
      component: BEdit,
      meta: {requiresAuth: true}
    },
    {
      path: '/budgetchart',
      name: 'budgetchart',
      component: BChart,
      meta: {requiresAuth: true}
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUp
    },
    {
      path: '/account',
      name: 'account',
      component: Account,
      meta: {requiresAuth: true}
    },
    {
      path: '/expense',
      name: 'expense',
      component: Expense,
      meta: {requiresAuth: true}
    },
    {
      path: '/income',
      name: 'income',
      component: Income,
      meta: {requiresAuth: true}
    },
    {
      path: '/payee',
      name: 'payee',
      component: Payee,
      meta: {requiresAuth: true}
    },
    {
      path: '/subcat',
      name: 'subcat',
      component: ExpenseSubcategory,
      meta: {requiresAuth: true}
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    var jwt = sessionStorage.getItem('auth_token')
    if (!jwt) {
      next({
        path: '/login',
        query: {
          redirect: to.fullPath
        }
      })
    } else {
      next()
    }
  } else {
    next()
  }
})

export default router
