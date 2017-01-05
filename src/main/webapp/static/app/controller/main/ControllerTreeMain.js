
Ext.define('eCredit.controller.main.ControllerTreeMain', {
    extend: 'Ext.app.Controller',
    models: [],
    stores: [],
    views: [],

    refs: [
        {
            ref: 'viewTreeMain',
            selector: 'ViewTreeMain'
        }
    ],

    init: function () {
        this.control({
            'ViewTreeMain': {
                itemclick: this._onItemClick
            },
            '[action=expand]': {
                click: this._onExpand
            },
            '[action=colapse]': {
                click: this._onColapse
            }
        });
    },
    _onItemClick: function (view, record) {
        var id = record.get('id');
        alert("Ok");
    },
    _onExpand: function () {
        var myTree = this.getViewTreeMain();
        myTree.expandAll();
    }
    ,_onColapse: function () {
        var myTree = this.getViewTreeMain();
        myTree.collapseAll();
    }

});