
Ext.define("eCredit.view.main.ViewTreeMain",{
	extend:"Ext.tree.Panel",
    cls: 'custom-grid',
	id:'idViewTreeMain',
//    cls:'my-header',
	alias:'widget.ViewTreeMain',
	//store:'eCredit.store.main.StoreTreeMain',
	rootVisible: false,

	/*mixins: {
		treeFilter: 'eCredit.lib.extjs4-treefilter'
	 },
	 */

	/*
	   dockedItems:[{
		   xtype:'toolbar',
		   items:[
			   {tooltip: "Expandir",icon: 'static/core/images/expand-all.gif',action:'expand'},
			   {tooltip: "Colapsar",icon: 'static/core/images/expand-all.gif',action:'colapse'}
		   ]
	   }],
	*/
	root: {
		text: 'Root',
		expanded: true,
		children: [
			{
				text: 'Registrar',
				expanded: true,
				children: [
					{
						text: 'Socio',
						leaf: true,
						useArrows: true
					}
				]
			},
			{
				text: 'Creditos',
				expanded: true,
				children: [
					{
						text: 'Solicitud de Credito',
						leaf: true,
						iconCls:'pdf.png',
						useArrows: true
					},
					{
						text: 'Aprobar Solicitud',
						leaf: true,
						useArrows: true
					},
					{
						text: 'Emitir Credito',
						leaf: true,
						useArrows: true
					}
				]
			},
			{
				text: 'Help me',
				leaf: true
			}

		]
	},
	listeners:{
		itemclick:function(){

			var panelForm = Ext.create('Ext.panel.Panel',{
				title:'hola',
				bodyPadding: 5,
				width: 350,
				closable:true,
				// The form will submit an AJAX request to this URL when submitted
				url: 'save-form.php',

				// Fields will be arranged vertically, stretched to full width
				layout: 'anchor',
				defaults: {
					anchor: '100%'
				},

				// The fields
				defaultType: 'textfield',
				items: [{
					fieldLabel: 'First Name',
					name: 'first',
					allowBlank: false
				},{
					fieldLabel: 'Last Name',
					name: 'last',
					allowBlank: false
				},
					{
						fieldLabel: 'lo que sea',
						name: 'last',
						allowBlank: false
					}
				],

				// Reset and Submit buttons
				buttons: [{
					text: 'Reset',
					handler: function() {
						this.up('form').getForm().reset();
					}
				}, {
					text: 'Submit',
					formBind: true, //only enabled once the form is valid
					disabled: true,
					handler: function() {
						var form = this.up('form').getForm();
						if (form.isValid()) {
							form.submit({
								success: function(form, action) {
									Ext.Msg.alert('Success', action.result.msg);
								},
								failure: function(form, action) {
									Ext.Msg.alert('Failed', action.result.msg);
								}
							});
						}
					}
				}],
				renderTo: Ext.getBody()
			});


			var panel = Ext.ComponentQuery.query('ViewPanelMain')[0]
			var tabPanel= panel.down('#editorTabPanelMain')
			console.log(panel.down('#editorTabPanelMain'));
			console.log(panel.down('tabpanel'));
			tabPanel.add(panelForm)
		}
	}

});

