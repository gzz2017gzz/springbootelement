export const genderFilter = (gender) => {
  if (gender === 1) return '男';
  if (gender === 2) return '女';
  return "";
};
function QuestionEnable(val) {
  if (val == 1) return "启用";
  if (val == 0) return "禁用";
}
export default function (Vue) {
  Vue.filter('gender-filter', genderFilter);
  Vue.filter('question_enable', QuestionEnable);
}
