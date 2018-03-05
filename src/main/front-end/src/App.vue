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
                   <li class="nav-item dropdown">
     <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
       Security
     </a>
     <div class="dropdown-menu">
          <router-link class="dropdown-item" to="/signup">Sign Up</router-link>
        <router-link class="dropdown-item" to="/login">Log In</router-link>
       <router-link v-if="loggedIn" class="dropdown-item" to="/logout">Log Out</router-link>
     </div>
   </li>

               </ul>
           </div>
 </nav>
 <router-view></router-view>
<footer class="footer">
      <div class="container">
        <span class="text-muted">budget.io</span>
      </div>
    </footer>

  </div>
</template>

<script>
import loginservice from './services/authorization/authorizationservice'

export default {
  name: 'app',
  data () {
    return {
      loggedIn: true
    }
  },
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
  margin: 25px auto;
}

p.description {
  padding-bottom: 20px;
  border-bottom: 1px solid #eee;
}

.footer {
  position: absolute;
  bottom: 0;
  width: 75%;
  height: 60px; /* Set the fixed height of the footer here */
  line-height: 60px; /* Vertically center the text there */
  background-color: #f5f5f5;

}

.container {
  width: auto;
  max-width: 680px;
  padding: 0 15px;

}

</style>
