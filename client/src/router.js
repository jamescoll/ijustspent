import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import store from './store';

Vue.use(Router);

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: {
        auth: true,
      },
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('./views/Register.vue'),
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('./views/Login.vue'),
    },
  ],
});

router.beforeEach((to, from, next) => {
  store.commit('setRouteLoading', true);
  to.matched.some(route => route.meta.auth)
    ? store.getters['user/authenticated']
      ? next()
      : next({ name: 'Login' })
    : next();
});

router.afterEach(() => {
  store.commit('setRouteLoading', false);
});

export default router;
