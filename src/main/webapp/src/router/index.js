import Vue from 'vue'
import Router from 'vue-router'
import MenuTree from '../components/menu/MenuTree.vue'
import World from '../components/World.vue'
import Home from '../components/Home.vue'
import ElementUI from 'element-ui'

Vue.use(Router)
Vue.use(ElementUI)
export default new Router({
  routes: [{
    path: '/',
    name: 'MenuTree',
    component: Home,
    redirect: "/MenuTree",
    children: [
      {
        path: 'World',
        name: '世界',
        component: World
      }, {
        path: 'MenuTree',
        name: '你好世界',
        component: MenuTree
      },
    ]
  },]
})
