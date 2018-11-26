import Vue from 'vue';
import Vuex from 'vuex';
import { cloneDeep } from 'lodash';
import user from './user';
import expenses from './expenses';
import categories from './categories';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    flags: {},
    routeLoading: false,
  },
  getters: {
    flag: state => flag => state.flags.hasOwnProperty(flag),
  },
  mutations: {
    setFlag: (state, { flag, status }) => {
      const clone = cloneDeep(state.flags);
      status
        ? clone.hasOwnProperty(flag)
          ? clone[flag]++
          : clone[flag] = 1
        : clone.hasOwnProperty(flag)
          ? clone[flag] > 1
            ? clone[flag]--
            : delete clone[flag]
          : null;
      state.flags = clone;
    },
    setRouteLoading: (state, status) => {
      state.routeLoading = status;
    },
  },
  actions: {

  },
  modules: {
    user,
    expenses,
    categories,
  },
});
