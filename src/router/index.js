import Vue from 'vue'
import Router from 'vue-router'
// import Foo from '@/components/Foo'
// import Bar from '@/components/Bar'
// import User from '@/components/User'
// import Menus from '@/components/Menus'
import Layouts from '@/components/Layouts'
import Todo from '@/components/Todo'
// import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    // { path: '/', name: 'HelloWorld', component: HelloWorld },
    // { path: '/', name: 'Layouts', component: Layouts },
    // { path: '/bar/:id', name: 'user', component: User },
    // { path: '/foo', name: 'Foo', component: Foo },
    // { path: '/bar', name: 'Bar', component: Bar },
    // { path: '/menus', name: 'menus', component: Menus },
    {
      path: '/',
      name: 'Layouts',
      component: Layouts,
      children: [
        {
          path: '/todo/:id',
          name: 'todo',
          component: Todo
        }
      ]
    }
  ]
})
