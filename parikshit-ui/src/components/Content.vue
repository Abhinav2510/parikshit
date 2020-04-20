<template>
<div v-if="content!=null">
  <div class="container">
    <h1>{{content.name}}</h1>
    <p>{{content.description}}</p>

    <div v-for="part in content.childContents" v-bind:key="part.partId">
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
</div>
</template>
<script>
import store from '../Stores/NavStore'
import axios from "axios";
export default {
  name: "Content",
  props: {
    id: Number
  },
  data() {
    return { content: null };
  },
  created() {
    this.getContent();
  },
  methods: {
    getContent() {
      axios
        .get("http://localhost:8080/contents/" + this.id)
        .then(res => {
          this.content = res.data;
          store.commit('setCurrentItem',{type:'CONTENT',item:res.data});
        })
        .catch(err => {
          console.log("Cant fetch content for ID " + this.id);
        });
    }
  },
  watch:{
    '$route':'getContent'
  }
};
</script>>