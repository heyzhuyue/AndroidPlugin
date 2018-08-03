package com.plugin.pgy;

import org.gradle.api.Plugin
import org.gradle.api.Project

class PluginImpl implements Plugin<Project> {
    private final String EXTENSION_PATCHER = "plugin_pgy"

    @Override
    void apply(Project project) {
        project.extensions.create(EXTENSION_PATCHER, PluginExtension)
        project.tasks.create("uploadPgy", PluginTask)
    }
}