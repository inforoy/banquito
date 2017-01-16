Ext.define('eCredit.store.persona.PersonaStore',{
    extend: 'Ext.data.Store',
    model: 'eCredit.model.persona.PersonaModel',
    pageSize: 5,

    proxy: {
        type : 'ajax',
        url : 'getListPersons.htm',
        reader : {
            type:'json',
            root : 'data',
            successProperty: 'success'
        }
    }
});