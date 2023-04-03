# FRExtensions

FRExtensions is a library of additional extensions for Kotlin Android.

## How to Install

### Create a Personal Access Token

You should create a GitHub personal access token to read the GitHub packages in your Android project.

1. Open your personal GitHub account.
1. Settings -> Developer Settings -> Personal access tokens -> Generate new token
1. Generate a new token. Scopes would be selected "read:packages" only.
1. You should keep the created token.

### Install your Android Project with Gradle

In your Android project, open the Gradle file (.gradle or .gradle.kts) of the root and add the following settings.  
`ACCOUNT_NAME` is your GitHub account name and `ACCESS_TOKEN` is the token you created above.

```Gradle
repositories {
    google()
    mavenCentral()

    // Add this settings.
    maven {
        url = uri("https://maven.pkg.github.com/sallyluenoa/FRExtensions")
        credentials {
            username = "ACCOUNT_NAME"
            password = "ACCESS_TOKEN"
        }
    }
}
```

Open the Gradle file of the module and add the following dependency, then sync your project with Gradle.  
The library will be installed in your project.

```Gradle
implementation("org.fog-rock.frextensions:frextensions:1.1.1")
```

## Releases

Release notes are available [here](./release-notes/README.md).

## Documents

[A latest version](./docs/index.html) can be read witch written with Kdoc formats.  
Old versions are available from Assets of the past releases.

## License

This license is [Apache License 2.0](./LICENSE.txt).

## For Developers

Please read [Memos for Developers](./developers.md).