
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

			var panelForm= Ext.create('Ext.panel.Panel',{
				title:'hola',
				html:'texto panel',
				closable:true
			});


			var panel = Ext.ComponentQuery.query('ViewPanelMain')[0]
			var tabPanel= panel.down('#editorTabPanelMain')
			console.log(panel.down('#editorTabPanelMain'));
			console.log(panel.down('tabpanel'));
			tabPanel.add(panelForm)
		}
	}

});

