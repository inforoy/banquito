Ext.define('eCredit.model.persona.PersonaModel',{
    extend: 'Ext.data.Model',

    fields: [
        {name: 'numeroDni',  type: 'string'},
        {name: 'nombre',  type: 'string'},
        {name: 'apeMaterno',  type: 'string'},
        {name: 'numeroRuc',  type: 'string'},
        {name: 'razonSocial',  type: 'string'},
        {name: 'direccion',  type: 'string'},
        {name: 'sexo',  type: 'string'},
        {name: 'fechaNacimiento',  type: 'string'},
        {name: 'email',  type: 'string'},
        {name: 'telefonoFijo',  type: 'string'},
        {name: 'telefonoMovil',  type: 'string'},
        {name: 'estadoCivil',  type: 'string'},
        {name: 'departamento',  type: 'string'},
        {name: 'provincia',  type: 'string'},
        {name: 'distrito',  type: 'string'},
        {name: 'indel',  type: 'string'}
    ]
});