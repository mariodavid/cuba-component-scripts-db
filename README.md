[![Build Status](https://travis-ci.com/mariodavid/cuba-component-taggable.svg?branch=master)](https://travis-ci.com/mariodavid/cuba-component-taggable)
[ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-taggable/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-taggable/_latestVersion)
[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

CUBA component - Scripts DB
======================
This application component makes groovy scripts a first class citizen in a CUBA application.

## Installation

1. `scripts-db` is available in the [CUBA marketplace](https://www.cuba-platform.com/marketplace)
2. Select a version of the add-on which is compatible with the platform version used in your project:

| Platform Version | Add-on Version |
| ---------------- | -------------- |
| 6.9.x            | 0.1.x          |


The latest version is: [ ![Download](https://api.bintray.com/packages/mariodavid/cuba-components/cuba-component-scripts-db/images/download.svg) ](https://bintray.com/mariodavid/cuba-components/cuba-component-scripts-db/_latestVersion)

Add custom application component to your project:

* Artifact group: `de.diedavids.cuba.scripts-db`
* Artifact name: `scripts-db-global`
* Version: *add-on version*

```groovy
dependencies {
  appComponent("de.diedavids.cuba.scripts-db:scripts-db-global:*addon-version*")
}
```


## Using the application component


#### Script definition via UI
![1-script-browse](https://github.com/mariodavid/cuba-component-scripts-db/blob/master/img/1-script-browse.png)

![2-script-editor](https://github.com/mariodavid/cuba-component-scripts-db/blob/master/img/2-script-editor.png)

#### DB Script selection in Scheduled Tasks
![3-scheduled-tasks-with-db-script](https://github.com/mariodavid/cuba-component-scripts-db/blob/master/img/3-scheduled-tasks-with-db-script.png)

