# Carbonio GraphQL

![Contributors](https://img.shields.io/github/contributors/zextras/carbonio-gql "Contributors")
![Activity](https://img.shields.io/github/commit-activity/m/zextras/carbonio-gql "Activity") ![License](https://img.shields.io/badge/license-AGPL%203-green
"License")
![Project](https://img.shields.io/badge/project-carbonio-informational
"Project")
[![Twitter](https://img.shields.io/twitter/url/https/twitter.com/zextras.svg?style=social&label=Follow%20%40zextras)](https://twitter.com/zextras)

Server and extensions for GraphQL database.
<!--
SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>

SPDX-License-Identifier: AGPL-3.0-only
-->

# `carbonio-gql`> Carbonio GraphQL Service

This service provides a GraphQL interface for users to perform operations on the
Carbonio platform.

---

## Installation

### Pre-Requisites

The `carbonio-mailbox` project must be built and deployed to the `.zcs-deps`
folder.

The `carbonio-build` and `carbonio-zcs` projects should also reside in the same
local parent folder as this project.

### Deploying the extension from CLI

For testing purposes you can build and and deploy the extension to
`/opt/zextras/lib/ext/zm-gql` by running the following:

```sh
ant clean deploy

```
Afterwards, become the `zextras` user and perform a `zmmailboxdctl restart`.

---

## Testing

## Unit testing the extension from CLI

```sh
ant clean test

```
---

## Usage

### API


Download and install a GraphQL explorer and view the docs built by
introspection.

The general usage flow involves performing an auth, then using the acquired auth
token to perform subsequent GraphQL requests.

The service url should appear as:
`https://<hostname>/service/extension/graphql`.

The auth token should be used in a `Cookie` header as
`ZM_AUTH_TOKEN=<auth_token_value>`.

## How to build

Since we are dealing with an Ant project, in order to build it you
have to give the following command:

```sh
ant jar
```

This will generate a `jar` file under the `build` directory.

## Additional references

You can always gather additional knowledge about Carbonio visiting the
project homepage here: https://www.zextras.com/carbonio/

## License

See [COPYING](COPYING) file for details
