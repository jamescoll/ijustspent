<template>
  <div>
    <div class="row">
   <div class="col-sm-4"></div>
   <div class="col-sm-4">

    <h3 class="center">Payee</h3>
    <form v-on:submit.prevent="createPayee">
       <section class="form">
  <div class="form-group">
    <label class="label">Name</label>
    <div class="control">
      <input v-model="payee.name" class="form-control" type="text" placeholder="Payee Name">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Account Number</label>
    <div class="control">
      <input v-model="payee.accountNumber" class="form-control" type="text" placeholder="Account Number">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Phone Number</label>
    <div class="control">
      <input v-model="payee.phoneNumber" class="form-control" type="text" placeholder="Phone Number">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Website</label>
    <div class="control">
      <input v-model="payee.website" class="form-control" type="text" placeholder="Website">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Note</label>
    <div class="control">
      <input v-model="payee.note" class="form-control" type="text" placeholder="Payee Name">
    </div>
  </div>
</section>
<button
  v-on:click="createPayee"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>


   </div>
    <div class="col-sm-4"></div>
    </div>
  </div>
</template>

<script>
import service from '../../services/expenses/payeeservice'

export default {
  name: 'budgetedit',
  data () {
    return {
      payee: {
        name: null,
        accountNumber: null,
        phoneNumber: null,
        website: null,
        note: null
      }
    }
  },
  mounted: function () {
  },
  methods: {
    createPayee () {
      console.log(service.createPayee(this.payee))
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
