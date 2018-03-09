<template>
  <div class="row">
    <div class="col-sm-2"></div>
   <div class="col-sm-8">
    <h3 class="center">Chart</h3>
    <vue-highcharts :options='options' ref='lineCharts'></vue-highcharts>
    <button class="centerBlock" @click='load'>Reload</button>
    </div>
    <div class="col-sm-2"></div>
    </div>

</template>

<script>
import VueHighcharts from 'vue2-highcharts'
import service from '../../services/demo/demoservice'

const asyncData = {
  series: [{
    name: 'rent',
    data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
    color: ''
  }, {
    name: 'food',
    data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3],
    color: ''
  }, {
    name: 'petrol',
    data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2],
    color: ''
  }, {
    name: 'entertainment',
    data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1],
    color: ''
  }]
}

function getRandomColor () {
  var letters = '0123456789ABCDEF'
  var color = '#'
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)]
  }
  return color
}

export default {
  name: 'budgetchart',
  components: {
    VueHighcharts
  },
  beforeRouteEnter (to, from, next) {
    service.getExpenses().then((data) => {
      next(vm => {
        for (let i = 0; i < 4; ++i) {
          asyncData.series[i].name = data[i].description //, data: data[i].total, color: getRandomColor()}
          asyncData.series[i].data[i] = data[i].total
          asyncData.series[i].color = getRandomColor()
        }
        vm.load()
      })
    })
  },
  created () {
    console.log(asyncData)
  },
  data () {
    return {
      options: {
        chart: {
          type: 'column'
        },
        title: {
          text: 'Monthly Expenditure'
        },
        subtitle: {
          text: 'Separated by Category'
        },
        xAxis: {
          categories: [
            'Jan',
            'Feb',
            'Mar',
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec'
          ],
          crosshair: true
        },
        yAxis: {
          min: 0,
          title: {
            text: 'Euro'
          }
        },
        tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
          pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
          '<td style="padding:0"><b>{point.y:.1f} euro</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
        },
        credits: {
          enabled: false
        },
        plotOptions: {
          column: {
            pointPadding: 0.2,
            borderWidth: 0
          }
        },
        series: [{
          name: 'rent',
          data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
        }, {
          name: 'food',
          data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]
        }, {
          name: 'petrol',
          data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]
        }, {
          name: 'entertainment',
          data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]
        }]
      }
    }
  },
  methods: {
    load () {
      let lineCharts = this.$refs.lineCharts
      console.log(asyncData)
      lineCharts.addSeries(asyncData)
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
