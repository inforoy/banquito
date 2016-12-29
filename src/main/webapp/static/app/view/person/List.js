
Ext.define('eCredit.view.person.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.personList',
    title : 'All Persons',
    store: 'Persons',

    initComponent: function() {

        this.columns = [
            {header: 'Name',  dataIndex: 'name',  flex: 1},
            {header: 'Email', dataIndex: 'email', flex: 1}
        ];

        this.callParent(arguments);
    }



});