# Trading Terminology

Reference glossary for the swap domain, covering acronyms, product types, action codes,
event types, market conventions, regulatory bodies, and identifiers. Where a CDM
equivalent exists, it is noted.

---

## 1. Acronyms — General

| Acronym | Full term | Definition |
|---|---|---|
| ANNA | Association of National Numbering Agencies | Global body that coordinates securities identification via national agencies |
| BIS | Bank for International Settlements | International financial institution owned by central banks; fosters monetary and financial cooperation |
| CCP | Central Counterparty | Entity that interposes itself between buyer and seller, becoming buyer to every seller and seller to every buyer, reducing bilateral counterparty risk |
| CDE | Critical Data Element | Standardised field definitions agreed by CPMI-IOSCO for harmonised OTC derivatives reporting |
| CDM | Common Domain Model | FINOS open-standard machine-readable model for financial product lifecycle (trades, events, legal docs) |
| CPMI | Committee on Payments and Market Infrastructures | BIS committee that sets standards for payment, clearing, settlement and FMI arrangements |
| CSA | Credit Support Annex | ISDA document governing collateral exchange between counterparties; also: Canadian Securities Administrators (regulator) |
| DRR | Digital Regulatory Reporting | ISDA initiative encoding trade reporting rules as machine-executable code on top of CDM |
| DSB | Derivatives Service Bureau (ANNA DSB) | ANNA subsidiary that issues UPIs and OTC ISIN codes |
| DSL | Domain-Specific Language | Programming language tailored to a particular domain; CDM uses the Rune DSL |
| EIC | Energy Identification Code | ACER-managed code identifying market participants in European energy markets |
| EMIR | European Market Infrastructure Regulation | EU regulation for OTC derivatives, CCPs and trade repositories |
| ETD | Exchange-Traded Derivative | Derivatives contract traded on a regulated exchange (futures, listed options) |
| FMI | Financial Market Infrastructure | Systems for payment, clearing, settlement (CCPs, TRs, CSDs, PSs, SSSs) |
| FpML | Financial products Markup Language | XML standard for OTC derivatives messaging, maintained by ISDA |
| FRA | Forward Rate Agreement | OTC contract fixing an interest rate for a future period; settled on the rate differential |
| FRO | Floating Rate Option | Named benchmark rate (e.g. USD-SOFR, EUR-EURIBOR-Reuters) used in floating-rate calculations |
| GLEIF | Global Legal Entity Identifier Foundation | Organisation overseeing the global LEI system |
| GMRA | Global Master Repurchase Agreement | ICMA standard master agreement for repo transactions |
| GMSLA | Global Master Securities Lending Agreement | ISLA standard master agreement for securities lending |
| ICLA | Individual Contributor License Agreement | Legal agreement for individual contributions to open-source projects (e.g. FINOS) |
| CCLA | Corporate Contributor License Agreement | Legal agreement for corporate contributions to open-source projects |
| ICMA | International Capital Market Association | Trade association for international capital markets; co-governs CDM with ISDA and ISLA |
| IRS | Interest Rate Swap | OTC contract exchanging fixed-rate and floating-rate interest payments on a notional amount |
| ISDA | International Swaps and Derivatives Association | Trade association for OTC derivatives; publishes master agreements, definitions, and DRR |
| ISLA | International Securities Lending Association | Trade association for securities lending; co-governs CDM with ISDA and ICMA |
| ISIN | International Securities Identification Number | 12-character alphanumeric code uniquely identifying a security (ISO 6166) |
| LEI | Legal Entity Identifier | 20-character alphanumeric code uniquely identifying a legal entity in financial transactions (ISO 17442) |
| MIC | Market Identifier Code | 4-character code identifying a trading venue or exchange (ISO 10383) |
| MTM | Mark to Market | Valuation of a position at current market prices |
| NDF | Non-Deliverable Forward | FX forward settled in cash (usually USD) rather than physical delivery of the non-convertible currency |
| NDO | Non-Deliverable Option | FX option settled in cash rather than physical delivery |
| NDS | Non-Deliverable Swap | Cross-currency swap settled in cash rather than physical exchange of principal |
| OIS | Overnight Index Swap | Interest rate swap where the fixed leg pays a fixed rate and the floating leg pays the compounded overnight rate (e.g. SOFR, SONIA, ESTR) over each calculation period. The overnight rate resets daily but is compounded and settled periodically. OIS rates serve as the primary discounting curve for collateralised derivatives. Post-LIBOR, most major-currency "vanilla" swaps are effectively OIS since replacement benchmarks are all overnight rates |
| OTC | Over-the-Counter | Bilateral trading directly between parties, not through a centralised exchange |
| PV | Present Value | Current worth of a future cash flow, discounted at an appropriate rate |
| RDS | Regulatory Data Submission | DTCC's harmonised format for submitting regulatory reports |
| RTS | Regulatory Technical Standards | Detailed rules implementing EU regulations (e.g. RTS 22 under MiFIR) |
| TR | Trade Repository | Central facility for collecting and maintaining records of OTC derivatives transactions |
| UPI | Unique Product Identifier | ISO 4914 code identifying an OTC derivatives product, assigned by the ANNA DSB |
| USI | Unique Swap Identifier | US (CFTC) identifier for a swap transaction; replaced by UTI under harmonised rules |
| UTI | Unique Transaction Identifier | Globally agreed identifier for an OTC derivatives transaction (ISO 23897) |
| XML | Extensible Markup Language | Text-based data format used by FpML, ISO 20022, and regulatory schemas |

