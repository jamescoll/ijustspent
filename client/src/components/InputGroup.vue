<template>
  <div class="field">
    <label class="label">{{ label }}</label>
    <slot></slot>
    <p v-if="error"
      class="help is-danger">
      {{ error }}
    </p>
  </div>
</template>

<script>
export default {
  props: {
    label: {
      type: String,
      required: true,
    },
    error: {
      type: String,
    },
  },
};
</script>

<style lang="scss" scoped>

</style>
