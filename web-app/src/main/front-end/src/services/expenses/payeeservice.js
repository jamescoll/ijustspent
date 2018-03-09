import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createPayee (payee) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/payees', payee).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getPayees () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/payees').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getPayee (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/payees/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updatePayee (payee) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/payees', payee).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deletePayee (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/payees/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deletePayees () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/payees/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
