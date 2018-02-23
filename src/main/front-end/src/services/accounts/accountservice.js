import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createAccount (account) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/accounts', account).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getAccounts () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/accounts').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getAccount (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/accounts/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateAccount (account) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/accounts', account).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteAccount (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/accounts/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteAccounts () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/accounts').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
