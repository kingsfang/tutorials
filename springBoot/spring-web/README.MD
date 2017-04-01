
1. 映射前台请求到后台

a. 使用@RequestMapping
b. 使用@GetMapping, @PostMapping, @PutMapping, @DeleteMapping


2. 传递参数到后台

a. request.getParameter
b. @Param注解获取请求参数
c. @PathVariable获取请求URL路径上的参数
d. @RequestBody 绑定输入的JSON字符串到对象获取POST数据
e. @ModelAttribute 绑定输入Form字段到对象获取POST数据
f. 表单校验: @Valid, BindingResult(获取校验错误), @NotEmpty, @Length
g. 上传文件



3.  输出参数到页面视图

a. 普通页面视图: Map, ModelMap, Model, ModelAndView
b. Rest(@ResponseBody): return "string", return object
c. Rest: return ResponseEntity.ok(object)


4. 视图类型 forward/redirect

a. return "viewName"
b. return "redirect:pageUrl"
c. redirect传参到新页面RedirectAttributes


5. 错误处理

a. 表单映射错误处理
b. 

