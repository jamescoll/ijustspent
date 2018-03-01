<template>
  <div>
    <div>
      <h1>Table View</h1>
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
      <div class="mt-5">
        <router-link to="/" class="btn btn-primary">Back</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import service from '../../services/deleteme/tempexpenseservice'

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

</style>
