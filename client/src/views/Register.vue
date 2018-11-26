<template>
  <section class="register section">
    <form
      @submit.prevent="handleSubmit"
      class="register__container container">
      <InputGroup
        :label="'Email'"
        :error="errors.first('email')">
        <TextInput
          v-model="email"
          v-validate="{ required: true, email: true }"
          data-vv-name="email"
          type="email"
          autocomplete="email"
          autofocus
        />
      </InputGroup>
      <InputGroup
        :label="'Password'"
        :error="errors.first('password')">
        <TextInput
          v-model="password"
          v-validate="{ required: true, min: 8 }"
          data-vv-name="password"
          ref="password"
          type="password"
          autocomplete="new_password"
        />
      </InputGroup>
      <InputGroup
        :label="'Confirm password'"
        :error="errors.first('confirm')">
        <TextInput
          v-model="confirmPassword"
          v-validate="{ required: true, confirmed: 'password' }"
          data-vv-name="confirm"
          data-vv-as="password"
          type="password"
          autocomplete="new_password"
          @keyup.enter="handleSubmit"
        />
      </InputGroup>
      <div class="field">
        <button
          class="button is-primary is-fullwidth"
          :class="{ 'is-loading': flag('submittingRegistration') }"
          @click="handleSubmit">
          Register
        </button>
      </div>
      <div class="field">
        <router-link
          :to="{ name: 'Login' }"
          class="button is-fullwidth">
          I already have an account
        </router-link>
      </div>
    </form>
  </section>
</template>

<script>
import TextInput from '@/components/TextInput.vue';
import InputGroup from '@/components/InputGroup.vue';
import { mapActions, mapGetters } from 'vuex';

export default {
  components: {
    TextInput,
    InputGroup,
  },
  data() {
    return {
      email: '',
      password: '',
      confirmPassword: '',
    };
  },
  computed: {
    ...mapGetters({
      flag: 'flag',
    }),
  },
  methods: {
    ...mapActions({
      register: 'user/register',
    }),
    async handleSubmit() {
      const valid = await this.$validator.validateAll();
      if (valid) {
        try {
          await this.register({
            email: this.email,
            password: this.password,
          });
          this.$router.push({ name: 'Home' });
        } catch (err) {
          this.$validator.errors.add({
            field: 'confirm',
            msg: err.message,
          });
        }
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.register {
  &__container {
    max-width: 300px;
  }
}
</style>
