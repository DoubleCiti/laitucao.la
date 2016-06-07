<#import "../layout.html" as layout />
<@layout.application title="注册新用户">
<div class="col-md-8">
    <h2>注册新用户</h2>
    <form class="form-horizontal" method="POST" action="/register">
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">邮件地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputLink" placeholder="Link" name="email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputLink" placeholder="Link" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputLink" placeholder="Link" name="password">
            </div>
        </div>
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">确定密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputLink" placeholder="Link" name="passwordConfirm">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Post</button>
            </div>
        </div>
    </form>
</div>
</@layout.application>
