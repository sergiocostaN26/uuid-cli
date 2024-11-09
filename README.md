# UUID CLI

Simple CLI to generate UUIDs v7 using Kotlin/Native.

## Installation
1. Go to one of the existing releases in [uuid-cli/releases](https://github.com/sergiocostaN26/uuid-cli/releases/).
2. Copy the asset link of the `.kexe` file.
   Take [uuid-cli/releases/download/v0.0.1/uuid-cli_0.0.1.kexe](https://github.com/sergiocostaN26/uuid-cli/releases/download/v0.0.1/uuid-cli_0.0.1.kexe)
   copied from [uuid-cli/releases/tag/v0.0.1](https://github.com/sergiocostaN26/uuid-cli/releases/tag/v0.0.1) as example.
3. Run `brew create <copied link>`.
4. Edit the generated file. Take [docs/uuid-cli.rb](docs/uuid-cli.rb) as an example. 
5. Run `brew install --build-from-source <path to the formula on your machine>`.
6. Run `uuid` and enjoy.

## Usage

| Feature                                                                   | Command                                        | Output                                 |
| ------------------------------------------------------------------------- | ---------------------------------------------- | -------------------------------------- |
| Generate random UUID v7                                                   | `uuid`                                         | `019123b6-1be1-7bc2-925a-badf472e51c1` |
| Generate random UUID v7 based on a timestamp with `OffsetDateTime` format | `uuid 2024-08-05T18:03:42.945Z`                | `019123b6-1be1-7bc2-925a-badf472e51c1` |
| Generate random UUID v7 based on a timestamp with `Instant` format        | `uuid 1722881022945`                           | `019123b6-1be1-7bc2-925a-badf472e51c1` |
| Decode the timestamp of a UUID v7                                         | `uuid -d 019123b6-1be1-7bc2-925a-badf472e51c1` | `2024-08-05T18:03:42.945Z`             |
| Get help                                                                  | `uuid -h`, `uuid --help`                       | Help information                       |

---

### IETF RFC Standard

This implementation follows the [RFC 9562](https://datatracker.ietf.org/doc/rfc9562/).