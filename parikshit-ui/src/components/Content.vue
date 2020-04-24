<template>
<div v-if="content!=null">
  <div v-if="content.type=='VIDEO'"><VideoContent :additionalData="content.additionaldata"/></div>
  <div v-else class="container">
    <h1>{{content.name}}</h1>
    <p>{{content.description}}</p>
    <div v-for="part in content.childContents" v-bind:key="part.partId">
      <div class="card" v-if="part.type!='Test'">
        <div class="card-content">
          <router-link :to="{name:'Content',params:{id:part.contentId}}"><span class="card-title">{{part.name}}</span></router-link>
          <p>{{part.description}}</p>
        </div>
        <div class="card-action">
          <router-link v-if="part.type=='QUIZ'"
            active-class="active"
            class="waves-effect"
            :to="{name:'QuizComponent',params:{id:part.contentId, contentId:content.testId,content:part}}"
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
import VideoContent from './VideoContent'
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
        .get(this.$backEndURL+"contents/" + this.id)
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
  },
  components:{
    VideoContent
  }
};
</script>>