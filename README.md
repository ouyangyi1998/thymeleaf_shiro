# thymeleaf_shiro
通过shiro thymeleaf mybatis springboot对于用户权限进行控制crud
- thymleaf对于前端进行渲染 可以导入thymeleaf-extras-shiro 在前端进行拦截<shiro hasPermissions><shiro hasRoles>
- 数据库 有三张实体表，两张关联表 user role permission user_role role_permission
- mybatis 作为持久层framework，对于数据库进行操作
- 数据库预设三种角色 1.admin 可以进行 edit add delete，2.edit，3.add ，也可以添加delete角色
- 通过jsonview对于异常进行捕获
- 本demo的缺点 无法进行权限添加 也无法实现admin对于其他角色的控制
