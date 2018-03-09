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
import AccountType from '@/components/forms/AccountType'
import Expense from '@/components/forms/Expense'
import ExpenseCategory from '@/components/forms/ExpenseCategory'
import ExpenseSubcategory from '@/components/forms/ExpenseSubcategory'
import Icon from '@/components/forms/Icon'
import Income from '@/components/forms/Income'
import IncomeCategory from '@/components/forms/IncomeCategory'
import Payee from '@/components/forms/Payee'
import PaymentMethod from '@/components/forms/PaymentMethod'

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
      component: Account
    },
    {
      path: '/accounttype',
      name: 'accounttype',
      component: AccountType
    },
    {
      path: '/expense',
      name: 'expense',
      component: Expense
    },
    {
      path: '/expensecategory',
      name: 'expensecategory',
      component: ExpenseCategory
    },
    {
      path: '/ExpenseSubcategory',
      name: 'expensesubcategory',
      component: ExpenseSubcategory
    },
    {
      path: '/icon',
      name: 'icon',
      component: Icon
    },
    {
      path: '/income',
      name: 'income',
      component: Income
    },
    {
      path: '/incomecategory',
      name: 'incomecategory',
      component: IncomeCategory
    },
    {
      path: '/payee',
      name: 'payee',
      component: Payee
    },
    {
      path: '/paymentmethod',
      name: 'paymentmethod',
      component: PaymentMethod
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
