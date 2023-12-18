import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Usuario from 'App/Models/Usuario';
import Application from "@ioc:Adonis/Core/Application";
import { v4 as uuidv4 } from 'uuid'

export default class UsuariosController {

    /**** Autenticação de usuario ****/

    public async login({ auth, request, response }) {
        const email = request.input('email')
        const password = request.input('password')

        try {
            const token = await auth.use('api').attempt(email, password, {
                expiresIn: '120mins'
            })
            return token
        } catch {
            return response.unauthorized('Credenciais não autorizadas')
        }
    }

    public async logout({ auth }) {

        await auth.use('api').revoke()
        return {
            revoked: "Usuario deslogado com sucesso"
        }
    }

    /**** Teste das funcionalidades do middleware ****/

    public async teste({ auth }) {
        return {
            Welcome: `${auth.user!.email}`,
        }
    }

    /**** Criação de usuario ****/

    public validationOptions = {
        types: ['image'],
        size: '2mb'
    }

    public validationOptionsDocuments = {
        types: ['pdf'],
        size: '2mb'
    }

    public async post({ request, response }: HttpContextContract) {
        const body = request.body();

        body.localizacao = body.bairro + ", " + body.cidade + " - " + body.estado

        /**** Anexo de Arquivo ****/

        const image = request.file('image', this.validationOptions);
        const rg = request.file('rg', this.validationOptionsDocuments);
        const titulo_eleitor = request.file('titulo_eleitor', this.validationOptionsDocuments);
        const militar = request.file('militar', this.validationOptionsDocuments);
        const nascimento = request.file('nascimento', this.validationOptionsDocuments);
        const endereco = request.file('endereco', this.validationOptionsDocuments);
        const carteira_trabalho = request.file('carteira_trabalho', this.validationOptionsDocuments);


        if (image) {
            const imageName = `${uuidv4()}.${image.extname}`;
            await image.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: imageName
            });

            body.image = imageName;
        }

        if (rg) {
            const rgName = `${uuidv4()}.${rg.extname}`;
            await rg.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: rgName
            });

            body.rg = rgName;
        }

        if (titulo_eleitor) {
            const titulo_eleitorName = `${uuidv4()}.${titulo_eleitor.extname}`;
            await titulo_eleitor.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: titulo_eleitorName
            });

            body.titulo_eleitor = titulo_eleitorName;
        }

        if (militar) {
            const militarName = `${uuidv4()}.${militar.extname}`;
            await militar.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: militarName
            });

            body.militar = militarName;
        }

        if (nascimento) {
            const nascimentoName = `${uuidv4()}.${nascimento.extname}`;
            await nascimento.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: nascimentoName
            });

            body.nascimento = nascimentoName;
        }

        if (endereco) {
            const enderecoName = `${uuidv4()}.${endereco.extname}`;
            await endereco.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: enderecoName
            });

            body.endereco = enderecoName;
        }

        if (carteira_trabalho) {
            const carteira_trabalhoName = `${uuidv4()}.${carteira_trabalho.extname}`;
            await carteira_trabalho.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: carteira_trabalhoName
            });

            body.carteira_trabalho = carteira_trabalhoName;
        }

        /**** Create Usuário ****/

        await Usuario.create(body);

        response.status(201);
        return {
            msg: "Usuario adicionado com sucesso",
            usuario: body
        }
    }

    public async get({ response }: HttpContextContract) {

        response.status(200);
        return Usuario.all();
    }

    public async getID({ params, response }: HttpContextContract) {
        const usuarios = Usuario.findOrFail(params.id);

        response.status(200);
        return usuarios;
    }

    public async update({ params, response, request }: HttpContextContract) {
        const usuario = Usuario.findOrFail(params.id);
        const body = request.body();

        /**** Ficha Cadastral ****/

        (await usuario).colaborador = body.colaborador;
        (await usuario).setor = body.setor;
        (await usuario).email = body.email;
        (await usuario).telefone1 = body.telefone1;
        (await usuario).telefone2 = body.telefone2;
        (await usuario).cep = body.cep;
        (await usuario).logradouro = body.logradouro;
        (await usuario).bairro = body.bairro;
        (await usuario).cidade = body.cidade;
        (await usuario).estado = body.estado;
        (await usuario).complemento = body.complemento;
        (await usuario).localizacao = body.bairro + ", " + body.cidade + " - " + body.estado;
        (await usuario).emergencia = body.emergencia;
        (await usuario).documento = body.documento;

        /**** Anexo de Arquivo ****/

        const image = request.file('image', this.validationOptions);
        const rg = request.file('rg', this.validationOptionsDocuments);
        const titulo_eleitor = request.file('titulo_eleitor', this.validationOptionsDocuments);
        const militar = request.file('militar', this.validationOptionsDocuments);
        const nascimento = request.file('nascimento', this.validationOptionsDocuments);
        const endereco = request.file('endereco', this.validationOptionsDocuments);
        const carteira_trabalho = request.file('carteira_trabalho', this.validationOptionsDocuments);


        if (image) {
            const imageName = `${uuidv4()}.${image.extname}`;
            await image.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: imageName
            });

            body.image = imageName;
        }

        if (rg) {
            const rgName = `${uuidv4()}.${rg.extname}`;
            await rg.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: rgName
            });

            body.rg = rgName;
        }

        if (titulo_eleitor) {
            const titulo_eleitorName = `${uuidv4()}.${titulo_eleitor.extname}`;
            await titulo_eleitor.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: titulo_eleitorName
            });

            body.titulo_eleitor = titulo_eleitorName;
        }

        if (militar) {
            const militarName = `${uuidv4()}.${militar.extname}`;
            await militar.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: militarName
            });

            body.militar = militarName;
        }

        if (nascimento) {
            const nascimentoName = `${uuidv4()}.${nascimento.extname}`;
            await nascimento.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: nascimentoName
            });

            body.nascimento = nascimentoName;
        }

        if (endereco) {
            const enderecoName = `${uuidv4()}.${endereco.extname}`;
            await endereco.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: enderecoName
            });

            body.endereco = enderecoName;
        }

        if (carteira_trabalho) {
            const carteira_trabalhoName = `${uuidv4()}.${carteira_trabalho.extname}`;
            await carteira_trabalho.move(Application.tmpPath(`uploads/${body.colaborador}`), {
                name: carteira_trabalhoName
            });

            body.carteira_trabalho = carteira_trabalhoName;
        }

        (await usuario).save();
        response.status(201);

        return {
            msg: "Usuario atualizado com sucesso!",
            usuario
        }
    }

    public async delete({ params }: HttpContextContract) {
        const usuario = await Usuario.findOrFail(params.id);

        await usuario.delete();

        return {
            msg: "Usuário cadastrado com sucesso",
            usuario
        };
    }
}