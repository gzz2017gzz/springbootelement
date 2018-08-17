import moment from 'moment';
import  {filterZoneCode} from '../utils/zoneService';

export const genderFilter = (gender) => {
  if (gender == 1) {
    return '男'
  }
  if (gender == 2) {
    return '女'
  }
  if (gender == 3) {
    return '未知'
  }
  if (gender == 4) {
    return '保密'
  }
  return "";
}

export const chargeModeFilter = (val) => {
  if (val == 1) {
    return "包时";
  }
  if (val == 2) {
    return "计时";
  }
  if (val == 3) {
    return "储值";
  }
  return "";
}

function data_format(time) {
  if (time != null)
    return new moment(time).format("YYYY-MM-DD")
}

function smsTypeFormat(val) {
  if (val === 1) {
    return "营销短信";
  }
  if (val == 2) {
    return "验证码短信";
  }
}

function smsStatusFormat(val) {
  if (val === 1) {
    return "启用";
  }
  if (val == 0) {
    return "停用";
  }
}

function bcaHideFormat(val) {
  if (val === 1) {
    return "显示";
  }
  if (val == 2) {
    return "隐藏";
  }
}

function optionSelect(val) {
  if (val == 1) return "选项";
  if (val == 2) return "输入框";
}
//Question_enable
function QuestionEnable(val) {
  if (val == 1) return "启用";
  if (val == 0) return "禁用";
}
//Question_type
function QuestionType(val) {
  if (val == 1) return "身体基本情况";
  if (val == 2) return "身体详细情况";
  if (val == 3) return "体能测试";
  if (val == 4) return "身体围度";
  if (val == 5) return "体型形体分析";
  if (val == 6) return "综合评价";

}
//说明须知类型(购卡，私教等)
export const ExplainTypeFilter = (val) => {
  if (val == 1) return "买卡须知";
  if (val == 2) return "买私教须知";
  if (val == 3) return "买储值须知";
  if (val == 4) return "买卡说明";
  if (val == 5) return "买私教说明";
}
export const usefeedStatusFilter = (val) => {
  if (val == 1) return "未修复";
  if (val == 2) return "已修复";
  return "";
}
//App菜单调整顺序专用
function appAuthFilter(val) {
  if (val == 1) return "员工";
  if (val == 2) return "会员";
}

export const SOFT_VERSION = (val) => {
  if (val == 1) return "团队版";
  if (val == 2) return "企业版";
  if (val == 3) return "旗舰版";
  return "";
}

export const SOFT_LIST = [
  {id: 1, name: SOFT_VERSION(1)},
  {id: 2, name: SOFT_VERSION(2)},
  {id: 3, name: SOFT_VERSION(3)}
]

export const INTENTION = (val) => {
  if (val == 1) return "加盟合作";
  if (val == 2) return "教练培训";
  if (val == 3) return "使用软件";
  return "";
}

export const INTENTION_LIST = [
  {id: 1, name: INTENTION(1)},
  {id: 2, name: INTENTION(2)},
  {id: 3, name: INTENTION(3)}
]

export const CHANNEL = (val) => {
  if (val == 1) return "加盟网";
  if (val == 2) return "学院网";
  if (val == 3) return "动岚科技官网";
  if (val == 4) return "资源网";
  if (val == 5) return "加盟后台";
  if (val == 6) return "动岚健身APP";
  return "";
}


export const CHANNEL_LIST = [
  {id: 1, name: CHANNEL(1)},
  {id: 2, name: CHANNEL(2)},
  {id: 3, name: CHANNEL(3)},
  {id: 4, name: CHANNEL(4)},
  {id: 5, name: CHANNEL(5)},
  {id: 6, name: CHANNEL(6)}
]


export const zone_code = (val) => {
  return filterZoneCode(val).join(" ");
}


export default function (Vue) {
  Vue.filter('question_type', QuestionType);
  Vue.filter('question_enable', QuestionEnable);
  Vue.filter('option_select', optionSelect);
  Vue.filter('gender-filter', genderFilter);
  Vue.filter('date-filter', data_format);
  Vue.filter('chargeMode-filter', chargeModeFilter);
  Vue.filter('sms-type-format', smsTypeFormat);
  Vue.filter('sms-Status-Format', smsStatusFormat)
  Vue.filter('bca-Hide-Format', bcaHideFormat)
  Vue.filter('ExplainTypeFilter', ExplainTypeFilter)
  Vue.filter('usefeedStatusFilter', usefeedStatusFilter)
  Vue.filter('appAuth-filter', appAuthFilter)//App菜单调整顺序专用
  Vue.filter('soft_version_filter', SOFT_VERSION)//软件版本
  Vue.filter('intention_filter', INTENTION)//意向
  Vue.filter('channel_filter', CHANNEL)//渠道
  Vue.filter('zone_code_filter', zone_code)//区划编码
}
