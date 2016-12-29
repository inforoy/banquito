
Ext.application({
    name: 'eCredit',

    appFolder: 'static/app',

    controllers: [
        'Persons'
    ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'personList'
            }
        });
    }
});