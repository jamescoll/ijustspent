import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createExpenseCategory (expensecategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expensecategories', expensecategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseCategories () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expensecategories').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseCategory (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expensecategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateExpenseCategory (expensecategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expensecategories', expensecategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpenseCategory (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expensecategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpenseCategories () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expensecategories/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
