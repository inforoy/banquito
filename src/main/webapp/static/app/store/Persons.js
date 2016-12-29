
Ext.define('eCredit.store.Persons', {
    extend: 'Ext.data.Store',
    model: 'eCredit.model.Person',

    data: [
        {name: 'Ed',    email: 'ed@sencha.com'},
        {name: 'Tommy', email: 'tommy@sencha.com'}
    ]

});