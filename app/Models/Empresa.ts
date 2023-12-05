import { DateTime } from 'luxon'
import { BaseModel, column } from '@ioc:Adonis/Lucid/Orm'

export default class Empresa extends BaseModel {
  @column({ isPrimary: true })
  public id: number;

  @column()
  public razao_social: string;

  @column()
  public cnpj: string;

  @column()
  public nome_fantasia: string;

  @column()
  public representante: string;
  
  @column()
  public contato: string;

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime;

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime;
}
