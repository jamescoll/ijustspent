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

    </div>
  </div>
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

</style>
