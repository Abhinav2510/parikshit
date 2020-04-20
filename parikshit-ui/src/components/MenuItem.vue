<template>
  <span>
    <span v-if="currentItem==null">
      <li>
        <router-link :to="{name:'Home'}">Home</router-link>
      </li>
      <li v-for="child in childList" v-bind:key="child.contentId">
        <router-link :to="{name:'Content',params:{id:child.contentId}}">{{child.name}}</router-link>
      </li>
    </span>
    <span v-else>
      <li v-show="currentItem.parentContentContentId!=0">
        <router-link
          :to="{name:'Content',params:{id:currentItem.parentContentContentId}}"
        >Back</router-link>
      </li>
      <li v-show="currentItem.parentContentContentId==0">
        <router-link :to="{name:'Home'}">Home</router-link>
      </li>
      <li v-for="child in currentItem.childContents" v-bind:key="child.contentId">
        <router-link :to="{name:'Content',params:{id:child.contentId}}">{{child.name}}</router-link>
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
      childList: []
    };
  },
  methods: {
    getContent() {
      if (this.currentItem == null) {
        axios.get("http://localhost:8080/contents/groups/").then(res => {
          this.childList = res.data;
        });
      }
      this.$forceUpdate();
    }
  },
  created() {
    this.getContent();
  },
  computed: {
    currentItem() {
      return this.$store.state.currentItem.item;
    }
  },
  watch: {
    currentItem(value) {
      console.log(`Current navigation Item changted to :`);
      console.log(value);
      this.getContent();
    }
  }
};
</script>>