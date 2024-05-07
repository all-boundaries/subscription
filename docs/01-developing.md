# Developing

Prepare your machine, play with the repository locally.

## :building_construction: Dependencies 

Most of the configurations are contained within the repository, however it
does requires a few tools to be installed, which are:

1. Install [devbox]
1. Install [direnv]
1. Install [colima]

## :rocket: Get Started

```sh
devbox run start
```

**[devbox.json][db-json]** is the source of truth for dependencies and commands.
Check [devbox.json][db-json] to understand better what is available and how it
works.

Execute the commmand below to see available tasks:

```sh
devbox run
```

[devbox]: https://www.jetify.com/devbox/docs/contributor-quickstart
[direnv]: https://direnv.net/docs/installation.html
[colima]: https://github.com/abiosoft/colima?tab=readme-ov-file#installation
[db-json]: ../devbox.json "devbox.json"
