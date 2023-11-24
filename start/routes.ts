import Route from '@ioc:Adonis/Core/Route'

// Saudações

Route.get('/', async () => {
  return { 
    Welcome: 'Seja bem vindo ao servidor back-end Lingo Kennel',
    Tecnologia: 'AdonisJS - TypeScript',
    DevOPS: 'Docker',
    Database: 'SQL',
    Desenvolvedor: 'Vitor Costa'
  }
});

// Autenticação

Route.post('login', async ({ auth, request, response }) => {
  const email = request.input('email')
  const password = request.input('password')

  try {
    const token = await auth.use('api').attempt(email, password)
    return token
  } catch {
    return response.unauthorized('Credenciais não autorizadas')
  }
});

Route.group(() => {

  // Route Usuarios

  Route.post('usuarios', 'UsuariosController.post')
}).prefix('/api')