---

## 2. Acronyms — Benchmark Rates

| Acronym | Full term | Currency | Definition |
|---|---|---|---|
| SOFR | Secured Overnight Financing Rate | USD | Broad measure of overnight Treasury repo rates; replaced USD LIBOR |
| SONIA | Sterling Overnight Index Average | GBP | Weighted average of unsecured overnight sterling transactions; replaced GBP LIBOR |
| ESTR (or ESTER) | Euro Short-Term Rate | EUR | ECB-published overnight unsecured euro rate; replaced EONIA |
| EURIBOR | Euro Interbank Offered Rate | EUR | Rate at which eurozone banks lend unsecured to each other at various tenors (1W–12M) |
| TONA | Tokyo Overnight Average Rate | JPY | Weighted average of overnight call rates in Tokyo; replaced JPY LIBOR |
| CDI | Certificado de Deposito Interbancario | BRL | Brazilian overnight interbank deposit rate |
| DI | Deposito Interbancario | BRL | Brazilian interbank deposit index; basis for DI futures and DI options |
| IDI | Indice de Depositos Interbancarios | BRL | Index derived from accumulated DI rates; basis for IDI options on B3 |
| LIBOR | London Interbank Offered Rate | multi | Former benchmark rate for USD, GBP, EUR, CHF, JPY; ceased 30 Jun 2023 (most settings) |
| DESTR | Danish kroner Short-Term Rate | DKK | Danish overnight unsecured rate |
| SWESTR | Swedish krona Short-Term Rate | SEK | Swedish overnight unsecured rate |

---

## 3. Action Types

4-letter codes used in regulatory reporting to describe what is being done with a trade
submission:

| Code | Full term | Meaning | CDM `ActionEnum` |
|---|---|---|---|
| NEWT | New Trade | First submission of a trade to a trade repository | `New` |
| MODI | Modification | Amendment to the terms of a previously reported trade (e.g. notional change, rate amendment) | `Correct` |
| CORR | Correction | Correction of data errors in a previously submitted report, without changing economic terms | `Correct` |
| EROR | Error | Cancellation of a previously submitted report that was sent in error | `Cancel` |
| TERM | Termination | Report that a trade has been terminated (early or at maturity) | `New` (new lifecycle event) |
| REVI | Revision / Revive | Reinstatement or revision of a previously reported trade | `Correct` |
| POSC | Position Component | Report of a trade that forms part of a compressed position | `New` |
| MARU | Margin Update | Update to margin/collateral information | `Correct` |
| VALU | Valuation Update | Update to the mark-to-market valuation | `New` (new valuation event) |
| PRTO | Porting | Transfer of a trade from one CCP member to another | `New` |

**Note:** CDM's `ActionEnum` has only three values: `New`, `Correct`, `Cancel`. The
richer regulatory distinctions (MODI vs CORR, TERM vs EROR) are handled in DRR's
reporting-rule layer, not at the CDM action level.

---

## 4. Event Types

