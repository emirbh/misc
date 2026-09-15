package drr.regulation.csa.rewrite.valuation.validation.exists;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.csa.rewrite.dtcc.valuation.DTCCAdditionalValuationFields;
import drr.regulation.csa.rewrite.valuation.CSAValuationReport;
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

public class CSAValuationReportOnlyExistsValidator implements ValidatorWithArg<CSAValuationReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CSAValuationReport> ValidationResult<CSAValuationReport> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("dtccValuationFields", ExistenceChecker.isSet((DTCCAdditionalValuationFields) o.getDtccValuationFields()))
				.put("uniqueProductIdentifier", ExistenceChecker.isSet((String) o.getUniqueProductIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CSAValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "CSAValuationReport", path, "");
		}
		return failure("CSAValuationReport", ValidationResult.ValidationType.ONLY_EXISTS, "CSAValuationReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
