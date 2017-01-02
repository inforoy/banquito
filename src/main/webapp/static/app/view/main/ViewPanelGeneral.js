Ext.define('DukeSource.view.main.ViewPanelGeneral',{
	extend:'Ext.panel.Panel',
	alias:'widget.ViewPanelGeneral',
	layout:'fit',
	padding:1,
	border:false,
	initComponent:function(){
		
		this.editorTabPanelGeneral=Ext.create('Ext.tab.Panel',{
		//	tabPosition: 'bottom',
//			bodyStyle:'background:#D5E2F2',
//			region:'center',
			layout:'fit'
		});

		this.items=[this.editorTabPanelGeneral];
		this.callParent();
		
	},
	addPanel:function(item){
    	var cmp = this.editorTabPanelGeneral.down("[title="+item.title+"]");
    	if(!cmp){
    		this.editorTabPanelGeneral.add(item);
    		this.editorTabPanelGeneral.setActiveTab(item);
    	}else{
    		this.editorTabPanelGeneral.setActiveTab(cmp);
    	}
	}
	
});
DukeSource.getComponent=function(){
//	console.log(DukeSource.view.main.SalesEditor);
///	return Fource.view.main.ResourcesEditor;
	//return Ext.getCmp('dd');
	//return this.editorTabPanel;
};
