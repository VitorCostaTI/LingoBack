import BaseSchema from '@ioc:Adonis/Lucid/Schema'

export default class extends BaseSchema {
  protected tableName = 'estoques'

  public async up () {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id');

      table.string('produto');
      table.string('codigo_produto');
      table.string('categoria');
      table.integer('quantidade');
      table.integer('usuario_id').unsigned().references('id').inTable('usuarios')
      /**
       * Uses timestamptz for PostgreSQL and DATETIME2 for MSSQL
       */
      table.timestamp('data', { useTz: true })
    })
  }

  public async down () {
    this.schema.dropTable(this.tableName)
  }
}
