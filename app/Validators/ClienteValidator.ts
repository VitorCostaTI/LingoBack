import { schema, rules } from '@ioc:Adonis/Core/Validator'

export default class ClienteValidator {
  public schema = schema.create({
    cliente: schema.string({}, [rules.trim()]),
    cpf: schema.string({}, [rules.trim(), rules.minLength(11)]),
    email: schema.string({}, [rules.trim(), rules.email()]),
    telefone: schema.string({}, [rules.trim()]),
    telefone2: schema.string.optional({}, [rules.trim()]),
    cep: schema.string({}, [rules.trim(), rules.minLength(8)]),
    logradouro: schema.string({}, [rules.trim(), rules.minLength(4)]),
    bairro: schema.string({}, [rules.trim(), rules.minLength(4)]),
    cidade: schema.string({}, [rules.trim(), rules.minLength(4)]),
    estado: schema.string({}, [rules.trim(), rules.minLength(2)]),
    complemento: schema.string.optional({}, [rules.trim()])
  })

  public messages = {
    'cliente.required': 'Cliente é obrigatório',
    'cliente.unique': 'Cliente informado já foi cadastrado',

    'cpf.required': 'CPF é obrigatório',
    'cpf.unique': 'CPF informado já foi cadastrado',

    'email.required': 'E-mail é obrigatório',
    'email.email': 'O E-mail informado é invalido',
    'email.unique': 'O E-mail informado já foi cadastrado',

    'telefone.required': 'Telefone é obrigatório',
    'telefone.unique': 'Telefone informado já foi cadastrado',

    'cep.required': 'CEP é obrigatório',

    'logradouro.required': 'Logradouro é obrigatório',

    'bairro.required': 'Cliente é obrigatório',

    'cidade.required': 'CPF é obrigatório',

    'estado.required': 'E-mail é obrigatório',
  }
}