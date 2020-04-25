<template>
  <div class="container">
    <div class="row">
      <div class="input-field col s12">
        <input
          v-model="searchParam"
          v-on:keyup.enter="searchCourseByQuery()"
          type="text"
          id="autocomplete-input"
        />
        <label for="autocomplete-input">Search courses</label>
        <i class="material-icons prefix">search</i>
      </div>
    </div>
    <div class="row">
      <div class="card small col m3 s12" v-for="content in searchResults" v-bind:key="content.contentId">
        <div class="card-content">
          <span class="card-title">{{content.name}}</span>
          <span > <i class="material-icons">{{getIcon(content.type)}}</i> {{content.type}} </span>

          <div class="divider"></div>
          <p>{{content.description}}</p>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
.material-icons{
    display: inline-flex;
    vertical-align: top;
}
</style>
<script>
import ContentHelper from '../utils/ContentHelper'
export default {
  name: "Home",
  data() {
    return { searchParam: "", searchResults: [] };
  },
  methods: {
    searchCourseByQuery() {
      console.log("fetching search result");

      this.$http
        .get(this.$backEndURL + "/contents/search?query=" + this.searchParam)
        .then(res => {
          console.log(res.data);
          this.searchResults = res.data;
          this.$forceUpdate();
        })
        .catch(() => {});
    },
  getIcon(type){
    return ContentHelper.getContentIcon(type);
  }
  }
};
</script>