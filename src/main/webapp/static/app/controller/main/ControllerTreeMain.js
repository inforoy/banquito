Ext.define('eCredit.controller.main.ControllerTreeMain', {
    extend: 'Ext.app.Controller',
    models: [
        'eCredit.model.persona.PersonaModel'
    ],
    stores: [
        'eCredit.store.persona.PersonaStore'
    ],
    views: [
        'eCredit.view.main.ViewPanelGeneral',
        'eCredit.view.persona.ViewPanelGridPersona'
    ],

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
        var newPanel = Ext.create('eCredit.view.persona.ViewPanelGridPersona');

        gnrlViewTab.addPanel(newPanel);
    }

});