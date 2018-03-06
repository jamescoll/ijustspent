<template>

 <div>
    <h3 class="center">Account Type</h3>
    <form v-on:submit.prevent="createAccountType">
       <section class="form">
  <div class="form-group">
    <label class="label">Type</label>
    <div class="control">
      <input v-model="accounttype.type" class="form-control" type="text" placeholder="Account Type">
    </div>
  </div>
<div class="form-group">
    <label class="label">Icon</label>
    <div class="control">
      <select v-model="accounttype.icon">
        <option v-for="option in icons" v-bind:value="option" v-bind:key="option.id">
    {{ option.iconName }}
  </option>
      </select>
    </div>
  </div>
</section>
<button
  v-on:click="createAccountType"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>
</div>




</div>


</template>

<script>
import accounttypeservice from '../../services/accounts/accounttypeservice'
import iconservice from '../../services/resources/iconservice'

export default {
  name: 'accounttype',
  data () {
    return {
      accounttype: {
        type: null,
        icon: null

      },
      icons: [],
      loaded: false,
      selectedIcon: null
    }
  },
  created () {
    this.getIcons()
  },
  methods: {
    createAccountType () {
      accounttypeservice.createAccountType(this.accounttype)
    },
    async getIcons () {
      this.icons = await iconservice.getIcons()
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
