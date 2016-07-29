/**
 * @author chenyanxu
 */
Ext.define('kalix.dict.component.DictCombobox', {
    extend: 'Ext.form.field.ComboBox',
    alias: 'widget.dictCombobox',
    editable: false,
    xtype: 'dictCombobox',
    queryMode: 'local',
    valueField: 'value',
    displayField: 'label',
    listeners:{
        beforerender:function(){
            Ext.require(this.storeClass ,function(){
                var storeName=this.storeClass.split('.').reverse()[0];
                var storeId=storeName.substr(0,1).toLowerCase()+storeName.substr(1,storeName.length-1);
                var store=Ext.app.Application.instance.getApplication().getStore(storeId);

                this.customeFn=function(){
                    var store=arguments[0];

                    store.clearFilter();
                    store.filter('type', this.dictType);

                    var tempStore = Ext.create('Ext.data.Store');

                    tempStore.setData(store.getData().clone());
                    this.setStore(tempStore);
                };

                store.on('load',this.customeFn,this);

                if(store.totalCount>0){
                    this.customeFn(store);
                }
            },this);

            return true;
        }
    }
});