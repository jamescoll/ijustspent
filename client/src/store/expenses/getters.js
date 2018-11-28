export default {
  expensesWithCategories: (state, getters, rootState, rootGetters) => state.expenses.map(expense => ({ /* eslint-disable-line */
    ...expense,
    category: rootGetters['categories/categoriesById'][expense.category] || null,
  })),
};
