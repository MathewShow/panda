<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
FreeMarker模板引擎
<h1>${person.name}</h1>
<h1>${person.age}</h1>
<h1>${person.sex ? string("男",'女')}</h1>
<h1>${person.birthday?string("yyyy-MM-dd")}</h1>
<h1><#list person.list as key>
        ${key}
    <script>
        //alert('${key}');
        console.log('${key_index}');
    </script>
</#list></h1>

<h1>
    <#list person.map?keys as key>
        <#--${key}-->
        ${person.map["${key}"]}
    </#list>
</h1>
<h1>${person.dog.name}</h1>
<h1>${person.dog.age}</h1>
</body>
</html>