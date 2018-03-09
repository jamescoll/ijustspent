<template>
  <div>
    <h3 class="center">Expense</h3>
    <form v-on:submit.prevent="createExpense">
       <section class="form">

  <div class = "form-group">
  <label class="label">Expense Date</label>
    <div class = "control">
   <datepicker v-model="expense.date" @opened="datepickerOpenedFunction" @closed="datepickerClosedFunction"></datepicker>
    </div></div>
 <div class="form-group">
    <label class="label">Expense Category</label>
    <div class="control">
      <select v-model="expense.expenseCategory">
        <option v-for="option in expenseCategories" v-bind:value="option" v-bind:key="option.id">
    {{ option.categoryName }}
  </option>
      </select>
    </div>
  </div>
   <div class="form-group">
      <label class="label">Amount</label>
      <div class="control">
        <input v-model="expense.amount" class="form-control" type="text" placeholder="Amount">
      </div>
    </div>
     <div class="form-group">
        <label class="label">Payee</label>
        <div class="control">
          <select v-model="expense.payee">
            <option v-for="option in payees" v-bind:value="option" v-bind:key="option.id">
        {{ option.name }}
      </option>
          </select>
        </div>
      </div>
    <div class="form-group">
      <label class="label">Note</label>
      <div class="control">
        <textarea v-model="expense.note" class="form-control" type="text" placeholder="Expense Note"></textarea>
      </div>
    </div>


</section>
<button
  v-on:click="createExpense"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>
</div>
</template>

<script>
import expenseservice from '../../services/expenses/expenseservice'
import expensecategoryservice from '../../services/expenses/expensecategoryservice'
import payeeservice from '../../services/expenses/payeeservice'

export default {
  name: 'expense',
  data () {
    return {
      expense: {
        date: null,
        expenseCategory: null,
        amount: null,
        payee: null,
        note: null
      },
      expenseCategories: [],
      payees: []
    }
  },
  created () {
    this.getExpenseCategories()
    this.getPayees()
  },
  methods: {
    createExpense () {
      console.log(expenseservice.createExpense(this.expense))
    },
    async getExpenseCategories () {
      this.expenseCategories = await expensecategoryservice.getExpenseCategories()
    },
    async getPayees () {
      this.payeeservice = await payeeservice.getPayees()
    },
    datepickerOpenedFunction () {
      this.expense.date = new Date()
    },
    datepickerClosedFunction () {
      console.log(this.expense.date)
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
