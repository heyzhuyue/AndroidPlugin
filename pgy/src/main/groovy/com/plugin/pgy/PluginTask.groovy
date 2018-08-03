package com.plugin.pgy

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.jsoup.helper.StringUtil
import org.jsoup.nodes.Document

class PluginTask extends DefaultTask {
    public static final String UPLOAD_URL = "https://www.pgyer.com/apiv2/app/upload";

    // String WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=df24a72afa19bebd0f91e17564630ef94a562908fb34d1e0a297aa22ce993d9b";
//测试
    String WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=";
//正式

    PluginTask() {
        super()
        group = 'pgyer'
    }

    @TaskAction
    void test() {
        //  println(project.plugin_pgy.toString());
        //  println(project.plugin_pgy.sourceApk)
        uploadApk(project.plugin_pgy.sourceApk.toString(), project.plugin_pgy._api_key.toString(),
                project.plugin_pgy.desc.toString(), project.plugin_pgy.ceshiMobile.toString(),
                project.plugin_pgy.kaifaMobile.toString(),project.plugin_pgy.access_token.toString())
    }

    void uploadApk(String sourceApk, String apiKey, String desc, String ceshi, String kaifa, String access_token) {
        println("参数打印-->")
        println("sourceApk-->" + sourceApk)
        println("蒲公英apiKey-->" + apiKey)
        println("更新描述-->" + desc)
        println("钉钉机器人->" + access_token)
        WEB_HOOK = WEB_HOOK + access_token;
        String file = findFile(sourceApk)
        if (file == null) {
            println("文件不存在")
            return;
        }
        File uploadFile = new File(file);
        if (!uploadFile.exists() || !uploadFile.isFile()) {
            println("文件不存在");
            return;
        }
        desc = "更新说明：类型：" + uploadFile.getName() + "\n" + desc
        System.out.println("正在上传文件：" + uploadFile.getName() + " 到 " + UPLOAD_URL);
        InputStream is = new FileInputStream(uploadFile);
        Document doc = Jsoup.connect(UPLOAD_URL)
                .ignoreContentType(true)
                .data("_api_key", apiKey)
                .data("file", uploadFile.getName(), is)
                .data("buildInstallType", "1")
                .data("buildUpdateDescription", desc)
                .data("buildPassword", "")
                .timeout(1000 * 60 * 10)
                .post();

        is.close();
        String result = doc.body().text();
        System.out.println("文件上传完成" + result);
        PgyResult upload = new Gson().fromJson(result, new TypeToken<PgyResult>() {}.getType())
        if (upload.getCode() != 0) {
            System.out.println("上传失败\n");
            System.out.println("错误码：" + upload.getCode() + "\n");
            System.out.println("错误日志：" + upload.getMessage() + "\n");
            String errorMsg = "上传失败[错误码:" + upload.getCode() + "\n" + "错误日志：" + upload.getMessage() + "]";
            String error = "{\n" +
                    "     \"msgtype\": \"text\",\n" +
                    "     \"text\": {\n" +
                    "         \"content\": \" @" + kaifa + errorMsg + "\"\n" +
                    "     },\n" +
                    "     \"at\": {\n" +
                    "         \"atMobiles\": [\n" +
                    "             \"" + kaifa + "\"\n" +
                    "         ], \n" +
                    "         \"isAtAll\": false\n" +
                    "     }\n" +
                    " }";
            Jsoup.connect(WEB_HOOK).ignoreContentType(true)
                    .requestBody(error)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .post();
            return;
        }

        String appQRCodeURL = upload.getData().getbuildQRCodeURL();
        // String pa = "{\n     \"msgtype\": \"markdown\",\n     \"markdown\": {\"title\":\"" + uploadFile.getName() + "\",\n\"text\":\"#### " + uploadFile.getName() + "\n" + updateDesc + "\n" + " ![screenshot](" + appQRCodeURL + ")\\n   ###### 下载地址： [蒲公英](https://www.pgyer.com/axjjb) \"\n     },\n }";
        String pa = "{\n" +
                "     \"msgtype\": \"markdown\",\n" +
                "     \"markdown\": {\"title\":\"" + uploadFile.getName() + "\",\n" +
                "\"text\":\"#### " + uploadFile.getName() + "  \\n  @" + ceshi + desc + "\\n\\n  ![screenshot](" + appQRCodeURL + ")\\n   ###### 下载地址： [蒲公英](https://www.pgyer.com/" + upload.getData().getbuildShortcutUrl() + ") \"\n" +
                "     },\n" +
                "    \"at\": {\n" +
                "        \"atMobiles\": [\n" +
                "            \"" + ceshi + "\"\n" +
                "        ], \n" +
                "        \"isAtAll\": false\n" +
                "    }\n" +
                " }";
        Jsoup.connect(WEB_HOOK).ignoreContentType(true)
                .requestBody(pa)
                .header("Content-Type", "application/json;charset=UTF-8")
                .post();
        printResultInfo(upload);
    }

    /**
     * 根据文件名找出文件名
     *
     * @param file
     * @return
     */
    private String findFile(String file) {
        if (StringUtil.isBlank(file)) return null;
        if (!file.contains("*")) return file;

        String dirPath = file.substring(0, file.lastIndexOf("/"));
        final String[] keys = file.substring(file.lastIndexOf("/") + 1).split("\\*");
        String[] files = new File(dirPath).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                boolean ok = true;
                for (String key : keys) {
                    ok &= key.equals("") || name.contains(key);
                }
                return ok;
            }
        });
        return files == null || files.length == 0 ? null : files[0];
    }

    /**
     * @param upload
     */
    private static void printResultInfo(PgyResult upload) {
        System.out.println();
        PgyResult.DataBean data = upload.getData();
        System.out.println("应用类型：" + data.getBuildType());
        System.out.println("是否是最新版：" + data.getbuildIsLastest());
        System.out.println("App 文件大小：" + data.getbuildFileSize());
        System.out.println("应用名称：" + data.getbuildName());
        System.out.println("版本号：" + data.getbuildVersion());
        System.out.println("Android的版本编号：" + data.getbuildVersionNo());
        System.out.println("build号：" + data.getbuildBuildVersion());
        System.out.println("应用程序包名：" + data.getbuildIdentifier());
        System.out.println("应用的Icon图标key：" + data.getbuildIcon());
        System.out.println("应用介绍：" + data.getbuildDescription());
        System.out.println("应用更新说明：" + data.getbuildUpdateDescription());
        System.out.println("应用截图的key：" + data.getbuildScreenshots());
        System.out.println("应用短链接：" + data.getbuildShortcutUrl());
        System.out.println("应用二维码地址：" + data.getbuildQRCodeURL());
        System.out.println("应用上传时间：" + data.getbuildCreated());
        System.out.println("应用更新时间：" + data.getbuildUpdated());
        System.out.println();
    }


}