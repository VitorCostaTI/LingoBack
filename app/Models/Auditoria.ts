import { DateTime } from 'luxon'
import { BaseModel, column } from '@ioc:Adonis/Lucid/Orm'

export default class Auditoria extends BaseModel {
  @column({ isPrimary: true })
  public id: number;

  @column({})
  public colaborador: string;

  @column({})
  public setor: string;

  @column({})
  public atividade: string;

  @column.dateTime({ autoCreate: true })
  public hora: DateTime

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime
}
