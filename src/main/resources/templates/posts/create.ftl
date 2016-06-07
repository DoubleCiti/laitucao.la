<#import "../layout.html" as layout />
<@layout.application title="发表吐槽">
<div class="col-md-8">
    <h2>我要吐槽</h2>
    <form class="form-horizontal" method="POST" action="/create">
        <div class="form-group">
            <label for="inputLink" class="col-sm-2 control-label">链接</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputLink" placeholder="Link" name="link">
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
