# Excercise - Third Party Libraries
### Winter 2017 - Android

### Overview:
Learn how to integrate third party libraries to make your life easier!

### Getting Started:

1. Clone repository.
2. Create a new branch off master and name the branch according to the form {name}/thirdpartylibs (e.g. kenton/thirdpartylibs).

### How It Works:

This app works by first making a `GET` request to `random.cat/meow` via the `GetRandomCatUrlTask`. This task returns an image url
for a random cat picture. When this request finishes, the app then makes another web request to download the image bitmap via the
`DownloadCatImageTask`. On completion of this request, the app loads the bitmap into an `ImageView`.

### Your Task:

1. Integrate `Butterknife` into the app and convert all `findViewById` methods to using Butterknife view bindings.
2. Integrate `Picasso` into the app and use it to load the random cat image URL into the `ImageView`.
3. When you have finished integrating the two libraries, create a pull request against master.

