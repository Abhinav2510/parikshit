import Vue from 'vue'
import Router from 'vue-router'
import App from './App2.vue'
import Home from './components/Home.vue'
import Content from './components/Content.vue'
import QuizComponent from './components/QuizComponent.vue'
import ScoreCard from './components/ScoreCard.vue'
import 'materialize-css/dist/css/materialize.css'
import 'materialize-css'
import store from './Stores/NavStore'
import axios from 'axios';

Vue.use(Router);
Vue.prototype.$backEndURL="http://localhost:8080";
Vue.prototype.$http=axios;

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
      path: '/contents/:id/quiz',
      name: 'QuizComponent',
      component: QuizComponent,
      props: true
    },
    {
      path: '/contents/:id/scorecard',
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
