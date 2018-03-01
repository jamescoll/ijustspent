<template>
  <div>
    <h1>Chart</h1>
     <div>Imported by adding to the <code>entry</code> property of webpack.</div>
      <pre>entry: {<br/>  app: './src/main.js', <br/>  style: ['bootstrap/dist/css/bootstrap.css']<br/>}</pre>
    <div class="mt-5">
      <router-link to="starter" class="btn btn-primary">Back</router-link>
    </div>
  </div>
</template>

<script>

export default {
  name: 'budgetchart',
  data () {
    return {
      description: ''
    }
  }
}
</script>

<style scoped>

</style>
