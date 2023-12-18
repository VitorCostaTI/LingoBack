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

  @column()
  public categoria: string;

  @column()
  public quantidade: number;

  @column()
  public usuario_id: number

  @belongsTo(() => Usuario, { foreignKey: 'usuario_id' })
  public usuario: BelongsTo<typeof Usuario>

  @column.dateTime({ autoCreate: true })
  public data: DateTime
}
