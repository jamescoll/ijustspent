import Vue from 'vue'
import Promise from 'bluebird'

export default {
  getExpenses () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/expensetotals/').then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getExpenseTotals (description) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('/expensetotals/' + description).then(({data}) => {
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
