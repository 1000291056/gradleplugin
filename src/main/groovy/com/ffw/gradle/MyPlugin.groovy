package com.ffw.gradle

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project


class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println("into self_plugin...")
        project.afterEvaluate {
            project.android.lintOptions.xmlOutput = new File(project.buildDir, "lintResult.xml")
        }

        project.tasks.create("hello",{println("hello plugin")})
        def android=project.extensions.getByType(AppExtension)
        android.registerTransform(new MyTransform());
    }
}
