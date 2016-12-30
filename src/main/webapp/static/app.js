
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'eCredit',
    appFolder: 'static/app',
    controllers: [
        'Persons'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'PersonList',
                    title: 'Persons List'
                }
            ]
        });
    }
});