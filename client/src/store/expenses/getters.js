export default {
  expensesWithCategories: (state, getters, rootGetters) => state.expenses.map(expense => ({
    ...expense,
    category: rootGetters['categories/categoriesById'][expense.id],
  })),
};
