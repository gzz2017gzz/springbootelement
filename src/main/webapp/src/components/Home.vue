<template>
  <el-container>
    <el-header :style="{boxShadow: '0 2px 3px 2px rgba(0,0,0,.2)'}">
      你好张三,欢迎你使用!!
    </el-header>
    <el-container>
      <el-aside width="199px" style="background-color: #545c64;overflow: visible" :style="{minHeight: 'calc(100vh - 77px)'}">
        <el-aside width="200px">
          <el-col :span="24">
            <el-row class="tac">
              <el-menu default-active="1" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" router>
                <el-submenu v-for="menu in menus" :index="menu.func_id + ''" :key="menu.func_id" :title="menu.tip">
                  <template slot="title"><i :class="menu.icon"></i>{{menu.name}}</template>
                  <el-menu-item v-for="sub in menu.children" :key="sub.id" :index="sub.url" :title="sub.tip">{{sub.name}}</el-menu-item>
                </el-submenu>
              </el-menu>
            </el-row>
          </el-col>
        </el-aside>
      </el-aside>
      <el-container>
        <el-main>
          <router-view/>
        </el-main>
        <el-footer align="center">版权所有:gzz</el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>
<script>
  export default {
    components: {},
    data() {
      return {
        menus: [],
      }
    },
    components: {},
    created: function () {
      const that = this;
      that.$http.post("/api/adminFunc/queryList", {}).then(res => {
        that.menus = res.data;
      });
    },

  }
</script>

