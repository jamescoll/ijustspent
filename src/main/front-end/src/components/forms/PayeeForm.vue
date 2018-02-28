<template>
  <div>
    <p>Hello, world!</p>
  </div>
</template>

<script>
  import service from '../../services/expenses/payeeservice'
  // import loginservice from '../../services/authorization/authorizationservice'

  export default {
    name: 'add-payee-form',
    data: function () {
      return {
        payee: {
          name: null,
          accountNumber: null,
          phoneNumber: null,
          website: null,
          note: null
        },
        credentials: {
          username: null,
          password: null
        }
      }
    },
    mounted: function () {
      this.doTheThing()
    },
    methods: {
      doTheThing () {
        var tmpPayee = {
          name: 'ASDF',
          accountNumber: 'ASDF',
          phoneNumber: 'ASDF',
          website: 'ASDF',
          note: 'ASDF'
        }
        console.log(tmpPayee)
        console.log('Calling Get Payees')
        console.log(service.getPayees())
        console.log('Calling Create Payee')
        service.createPayee(tmpPayee)
        console.log('Calling Create Payee')
        service.createPayee(tmpPayee).then(function (data) {
          console.log(data)
          data.name = 'QWERTY'
          console.log('Calling Update Payee')
          service.updatePayee(data)
          console.log('Calling Get Payee for Payee ' + data.id)
          service.getPayee(data.id)
          console.log('Calling Delete Payee for Payee ' + data.id)
          service.deletePayee(data.id)
        })
       /* this.credentials.username = 'admin'
        this.credentials.password = 'password'
        loginservice.login(this.credentials, redirect) */
      }
    }
  }
</script>
