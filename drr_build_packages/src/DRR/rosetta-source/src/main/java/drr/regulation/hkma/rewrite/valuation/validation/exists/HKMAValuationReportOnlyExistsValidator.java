package drr.regulation.hkma.rewrite.valuation.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class HKMAValuationReportOnlyExistsValidator implements ValidatorWithArg<HKMAValuationReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends HKMAValuationReport> ValidationResult<HKMAValuationReport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("counterparty1", ExistenceChecker.isSet((String) o.getCounterparty1()))
				.put("counterparty2IdentifierType", ExistenceChecker.isSet((Boolean) o.getCounterparty2IdentifierType()))
				.put("counterparty2", ExistenceChecker.isSet((String) o.getCounterparty2()))
				.put("valuationAmount", ExistenceChecker.isSet((BigDecimal) o.getValuationAmount()))
				.put("valuationCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getValuationCurrency()))
				.put("valuationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getValuationTimestamp()))
				.put("valuationMethod", ExistenceChecker.isSet((ValuationType1Code) o.getValuationMethod()))
				.put("delta", ExistenceChecker.isSet((BigDecimal) o.getDelta()))
				.put("actionType", ExistenceChecker.isSet((ActionTypeEnum) o.getActionType()))
				.put("level", ExistenceChecker.isSet((ReportLevelEnum) o.getLevel()))
				.put("technicalRecordId", ExistenceChecker.isSet((String) o.getTechnicalRecordId()))
				.put("reportSubmittingEntityID", ExistenceChecker.isSet((String) o.getReportSubmittingEntityID()))
				.put("entityResponsibleForReporting", ExistenceChecker.isSet((String) o.getEntityResponsibleForReporting()))
				.put("counterparty2IdentifierSource", ExistenceChecker.isSet((String) o.getCounterparty2IdentifierSource()))
				.put("nextFloatingReferenceResetDateLeg1", ExistenceChecker.isSet((Date) o.getNextFloatingReferenceResetDateLeg1()))
				.put("nextFloatingReferenceResetDateLeg2", ExistenceChecker.isSet((Date) o.getNextFloatingReferenceResetDateLeg2()))
				.put("uniqueTransactionIdentifier", ExistenceChecker.isSet((String) o.getUniqueTransactionIdentifier()))
				.put("uniqueTransactionIdentifierProprietary", ExistenceChecker.isSet((String) o.getUniqueTransactionIdentifierProprietary()))
				.put("eventDate", ExistenceChecker.isSet((Date) o.getEventDate()))
				.put("variationMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getVariationMarginCollateralPortfolioCode()))
				.put("initialMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getInitialMarginCollateralPortfolioCode()))
				.put("lastFloatingReferenceValueLeg1", ExistenceChecker.isSet((BigDecimal) o.getLastFloatingReferenceValueLeg1()))
				.put("lastFloatingReferenceValueLeg2", ExistenceChecker.isSet((BigDecimal) o.getLastFloatingReferenceValueLeg2()))
				.put("lastFloatingReferenceResetDateLeg1", ExistenceChecker.isSet((Date) o.getLastFloatingReferenceResetDateLeg1()))
				.put("lastFloatingReferenceResetDateLeg2", ExistenceChecker.isSet((Date) o.getLastFloatingReferenceResetDateLeg2()))
				.put("counterparty2Name", ExistenceChecker.isSet((String) o.getCounterparty2Name()))
				.put("submitterIdentifier", ExistenceChecker.isSet((String) o.getSubmitterIdentifier()))
				.put("numberRecords", ExistenceChecker.isSet((BigDecimal) o.getNumberRecords()))
				.put("remarks", ExistenceChecker.isSet((String) o.getRemarks()))
				.put("counterparty2IdentifierFormat", ExistenceChecker.isSet((PartyIdentifierFormat2Enum) o.getCounterparty2IdentifierFormat()))
				.put("counterparty2SchemeName", ExistenceChecker.isSet((HKTRPartyScheme) o.getCounterparty2SchemeName()))
				.put("uniqueTransactionIdentifierProprietarySchemeName", ExistenceChecker.isSet((UTIProprietarySchemeNameEnum) o.getUniqueTransactionIdentifierProprietarySchemeName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("HKMAValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "HKMAValuationReport", path, "");
		}
		return failure("HKMAValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "HKMAValuationReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
