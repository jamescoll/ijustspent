<template>
  <section class="login section">
    <form
      @submit.prevent="handleSubmit"
      class="login__container container">
      <InputGroup
        :label="'Email'"
        :error="errors.first('email')">
        <TextInput
          v-model="email"
          v-validate="{ required: true, email: true }"
          data-vv-name="email"
          autocomplete="email"
          autofocus
          :type="'email'"
        />
      </InputGroup>
      <InputGroup
        :label="'Password'"
        :error="errors.first('password')">
        <TextInput
          v-model="password"
          v-validate="{ required: true, min: 8 }"
          data-vv-name="password"
          type="password"
          autocomplete="current_password"
          @keyup.enter="handleSubmit"
        />
      </InputGroup>
      <div class="field">
        <button
          class="button is-primary is-fullwidth"
          :class="{ 'is-loading': flag('submittingLogin') || routeLoading }"
          @click="handleSubmit">
          Login
        </button>
      </div>
      <div class="field">
        <router-link
          :to="{ name: 'Register' }"
          class="button is-fullwidth">
          I don't have an account
        </router-link>
      </div>
    </form>
  </section>
</template>

<script>
import TextInput from '@/components/TextInput.vue';
import InputGroup from '@/components/InputGroup.vue';
import { mapActions, mapGetters, mapState } from 'vuex';

export default {
  components: {
    TextInput,
    InputGroup,
  },
  data() {
    return {
      email: '',
      password: '',
    };
  },
  computed: {
    ...mapState({
      routeLoading: state => state.routeLoading,
    }),
    ...mapGetters({
      flag: 'flag',
    }),
  },
  methods: {
    ...mapActions({
      login: 'user/login',
    }),
    async handleSubmit() {
      const valid = await this.$validator.validateAll();
      if (valid) {
        try {
          await this.login({
            email: this.email,
            password: this.password,
          });
          this.$router.push({ name: 'Home' });
        } catch (err) {
          this.$validator.errors.add({
            field: 'password',
            msg: err.message,
          });
        }
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.login {
  &__container {
    max-width: 300px;
  }
}
</style>
