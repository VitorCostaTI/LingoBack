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

  @column({ columnName: 'usuario_id' })
  public usuarioId: number

  @belongsTo(() => Usuario, { foreignKey: 'usuario_id' })
  public usuario: BelongsTo<typeof Usuario>

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime
}
