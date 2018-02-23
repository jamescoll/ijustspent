<template>
  <div>
    <vue-highcharts :options='options' ref='lineCharts'></vue-highcharts>
    <button @click='load'>Reload</button>
  </div>
</template>

<script>
import VueHighcharts from 'vue2-highcharts'
import service from '../../services/'

const asyncData = {
  marker: {
    symbol: 'square'
  },
  data: []
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
  name: 'expense-chart',
  components: {
    VueHighcharts
  },
  mounted () {
    // let lineCharts = this.$refs.lineCharts
    // lineCharts.addSeries(asyncData)
  },
  beforeRouteEnter (to, from, next) {
    service.getExpenseTotals().then((data) => {
      next(vm => {
        for (var i in data) {
          asyncData.data[i] = {name: data[i].description, y: data[i].total, color: getRandomColor()}
        }
        vm.load()
      })
    })
  },
  data () {
    return {
      chartdata: {
        marker: {
          symbol: 'square'
        },
        data: []
      },
      options: {
        chart: {
          type: 'pie'
        },
        title: {
          text: 'January Expenditure'
        },
        subtitle: {
          text: 'Loading from Back-end'
        },
        xAxis: {

        },
        yAxis: {

        },
        tooltip: {
          crosshairs: true,
          shared: true
        },
        credits: {
          enabled: false
        },
        plotOptions: {
          spline: {
            marker: {

            }
          }
        },
        series: []
      }
    }
  },
  methods: {
    load () {
      let lineCharts = this.$refs.lineCharts
      lineCharts.addSeries(asyncData)
    }
  }
}
</script>