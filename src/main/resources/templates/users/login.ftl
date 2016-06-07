<#import "../layout.html" as layout />
<@layout.application title="登录">
<div class="col-md-8">
    <h2>登录</h2>
    <form class="form-horizontal" method="POST" action="/login">
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">邮件地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputLink" placeholder="Link" name="email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputLink" placeholder="Link" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>
</@layout.application>
