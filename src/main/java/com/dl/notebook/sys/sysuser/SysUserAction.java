package com.dl.notebook.sys.sysuser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "api/sysUser" })
public class SysUserAction {

	@RequestMapping({ "getUser" })
	public SysUser getUser() {
		return new SysUser(1L, "李四光");
	}
}
