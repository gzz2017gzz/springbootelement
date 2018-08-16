<template>
  <div>
    <div class="block">
      <span>
        <el-button type="text" size="mini" @click="() => doAdd(menus)" >填加子菜单</el-button>
      </span>
      <el-tree :data="menus" show-checkbox node-key="id" default-expand-all :expand-on-click-node="false">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          {{ data.title }}
          <span>
            <el-button type="text" size="mini" @click="() => doAdd(data)">填加子菜单</el-button>
            <el-button type="text" size="mini" @click="() => doDelete(node, data)">删除</el-button>
            <el-button type="text" size="mini" @click="() => doEdit(node, data)">修改</el-button>
          </span>
        </span>
      </el-tree>
    </div>
    <MenuDialog ref="dialog" :refresh="refresh"/>
  </div>
</template>
<script>
  import MenuDialog from "./MenuDialog"
  export default {
    components: {MenuDialog},
    created: function () {
      this.refresh();
    },
    methods: {
      refresh() {
        const that = this;
        that.$http.post("/api/menu/queryList").then(res => {
          that.menus = res.data;
        }).catch(res => {
          that.$message.error("查询菜单失败：" + res);
        });
      },
      doAdd(data) {
        this.$refs["dialog"].addDialog(data);
      },
      doEdit(node, row) {
        this.$refs["dialog"].editDialog(node, row);
      },
      doDelete(node, data) {
        const that = this;
        // if (data.children.length > 0) {
        //   that.$message.error("请先删除子结点!");
        //   return;
        // }
        this.$confirm('你确定要删除吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          const parent = node.parent;
          const arrays = parent.data.children || parent.data;
          const index = arrays.findIndex(d => d.id === data.id);
          that.ids.push(data.id);
          that.findIds(arrays[index]);
          // console.log(this.ids);
          arrays.splice(index, 1);
          that.$http.delete("/api/menu/delete", {params: {ids: that.ids}}).then(res => {
            this.$message.success("删除成功");
            that.refresh();
          }).catch(res => {
            that.$message.error("删除失败：" + res);
          });
        });
      },
      findIds(menu) {
        if (menu.children.length > 0) {
          menu.children.forEach(item => {
            this.ids.push(item.id);
            this.findIds(item);
          });
        } else {
          return;
        }
      },
    },
    data() {
      return {
        ids: [],
        menus: [],
      }
    }
  }
</script>

