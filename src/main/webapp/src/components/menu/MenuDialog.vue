/*菜单新增与修改,作者:高振中,日期:2018-05-18 16:04:03*/
<template>
  <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="form" ref="form" :rules="rules" label-width="100px">
      <el-row>
        <el-col>
          <el-form-item label="图标" prop="icon">
            <el-input placeholder="请输入图标" v-model="form.icon"/>
          </el-form-item>
          <el-form-item label="提示信息" prop="tip">
            <el-input placeholder="请输入提示信息" v-model="form.tip"/>
          </el-form-item>
          <el-form-item label="标题" prop="title">
            <el-input placeholder="请输入标题" v-model="form.title"/>
          </el-form-item>
          <el-form-item label="地址" prop="url">
            <el-input placeholder="请输入地址" v-model="form.url"/>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" style="text-align: right">
      <el-button @click="show = false">取消</el-button>
      <el-button type="primary" @click="save()">确定</el-button>
    </div>
  </el-dialog>
</template>
<script>
  import Vue from 'vue';

  export default {
    props: ["refresh", "append"],
    data() {
      return {
        title: '',
        form: this.initForm(),
        dialogMode: "save",
        show: false,
        data: null,
        node: null,
        rules: {
          icon: [
            {required: true, message: '请输入图标', trigger: 'blur'},
            {min: 1, max: 10, message: '图标长度不正确', trigger: 'blur'},
          ],
          tip: [
            {required: true, message: '请输入提示信息', trigger: 'blur'},
            {min: 1, max: 10, message: '提示信息长度不正确', trigger: 'blur'},
          ],
          title: [
            {required: true, message: '请输入标题', trigger: 'blur'},
            {min: 1, max: 10, message: '标题长度不正确', trigger: 'blur'},
          ],
          url: [
            {required: true, message: '请输入地址', trigger: 'blur'},
            {min: 1, max: 10, message: '地址长度不正确', trigger: 'blur'},
          ],
        }
      }
    },
    methods: {
      save() {//新增及修改记录
        const that = this;
        this.$refs['form'].validate((valid) => {
          if (!valid) {
            return;
          }
          if (that.dialogMode == "save") {
            let arrays = that.data.children || that.data;
            arrays.push(that.form);
          } else {
            const parent = that.node.parent;
            const children = parent.data.children || parent.data;
            const index = children.findIndex(d => d.id === that.data.id);

            Vue.set(children[index], "title", that.form.title);
            Vue.set(children[index], "icon", that.form.icon);
            Vue.set(children[index], "tip", that.form.tip);
            Vue.set(children[index], "url", that.form.url);
          }
          that.$http.post("/api/menu/" + that.dialogMode, JSON.stringify(that.form)).then(res => {
            that.show = false;
            that.$message.success(that.title + "成功!");
            that.form.id = res.data;
          }).catch(res => {
            that.$message.error(that.title + "出错!" + res);
          });
        });
      },
      initForm() {//初始数据
        return {
          id: null,//id
          icon: null,//图标
          parent_id: null,//上级结点
          tip: null,//提示信息
          title: null,//标题
          url: null,//地十
          children: [],
        }
      },
      addDialog(data) {//新增
        this.title = "新增菜单";
        this.dialogMode = "save";
        this.form = this.initForm();
        this.form.parent_id = data.id;
        this.data = data;
        this.show = true;
      },
      editDialog(node, data) {//修改
        this.title = "修改菜单";
        this.dialogMode = "update";
        this.form = {...data};
        this.data = data;
        this.node = node;
        this.show = true;
      },
    },
  }
</script>
<style></style>
