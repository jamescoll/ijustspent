import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createExpense (expense) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expenses/', expense).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenses () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expenses').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpense (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/expenses/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateExpense (expense) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/expenses', expense).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpense (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expenses/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteExpenses () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/expenses/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
