import Vue from 'vue'
import Promise from 'bluebird'

export default {
  getTechnologyDetails (technology) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/technologies/' + technology).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseTotals () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/expensetotals/').then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpense (name) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/expensetotals/' + name).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
