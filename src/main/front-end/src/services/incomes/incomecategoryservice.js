import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createPayee (incomeCategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/incomecategories', incomeCategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getPayees () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/incomecategories').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getPayee (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/incomecategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updatePayee (incomeCategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/incomecategories', incomeCategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deletePayee (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/incomecategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deletePayees () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/incomecategories/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
