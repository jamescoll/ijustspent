<template>
  <div>

    <h3 class="center">Expense Subcategory</h3>
    <form v-on:submit.prevent="createExpenseSubcategory">
       <section class="form">

  <div class="form-group">
      <label class="label">Subcategory Name</label>
      <div class="control">
        <input v-model="expensesubcategory.subcategoryName" class="form-control" type="text" placeholder="Subcategory Name"></textarea>
      </div>
    </div>

 <div class="form-group">
    <label class="label">Expense Category</label>
    <div class="control">
      <select v-model="expensesubcategory.expenseCategory">
        <option v-for="option in expenseCategories" v-bind:value="option" v-bind:key="option.id">
    {{ option.categoryName }}
  </option>
      </select>
    </div>
  </div>




</section>
<button
  v-on:click="createExpenseSubcategory"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>
</div>
</template>

<script>
import expensesubcategoryservice from '../../services/expenses/expensesubcategoryservice'
import expensecategoryservice from '../../services/expenses/expensecategoryservice'
import iconservice from '../../services/resources/iconservice'

export default {
  name: 'subcat',
  data () {
    return {
      expensesubcategory: {
        subcategoryName: null,
        expenseCategory: null,
        icon: null
      },
      expenseCategories: [],
      icon: null
    }
  },
  created () {
    this.getExpenseCategories()
    this.getIcon('5aa30ad78de60403c424087d')
  },
  methods: {
    createExpenseSubcategory () {
      this.expensesubcategory.icon = this.icon
      console.log(expensesubcategoryservice.createExpenseSubCategory(this.expensesubcategory))
    },
    async getExpenseCategories () {
      this.expenseCategories = await expensecategoryservice.getExpenseCategories()
    },
    async getIcon (id) {
      this.icon = await iconservice.getIcon(id)
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
