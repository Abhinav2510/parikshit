export default{
    getProperty:(additionalData,keyName)=>{
        for(var i=0;i<additionalData.length;i++){
            if(additionalData[i].key===keyName)
                return additionalData[i].value;
        }
    },
    getContentIcon(type){
        let iconMap=new Map([
            ["VIDEO","ondemand_video"],
            ["QUIZ","help_outline"],
            ["MODULE","view_quilt"],
            ["EXAM","menu_book"],
            ["MARKDOWN","text_format"]
        ]);
       return iconMap.get(type)==null?"account_balance":iconMap.get(type);
    }
}