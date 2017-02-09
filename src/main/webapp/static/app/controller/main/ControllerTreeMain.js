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
        'eCredit.view.persona.ViewPanelGridPersona',
        'eCredit.view.persona.ViewPanelFormPersona'
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
            'ViewPanelGridPersona': {
                itemdblclick : this._onEditPersona
            },
            'ViewPanelGridPersona button#add': {
                click: this._onAddPersona
            },

            'ViewPanelGridPersona button#delete': {
                click: this._onDeletePersona
            },

            /** Cancelar Persona **/
            'ViewPanelFormPersona button#cancel': {
                click: this._onClickCancelPersona
            },

            /** Guardar Persona**/
            'ViewPanelFormPersona button#save': {
                click: this._onClickSavePersona
            },

            '[action=expand]': {
                click: this._onExpand
            },
            '[action=colapse]': {
                click: this._onColapse
            }
        });
    }

    ,_onItemClick: function (view, record) {
        var id = record.internalId;
        console.log('_onItemClick:'+id);
        if('ext-record-23' === id){// Registrar Persona
            this._viewRegistrarPersona(view);
        } else {
            console.log("Otros");
        }
    }

    ,_onAddPersona: function(btn, e, eOpts){
        var win = Ext.create('eCredit.view.persona.ViewPanelFormPersona');
        win.setTitle("Nueva Persona");
    }

    ,_onDeletePersona:function(btn, e, eOpts){
        var grid = btn.up('grid');
        var record = grid.getSelectionModel().getSelection();
        var store = grid.getStore();

        Ext.Ajax.request({
            method: 'POST',
            url: 'deletePersona.htm',
            params: {
                //jsonData: JSON.stringify(values)
                jsonData: record[0].data.numeroDni
            },
            success: function (response) {
                response = Ext.decode(response.responseText);
                if (response.success) {
                    store.remove(record);
                    ///Ext.MessageBox.alert('CONFIRMACION', response.message);
                } else {
                    //Ext.MessageBox.alert('ERROR', response.message);
                }
            },
            failure: function () {
                console.log("Error*deletePersona");
            }
        });

        store.sync();
    }

    ,_onEditPersona: function(itemGridEdit, record, item, index, e, eOpts){
        console.log('Editar persona');
        var win = Ext.create('eCredit.view.persona.ViewPanelFormPersona');
        win.setTitle("Editar Persona - "+record.get('nombre') +' '+record.get('apePaterno') );
        var form = win.down('form');
        form.loadRecord(record);

    }

    ,_onClickCancelPersona:function(btn, e, eOpts){
        var win = btn.up('window');
        var form = win.down('form');
        form.getForm().reset();
        win.close();
    }

    ,_onClickSavePersona: function(btn, e, eOpts){
        var win = btn.up('window');
        var form = win.down('form');
        var values = form.getValues();
        var record = form.getRecord();
        var grid = Ext.ComponentQuery.query('ViewPanelGridPersona')[0];
        var store = grid.getStore();

        if(record){// edicion

            Ext.Ajax.request({
                method: 'POST',
                url: 'updatePersona.htm',
                params: {
                    jsonData: Ext.JSON.encode(values)
                },
                success: function (response) {
                    response = Ext.decode(response.responseText);
                    if (response.success) {
                        record.set(values);
                        Ext.MessageBox.alert('CONFIRMACION', response.message);
                    } else {
                        Ext.MessageBox.alert('ERROR', response.message);
                    }
                },
                failure: function () {
                    console.log("Error*updatePersona");
                }
            });

        } else {// nuevo REGISTRO

            var persona = Ext.create('eCredit.model.persona.PersonaModel',{
                numeroDni: values.numeroDni,
                nombre: values.nombre,
                apePaterno: values.apePaterno,
                apeMaterno: values.apeMaterno,
                numeroRuc: values.numeroRuc,
                razonSocial: values.razonSocial,
                direccion: values.direccion,
                sexo: values.sexo,
                fechaNacimiento: values.fechaNacimiento,
                email: values.email,
                telefonoFijo: values.telefonoFijo,
                telefonoMovil: values.telefonoMovil,
                estadoCivil: values.estadoCivil,
                departamento: values.departamento,
                provincia: values.provincia,
                distrito: values.distrito,
                indel: values.indel
            });

            Ext.Ajax.request({
                method: 'POST',
                url: 'savePersona.htm',
                params: {
                    jsonData: Ext.JSON.encode(values)
                },
                success: function (response) {
                    response = Ext.decode(response.responseText);
                    if (response.success) {
                        Ext.MessageBox.alert('CONFIRMACION', response.message);
                        store.insert(0, persona);
                    } else {
                        Ext.MessageBox.alert('ERROR', response.message);
                    }
                },
                failure: function () {
                    console.log("Error*savePersona");
                }
            });

        }
        store.sync();
        win.close();
    }

    ,_onExpand: function () {
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
        console.log('Registrar Persona'+view);
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