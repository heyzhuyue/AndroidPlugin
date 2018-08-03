package com.plugin.pgy;

class PgyResult {

    /**
     * code : 0
     * message :
     * data : {"buildKey":"052171abdd35af4a26f9071f6b893908","userKey":"84e1019fb01536f66e4c62c910879159","buildType":"2","buildIsLastest":"1","buildFileSize":"1947841","buildName":"Address-sample","buildVersion":"1.0","buildVersionNo":"1","buildBuildVersion":"5","buildIdentifier":"ren.helloworld.address_sample","buildIcon":"e1bb991d7bbc6c2c3ab164db89490480","buildDescription":"","buildUpdateDescription":"","buildScreenshots":"","buildShortcutUrl":"8fMv","buildCreated":"2017-05-04 20:52:00","buildUpdated":"2017-05-04 20:52:00","buildQRCodeURL":"https://static.pgyer.com/build/qrcodeHistory/eef17314c3e03426d737a21802a985c86fd26b35dd3aa8556be634925eed8118"}*/

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * buildKey : 052171abdd35af4a26f9071f6b893908
         * userKey : 84e1019fb01536f66e4c62c910879159
         * buildType : 2
         * buildIsLastest : 1
         * buildFileSize : 1947841
         * buildName : Address-sample
         * buildVersion : 1.0
         * buildVersionNo : 1
         * buildBuildVersion : 5
         * buildIdentifier : ren.helloworld.address_sample
         * buildIcon : e1bb991d7bbc6c2c3ab164db89490480
         * buildDescription :
         * buildUpdateDescription :
         * buildScreenshots :
         * buildShortcutUrl : 8fMv
         * buildCreated : 2017-05-04 20:52:00
         * buildUpdated : 2017-05-04 20:52:00
         * buildQRCodeURL : https://static.pgyer.com/build/qrcodeHistory/eef17314c3e03426d737a21802a985c86fd26b35dd3aa8556be634925eed8118
         */

        private String buildKey;
        private String userKey;
        private String buildType;
        private String buildIsLastest;
        private String buildFileSize;
        private String buildName;
        private String buildVersion;
        private String buildVersionNo;
        private String buildBuildVersion;
        private String buildIdentifier;
        private String buildIcon;
        private String buildDescription;
        private String buildUpdateDescription;
        private String buildScreenshots;
        private String buildShortcutUrl;
        private String buildCreated;
        private String buildUpdated;
        private String buildQRCodeURL;

        public String getbuildKey() {
            return buildKey;
        }

        public void setbuildKey(String buildKey) {
            this.buildKey = buildKey;
        }

        public String getUserKey() {
            return userKey;
        }

        public void setUserKey(String userKey) {
            this.userKey = userKey;
        }

        public String getBuildType() {
            return buildType;
        }

        public void setBuildType(String buildType) {
            this.buildType = buildType;
        }

        public String getbuildIsLastest() {
            return buildIsLastest;
        }

        public void setbuildIsLastest(String buildIsLastest) {
            this.buildIsLastest = buildIsLastest;
        }

        public String getbuildFileSize() {
            return buildFileSize;
        }

        public void setbuildFileSize(String buildFileSize) {
            this.buildFileSize = buildFileSize;
        }

        public String getbuildName() {
            return buildName;
        }

        public void setbuildName(String buildName) {
            this.buildName = buildName;
        }

        public String getbuildVersion() {
            return buildVersion;
        }

        public void setbuildVersion(String buildVersion) {
            this.buildVersion = buildVersion;
        }

        public String getbuildVersionNo() {
            return buildVersionNo;
        }

        public void setbuildVersionNo(String buildVersionNo) {
            this.buildVersionNo = buildVersionNo;
        }

        public String getbuildBuildVersion() {
            return buildBuildVersion;
        }

        public void setbuildBuildVersion(String buildBuildVersion) {
            this.buildBuildVersion = buildBuildVersion;
        }

        public String getbuildIdentifier() {
            return buildIdentifier;
        }

        public void setbuildIdentifier(String buildIdentifier) {
            this.buildIdentifier = buildIdentifier;
        }

        public String getbuildIcon() {
            return buildIcon;
        }

        public void setbuildIcon(String buildIcon) {
            this.buildIcon = buildIcon;
        }

        public String getbuildDescription() {
            return buildDescription;
        }

        public void setbuildDescription(String buildDescription) {
            this.buildDescription = buildDescription;
        }

        public String getbuildUpdateDescription() {
            return buildUpdateDescription;
        }

        public void setbuildUpdateDescription(String buildUpdateDescription) {
            this.buildUpdateDescription = buildUpdateDescription;
        }

        public String getbuildScreenshots() {
            return buildScreenshots;
        }

        public void setbuildScreenshots(String buildScreenshots) {
            this.buildScreenshots = buildScreenshots;
        }

        public String getbuildShortcutUrl() {
            return buildShortcutUrl;
        }

        public void setbuildShortcutUrl(String buildShortcutUrl) {
            this.buildShortcutUrl = buildShortcutUrl;
        }

        public String getbuildCreated() {
            return buildCreated;
        }

        public void setbuildCreated(String buildCreated) {
            this.buildCreated = buildCreated;
        }

        public String getbuildUpdated() {
            return buildUpdated;
        }

        public void setbuildUpdated(String buildUpdated) {
            this.buildUpdated = buildUpdated;
        }

        public String getbuildQRCodeURL() {
            return buildQRCodeURL;
        }

        public void setbuildQRCodeURL(String buildQRCodeURL) {
            this.buildQRCodeURL = buildQRCodeURL;
        }
    }
}