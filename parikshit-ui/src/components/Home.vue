<template>
  <div class="container">
    <div class="row">
      <div class="input-field col s12">
        <i class="material-icons prefix">search</i>

        <input
          v-model="searchParam"
          v-on:keyup.enter="searchCourseByQuery()"
          v-on:keyup="searchCompleted=false"
          type="text"
          id="autocomplete-input"
        />
        <label for="autocomplete-input">Search contents</label>
      </div>
    </div>
    <div class="row">
      <span class="col m2 s6">
        <label>
          <input type="checkbox" @change="filterAdd('VIDEO')" />
          <span>
            <i class="material-icons prefix">ondemand_video</i> Video
          </span>
        </label>
      </span>
      <span class="col m2 s6">
        <label>
          <input type="checkbox" @change="filterAdd('QUIZ')" />
          <span>
            <i class="material-icons prefix">help_outline</i> Quiz
          </span>
        </label>
      </span>

      <span class="col m2 s6">
        <label>
          <input type="checkbox" @change="filterAdd('EXAM')" />
          <span>
            <i class="material-icons prefix">menu_book</i> Exam
          </span>
        </label>
      </span>

      <span class="col m2 s6">
        <label>
          <input type="checkbox" @change="filterAdd('MODULE')" />
          <span>
            <i class="material-icons prefix">view_quilt</i> Module
          </span>
        </label>
      </span>

      <span class="col m2 s6">
        <label>
          <input type="checkbox" @change="filterAdd('TEXT')" />
          <span>
            <i class="material-icons prefix">{{getIcon('TEXT')}}</i> Text
          </span>
        </label>
      </span>
    </div>

    <div class="row">
      <div v-if="searchResultsFiltered.length==0 && searchParam!='' && searchCompleted">0 results</div>
      <div
        class="col m4 s12"
        v-for="content in searchResultsFiltered"
        v-bind:key="content.contentId"
      >
        <div class="card small">
          <div class="card-content">
            <span class="card-title">
              <router-link :to="{name:'Content',params:{id:content.contentId}}">
                <i class="material-icons">{{getIcon(content.type)}}</i>
                {{content.name}}
              </router-link>
            </span>
            <div class="divider"></div>
            <p>{{content.description}}</p>
            <div class="card-action">
              <span>
                <i class="material-icons">account_tree</i>
                {{content.childContents.length}} sections
              </span>
              <span>
                <i class="material-icons">supervised_user_circle</i>
                {{content.childContents.length}} users
              </span>
              <span>
                <i class="material-icons">stars</i>
                5 rating
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.material-icons {
  display: inline-flex;
  vertical-align: top;
}
</style>
<script>
import ContentHelper from "../utils/ContentHelper";
export default {
  name: "Home",
  data() {
    return {
      searchParam: "",
      searchResults: [],
      filterMap: [],
      searchCompleted: false
    };
  },
  methods: {
    searchCourseByQuery() {
      console.log("fetching search result");

      this.$http
        .get(`${this.$backEndURL}/api/public/contents/search?query=${this.searchParam}`)
        .then(res => {
          console.log(res.data);
          this.searchResults = res.data;
          this.$forceUpdate();
          this.searchCompleted = true;
        })
        .catch(() => {});
    },
    getIcon(type) {
      return ContentHelper.getContentIcon(type);
    },
    filterAdd(type) {
      console.log("Adding filtrr" + this.filterMap.includes(type));
      if (!this.filterMap.includes(type)) {
        console.log("Adding to filterMap");
        this.filterMap.push(type);
      } else {
        this.filterMap.splice(this.filterMap.indexOf(type), 1);
      }
    }
  },
  computed: {
    searchResultsFiltered() {
      return this.searchResults.filter(item => {
        return (
          this.filterMap.includes(
            ContentHelper.getContentGeneralType(item.type)
          ) || this.filterMap.length == 0
        );
      });
    }
  }
};
</script>