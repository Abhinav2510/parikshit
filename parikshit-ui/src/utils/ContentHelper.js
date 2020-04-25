export default{
    getProperty:(additionalData,keyName)=>{
        for(var i=0;i<additionalData.length;i++){
            if(additionalData[i].key===keyName)
                return additionalData[i].value;
        }
    }
}