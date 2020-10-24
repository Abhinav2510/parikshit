<template>
  <span>
    <span v-if="currentItem==null">
      <li>
        <router-link :to="{name:'Home'}">
          <i class="material-icons">home</i>Home
        </router-link>
      </li>
      <li>
        <div class="divider"></div>
      </li>
      <span v-for="child in childList" v-bind:key="child.contentId">
        <li>
          <router-link :to="{name:'Content',params:{id:child.contentId}}">
            <i class="material-icons" >account_balance</i>
            {{child.name}}
          </router-link>
        </li>
        <li>
          <div class="divider"></div>
        </li>
      </span>
    </span>
    <span v-else>
      <li v-show="currentItem.parentContentContentId!=0">
        <router-link :to="{name:'Content',params:{id:currentItem.parentContentContentId}}">
          <i class="material-icons">arrow_back</i> Back
        </router-link>
      </li>
      <li v-show="currentItem.parentContentContentId==0">
        <router-link :to="{name:'Home'}">
          <i class="material-icons">home</i> Home
        </router-link>
      </li>
      <li>
        <div class="divider"></div>
      </li>
      <span v-for="child in currentItem.childContents" v-bind:key="child.contentId">
        <li>
          <router-link :to="{name:'Content',params:{id:child.contentId}}">
            <i class="material-icons" v-if="child.type==='VIDEO'">ondemand_video</i>
            <i class="material-icons" v-else-if="child.type=='QUIZ'">help_outline</i>
            <i class="material-icons" v-else-if="child.type=='MARKDOWN'">text_format</i>
            <i class="material-icons" v-else-if="child.type=='EXAM'">menu_book</i>
            <i class="material-icons" v-else-if="child.type=='MODULE'">view_quilt</i>
            <i class="material-icons" v-else >account_balance</i>
          
            {{child.name}}</router-link>
        </li>
        <li>
          <div class="divider"></div>
        </li>
      </span>
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
        axios.get(`${this.$backEndURL}api/public/contents/groups/`).then(res => {
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
</script>
