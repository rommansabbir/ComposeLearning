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
            "Passionate Android Engineer with the experience of 4+ years in Android Native Application Development and it’s one of my biggest passion. Strong knowledge of Android Platform (Java/Kotlin), Collections, Multithreading, IO, Networking, Generics and Profiling.\n" +
                    "\n" +
                    "Building Scalable Enterprise Mobile Application by following SOLID, Design Pattern & Principles, Dependency Injection, Clean Architecture, MVVM, RxJava2, Coroutine, Git Flow, Git. \n" +
                    "\n" +
                    "Communication with Backend/Server Side through RESTAPI/GraphQL/Client SDK. Experience in Backend Development with Django and Spring Framework (Kotlin).\n" +
                    "\n" +
                    "Integration of 3rd Party Libraries, Documenting - Modularizing - Refactoring Code, Code Review and Maintaining proper codebase.\n" +
                    "\n" +
                    "I love to contribute to the Open-Source Community. I have developed several Android Libraries which are available on my Github Profile to Download or Intregration in Android Project."
        ),
        DynamicViewActivity.Models.DynamicViewModel4(
            linkedInProfile = "https://www.linkedin.com/in/rommansabbir/",
            githubProfile = "https://github.com/rommansabbir/",
            website = "https://rommansabbir.com/"
        )
    )