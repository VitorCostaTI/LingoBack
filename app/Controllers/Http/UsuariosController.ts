import type { HttpContextContract } from '@ioc:Adonis/Core/HttpContext'
import Usuario from 'App/Models/Usuario';

export default class UsuariosController {

    /**** Autenticação de usuario ****/ 

    public async login({auth, request, response}){
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

    public async logout({auth}){
        await auth.use('api').revoke()
        return {
          revoked: "Usuario deslogado com sucesso"
        }
    }

    /**** Teste das funcionalidades do middleware ****/ 
    
    public async teste({auth}){
        return {
            Welcome: `${auth.user!.email}`,
          }
    }

    /**** Criação de usuario ****/ 

    public async post({request, response}: HttpContextContract){
        const body = request.body();

        await Usuario.create(body);

        response.status(201);

        return{
            msg: "Usuario adicionado com sucesso",
            produto: body
        }
    }
}