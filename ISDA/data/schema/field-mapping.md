# Field Mapping — Internal Schema → CDM

Every field in the internal swap trade schema and where it lands in CDM `TradeState`
(CDM 5.29.0, matching DRR's pin).

## Core fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `tradeId` | `trade.tradeIdentifier[].assignedIdentifier[].identifier` | `string` | Becomes the UTI value |
| `tradeVersion` | `trade.tradeIdentifier[].assignedIdentifier[].version` | `int` | 1 = original, 2+ = amendment |
| `actionType` | `WorkflowStep.action` | `ActionEnum` | NEWT→New, MODI/CORR/REVI→Correct, EROR→Cancel |
| `eventType` | `WorkflowStep.businessEvent.intent` | `EventIntentEnum` | TRAD→ContractFormation, NOVA→Novation, etc. |
| `productType` | (not stored — inferred by qualification) | — | CDM qualifies the product from payout structure |
| `tradeDate` | `trade.tradeDate` | `date` | |
| `effectiveDate` | `economicTerms.payout[].calculationPeriodDates.effectiveDate` | `AdjustableDate` | |
| `terminationDate` | `economicTerms.payout[].calculationPeriodDates.terminationDate` | `AdjustableDate` | |

## Notional and currency

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `notionalAmount` | `trade.tradeLot[].priceQuantity[].quantity.value` | `number` | |
| `notionalCurrency` | `trade.tradeLot[].priceQuantity[].quantity.unit.currency` | `string` | ISO 4217 |
| `notionalAmount2` | second `priceQuantity[].quantity.value` | `number` | Cross-currency / FX only |
| `notionalCurrency2` | second `priceQuantity[].quantity.unit.currency` | `string` | |

## Rate specification

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `fixedRate` | `tradeLot[].priceQuantity[].price.value` + `priceType: InterestRate` | `number` | Also in `FixedRateSpecification.rateSchedule` |
| `floatingRateIndex` | `FloatingRateIndex.floatingRateIndex` | `FloatingRateIndexEnum` | e.g. USD-SOFR |
| `floatingRateIndexTenor` | `FloatingRateIndex.indexTenor` | `Period` | periodMultiplier + period |
| `spread` | `FloatingRateSpecification.spreadSchedule` | `number` | |

## Day count and frequency

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `fixedDayCount` | `payout[fixed].dayCountFraction` | `DayCountFractionEnum` | |
| `floatingDayCount` | `payout[float].dayCountFraction` | `DayCountFractionEnum` | |
| `paymentFrequency` | `payout[].paymentDates.paymentFrequency` | `Period` | periodMultiplier + period |
| `resetFrequency` | `payout[float].resetDates.resetFrequency` | `Period` | |
| `businessDayConvention` | `calculationPeriodDatesAdjustments.businessDayConvention` | `BusinessDayConventionEnum` | |
| `businessCenters` | `calculationPeriodDatesAdjustments.businessCenters` | `BusinessCenter[]` | |

## Parties

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `party1.lei` | `trade.party[].partyId[].identifier` + `identifierType: LEI` | `string` | |
| `party1.name` | `trade.party[].name` | `string` | |
| `party2.lei` | `trade.party[].partyId[].identifier` + `identifierType: LEI` | `string` | |
| `party2.name` | `trade.party[].name` | `string` | |

## Reporting metadata (used in Phase 4 — ReportableInformation)

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `executionVenue` | `ReportableInformation.executionVenueType` | `ExecutionVenueTypeEnum` | XXXX→OFF_FACILITY, MIC→ON_VENUE |
| `confirmationMethod` | `ReportableInformation.confirmationMethod` | `ConfirmationMethodEnum` | |
| `masterAgreementType` | `trade.contractDetails.documentation[].agreementName.masterAgreementType` | `string` | |
| `clearingStatus` | `ReportableInformation.mandatorilyClearable` | `MandatorilyClearableEnum` | Mapping depends on regime |

## Option fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `optionType` | `OptionPayout.optionType` | `OptionTypeEnum` | CALL / PUT |
| `optionExpiryDate` | `OptionPayout.exerciseTerms.*.expirationDate` | `AdjustableDate` | |
| `optionExerciseStyle` | `OptionPayout.exerciseTerms` | `europeanExercise` / `americanExercise` / `bermudanExercise` | Determines which sub-type |
| `strikeRate` | `OptionPayout.strike` or `tradeLot.priceQuantity.price` | `number` | |
| `premium` | `tradeLot.priceQuantity.price` with `priceType: PremiumSpread` | `number` | |
| `premiumCurrency` | `tradeLot.priceQuantity.price.unit.currency` | `string` | |
| `settlementType` | `OptionPayout.settlementTerms.settlementType` | `SettlementTypeEnum` | PHYSICAL / CASH |

## FX fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `fxRate` | `tradeLot.priceQuantity.price.value` with `priceType: ExchangeRate` | `number` | |
| `fxFarDate` | second `SettlementPayout.settlementTerms.settlementDate` | `AdjustableDate` | FX swap far leg |
| `fxFarRate` | second `SettlementPayout` price | `number` | |

## Cap/floor fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `capRate` | `InterestRatePayout.rateSpecification.capRateSchedule` | `number` | |
| `floorRate` | `InterestRatePayout.rateSpecification.floorRateSchedule` | `number` | |

## Inflation fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `inflationIndex` | `InflationRateSpecification.inflationIndex` | `string` | |
| `inflationInterpolation` | `InflationRateSpecification.interpolationMethod` | `InterpolationMethodEnum` | |

## Lifecycle fields

| Internal field | CDM path | CDM type | Notes |
|---|---|---|---|
| `cancelableFrom` | `EconomicTerms.terminationProvision.cancelableProvision.americanExercise.commencementDate` | `AdjustableDate` | |
| `novationNewParty` | `SplitInstruction.breakdown[].partyChange.counterparty.partyReference` | `Party` | Stepping-in party |
| `priorTradeId` | `Instruction.before.trade.tradeIdentifier` | `TradeIdentifier` | Links to the trade being amended/novated |
| `feeAmount` | `SettlementPayout.settlementTerms.settlementAmount` or transfer | `number` | |
| `feeCurrency` | `SettlementPayout.settlementTerms.settlementAmount.unit.currency` | `string` | |
