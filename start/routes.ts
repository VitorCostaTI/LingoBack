import Route from '@ioc:Adonis/Core/Route'

/*
|--------------------------------------------------------------------------
| Saudações
|--------------------------------------------------------------------------
*/

Route.get('/', async () => {
  return {
    Welcome: 'Seja bem vindo ao servidor back-end Lingo Kennel',
    Tecnologia: 'AdonisJS - TypeScript',
    DevOPS: 'Docker',
    Database: 'SQL',
    Desenvolvedor: 'Vitor Costa'
  }
});

/*
|--------------------------------------------------------------------------
| Autenticação
|--------------------------------------------------------------------------
*/

Route.post('login', 'UsuariosController.login');

Route.get('usuario/teste', 'UsuariosController.teste').middleware('auth');

Route.post('logout', 'UsuariosController.logout');


/*
|--------------------------------------------------------------------------
| Funcionalidades
|--------------------------------------------------------------------------
*/


Route.group(() => {
  
  /**** Usuarios ****/ 
  Route.get('usuarios', 'UsuariosController.get')
  Route.get('usuarios/:id', 'UsuariosController.getID')
  Route.post('usuarios', 'UsuariosController.post');
  
}).prefix('/api').middleware('auth')