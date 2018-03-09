
  <template>
  <div class="signup">
    <div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">

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
      <div class="row">
        <div class="col-sm-4"></div>
          <div class="col-sm-4"><button class="btn btn-primary" @click="submit()">Sign-Up</button></div>
      <div class="col-sm-4"></div>
      </div>

      </div>
      <div class="col-sm-4"></div>
   </div>
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

<style>


.signup {
  padding: 25px;
}


</style>
