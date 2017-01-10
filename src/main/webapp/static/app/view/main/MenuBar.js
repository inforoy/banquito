Ext.Ajax.request({
    method: 'GET',
    url: 'getAttributesToSession.htm',
    success: function (response) {
        response = Ext.decode(response.responseText);
        if (response.success) {
            var menuBar = Ext.ComponentQuery.query('MenuBar')[0];
            menuBar.down('tbtext').setText(response.fullName);
            fullName = response.fullName;
            //controlCategory = response.category;
            if (response.category != 'COLABORADOR') {
                menuBar.query('.button').forEach(function (c) {
                    c.setVisible(true);
                });
                menuBar.getComponent('pending').setText('PENDIENTES ( ' + response.pending + ' )');
                menuBar.getComponent('process').setText('PROCESO ( ' + response.process + ' )');
            }
        }
        else {
            this.messageAlert("ERROR", response.mensaje, Ext.Msg.ERROR);
            this.messageAlert("ERROR", response.mensaje, Ext.Msg.ERROR);
        }
    },
    failure: function () {

    }
});


Ext.define('eCredit.view.main.MenuBar', {
    alias: 'widget.MenuBar',
    extend: 'Ext.toolbar.Toolbar',
    layout: {
        align: 'middle',
        pack: 'center',
        type: 'hbox'
    },
    initComponent: function () {
        /*
        this.systemMenu = Ext.create('Ext.menu.Menu', {
            items: [
                {
                    text: 'Disconnect',
                    icon: 'resources/silkicons/disconnect.png'
                },
                {
                    text: "User Preferences",
                    icon: 'resources/fugue-icons/icons/gear.png'
                }
            ]
        });
        */
        this.items = [
            '->',
            {
                scale: 'large',
                rowspan: 3,
                iconCls: 'pending',
                itemId: 'pending',
                hidden: true,
                cls: 'mybutton',
                overCls: 'customOverStyle',
                height: 40,
                handler: function () {// Al hacer click se ejecuta el handler
                    loadPanelDirect("Notificaciones");
                }

            },
            {
                scale: 'large',
                rowspan: 3,
                iconCls: 'process',
                itemId: 'process',
                hidden: true,
                cls: 'mybutton',
                overCls: 'customOverStyle',
                height: 40,
                handler: function () {// Al hacer click se ejecuta el handler
                    general = "PROGRESO";
                    loadPanelDirect("Progreso");
                }
            },

            {
                xtype: 'tbspacer',
                width: 100
            },
            {
                xtype: 'tbtext',
                cls: 'text-toolbar'
            },
            {
                xtype: 'button',
                scale: 'large',
                rowspan: 3,
                iconCls: 'logout',
                overCls: 'customOverStyle',
                cls: 'mybutton',
                url: 'logout',
                hrefTarget: '_self',
                text: 'SALIR',
                textAlign: 'right'
            }
        ];
        this.callParent();
    }

});
function loadPanelDirect(value) {
/*
    if (Ext.ComponentQuery.query('ViewPanelDocumentPending')[0] == undefined) {
        Ext.ComponentQuery.query('ViewTreeMain')[0].collapse();
        DukeSource.getApplication().loadController('DukeSource.controller.fulfillment.ControllerPanelDocumentPending');
        DukeSource.getApplication().centerPanel.addPanel(Ext.create('DukeSource.view.fulfillment.ViewPanelDocumentPending', {
            title: 'PENDIENTES',
            closeAction: 'destroy',
            closable: true
        }));
        Ext.ComponentQuery.query('ViewPanelDocumentPending combobox')[0].setValue(value);
    } else {
        Ext.ComponentQuery.query('ViewTreeMain')[0].collapse();
        var grid = Ext.ComponentQuery.query('ViewPanelDocumentPending grid')[0]
        grid.store.getProxy().extraParams = {stateDocument: value};
        grid.store.getProxy().url = 'showDefaultFilesByState.htm?nameView=ViewPanelDocumentPending';
        grid.down('pagingtoolbar').moveFirst();
        general = DukeSource.view.risk.util.Constants.PENDING;
        Ext.ComponentQuery.query('ViewPanelDocumentPending combobox')[0].setValue(value);
    }
*/
    alert(value);
}