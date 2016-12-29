
Ext.define('eCredit.store.Persons', {
    extend: 'Ext.data.Store',
    model: 'eCredit.model.Person',
    autoLoad: true,

    proxy : {
        type: 'ajax',
        api: {
            read: 'getPersons.htm',
            update: 'updatePersons.htm'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    }

});