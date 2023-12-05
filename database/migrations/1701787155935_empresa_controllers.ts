import BaseSchema from '@ioc:Adonis/Lucid/Schema'

export default class extends BaseSchema {
  protected tableName = 'empresa_controllers'

  public async up () {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id');

      table.string('razao_social').notNullable().unique();
      table.string('cnpj').notNullable().unique();
      table.string('nome_fantasia');
      table.string('representante').notNullable;
      table.string('contato').notNullable();

      /**
       * Uses timestamptz for PostgreSQL and DATETIME2 for MSSQL
       */
      table.timestamp('created_at', { useTz: true });
      table.timestamp('updated_at', { useTz: true });
    })
  }

  public async down () {
    this.schema.dropTable(this.tableName)
  }
}
