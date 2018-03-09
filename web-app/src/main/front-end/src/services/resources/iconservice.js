import Vue from 'vue'
import Promise from 'bluebird'

export default {
  createIcon (icon) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/icons', icon).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getIcons () {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/icons').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  getIcon (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.get('v1/icons/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  updateIcon (icon) {
    return new Promise((resolve, reject) => {
      Vue.$http.post('v1/icons', icon).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteIcon (id) {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/icons/' + id).then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  },
  deleteIcons () {
    return new Promise((resolve, reject) => {
      Vue.$http.delete('v1/icons/').then(({data}) => {
        console.log(data)
        resolve(data)
      }).catch((error) => {
        reject(error)
      })
    })
  }
}
