<template>
  <div class="home">
    <Expense
      v-for="expense in expenses"
      :expense="expense"
      :key="expense.id"
      class="home__expense"
    />
  </div>
</template>

<script>
import Expense from '@/components/Expense.vue';
import store from '@/store';
import { mapGetters } from 'vuex';

export default {
  components: {
    Expense,
  },
  data() {
    return {
      expense: {
        id: 1,
        amount: 500,
        date: '2018-11-19',
        category: {
          id: 1,
          name: 'Phone'
        }
      }
    };
  },
  computed: {
    ...mapGetters({
      expenses: 'expenses/expensesWithCategories'
    })
  },
  async beforeRouteEnter(to, from, next) {
    await Promise.all([
      store.dispatch('expenses/fetchExpenses'),
      store.dispatch('categories/fetchCategories'),
    ]);
    next();
  },
};
</script>

<style lang="scss" scoped>
.home {
  &__expense {
    margin: 1em;
  }
}
</style>
