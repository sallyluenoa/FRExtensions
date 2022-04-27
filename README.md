# FRExtensions

[FRExtensions](https://sallyluenoa.github.io/FRExtensions/index.html) is a library of additional extensions for Kotlin Android.

## How to Install

### Create a Personal Access Token

You should create a GitHub personal access token to read the GitHub packages in your Android project.

1. Open your personal GitHub account.
1. Settings -> Developer Settings -> Personal access tokens -> Generate new token
1. Generate a new token. Scopes would be selected "read:packages" only.
1. You should keep the created token.

### Install your Android Project with Gradle

In your Android project, open build.gradle of the root and add the following settings.  
`ACCOUNT_NAME` is your GitHub account name and `ACCESS_TOKEN` is the token you created above.

```Gradle
allprojects {
    repositories {
        google()
        mavenCentral()

        // Add this settings.
        maven {
            name = 'GitHubPackages'
            url = uri('https://maven.pkg.github.com/sallyluenoa/FRExtensions')
            credentials {
                username = ACCOUNT_NAME
                password = ACCESS_TOKEN
            }
        }
    }
}
```

Open build.gradle of the module and add the following dependency.

```Gradle
implementation 'org.fog-rock.frextensions:frextensions:1.0.1'
```

Then sync your project with Gradle.  
The library will be installed in your project.

## Releases

Please read [GitHub Releases](https://github.com/sallyluenoa/FRExtensions/releases).

## Documents

[A latest version](./docs/index.html) can be read witch written with Kdoc formats.  
Old versions are available from Assets of the past releases.

## License

This license is [Apache License 2.0](./LICENSE.txt).

## For Developers

Please read [Memos for Developers](./developers.md).