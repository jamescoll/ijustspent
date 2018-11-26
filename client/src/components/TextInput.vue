<template>
  <input
    v-bind="options"
    :type="type"
    class="input"
    @input="handleInput"
  />
</template>

<script>
export default {
  props: {
    value: {
      type: String,
    },
    options: {
      type: Object,
    },
    type: {
      type: String,
      default: () => 'text',
    },
  },
  methods: {
    handleInput(event) {
      this.$emit('input', event.target.value);
    },
  },
};
</script>

<style lang="scss" scoped>

</style>
