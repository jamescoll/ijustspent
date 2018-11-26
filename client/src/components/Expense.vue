<template>
  <div class="expense card">
    <header class="expense__header card-header">
      <p class="card-header-title">
        {{ formattedAmount }}
        {{ expense.category.amount }}
      </p>
      <router-link
        :to="{}"
        class="expense__edit button is-outline">
        <i class="mdi mdi-square-edit-outline" />
      </router-link>
      <!-- <button class="expense__edit button is-outline" aria-label="more options">
        <i class="mdi mdi-square-edit-outline" />
      </button> -->
    </header>
    <footer class="card-footer">
      <div class="card-footer-item">{{ expense.category.name }}</div>
      <div class="card-footer-item">{{ expense.date }}</div>
    </footer>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  props: {
    expense: {
      type: Object,
      required: true,
    }
  },
  computed: {
    ...mapState({
      user: state => state.user.user,
    }),
    formattedAmount() {
      return `${this.user.currency}${Math.floor(this.expense.amount / 100)}`;
    }
  }
};
</script>

<style lang="scss" scoped>
.expense {
  &__header {
    align-items: center;
  }
  &__edit {
    margin-right: 5px;
  }
}
</style>