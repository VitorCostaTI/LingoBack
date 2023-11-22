import Route from '@ioc:Adonis/Core/Route'

Route.get('/', async () => {
  return { 
    Welcome: 'Seja bem vindo ao servidor back-end Lingo Kennel',
    Tecnologia: 'AdonisJS - TypeScript',
    DevOPS: 'Docker',
    Database: 'SQL',
    Desenvolvedor: 'Vitor Costa'
  }
});

Route.group(() => {
  // Route Usuarios

  Route.post('usuarios', 'UsuariosController.post')
}).prefix('/api')