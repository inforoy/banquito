
Ext.define('eCredit.view.person.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.personList',
    title : 'All Persons',
    store: 'Persons',

    columns: [
        {header: 'Nombre',              dataIndex: 'name',  flex:1},
        {header: 'Correo Electronico',  dataIndex: 'email', flex:1, sortable: false,
            renderer: function(value) {
                return Ext.String.format('<a href="mailto:{0}">{1}</a>', value, value);
            }
        },
        {header: 'Telefono',            dataIndex: 'phone',         sortable: false }
    ],
    height: 200,
    width: 400,
    dockedItems: [{
        xtype: 'pagingtoolbar',
        store: 'Persons',   // same store GridPanel is using
        dock: 'bottom',
        displayInfo: true
    }],
    renderTo: Ext.getBody()
/*
    initComponent: function() {

        this.columns = [
            {header: 'Name',  dataIndex: 'name',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }

*/

});