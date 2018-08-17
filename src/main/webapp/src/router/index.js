import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui'
import Welcome from '../components/Welcome.vue'
import Home from '../components/Home.vue'
import AdminSysUser from '../components/sys/adminsysuser/AdminSysUserList.vue'
import AdminDept from '../components/sys/admindept/AdminDeptTree.vue'
import AdminFunc from '../components/sys/adminfunc/AdminFuncTree.vue'
import AdminRole from '../components/sys/adminrole/AdminRoleList.vue'

Vue.use(Router)
Vue.use(ElementUI)
export default new Router({
  routes: [{
    path: '/',
    name: '主页面',
    component: Home,
    redirect: "/Welcome",//默认加载欢迎页
    children: [
      {path: 'Welcome', name: '欢迎页', component: Welcome},
      {path: 'adminSysUser', component: AdminSysUser, name: '用户管理',},
      {path: 'adminDept', component: AdminDept, name: '部门',},
      {path: 'adminRole', component: AdminRole, name: '角色管理',},
      {path: 'adminMenu', component: AdminFunc, name: '菜单管理',}]
  },]
})
