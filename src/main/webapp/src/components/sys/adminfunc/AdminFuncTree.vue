/*菜单列表,作者:高振中,日期:2018-08-10 09:21:48*/
<template>
  <div>
    <el-tree :data="dataList" node-key="id" default-expand-all :expand-on-click-node="false" v-loading="loading" element-loading-text="正在加载......">
        <span class="custom-tree-node" slot-scope="{ node,data}">
          {{ data.name}}
          <span style="margin-left: 30px">
            <el-button type="text" size="mini" @click="() => doAdd(data)">添加子菜单</el-button>
            <el-button type="text" size="mini" @click="() => doEdit(data)">修改</el-button>
            <el-button type="text" size="mini" :disabled="data.parent_id ==0" @click="() => doDelete(node, data)">删除</el-button>
          </span>
        </span>
    </el-tree>
    <AdminFuncDialog ref="dialog" :refresh="refresh"></AdminFuncDialog>
  </div>
</template>
<script>
  import AdminFuncDialog from './AdminFuncDialog.vue';

  export default {
    data: function () {
      return {
        total: 0,
        page: 1,
        size: 20,
        dataList: [],
        form: {
          func_id: null,//主键
          type: null,//类型
          color: null,//颜色
          icon: null,//图标
          name: null,//名称
          parent_id: null,//父结点ID
          tip: null,//提示信息
          remark: null,//备注
          status: null,//状态
          url: null,//地址
          order_num: null,//排序编号
        },
        loading: false
      }
    },
    computed: {},
    created: function () {
      this.refresh();
    },
    methods: {
      refresh() {
        const that = this;
        that.loading = true;
        // const requestData = {...that.form, page: that.page - 1, size: that.size};
        that.$http.post("/api/adminFunc/queryList", {}).then(res => {
          that.loading = false;
          that.dataList = res.data;
          // that.total = res.data.totalElements;
        }).catch(res => {
          that.$message.error("获取菜单列表失败：" + res);
          that.loading = false;
        });
      },
      doAdd(data) {
        this.$refs["dialog"].addDialog(data.func_id);
      },
      doEdit(row) {
        this.$refs["dialog"].editDialog(row);
      },
      doDelete(node, row) {
        const that = this;
        if (row.children.length > 0) {
          that.$message.error("请先删除子结点!");
          return;
        }
        this.$confirm('你确定要删除吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          that.$http.delete("/api/adminFunc/delete", {
            params: {ids: [row.func_id]}
          }).then(res => {
            this.$message.success("删除成功");
            that.refresh();
          }).catch(res => {
            that.$message.error("删除失败：" + res);
          });
        }).catch(() => {
        });
      }
    },
    components: {AdminFuncDialog}
  }
</script>
<style></style>
