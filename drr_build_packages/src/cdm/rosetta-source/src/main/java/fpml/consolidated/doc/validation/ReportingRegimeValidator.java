package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.CurrencyPairClassification;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.FacilityExecutionExceptionDeclaration;
import fpml.consolidated.doc.NotionalReportingType;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.ReportingBoolean;
import fpml.consolidated.doc.ReportingRegime;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.ReportingRegimeName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeValidator implements Validator<ReportingRegime> {

	private List<ComparisonResult> getComparisonResults(ReportingRegime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (ReportingRegimeName) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingRole", (ReportingRole) o.getReportingRole() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatorilyClearable", (ReportingBoolean) o.getMandatorilyClearable() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryFacilityExecution", (Boolean) o.getMandatoryFacilityExecution() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryFacilityExecutionException", (Boolean) o.getMandatoryFacilityExecutionException() != null ? 1 : 0, 0, 1), 
				checkCardinality("mandatoryFacilityExecutionExceptionDeclaration", (FacilityExecutionExceptionDeclaration) o.getMandatoryFacilityExecutionExceptionDeclaration() != null ? 1 : 0, 0, 1), 
				checkCardinality("exceedsClearingThreshold", (Boolean) o.getExceedsClearingThreshold() != null ? 1 : 0, 0, 1), 
				checkCardinality("entityClassification", (EntityClassification) o.getEntityClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradePartyRelationshipType", (PartyRelationshipType) o.getTradePartyRelationshipType() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionType) o.getActionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("preEnactmentTrade", (Boolean) o.getPreEnactmentTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalType", (NotionalReportingType) o.getNotionalType() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyPairClassification", (CurrencyPairClassification) o.getCurrencyPairClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("transmissionOfOrder", (Boolean) o.getTransmissionOfOrder() != null ? 1 : 0, 0, 1), 
				checkCardinality("postPricedIndicator", (Boolean) o.getPostPricedIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("directlyLinkedActivity", (Boolean) o.getDirectlyLinkedActivity() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserException", (Boolean) o.getEndUserException() != null ? 1 : 0, 0, 1), 
				checkCardinality("endUserExceptionDeclaration", (EndUserExceptionDeclaration) o.getEndUserExceptionDeclaration() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegime", ValidationResult.ValidationType.CARDINALITY, "ReportingRegime", path, "", res.getError());
				}
				return success("ReportingRegime", ValidationResult.ValidationType.CARDINALITY, "ReportingRegime", path, "");
			})
			.collect(toList());
	}

}
