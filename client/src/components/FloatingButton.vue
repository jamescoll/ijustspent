<template>
  <router-link
    :to="{ name: 'AddExpense' }"
    class="floating-button">
    +
  </router-link>
</template>

<script>
export default {
  
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/_variables.scss';

.floating-button {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 2em;
  width: 2em;
  font-size: 2em;
  position: fixed;
  bottom: 1em;
  right: 1em;
  border-radius: 200px;
  color: $white;
  background-color: $primary;
  box-shadow: $heavy-shadow;
  user-select: none;
}
</style>