<template>
  <div class="container">
    <h1>{{content.name}}</h1>
    <p>{{content.description}}</p>

    <p v-if="content.testPartsList.length==0">The course does not have any contents</p>

    <div v-for="part in content.testPartsList" v-bind:key="part.partId">
      <div class="card" v-if="part.type!='Test'">
        <div class="card-content">
          <span class="card-title">{{part.name}}</span>
          <p>{{part.description}}</p>
        </div>
        <div class="card-action">
          <router-link
            active-class="active"
            class="waves-effect"
            :to="{name:'ContentPart',params:{id:part.partId, contentId:content.testId,contentPart:part}}"
          >Go to test</router-link>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Content",
  props: {
    content: Object
  }
};
</script>>