import Vue from 'vue'
import Router from 'vue-router'
import App from './App2.vue'
import Home from './components/Home.vue'
import Content from './components/Content.vue'
import ContentPart from './components/ContentPart.vue'
import ScoreCard from './components/ScoreCard.vue'
import 'materialize-css/dist/css/materialize.css'
import 'materialize-css'
import Vuex from 'vuex'
import store from './Stores/NavStore'


Vue.use(Router)
const router = new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/content/:id',
      name: 'Content',
      component: Content,
      props: true
    },
    {
      path: '/contents/parts/:id',
      name: 'ContentPart',
      component: ContentPart,
      props: true
    },
    {
      path: '/contents/parts/:id/scorecard',
      name: 'ScoreCard',
      component: ScoreCard,
      props: true
    }
  ]
});

router.beforeEach((to, from, next) => {
  //generic route authentication logic should come here
  if(to.name=='Home'){
    store.commit('setCurrentItem',{type:'HOME',item:null});
  }
  next();
});

new Vue({
  el: '#app',
  render: h => h(App),
  store,
  router
})
