<template>
  <div id="app">
    <header>
      <nav>
        <div class="nav-wrapper  purple darken-4">
          <span style="cursor:pointer;" data-target="slide-out" class="sidenav-trigger show-on-large"><i class="material-icons">menu</i></span>          
          <router-link :to="{name:'Home'}" class="brand-logo center">Parikshit</router-link>
        </div>
      </nav>
    </header>
    <main>
      <div id="slide-out" class="sidenav">
        <ul class="collapsible">
          <MenuItem></MenuItem>
        </ul>
      </div>
    
      <div class="contents">
        <transition name="fade" mode="out-in">
        <router-view></router-view>
        </transition>
      </div>
    </main>
  </div>
</template>

<script>

import MenuItem from './components/MenuItem.vue'
export default {
  name:"app",
  mounted:function(){
    M.AutoInit();
  } ,
  components:{
    MenuItem
  }
}
</script>>