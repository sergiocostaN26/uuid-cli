# UUID CLI

A tiny project intended to play with Kotlin Native and UUIDs version 7. 

## Getting Started

1. Clone this repository.
2. Generate the `.kexe` file by running `./gradlew build` inside the folder of the repository.
3. Start generating UUIDs v7 by running `./build/bin/native/releaseExecutable/uuid-cli.kexe` from your terminal inside the folder of the repository.

Do you want to generate several UUIDv7 at the same time? Try running `seq 10 | xargs -I {} ./build/bin/native/releaseExecutable/uuid-cli.kexe` from your terminal.

## Generating the Homebrew Formula

1. Generate a new release version attaching the `.kexe` file. You will find the existing releases in [uuid-cli/releases](https://github.com/sergiocostaN26/uuid-cli/releases/).
2. Copy the asset link of the `.kexe` file. Take [uuid-cli/releases/download/v.0.0.1-alpha/uuid-cli.kexe](https://github.com/sergiocostaN26/uuid-cli/releases/download/v.0.0.1-alpha/uuid-cli.kexe) copied from [uuid-cli/releases/tag/v.0.0.1-alpha](https://github.com/sergiocostaN26/uuid-cli/releases/tag/v.0.0.1-alpha) as example.
3. Run `brew create <copied link>`.
4. Edit the file according to the generated version. Take the following as an example:
```
class UuidCli < Formula
  desc "A CLI to generate UUIDv7 using Kotlin/Native."
  homepage "https://github.com/sergiocostaN26/uuid-cli"
  url "https://github.com/sergiocostaN26/uuid-cli/releases/download/v.0.0.1-alpha/uuid-cli.kexe"
  sha256 "36450ed434e53a9d2a5f41382e9f37dda437ff6caa3518ab3457dd58129308ff"
  version "0.0.1-alpha"
  license "Apache-2.0"

  def install
    bin.install "uuid-cli.kexe" => "uuid-cli"
  end
end
```
5. Run `uuid-cli` and enjoy.

## Future plans
- Decode UUIDs.

This implementation follows the [RFC 9562](https://datatracker.ietf.org/doc/rfc9562/).
