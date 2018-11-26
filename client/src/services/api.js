// import xhr from '@/utils/xhr';

export default {
  login({ email, password }) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (email === 'seb@example.com' && password === '123456789') {
          resolve({
            token: 'some_valid_token',
            user: {
              name: 'Seb',
              currency: '$',
            },
          });
        } else {
          reject(new Error('Incorrect email and password combination'));
        }
      }, 1000);
    });
    // return xhr.post(`test`);
  },
  register({ email }) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (email !== 'seb@example.com') {
          resolve({
            token: 'some_valid_token',
            user: {
              name: 'Seb',
              currency: '$',
            },
          });
        } else {
          reject(new Error('Email already in use'));
        }
      }, 1000);
    });
    // return xhr.post(`test`);
  },
  fetchExpenses(user) { /* eslint-disable-line */
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve([
          {
            id: 1,
            category: 1,
            amount: 800,
            date: '2018-11-19',
          },
          {
            id: 2,
            category: 1,
            amount: 1500,
            date: '2018-11-19',
          },
          {
            id: 3,
            category: 1,
            amount: 500,
            date: '2018-11-19',
          },
          {
            id: 4,
            category: 2,
            amount: 500,
            date: '2018-11-19',
          },
          {
            id: 5,
            category: 1,
            amount: 500,
            date: '2018-11-19',
          },
          {
            id: 6,
            category: 2,
            amount: 500,
            date: '2018-11-19',
          },
        ]);
      }, 1000);
    });
  },
  fetchCategories(user) { /* eslint-disable-line */
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve([
          {
            id: 1,
            name: 'Bills',
          },
          {
            id: 2,
            name: 'Phone',
          },
        ]);
      }, 1000);
    });
  },
};
