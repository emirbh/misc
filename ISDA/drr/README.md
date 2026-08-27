# Digital Regulatory Reporting (DRR)

A community-driven implementation of **Digital Regulatory Reporting** built with the **Rune** DSL and the **Rosetta** platform, extending the **FINOS Common Domain Model (CDM)**.  
The goal of this project is to provide a standardised, machine-executable expression of reporting rules that firms can implement consistently across jurisdictions and regimes.


## 📘 What is DRR?

**Digital Regulatory Reporting (DRR)** is a shared, machine-executable standard for derivatives reporting, built on the **Common Domain Model (CDM)**. Developed by ISDA, it replaces inconsistent, manual interpretations of rules with a single digital rulebook, improving data quality, reducing costs, and making compliance safer, faster, and cheaper.


[Read more about DRR here.](https://www.isda.org/isda-solutions-infohub/isda-digital-regulatory-reporting/)

## 🚀 Why This Exists

- **Consistency & mutualisation** – Encode reporting rules once, share them as open logic, and avoid duplicative interpretation across firms and vendors.  
- **Model-driven execution** – Rules are authored in **Rune** (formerly Rosetta DSL) and run via **Rosetta**, generating transparent, testable outcomes from well-typed inputs.  
- **CDM alignment** – Inputs/outputs are aligned to the **FINOS CDM**, enabling data interoperability and lifecycle consistency.

## 🔍 Core Concepts

> The DRR lifecycle follows the canonical **Translate → Enrich → Transform → Project** pattern recommended by Rosetta.

| Stage       | Purpose                                                                 |
|--------------|--------------------------------------------------------------------------|
| **Translate** | Normalise inbound payloads into the CDM-aligned input shape.           |
| **Enrich**    | Derive fields required by the reporting regime (e.g., UTI, product ID).|
| **Transform** | Apply rule logic to compute reportable fields and validations.         |
| **Project**   | Produce regulator-ready outputs (schemas, templates, etc.).            |

---

## 🧠 Development Workflow

1. **Model first** – Extend CDM where necessary in `rosetta-source/model/`.  
2. **Author rules** – Add Rune rules/functions in `rosetta-source/rules/` and `functions/`.  
3. **Test-drive** – Create unit and scenario tests under `tests/`.  
4. **Document** – Capture design decisions and release notes in `docs/`.

### Coding Standards

- Functional, composable rules  
- Clear, domain-aligned naming  
- Small, reusable functions  
- Deterministic, self-contained tests

## 🤝 Contributing

We welcome issues, discussions, and pull requests!

1. Create a feature branch from `main`.  
2. Add or update tests for any changes.  
3. Run the full pipeline and validate golden outputs.  
4. Open a PR with a clear summary and rationale.

> Please follow DRR documentation guidance for release notes and change logs.

## 📚 References

- [DRR Documentation (Overview & Guides)](https://docs.rosetta-technology.io/drr)  
- [FINOS CDM GitHub](https://github.com/finos/common-domain-model)  
- [Rune DSL on FINOS](https://github.com/finos/rune)  
- [ISDA DRR Fact Sheet](https://www.isda.org/category/digital-regulatory-reporting/)

## ⚖️ License

Unless otherwise noted, this project is released under an open-source license compatible with the CDM community guidelines.  
See the `LICENSE` file for details.
