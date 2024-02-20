import BaseSchema from '@ioc:Adonis/Lucid/Schema'

export default class extends BaseSchema {
  protected tableName = 'usuarios'

  public async up() {
    this.schema.createTable(this.tableName, (table) => {

      /**** Ficha de Cadastro ****/

      table.increments('id').primary();
      
      table.string('colaborador', 255).notNullable();
      table.string('setor', 255).notNullable();
      table.string('email', 255).notNullable().unique();
      table.string('telefone1', 255).notNullable().unique();
      table.string('telefone2', 255);
      table.string('cep', 255).notNullable();
      table.string('logradouro', 255).notNullable();
      table.string('bairro', 255).notNullable();
      table.string('cidade', 255).notNullable();
      table.string('estado', 255).notNullable();
      table.string('complemento', 255);
      table.string('localizacao', 255).notNullable();
      table.string('emergencia', 255);
      table.string('documento', 255).notNullable();
      table.string('pis', 255).notNullable();
      table.string('password', 180).notNullable();
      table.string('remember_me_token').nullable();

      /**** Upload de Arquivos ****/

      table.string('image');
      table.string('rg');
      table.string('titulo_eleitor');
      table.string('militar');
      table.string('nascimento');
      table.string('endereco');
      table.string('carteira_trabalho');

      /**
       * Uses timestampz for PostgreSQL and DATETIME2 for MSSQL
       */
      table.timestamp('created_at', { useTz: true }).notNullable()
      table.timestamp('updated_at', { useTz: true }).notNullable()
    })
  }

  public async down() {
    this.schema.dropTable(this.tableName)
  }
}