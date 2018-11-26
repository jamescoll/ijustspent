export default {
  receiveToken: (state, token) => {
    state.token = token;
  },
  receiveUser: (state, user) => {
    state.user = user;
  },
  logout: state => {
    state.token = null;
    state.user = null;
  },
};
