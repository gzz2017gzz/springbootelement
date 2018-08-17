// 性别
export const GENDER_TYPES = {GENDER_MALE: 1, /*男*/  GENDER_FEMALE: 2, /*女*/};
export const GENDER = [{id: GENDER_TYPES.GENDER_MALE, name: '男'}, {id: GENDER_TYPES.GENDER_FEMALE, name: '女'}];
//手机号验证
export const poneNoFormatValidator = (rule, value, callback) => {
  let reg = /^1([0-9]{10})$/;
  if (!reg.test(value)) {
    callback("手机号格式必须正确");
  } else {
    callback();
  }
};
