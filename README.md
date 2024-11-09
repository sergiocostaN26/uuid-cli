# UUID CLI

Simple CLI to generate UUIDs v7 using Kotlin/Native.

## Installation
`brew install uuid-cli`.

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

### Troubleshooting

If the CLI has not been merged into homebrew-core yet, follow the instructions [here](docs/install-formula-locally.md) to install 
the Homebrew Formula locally.