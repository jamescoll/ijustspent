module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    'plugin:vue/essential',
    '@vue/airbnb',
  ],
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'arrow-parens': 'off',
    'no-param-reassign': 'off',
    'quotes': 'off',
    'no-prototype-builtins': 'off',
    'no-nested-ternary': 'off',
    'no-unused-expressions': 'off',
    'no-plusplus': 'off',
  },
  parserOptions: {
    parser: 'babel-eslint',
  },
};