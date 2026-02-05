# Lingr

Lingr is a desktop utility for macOS and Linux that helps you find files,
folders, and system artifacts that no longer belong on your machine.

The goal is not aggressive cleanup, but clarity — showing what exists,
why it exists, and how confident Lingr is that something is safe to remove.

---

## Status

Lingr is currently under active development and is **not yet feature-complete**.
The API, data model, and UI are still evolving.

---

## Vision

Modern operating systems accumulate a large amount of leftover data:
application support files, caches, logs, launch agents, and other artifacts
that remain after apps are removed or stop being used.

Lingr aims to:

- Scan well-defined system locations
- Group findings into meaningful artifacts
- Explain *why* something exists
- Assign a confidence level to each finding
- Let users decide what to remove — nothing is deleted automatically

Lingr prioritizes transparency and safety over one-click cleanup.

---

## Scope

### In scope
- macOS and Linux
- User-level artifacts
- Explainable scan results
- Confidence-based recommendations

### Out of scope
- Windows support (for now)
- Registry-style cleanup
- Automatic or silent deletion
- “Boost performance” claims

---

## Architecture (high level)

Lingr is built using:
- Kotlin Multiplatform
- Compose Multiplatform (Desktop)
- A modular, domain-driven structure

Platform-specific scanning logic is isolated and explicit.

---

## License

Lingr is source-available under a non-commercial license.

You’re welcome to explore, study, and modify the code for personal or educational
use. Commercial use or redistribution requires explicit permission.

See the LICENSE file for details.

---

## Notes

This project is developed and maintained by a single author.
Expect iteration, refactoring, and changes as the MVP takes shape.