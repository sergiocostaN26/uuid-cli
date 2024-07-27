# UUID CLI

A tiny project intended to play with Kotlin Native and UUIDs version 7. 

## Getting Started

1. Clone this repository.
2. Generate the `kexe` file by running `./gradlew build` inside the folder of the repository.
3. Start generating UUIDs v7 by running `./build/bin/native/releaseExecutable/uuid-cli.kexe` from your terminal inside the folder of the repository.

Bear in mind, that the current implementation generates UUIDs using nanoseconds precision.

Do you want to generate several UUIDv7 at the same time? Try running `seq 10 | xargs -I {} ./build/bin/native/releaseExecutable/uuid-cli.kexe` from your terminal.

## Future plans
- Support milli and microseconds and choosing among them via the CLI.
- Decode UUIDs.
- Generate UUIDs based on a given timestamp.