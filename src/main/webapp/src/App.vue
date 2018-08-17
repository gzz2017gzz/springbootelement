<template>
  <router-view/>
</template>
<!--<script>-->
<!--export default {-->
<!--name: 'App'-->
<!--}-->
<!--</script>-->

<style>

  /**
  新增 v1.2 tzc
   */
  .el-table td {
    padding: 2px 0 !important;
  }

  input, button, .el-card, .el-message, .el-alert, textarea, .el-dialog, .el-select-dropdown, .el-tag, .el-radio-button:first-child .el-radio-button__inner, .el-radio-button:last-child .el-radio-button__inner {
    border-radius: 0px !important;
  }

  .el-form-item__content, .el-form-item__label {
    line-height: 30px;
  }

  .el-input__inner, .el-button, .el-cascader {
    height: 30px;
    line-height: 30px;
    font-size: 12px !important;

  }

  .el-button {
    padding: 0 20px;
  }

  .el-button--text {
    padding-right: 0px;
    padding-left: 0px;
  }

  .el-tree-node__content {
    height: 30px;
  }

</style>
