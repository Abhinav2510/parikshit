<template>
  <div class="container">
    <h1>{{content.name}}</h1>
    <span>    {{Math.round(score.percentage*100)/100}}</span>
  </div>
</template>

<script>
export default {
  name: "ScoreCard",
  props: {
    score: Object,
    content:Object,
    id: Number
  }
};
</script>