4-letter codes describing the lifecycle event that occurred:

| Code | Full term | Meaning | CDM `EventIntentEnum` |
|---|---|---|---|
| TRAD | Trade | A new trade has been executed | `ContractFormation` |
| NOVA | Novation | Transfer of a trade to a new counterparty (step-in/step-out) | `Novation` |
| ETRM | Early Termination | Full termination of a trade before its scheduled maturity | `EarlyTerminationProvision` |
| ALOC | Allocation | Block trade split into individual allocations | `Allocation` |
| COMP | Compression | Multiple trades netted/compressed into fewer or zero trades | `Compression` |
| CLRG | Clearing | Trade submitted to a CCP for clearing | `Clearing` |
| AMND | Amendment | Change to economic terms of an existing trade | `ContractTermsAmendment` |
| INCP | Increase (partial) | Increase in notional or quantity of an existing trade | `Increase` |
| DCRS | Decrease (partial) | Partial reduction in notional or quantity | `Decrease` |
| EXER | Exercise | Exercise of an option or swaption | `OptionExercise` |
| RPRC | Repurchase | Closing leg of a repo transaction | `Repurchase` |
| IDXT | Index Transition | Replacement of a floating rate index (e.g. LIBOR → SOFR) with transition spread | `IndexTransition` |
| CORP | Corporate Action | Adjustment due to a corporate event on the underlier | `CorporateActionAdjustment` |
| CREV | Credit Event | Settlement triggered by a credit event (default, restructuring) | `CreditEvent` |
| REAL | Reallocation | Re-assignment of allocations within a block trade | `Reallocation` |
| PRBK | Portfolio Rebalancing | Insertion of offsetting trades to rebalance portfolio risk | `PortfolioRebalancing` |

---

## 5. Product Types — Swaps and Related

