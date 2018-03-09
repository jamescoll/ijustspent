<template>
  <div class="home">
    <div class="row">
     <div class="col-sm-2"></div>
        <div class="col-sm-8">
    <ul class="list-unstyled">
      <li class="media table" @click="open('budgettable')">
        <img class="d-flex" src="../assets/images/table.png">
        <div class="media-body ml-4">
          <h5 class="mt-0 mb-1"><router-link to="budgettable">Table View</router-link></h5>
          View expenses in traditional tabular format.
        </div>
      </li>
      <li class="media chart my-4" @click="open('budgetchart')">
        <img class="d-flex" src="../assets/images/chart.png">
        <div class="media-body ml-4">
          <h5 class="mt-0 mb-1"><router-link to="budgetchart">Charts View</router-link></h5>
          View visualizations of your expensives by category.
        </div>
      </li>
      <li class="media table" @click="open('budgetedit')">
        <img class="d-flex" src="../assets/images/edit.png">
        <div class="media-body ml-4">
          <h5 class="mt-0 mb-1"><router-link to="budgetedit">Edit View</router-link></h5>
          Add expenses, accounts, payees...
        </div>
      </li>

    </ul></div>

<div class="col-sm-2"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'starter',
  data () {
    return {
    }
  },
  methods: {
    open (homecard) {
      this.$router.push(homecard)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1 code {
  padding: 0.2rem 0.6rem;
  background-color: #f4f4f4;
  border-radius: 0.5rem;
}
.home {
  margin: auto;
}
.home a {
  color: #333;
}

ul {
  margin-top: 50px;

}

ul li {
  padding: 10px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  cursor: pointer;
  height: 85px;
}

.media img {
  width: 64px;
}

.media.table:hover {
  background-color: #e0fbef;
}

.media.chart:hover {
  background-color: #e7dcf9;
}

.media.edit-boot:hover {
  background-color: #eaf7e2;
}
</style>
