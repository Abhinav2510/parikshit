<template>
  <span>
    <span v-if="currentItem.current==null">
      <li>
        <router-link :to="{name:'Home'}">Home</router-link>
      </li>
      <li v-for="child in childList" v-bind:key="child.contentId">
        <router-link :to="{name:'Content',params:{id:child.contentId,content:child}}">{{child.name}}</router-link>
      </li>
    </span>
    <span v-else>
      <li v-show="parentContent!=null">
        <router-link
          :to="{name:'Content',params:{id:currentItem.current.parentContentContentId,content:parentContent}}"
        >Back</router-link>
      </li>
      <li v-show="parentContent==null">
        <router-link :to="{name:'Home'}">Home</router-link>
      </li>
      <li v-for="child in currentItem.current.childContents" v-bind:key="child.contentId">
        <router-link :to="{name:'Content',params:{id:child.contentId,content:child}}">{{child.name}}</router-link>
      </li>
    </span>
  </span>
</template>
<script>
import axios from "axios";
export default {
  name: "MenuItem",
  data() {
    return {
      parentContent: null,
      childList: []
    };
  },
  methods: {
    getContent(contentId) {
      if (contentId == null) {
        axios.get("http://localhost:8080/contents/groups/").then(res => {
          this.childList = res.data;
        });
      } else {
        console.log("Querying for data contnet");
        axios.get("http://localhost:8080/contents/" + contentId).then(res => {
          console.log(res);
          this.parentContent = res.data;
        }).catch(err=>{
          this.parentContent=null;
        });
      }
    }
  },
  created() {
    this.getContent();
  },
  computed: {
    currentItem() {
      return this.$store.getters.getParentNav;
    }
  },
  watch: {
    currentItem(value) {
      console.log(`My store value for 'parentBackLink' changed to`);
      console.log(value);
      if (value.current != null|| value.current!=undefined) {
        this.getContent(value.current.parentContentContentId);
      }
    }
  }
};
</script>>