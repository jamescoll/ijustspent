<template>
  <div>
    <h3 class="center">Account</h3>
    <form v-on:submit.prevent="createAccount">
       <section class="form">
  <div class="form-group">
    <label class="label">Name</label>
    <div class="control">
      <input v-model="account.name" class="form-control" type="text" placeholder="Account Name">
    </div>
  </div>

</section>
<button
  v-on:click="createAccount"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>
</div>
</template>

<script>
import accountservice from '../../services/accounts/accountservice'
import accounttypeservice from '../../services/accounts/accounttypeservice'

export default {
  name: 'account',
  data () {
    return {
      account: {
        name: null,
        accountType: null,
        date: null,
        includeInTotals: null
      },
      accountTypes: null
    }
  },
  mounted: function () {
  },
  methods: {
    createAccount () {
      console.log(accountservice.createAccount(this.account))
    },
    getAccountTypes () {
      this.accountTypes = accounttypeservice.getAccountTypes()
    }
  }
}
</script>

<style scoped>
.center {
  text-align:center;
  padding: 20px;
}
.centerBlock {
   margin-left:auto;
   margin-right:auto;
   display:block;
}

</style>