| Product name | Description | CDM payout composition | CDM qualification |
|---|---|---|---|
| Vanilla swap | Plain fixed-vs-floating IRS, single currency | `InterestRatePayout[]` (fixed + float) | `InterestRate_IRSwap_FixedFloat` |
| Basic swap (basis swap) | Float-vs-float IRS, same currency, different indices | `InterestRatePayout[]` (two float) | `InterestRate_IRSwap_Basis` |
| OIS | Overnight index swap — fixed vs overnight rate | `InterestRatePayout[]` (fixed + OIS float) | `InterestRate_IRSwap_FixedFloat_OIS` |
| Basis OIS | Float-vs-float where one leg is an overnight rate | `InterestRatePayout[]` (two float, one OIS) | `InterestRate_IRSwap_Basis_OIS` |
| FRA | Forward rate agreement — single-period rate fixing | `InterestRatePayout[]` (single calc period) | `InterestRate_Fra` |
| Cap / floor | Interest rate cap, floor, or collar | `InterestRatePayout` with cap/floor rate schedule | `InterestRate_CapFloor` |
| Swaption | Option to enter into an IRS | `OptionPayout` over `InterestRatePayout[]` | `InterestRate_Option_Swaption` |
| OIS swaption | Option to enter into an OIS | `OptionPayout` over OIS swap | `InterestRate_Option_Swaption` |
| Cancelable swap | IRS with embedded right to cancel | vanilla swap + `CancelableProvision` | `InterestRate_IRSwap_FixedFloat` + provision |
| Swap spread | IRS where the fixed rate is quoted as a spread over a benchmark | `InterestRatePayout[]` (fixed with spread) | `InterestRate_IRSwap_FixedFloat` |
| Rate lock | Forward-starting IRS used to lock in a rate | `InterestRatePayout[]` (forward effective date) | `InterestRate_IRSwap_FixedFloat` |
| Bond option | Option on a debt instrument | `OptionPayout` over bond underlier | `InterestRate_Option_DebtOption` |
| Inflation swap (zero coupon) | Fixed vs inflation-linked (zero coupon) | `InterestRatePayout` with `InflationRateSpecification` | `InterestRate_InflationSwap_FixedFloat_ZeroCoupon` |
| Inflation YoY swap | Fixed vs year-on-year inflation rate | `InterestRatePayout` with `InflationRateSpecification` | `InterestRate_InflationSwap_FixedFloat_YearOn_Year` |
| Cross-currency swap | IRS with legs in different currencies | `InterestRatePayout[]` (different currency per leg) | `InterestRate_CrossCurrency_FixedFloat` or `_Basis` |
| FX spot / forward | Single exchange of currencies at a future (or spot) date | `SettlementPayout` | `ForeignExchange_Spot_Forward` |
| FX swap | Two FX exchanges — near leg + far leg | `SettlementPayout[]` (two legs) | `ForeignExchange_Swap` |
| FX simple option | Vanilla FX option (call/put on a currency pair) | `OptionPayout` over FX underlier | `ForeignExchange_VanillaOption` |
| FX reset | Cross-currency swap with periodic notional reset | `InterestRatePayout[]` + notional reset | `InterestRate_CrossCurrency_*` + reset |
| NDF | Non-deliverable FX forward | `SettlementPayout` (cash settled) | `ForeignExchange_NDF` |
| NDO | Non-deliverable FX option | `OptionPayout` over non-deliverable FX | `ForeignExchange_NDO` |
| DI option | Option on the Brazilian DI rate | `OptionPayout` over DI index | Custom — no standard CDM qualification |
| IDI option | Option on the Brazilian IDI index | `OptionPayout` over IDI index | Custom — no standard CDM qualification |
| CDS | Credit default swap — protection against credit events | `InterestRatePayout` (premium) + credit underlier | `CreditDefaultSwap_SingleName` / `_Index` / `_Basket` |
| Credit fee only | Fee payment on a credit derivative (upfront fee, restructuring fee) | `SettlementPayout` | No swap qualification — standalone transfer |
| Commodity rate lock | Rate lock on a commodity price | `FixedPricePayout` | `Commodity_Swap_FixedFloat` or custom |
| Commodity swap | Fixed-vs-floating exchange on commodity prices | `FixedPricePayout` + commodity observable | `Commodity_Swap_FixedFloat` or `_Basis` |
| Fee only | Standalone fee or premium payment (not part of a swap) | `SettlementPayout` | No swap qualification — standalone transfer |
| Rates fee only | Fee payment in rates context (break fee, amendment fee) | `SettlementPayout` | No swap qualification — standalone transfer |
| Variance swap | Swap on realised vs implied variance | `PerformancePayout` (variance return) | `EquitySwap_ParameterReturnVariance_*` |
| Volatility swap | Swap on realised vs implied volatility | `PerformancePayout` (volatility return) | `EquitySwap_ParameterReturnVolatility_*` |
| Total return swap | Swap on total return of an underlier (equity, bond, index) | `PerformancePayout` (total return) | `EquitySwap_TotalReturnBasicPerformance_*` |

---

## 6. Day Count Conventions

Fraction of a year used to calculate interest accrual:

| Convention | Also known as | How it counts |
|---|---|---|
| ACT/360 | Actual/360, Money Market | Actual days elapsed / 360 |
| ACT/365 | Actual/365 Fixed | Actual days elapsed / 365 |
| ACT/ACT | Actual/Actual ISDA | Actual days / actual days in year (365 or 366) |
| 30/360 | Bond Basis, 30/360 US | Each month = 30 days, year = 360 |
| 30E/360 | Eurobond Basis, 30/360 ISDA | 30-day months with European end-of-month rules |
| ACT/365L | Actual/365 Leap | Actual days / 365 or 366 (if period contains 29 Feb) |
| BUS/252 | Business/252 | Business days elapsed / 252 (Brazilian convention for DI) |

---

## 7. Business Day Conventions

How payment and calculation dates are adjusted when they fall on a non-business day:

| Convention | Rule |
|---|---|
| FOLLOWING | Move to the next business day |
| MODFOLLOWING | Move to the next business day, unless it falls in the next month — then move back |
| PRECEDING | Move to the previous business day |
| MODPRECEDING | Move to the previous business day, unless it falls in the prior month — then move forward |
| NONE | No adjustment — pay on the calendar date regardless |
| NEAREST | Move to the nearest business day (forward or back) |

---

## 8. Regulatory Authorities

Bodies that mandate OTC derivatives trade reporting:

