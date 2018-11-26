import api from '@/services/api';

export default {
  login: async ({ commit }, { email, password }) => {
    try {
      commit('setFlag', { flag: 'submittingLogin', status: true }, { root: true });
      const data = await api.login({ email, password });
      console.debug(data);
      commit('receiveUser', data.user);
      commit('receiveToken', data.token);
    } catch (err) {
      throw err;
    } finally {
      commit('setFlag', { flag: 'submittingLogin', status: false }, { root: true });
    }
  },
  register: async ({ commit }, { email, password }) => {
    try {
      commit('setFlag', { flag: 'submittingRegistration', status: true }, { root: true });
      const data = await api.register({ email, password });
      console.debug(data);
      commit('receiveUser', data.user);
      commit('receiveToken', data.token);
    } catch (err) {
      throw err;
    } finally {
      commit('setFlag', { flag: 'submittingRegistration', status: false }, { root: true });
    }
  },
};
