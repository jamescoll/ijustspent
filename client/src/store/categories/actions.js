import api from '@/services/api';

export default {
  fetchCategories: async ({ commit, rootState }) => {
    try {
      const response = await api.fetchCategories(rootState.user.user);
      commit('receiveCategories', response);
    } catch (err) {
      console.error(err);
    }
  },
};
