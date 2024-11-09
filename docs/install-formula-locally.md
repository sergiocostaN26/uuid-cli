## Generating the Homebrew Formula

1. Go to one of the existing releases in [uuid-cli/releases](https://github.com/sergiocostaN26/uuid-cli/releases/).

2. Copy the asset link of the `.kexe` file. 
Take [uuid-cli/releases/download/v.0.0.1/uuid-cli.kexe](https://github.com/sergiocostaN26/uuid-cli/releases/download/v.0.0.1/uuid-cli.kexe) 
copied from [uuid-cli/releases/tag/v.0.0.1](https://github.com/sergiocostaN26/uuid-cli/releases/tag/v.0.0.1) as example.

3. Run `brew create <copied link>`.

4. Edit the generated file. Take the following as an example:

```
class UuidCli < Formula
  desc "Simple CLI to generate UUIDs v7 using Kotlin/Native."
  homepage "https://github.com/sergiocostaN26/uuid-cli"
  url "https://github.com/sergiocostaN26/uuid-cli/releases/download/v.0.0.1/uuid-cli.kexe"
  sha256 "<sha256 hash should be automatically generated>"
  version "0.0.1"
  license "Apache-2.0"

  def install
    bin.install "uuid-cli.kexe" => "uuid"
  end
end
```

5. Run `brew install --build-from-source <path to the formula on your machine>`. 
The path could look like the following: `/opt/homebrew/Library/Taps/homebrew/homebrew-core/Formula/u/uuid-cli.rb`..

6. Run `uuid` and enjoy.