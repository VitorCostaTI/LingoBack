import BaseSchema from '@ioc:Adonis/Lucid/Schema'

export default class extends BaseSchema {
  protected tableName = 'clientes'

  public async up () {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')

      table.string('cliente').notNullable().unique();
      table.string('cpf').notNullable().unique();
      table.string('email').notNullable().unique();
      table.string('telefone1').notNullable().unique();
      table.string('telefone2');
      table.string('cep').notNullable();
      table.string('logradouro').notNullable();
      table.string('bairro').notNullable();
      table.string('cidade').notNullable();
      table.string('estado').notNullable();
      table.string('complemento');

      /**
       * Uses timestamptz for PostgreSQL and DATETIME2 for MSSQL
       */
      table.timestamp('created_at', { useTz: true })
      table.timestamp('updated_at', { useTz: true })
    })
  }

  public async down () {
    this.schema.dropTable(this.tableName)
  }
}
