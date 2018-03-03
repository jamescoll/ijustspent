<template>
  <div id="app">
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
     <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <router-link class="nav-link" to="/">Home</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/about">About</router-link>

                </li>

            </ul>
        </div>
           <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="#">Budget.io</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <router-link class="nav-link" to="/signup">Sign Up</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" to="/login">Log In</router-link>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" @click="logout()">Log Out</a>
                    </li>
                </ul>
            </div>
  </nav>
    <router-view></router-view>
  </div>
</template>

<script>
import loginservice from './services/authorization/authorizationservice'

export default {
  name: 'app',
  methods: {
    logout () {
      console.log('logging out')
      loginservice.logout()
    }
  }
}
</script>

<style>


#app {
  width: 75%;
  margin: 120px auto;
}

p.description {
  padding-bottom: 20px;
  border-bottom: 1px solid #eee;
}


</style>
