
  <template>
    <div class="col-sm-4 col-sm-offset-4">
      <h2>Sign Up</h2>
      <p>Test Sign Up</p>
      <div class="alert alert-danger" v-if="error">
        <p>{{ error }}</p>
      </div>
      <div class="form-group">
        <input
          type="text"
          class="form-control"
          placeholder="Enter your username"
          v-model="credentials.username"
        >
      </div>
      <div class="form-group">
        <input
          type="password"
          class="form-control"
          placeholder="Enter your password"
          v-model="credentials.password"
        >
      </div>
      <button class="btn btn-primary" @click="submit()">Sign-Up</button>
    </div>
  </template>

  <script>
  import authorizationservice from '../../services/authorization/authorizationservice'

  export default {

    data () {
      return {
        credentials: {
          username: '',
          password: ''
        },
        error: ''
      }
    },

    methods: {

      submit () {
        var credentials = {
          username: this.credentials.username,
          password: this.credentials.password
        }
        console.log(credentials)
        authorizationservice.signup(credentials, this.$route.query.redirect)
      },
      logout () {
        console.log('logging out')
        authorizationservice.logout()
      }
    }

  }
  </script>
