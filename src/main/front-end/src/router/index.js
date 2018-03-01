import Vue from 'vue'
import Router from 'vue-router'
import Starter from '@/components/Starter'
import BTable from '@/components/homecards/BTable'
import BEdit from '@/components/homecards/BEdit'
import BChart from '@/components/homecards/BChart'
import Login from '@/components/login/Login'
import SignUp from '@/components/login/SignUp'

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
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUp
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
