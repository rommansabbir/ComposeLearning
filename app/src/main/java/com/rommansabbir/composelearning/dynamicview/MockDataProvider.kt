package com.rommansabbir.composelearning.dynamicview

internal fun getDynamicViewMockedData(): MutableList<DynamicViewActivity.Models.BaseDynamicModel> =
    mutableListOf(
        DynamicViewActivity.Models.DynamicViewModel1(
            "Romman Sabbir",
            "Senior Android Engineer, Electronic Music Producer",
            image = "https://i.scdn.co/image/ab6761610000e5eb66caf66f623c0e491477c1d6"
        ),
        DynamicViewActivity.Models.DynamicViewModel2(
            currentCompany = "Ami Probashi (Bangla Trac Group)",
            jobTitle = "Senior Android Engineer, Mobile Application"
        ),
        DynamicViewActivity.Models.DynamicViewModel3(
            skillsSet = mutableListOf(
                "Android",
                "Kotlin",
                "Java",
                "Gradle",
                "Git",
                "CI",
                "DI",
                "Clean Arch",
                "MVVVM",
                "JetPack",
                "Compose",
                "CustomView",
                "Code Review"
            ),
            "Passionate Android Engineer with the experience of 4+ years in Android Native Application Development and it’s one of my biggest passion. Strong knowledge of Android Platform (Java/Kotlin), Collections, Multithreading, IO, Networking, Generics and Profiling."
        ),
        DynamicViewActivity.Models.DynamicViewModel4(
            linkedInProfile = "https://www.linkedin.com/in/rommansabbir/",
            githubProfile = "https://github.com/rommansabbir/",
            website = "https://rommansabbir.com/"
        )
    )