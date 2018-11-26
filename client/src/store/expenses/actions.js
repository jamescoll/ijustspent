import api from '@/services/api';

export default {
  fetchExpenses: async ({ commit, rootState }) => {
    try {
      const response = await api.fetchExpenses(rootState.user.user);
      commit('receiveExpenses', response);
    } catch (err) {
      console.error(err);
    }
  },
};
