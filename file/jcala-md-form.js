$(function() {
    var mdEditor;
    function a(a, b, c, d) {
        var f, g, h, i, e = $("#" + a);
        for (localStorage[c] = b[0], f = 0, g = b.length; g > f; f++) h = b[f], i = localStorage[c] == h ? 'selected="selected"' : "", e.append('<option value="' + h + '"' + i + ">" + h + "</option>");
        return e.bind("change", function() {
            var a = $(this).val();
            return "" === a ? !1 : (console.log("lsKey =>", c, a), localStorage[c] = a, d(e, a), void 0)
        }), e
    }
    mdEditor = editormd("markdown-editor", {
        width: "100%",
        height: 900,
        syncScrolling: "single",
        path: "../lib/",
        imageUpload: !0,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/admin/file/uplPic.action",
        saveHTMLToTextarea: !0
    }), a("editormd-theme-select", editormd.themes, "theme", function(a, b) {
        mdEditor.setTheme(b)
    }), a("editor-area-theme-select", editormd.editorThemes, "editorTheme", function(a, b) {
        mdEditor.setCodeMirrorTheme(b)
    }), a("preview-area-theme-select", editormd.previewThemes, "previewTheme", function(a, b) {
        mdEditor.setPreviewTheme(b)
    }), $("#add-blog").bind("click", function() {
        var a = document.forms[0];
        a.action = "/admin/post.do", a.method = "post", document.blogForm.article.value = $(".markdown-body")[0].innerHTML, document.blogForm.md.value = mdEditor.getMarkdown(), a.submit()
    }), $("#update-blog").bind("click", function() {
        var a = document.forms[0];
        a.action = "/admin/update.do", a.method = "post", document.blogForm.article.value = $(".markdown-body")[0].innerHTML, document.blogForm.md.value = mdEditor.getMarkdown(), a.submit()
    }), $("#update-resume").bind("click", function() {
        var a = document.forms[0];
        a.action = "/admin/resume.do", a.method = "post", document.resumeForm.resume.value = $(".markdown-body")[0].innerHTML, document.resumeForm.md.value = mdEditor.getMarkdown(), a.submit()
    })
});