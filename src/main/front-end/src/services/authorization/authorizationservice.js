// import {router} from '../index'

// const API_URL = 'http://localhost:3001/'
// const LOGIN_URL = API_URL + 'sessions/create/'
// const SIGNUP_URL = API_URL + 'users/'

import Vue from 'vue'
import Promise from 'bluebird'
import router from '../../router/'

// todo plugin in signup to a signup url

export default {
  user: {
    authenticated: false
  },
  login (credentials, redirect) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('signup', credentials).then(response => {
        console.log(response.data)
        this.authorize(response.data)
        this.user.authenticated = true
        if (redirect) {
          router.push(redirect)
        }
      }
      ).catch((error) => {
        console.log('unauthorized' + error)
      })
    })
  },
  authorize (data) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('auth', data).then(response => {
        sessionStorage.setItem('auth_token', response.data.token)
        console.log(response.data.token)
        this.user.authenticated = true
      }
        ).catch((error) => {
          console.log('unauthorized' + error)
        })
    })
  },
   // todo this now doesn't work... copy login here this is a placeholder which is the same as sign-in - in fact, it should be sending user state to the back-end
  signup (credentials, redirect) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('signup', credentials).then(response => {
        sessionStorage.setItem('auth_token', response.headers.authorization)
        this.user.authenticated = true
        if (redirect) {
          router.push(redirect)
        }
      }
      ).catch((error) => {
        reject(error)
      })
    })
  },
  logout () {
    // todo this is connected to localStorage but the other to sessionStorage resolve later
    sessionStorage.removeItem('auth_token')
    this.user.authenticated = false
    router.push('/')
  },
  checkAuth () {
    var jwt = sessionStorage.getItem('auth_token')
    if (jwt) {
      this.user.authenticated = true
    } else {
      this.user.authenticated = false
    }
  },
  getAuthHeader () {
    return {
      // todo i don't think this method is used
      'Authorization': sessionStorage.getItem('auth_token')
    }
  }
}
