import { DateTime } from 'luxon'
import { BaseModel, BelongsTo, belongsTo, column } from '@ioc:Adonis/Lucid/Orm'
import Usuario from './Usuario';

export default class Estoque extends BaseModel {
  @column({ isPrimary: true })
  public id: number;

  @column({ isPrimary: true })
  public produto: string;

  @column()
  public codigo_produto: string;

  @belongsTo(() => Usuario)
  public responsavel: BelongsTo<typeof Usuario>

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime
}
