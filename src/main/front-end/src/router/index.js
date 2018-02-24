import Vue from 'vue'
import Router from 'vue-router'
import Starter from '@/components/Starter'
import Vuejs from '@/components/technology/Vuejs'
import SpringBoot from '@/components/technology/SpringBoot'
import Bootstrap from '@/components/technology/Bootstrap'
import Chart from '@/components/charts/Chart'
import Circle from '@/components/charts/Circle'
import AdjustableCircle from '@/components/charts/AdjustableCircle'
import HighchartsPie from '@/components/charts/HighchartsPie'
import HighchartsBar from '@/components/charts/HighchartsBar'
import PayeeForm from '@/components/forms/PayeeForm'
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
      path: '/vuejs',
      name: 'vuejs',
      component: Vuejs,
      meta: {requiresAuth: true}
    },
    {
      path: '/spring-boot',
      name: 'spring-boot',
      component: SpringBoot,
      meta: {requiresAuth: true}
    },
    {
      path: '/bootstrap',
      name: 'bootstrap',
      component: Bootstrap,
      meta: {requiresAuth: true}
    },
    {
      path: '/chart',
      name: 'chart',
      component: Chart
    },
    {
      path: '/d3-circle',
      name: 'd3-circle',
      component: Circle
    },
    {
      path: '/adjustable-circle',
      name: 'adjustable-circle',
      component: AdjustableCircle
    },
    {
      path: '/expense-chart',
      name: 'expense-chart',
      component: HighchartsPie
    },
    {
      path: '/expense-bar-chart',
      name: 'expense-bar-chart',
      component: HighchartsBar
    },
    {
      path: '/add-payee-form',
      name: 'add-payee-form',
      component: PayeeForm,
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
