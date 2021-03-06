// import {router} from '../index'

// const API_URL = 'http://localhost:3001/'
// const LOGIN_URL = API_URL + 'sessions/create/'
// const SIGNUP_URL = API_URL + 'users/'

import Vue from 'vue'
import Promise from 'bluebird'
import router from '../../router/'

export default {
  user: {
    authenticated: false
  },
  signup (credentials, redirect) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('signup', credentials).then(response => {
        console.log(response.data)
        console.log('authorizing after signup')
        this.login(credentials, redirect)
        this.user.authenticated = true
        if (redirect) {
          router.push(redirect)
        }
      }
      ).catch((error) => {
        console.log('failed to signup' + error)
      })
    })
  },
  login (credentials, redirect) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('auth', credentials).then(response => {
        console.log('authorizing after login')
        sessionStorage.setItem('auth_token', response.data.token)
        console.log(response.data.token)
        this.user.authenticated = true
        if (redirect) {
          router.push(redirect)
        }
      }
        ).catch((error) => {
          console.log('failed to login' + error)
        })
    })
  },
  logout () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('auth/signout').then(response => {
        console.log('signing out')
        sessionStorage.removeItem('auth_token')
        this.user.authenticated = false
      }
        ).catch((error) => {
          console.log('failed to logout' + error)
        })
    })
  },
  checkAuth () {
    var jwt = sessionStorage.getItem('auth_token')
    if (jwt) {
      this.user.authenticated = true
    } else {
      this.user.authenticated = false
      router.push('login')
    }
  }
}
