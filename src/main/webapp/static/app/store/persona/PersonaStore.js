Ext.define('eCredit.store.persona.PersonaStore',{
    extend: 'Ext.data.Store',
    model: 'eCredit.model.persona.PersonaModel',
    pageSize: 5,
    proxy: {
        actionMethods: {
            create: 'POST',
            read: 'GET',
            update: 'POST',
            destroy:'POST'
        },

        type: 'ajax'
        ,url: 'getListPersons.htm'

        /*
        extraParams:{
            numeroDni: Ext.ComponentQuery.query('ViewPanelGridPersona grid')[0].getSelectionModel().getSelection()[0].get('numeroDni')
        },
        */

        ,reader: {
            type: 'json'
            ,root: 'data'
            ,totalProperty: 'totalCount'
            ,successProperty: 'success'
        }
    }
    //,autoLoad: true
});

