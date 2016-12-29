
Ext.define('eCredit.controller.Persons', {
    extend: 'Ext.app.Controller',

    stores: ['Persons'],
    models: ['Person'],
    views: [
        'person.List',
        'person.Edit'
    ],

    init: function() {
        this.control({
            'personList': {
                itemdblclick : this.editPersons
            }
        });
    },

    editPersons: function(grid, record) {
        var view = Ext.widget('personEdit');
        view.down('form').loadRecord(record);
    }

});