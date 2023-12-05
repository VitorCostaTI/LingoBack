import BaseSchema from '@ioc:Adonis/Lucid/Schema'

export default class extends BaseSchema {
  protected tableName = 'produtos'

  public async up () {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id');

      table.string('produto').notNullable().unique();
      table.string('fornecedor').notNullable();
      table.string('preco').notNullable();
      table.string('investimento').notNullable();
      table.integer('quantidade').notNullable();
      table.string('codigo_produto').notNullable();

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
