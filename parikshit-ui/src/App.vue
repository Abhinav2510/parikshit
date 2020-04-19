<template>
  <div id="app">
    <header>
      <nav>
        <div class="nav-wrapper  purple darken-4">
          <span style="cursor:pointer;" data-target="slide-out" class="sidenav-trigger show-on-large"><i class="material-icons">menu</i></span>          
          <router-link :to="{name:'Home'}" class="brand-logo center">Rajyasewa</router-link>
        </div>
      </nav>
    </header>
    <main>
      <div id="slide-out" class="sidenav">
        <ul class="collapsible">
          <MenuItem :content="content" v-for="content in contentsList" v-bind:key="content.testId" ></MenuItem>
        </ul>
      </div>
    
      <div class="contents">
        <router-view></router-view>
      </div>
    </main>
  </div>
</template>

<script>
import axios from 'axios'
import MenuItem from './components/MenuItem.vue'
export default {
  name:"app",
  data(){
    return {
      contentsList:[]
    }
  }
  ,
  created(){
    console.log("Loaded VUE")

    this.getCourseGroups();
  },
  mounted:function(){
    M.AutoInit();
  },
  methods:{
    getCourseGroups(){
      axios.get("http://localhost:8080/contents/").then(response=>{
        this.contentsList=response.data;
      }).catch(error=>{
        console.log("Something went wrong while fetching Course Groups")
      });
    }
  }
  ,
  components:{
    MenuItem
  }
}
</script>>