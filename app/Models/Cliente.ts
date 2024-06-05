import { DateTime } from 'luxon'
import { BaseModel, column } from '@ioc:Adonis/Lucid/Orm'

export default class Cliente extends BaseModel {
  @column({ isPrimary: true })
  public id: number

  @column()
  public cliente: string;

  @column()
  public cpf: string;

  @column()
  public email: string;

  @column()
  public telefone: string;

  @column()
  public telefone2: string;

  @column()
  public cep: string;

  @column()
  public logradouro: string;

  @column()
  public bairro: string;

  @column()
  public cidade: string;

  @column()
  public estado: string;

  @column()
  public localizacao: string;

  @column()
  public complemento: string;

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime
}
