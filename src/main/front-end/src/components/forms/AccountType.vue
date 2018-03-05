<template>
<div>
<ul>
         <li v-for="(data, index) in icons" :key="index">{{ index }}.{{data.iconName}}</li>
</ul>
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
      icons: null,
      loaded: false,
      selectedIcon: null
    }
  },
  beforeMount () {
    this.icons = this.getIcons()
  },
  methods: {
    createAccountType () {
      console.log(accounttypeservice.createAccountType(this.accounttype))
    },
    getIcons () {
      return iconservice.getIcons()
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
