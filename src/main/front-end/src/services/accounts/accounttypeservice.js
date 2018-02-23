import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createAccountType (accountType) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/accounttypes', accountType).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getAccountTypes () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/accounttypes').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getAccountType (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/accounttypes/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateAccountType (accountType) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/accounttypes', accountType).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteAccountType (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/accounttypes/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteAccountTypes () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/accounttypes').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
