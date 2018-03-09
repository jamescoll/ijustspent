<template>
  <div>
    <h3 class="center">Icon</h3>
    <form v-on:submit.prevent="createIcon">
       <section class="form">
  <div class="form-group">
    <label class="label">Icon Name</label>
    <div class="control">
      <input v-model="icon.iconName" class="form-control" type="text" placeholder="Icon Name">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Icon Category</label>
    <div class="control">
      <input v-model="icon.iconCategory" class="form-control" type="text" placeholder="Icon Category">
    </div>
  </div>
   <div class="form-group">
    <label class="label">Icon Location</label>
    <div class="control">
      <input v-model="icon.location" class="form-control" type="text" placeholder="Icon Location">
    </div>
  </div>
</section>
<button
  v-on:click="createIcon"
  class="btn btn-primary centerBlock">
  Submit
</button>
    </form>
</div>
</template>

<script>
import iconservice from '../../services/resources/iconservice'

export default {
  name: 'icon',
  data () {
    return {
      icon: {
        iconName: null,
        iconCategory: null,
        iconLocation: null
      }
    }
  },
  mounted: function () {
  },
  methods: {
    createIcon () {
      console.log(iconservice.createIcon(this.icon))
    }
  }
}
</script>

<style scoped>
.center {
  text-align:center;
  padding: 20px;
}
.centerBlock {
   margin-left:auto;
   margin-right:auto;
   display:block;
}

</style>
