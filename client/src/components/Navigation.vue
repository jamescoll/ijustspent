<template>
  <nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <router-link :to="{ name: 'Home' }" class="navbar-item">
        <strong>Ijustspent</strong>
      </router-link>

      <a role="button" class="navbar-burger burger"
        :class="{ 'is-active': burgerOpen }"
        aria-label="menu"
        aria-expanded="false"
        data-target="navbarBasicExample"
        @click="burgerOpen = !burgerOpen">
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>

    <div
      id="navbarBasicExample"
      class="navbar-menu"
      :class="{ 'is-active': burgerOpen }">
      <div class="navbar-start">
        <router-link
          :to="{ name: 'Home' }"
          class="navbar-item">
          Home
        </router-link>
        <router-link
          :to="{ name: 'Budget' }"
          class="navbar-item">
          Budget
        </router-link>
        <router-link
          :to="{ name: 'Home' }"
          class="navbar-item">
          Spendings
        </router-link>
      </div>

      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <router-link v-if="!authenticated" :to="{ name: 'Login' }" class="button is-primary">
              <strong>Login</strong>
            </router-link>
            <router-link v-if="!authenticated" :to="{ name: 'Register' }" class="button is-light">
              Register
            </router-link>
            <button v-if="authenticated" @click="handleLogout" class="button is-outlined">
              Logout
            </button>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
import { mapMutations, mapGetters } from 'vuex';

export default {
  data() {
    return {
      burgerOpen: false,
    };
  },
  computed: {
    ...mapGetters({
      authenticated: 'user/authenticated'
    }),
  },
  methods: {
    ...mapMutations({
      logout: 'user/logout'
    }),
    handleLogout() {
      this.$router.push({ name: 'Login' });
      this.logout();
    },
  }
};
</script>

<style lang="scss" scoped>

</style>
