import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex);

export default new Vuex.Store({
    state:{
      currentItem:{type:null,item:null}
    },
    mutations:{
        setCurrentItem(state,currentItem){
            state.currentItem=currentItem;
        }
    },
    getters:{
        getCurrentItem(state){
            return state.currentItem;
        }
    }
    
  });
  