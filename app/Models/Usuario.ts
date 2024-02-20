import { DateTime } from 'luxon'
import Hash from '@ioc:Adonis/Core/Hash'
import { column, beforeSave, BaseModel } from '@ioc:Adonis/Lucid/Orm'

export default class Usuario extends BaseModel {

  /**** Ficha de Cadastro ****/

  @column({ isPrimary: true })
  public id: number;

  @column()
  public colaborador: string;

  @column()
  public setor: string;

  @column()
  public email: string;

  @column()
  public telefone1: string;

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
  public complemento: string;

  @column()
  public localizacao: string;

  @column()
  public emergencia: string;

  @column()
  public documento: string;

  @column()
  public pis: string;

  @column({ serializeAs: null })
  public password: string;

  @column()
  public rememberMeToken: string | null;

  /**** Upload de Arquivos ****/

  @column()
  public image: string;

  @column()
  public rg: string;

  @column()
  public titulo_eleitor: string;

  @column()
  public militar: string;

  @column()
  public nascimento: string;

  @column()
  public endereco: string;

  @column()
  public carteira_trabalho: string;

  /**** TimeStamps ****/

  @column.dateTime({ autoCreate: true })
  public createdAt: DateTime;

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  public updatedAt: DateTime;

  @beforeSave()
  public static async hashPassword(usuario: Usuario) {
    if (usuario.$dirty.password) {
      usuario.password = await Hash.make(usuario.password)
    }
  }
}