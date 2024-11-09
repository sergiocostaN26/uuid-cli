class UuidCli < Formula
  desc "Simple CLI to generate UUIDs v7 using Kotlin/Native."
  homepage "https://github.com/sergiocostaN26/uuid-cli"
  url "https://github.com/sergiocostaN26/uuid-cli/releases/download/v0.0.1/uuid-cli_0.0.1.kexe"
  sha256 "<sha256 hash should be automatically generated>"
  version "0.0.1"
  license "Apache-2.0"

  def install
    bin.install "uuid-cli.kexe" => "uuid"
  end
end