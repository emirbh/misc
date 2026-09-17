package fpml.consolidated.valuation.fpmlreporting.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.ReportIdentification;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.valuation.fpmlreporting.ReportContents;
import fpml.consolidated.valuation.fpmlreporting.ValuationReportRetracted;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuationReportRetractedValidator implements Validator<ValuationReportRetracted> {

	private List<ComparisonResult> getComparisonResults(ValuationReportRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (NotificationMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("reportIdentification", (ReportIdentification) o.getReportIdentification() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportContents", (ReportContents) o.getReportContents() != null ? 1 : 0, 0, 1), 
				checkCardinality("asOfDate", (IdentifiedDate) o.getAsOfDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationReportRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationReportRetracted", ValidationResult.ValidationType.CARDINALITY, "ValuationReportRetracted", path, "", res.getError());
				}
				return success("ValuationReportRetracted", ValidationResult.ValidationType.CARDINALITY, "ValuationReportRetracted", path, "");
			})
			.collect(toList());
	}

}
