import Vuex from 'vuex'
import Vue from 'vue'
Vue.use(Vuex);

export default new Vuex.Store({
    state:{
      parentNav:{parent:null,current:null}
    },
    mutations:{
        setParentNav(state,parentNav){
            state.parentNav=parentNav;
        }
    },
    getters:{
        getParentNav(state){
            return state.parentNav;
        }
    }
    
  });
  