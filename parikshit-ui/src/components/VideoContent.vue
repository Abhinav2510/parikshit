<template>
  <div class="container">
    <div clas="row">
        <div class="col s12">
            <div class="iframe-container">
            <iframe  v-bind:src="'http://youtube.com/embed/'+videoURL" allowfullscreen></iframe>
            </div>
        </div>
      </div>
  </div>
</template>
<style scoped>
.iframe-container{
  position: relative;
  width: 100%;
  padding-bottom: 56.25%; 
  height: 0;
}
.iframe-container iframe{
  position: absolute;
  top:0;
  left: 0;
  width: 100%;
  height: 100%;
}</style>
<script>
export default {
    name:'VideoContent',
    props:{
        additionalData:Array
    },
    methods:{
        getProperty(keyName){
            console.log(keyName)
            for(var i=0;i<this.additionalData.length;i++){
                if(this.additionalData[i].key===keyName)
                    console.log(this.additionalData[i])
                    return this.additionalData[i].value;
            }
        }
    },
    computed:{
        videoURL(){
            return this.getProperty("URL");
        },
        videoSource(){
           return this.getProperty("SOURCE");
        }
    }
}
</script>

<style>

</style>