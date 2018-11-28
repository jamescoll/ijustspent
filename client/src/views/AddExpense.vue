<template>
  <div class="add-expense">
    <div class="add-expense__amount">
      $100.00
    </div>
    <div class="add-expense__keys">
      <button class="button is-outline add-expense__key" @click="handleClickNumber(1)">1</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(2)">2</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(3)">3</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(4)">4</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(5)">5</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(6)">6</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(7)">7</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(8)">8</button>
      <button class="button is-outline add-expense__key" @click="handleClickNumber(9)">9</button>
      <button class="button is-outline add-expense__key" @click="handleClickDecimal">.</button>
      <button class="button is-outline add-expense__key" @click="handleClickZero">0</button>
      <button class="button is-outline add-expense__key" @click="handleClickBackspace"><i class="mdi mdi-backspace" /></button>
    </div>
    <button class="button is-primary is-large is-fullwidth add-expense__choose-category">Choose category</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      amount: '',
    };
  },
  methods: {
    handleClickNumber(value) {

    },
    handleClickZero() {

    },
    handleClickDecimal() {

    },
    handleClickBackspace() {

    }
  }
};
</script>

<style lang="scss" scoped>
@import '@/assets/scss/_variables.scss';

.add-expense {
  padding: 1em;
  &__amount {
    padding: 1.5rem 3rem;
    font-family: $family-code;
    background-color: $code-background;
    text-align: center;
    font-size: 2em;
  }
  &__keys {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr 1fr;
    grid-gap: 15px;
    height: 55vh;
    margin-top: 1em;
  }
  &__key {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    box-shadow: $light-shadow;
  }
  &__choose-category {
    margin-top: 1em;
  }
}
</style>