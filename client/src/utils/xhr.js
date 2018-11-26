import axios from 'axios';
import router from '@/router';
import store from '../store';

const instance = axios.create({
  //
});

instance.interceptors.response.use(
  response => response,
  error => {
    if (error.status === '401') {
      store.commit('user/logout');
      router.push({ name: 'Login' });
    }
    return error;
  },
);

instance.interceptors.request.use(config => ({
  ...config,
  headers: {
    ...config.headers,
    Authorization: `Bearer ${store.state.user.token}`,
  },
}));

export default instance;
