<template>
  <div class="container">
      
    <h1>{{content.name}}</h1>
    <canvas id="scoreChart"></canvas>
  </div>

</template>

<script>
import Chart from 'chart.js'
export default {
  name: "ScoreCard",
  data(){
    return{ scoreData:[["string","content"],["Correct",this.score.correct],["Non attempted",this.score.notAttempted]]}
  },mounted(){
      let chartCtx=document.getElementById("scoreChart");
      new Chart(chartCtx,{
        type:'pie',
        data:{
          datasets: [{
            data: [this.score.correct, this.score.attempted, this.score.attempted-this.score.correct],
            backgroundColor:[
              "rgb(255, 99, 132)",
              "rgb(54, 162, 235)",
              "rgb(255, 205, 86)"
            ]
            }],
          labels: [
            'Correct',
            'Attempted',
            'Incorrect'
          ]
        }
      });
  },
  props: {
    score: Object,
    content:Object,
    id: Number
  },components:{
    
  }
};
</script>
