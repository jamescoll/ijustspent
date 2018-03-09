<template>
  <div>
    <div class="row">
   <div class="col-sm-4">
 <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                 <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Dashboard</span>
              <a class="d-flex align-items-center text-muted" href="#">
                <span data-feather="plus-circle"></span>
              </a>
            </h6>
              </li>
              <li class="nav-item">
                <a class="nav-link" v-bind:class="{ active: showAccounts }" v-on:click="showAccounts=!showAccounts">
                  <span data-feather="file"></span>
                  Accounts
                </a>
              </li>
              <div v-if="showAccounts">
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addAccount')">
                  <span data-feather="shopping-cart"></span>
                  Add Account
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addAccountType')">
                  <span data-feather="users"></span>
                  Add Account Type
                </a>
              </li>
              </div>
              <li class="nav-item">
                <a class="nav-link" v-bind:class="{ active: showExpenses }" v-on:click="showExpenses=!showExpenses">
                  <span data-feather="file"></span>
                  Expenses
                </a>
              </li>
              <div v-if="showExpenses">
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addExpenseCategory')">
                  <span data-feather="shopping-cart"></span>
                  Add Expense Category
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addExpense')">
                  <span data-feather="users"></span>
                  Add Expense
                </a>
              </li>
               <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addExpenseSubcategory')">
                  <span data-feather="shopping-cart"></span>
                  Add Expense Subcategory
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addPayee')">
                  <span data-feather="users"></span>
                  Add Payee
                </a>
              </li>
               <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addPaymentMethod')">
                  <span data-feather="shopping-cart"></span>
                  Add Payment Method
                </a>
              </li>
              </div>
                <li class="nav-item">
                <a class="nav-link" v-bind:class="{ active: showIncomes }" v-on:click="showIncomes=!showIncomes">
                  <span data-feather="file"></span>
                  Incomes
                </a>
              </li>
              <div v-if="showIncomes">
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addIncomeCategory')">
                  <span data-feather="shopping-cart"></span>
                  Add Income Category
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addIncome')">
                  <span data-feather="users"></span>
                  Add Income
                </a>
              </li>
              </div>
                <li class="nav-item">
                <a class="nav-link" v-bind:class="{ active: showResources }" v-on:click="showResources=!showResources">
                  <span data-feather="file"></span>
                  Resources
                </a>
              </li>
              <div v-if="showResources">
              <li class="nav-item">
                <a class="nav-link text-muted" v-on:click="setCenterPane('addIcon')">
                  <span data-feather="shopping-cart"></span>
                  Add Icon
                </a>
              </li>
              </div>
              </ul>
          </div>
        </nav>
   </div>
   <div class="col-sm-4">
     <div v-if="selectedView=='addAccount'"><account></account></div>
    <div v-if="selectedView=='addAccountType'"><accounttype></accounttype></div>
      <div v-if="selectedView=='addExpenseCategory'"><expensecategory></expensecategory></div>
    <div v-if="selectedView=='addExpense'"><expense></expense></div>
      <div v-if="selectedView=='addExpenseSubcategory'"><expensesubcategory></expensesubcategory></div>
    <div v-if="selectedView=='addPayee'"><payee></payee></div>
      <div v-if="selectedView=='addPaymentMethod'"><paymentmethod></paymentmethod></div>
    <div v-if="selectedView=='addIncome'"><income></income></div>
      <div v-if="selectedView=='addIncomeCategory'"><incomecategory></incomecategory></div>
    <div v-if="selectedView=='addIcon'"><icon></icon></div>
   </div>
    <div class="col-sm-4"></div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'budgetedit',
  data () {
    return {
      showAccounts: false,
      showExpenses: false,
      showIncomes: false,
      showResources: false,
      selectedView: ''
    }
  },
  mounted: function () {
  },
  methods: {
    setCenterPane (selectedView) {
      this.selectedView = selectedView
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

.sidebar {
  position: fixed;
  z-index: 100; /* Behind the navbar */
  padding: 0;
  box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
}

.sidebar-sticky {
  position: -webkit-sticky;
  position: sticky;
  top: 48px; /* Height of navbar */
  height: calc(100vh - 200px);
  padding-top: .5rem;
  overflow-x: hidden;
  overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
}

.sidebar .nav-link {
  font-weight: 500;
  color: #333;
}

.sidebar .nav-link .feather {
  margin-right: 4px;
  color: #999;
}

.sidebar .nav-link.active {
  color: #007bff;
}

.sidebar .nav-link:hover .feather,
.sidebar .nav-link.active .feather {
  color: inherit;
}

.sidebar-heading {
  font-size: .75rem;
  text-transform: uppercase;
}
</style>
