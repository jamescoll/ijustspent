import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createIncome (income) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/incomes', income).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getIncomes () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/incomes').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getIncome (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/incomes/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateIncome (income) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/incomes', income).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteIncome (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/incomes/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteIncomes () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/incomes/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
