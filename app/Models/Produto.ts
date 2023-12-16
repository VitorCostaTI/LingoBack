import { DateTime } from 'luxon'
import { BaseModel, column } from '@ioc:Adonis/Lucid/Orm'

export default class Produto extends BaseModel {
  @column({ isPrimary: true })
  public id: number

  @column()
  public produto: string;

  @column()
  public fornecedor: string;

  @column()
  public categoria: string;

  @column()
  public preco: string;

  @column()
  public investimento: string;

  @column()
  public quantidade: number;

  @column()
  public codigo_produto: string;

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime;

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime;
}
