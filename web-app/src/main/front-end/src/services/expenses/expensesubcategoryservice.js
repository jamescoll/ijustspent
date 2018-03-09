import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createExpenseSubCategory (expensesubcategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expensesubcategories', expensesubcategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseSubCategories () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expensesubcategories').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseSubCategory (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expensesubcategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateExpenseSubCategory (expensesubcategory) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expensesubcategories', expensesubcategory).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpenseSubCategory (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expensesubcategories/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpenseSubCategories () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expensesubcategories').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
