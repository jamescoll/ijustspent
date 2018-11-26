import { keyBy } from 'lodash';

export default {
  categoriesById: state => keyBy(state.categories, 'id'),
};
