<template>
  <div class="row">
    <div class="col s12">
      <div class="iContainer">
        <iframe class="responsive-iframe" frameborder="0" :srcdoc="compiledMarkDown"></iframe>
      </div>
    </div>
  </div>
</template>
<style>
.iContainer {
  overflow: hidden;
  width: 100%;
}

/* Then style the iframe to fit in the container div with full height and width */
.responsive-iframe {
    margin-top: 100px;
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  width: 100%;
  height: 100%;
}
</style>
<script>
import marked from "marked";
import ContentHelper from "../utils/ContentHelper";
export default {
  name: "MarkDownContent",
  props: {
    content: Object
  },
  computed: {
    compiledMarkDown() {
      return marked(
        ContentHelper.getProperty(this.content.additionaldata, "MARKDOWNTEXT")
      );
    }
  }
};
</script>