| Acronym | Full name | Jurisdiction | Key regulation |
|---|---|---|---|
| CFTC | Commodity Futures Trading Commission | United States | 17 CFR Parts 43, 45 (swap reporting) |
| SEC | Securities and Exchange Commission | United States | Security-based swap reporting |
| ESMA | European Securities and Markets Authority | European Union | EMIR / EMIR REFIT |
| FCA | Financial Conduct Authority | United Kingdom | UK EMIR |
| CSA | Canadian Securities Administrators | Canada | Derivatives Data Technical Manual |
| HKMA | Hong Kong Monetary Authority | Hong Kong | OTC derivatives reporting |
| JFSA | Japan Financial Services Agency | Japan | OTC derivatives reporting |
| MAS | Monetary Authority of Singapore | Singapore | OTC derivatives reporting |
| ASIC | Australian Securities and Investments Commission | Australia | OTC derivatives reporting |
| CPMI-IOSCO | Committee on Payments and Market Infrastructures / IOSCO | International | CDE guidance, UPI/UTI standards |

---

## 9. Trade Repositories

| Acronym | Full name | Notes |
|---|---|---|
| DTCC | Depository Trust & Clearing Corporation | Operates Global Trade Repository (GTR); provides RDS harmonised format |
| CME | Chicago Mercantile Exchange | Operates CME Trade Repository |
| ICE | ICE Trade Vault | Operated by Intercontinental Exchange |
| KOR | KOR Reporting | Canadian trade repository |

---

## 10. Legal Agreements

| Term | Full name | Definition |
|---|---|---|
| ISDA Master Agreement | ISDA Master Agreement | Bilateral framework contract governing all OTC derivatives between two parties |
| Schedule | ISDA Schedule | Customised elections and amendments to the ISDA Master Agreement |
| CSA | Credit Support Annex | Governs collateral exchange (margin) between counterparties under an ISDA Master |
| Confirmation | Trade Confirmation | Document specifying the economic terms of an individual trade under the Master Agreement |
| ISDA Definitions | ISDA Definitions (2006, 2021) | Standard definitions for interest rate and currency derivative terms |
| MiFIR | Markets in Financial Instruments Regulation | EU regulation requiring transaction reporting (RTS 22 = equity/bond; RTS 25 = reference data) |

---

## 11. Trade Lifecycle States

| State | Meaning | CDM representation |
|---|---|---|
| Live / Open | Trade is active and accruing | `TradeState` with no `closedState` |
| Matured | Trade has reached its scheduled termination date | `TradeState` with `closedState.state = Terminated` |
| Terminated (early) | Trade was unwound before maturity | `closedState.state = Terminated`, via `EarlyTerminationProvision` event |
| Novated | Trade transferred to a new counterparty | `closedState.state = Novated` |
| Allocated | Block trade split into allocations | `closedState.state = Allocated` |
| Cancelled | Trade cancelled (error or mutual agreement) | `closedState.state = Cancelled` |
| Exercised | Option/swaption exercised | `closedState.state = Exercised` |
| Compressed | Trade eliminated via portfolio compression | `closedState.state = Cancelled` (via `Compression` event) |

---

## 12. Identifiers

| Identifier | Issuer | Format | Purpose |
|---|---|---|---|
| UTI | Generating entity (one of the counterparties) | Up to 52 alphanumeric characters, prefixed by LEI | Unique global trade identifier for regulatory reporting |
| USI | US counterparty | Alphanumeric, prefixed by namespace | CFTC-era US swap identifier; largely replaced by UTI |
| UPI | ANNA DSB | ISO 4914 format | Identifies the product type of an OTC derivative |
| LEI | National numbering agency via GLEIF | 20 alphanumeric characters | Identifies the legal entity that is a party to the trade |
| ISIN | National numbering agency | 12 alphanumeric characters (ISO 6166) | Identifies a specific security or instrument |
| MIC | ISO | 4 alphanumeric characters (ISO 10383) | Identifies the trading venue or exchange |
| EIC | ACER | 16 alphanumeric characters | Identifies participants in European energy markets |
| Trade ID | Internal (firm-specific) | Alphanumeric (firm-defined) | Internal reference for a trade, mapped to `TradeIdentifier.assignedIdentifier.identifier` in CDM |
| Trade version | Internal | Integer starting from 1 | Incremented on each amendment/correction; mapped to `AssignedIdentifier.version` in CDM |
