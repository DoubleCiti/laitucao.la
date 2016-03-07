<#import "../layout.ftl" as layout />
<@layout.application title="Welcome">
<#list postList as post>
    <div>
        <p><a href="/view/${post.id}">${post.link}</a></p>
    </div>
</#list>
<p><a href="/create" class="btn btn-default">我要吐槽</a></p>
</@layout.application>
