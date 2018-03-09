<template>

    <div class="row">
       <div class="col-sm-2"></div>
   <div class="col-sm-8">
      <h3 class="center">January Expenditure</h3>
      <table class="table table-striped">
        <thead class="thead-default">
          <tr>
            <th>Category</th>
            <th>Amount</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="entry in expenses">
            <td>{{entry.name}}</td>
            <td>{{entry.total}}</td>
          </tr>
        </tbody>
      </table>
   </div>
   <div class="col-sm-2"></div></div>


</template>

<script>
import service from '../../services/demo/demoservice'

export default {
  name: 'budgettable',
  data () {
    return {
      expenses: ''
    }
  },
  beforeRouteEnter (to, from, next) {
    service.getExpenses().then((data) => {
      next(vm => {
        vm.expenses = data
      })
      console.log(data)
    })
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
