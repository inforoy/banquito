Ext.define('eCredit.controller.main.ControllerTreeMain', {
    extend: 'Ext.app.Controller',
    models: [],
    stores: [],
    views: ['eCredit.view.main.ViewPanelGeneral'],

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
        var id = record.internalId;
        console.log('_onItemClick:'+id);
        if('ext-record-23' === id){// Registrar Persona
            this._viewRegistrarPersona(view);
        } else {
            console.log("Otros");
        }
    },
    _onExpand: function () {
        var myTree = this.getViewTreeMain();
        myTree.expandAll();
        console.log('_onExpand');
    }
    ,_onColapse: function () {
        var myTree = this.getViewTreeMain();
        myTree.collapseAll();
        console.log('_onColapse');
    }
    , _viewRegistrarPersona: function(view) {
        console.log('Registrar Persona');
        var gnrlViewTab = Ext.create('eCredit.view.main.ViewPanelGeneral', {
            title: "Registrar Persona",//response.tab,
            closable: true
        });
        //view.up('panel').collapse(); // Para que se oculte automaticamente
        eCredit.getApplication().centerPanel.addPanel(gnrlViewTab);
        //eCredit.getApplication().loadController(response.controller);
        gnrlViewTab.addPanel(Ext.create('Ext.panel.Panel'/*response.clase*/, {
            bodyPadding: 5,  // Don't want content to crunch against the borders
            width: 300,
            plain: true,
            title: 'Registrar Persona',
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Start date'
            }, {
                xtype: 'datefield',
                fieldLabel: 'End date'
            }],
            renderTo: Ext.getBody()

        }));
    }

});