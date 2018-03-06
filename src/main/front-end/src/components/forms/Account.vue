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
 <div class="form-group">
    <label class="label">Icon</label>
    <div class="control">
      <select v-model="account.accountType">
        <option v-for="option in accountTypes" v-bind:value="option" v-bind:key="option.id">
    {{ option.type }}
  </option>
      </select>
    </div>
  </div>
  <div class = "form-group">
    <div class = "control">
   <datepicker v-model="account.date" @opened="datepickerOpenedFunction" @closed="datepickerClosedFunction"></datepicker>
    </div></div>
 <div class = "form-group">
    <div class = "control">
<input type="checkbox" id="checkbox" v-model="account.includeInTotals">
<label for="checkbox">Include in Totals</label>
    </div></div>
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
      accountTypes: []
    }
  },
  created () {
    this.getAccountTypes()
  },
  methods: {
    createAccount () {
      console.log(accountservice.createAccount(this.account))
    },
    async getAccountTypes () {
      this.accountTypes = await accounttypeservice.getAccountTypes()
    },
    datepickerOpenedFunction () {
      this.account.date = new Date()
    },
    datepickerClosedFunction () {
      console.log(this.account.date)
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
