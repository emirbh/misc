package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductCreditDetails;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductCreditDetailsValidator implements Validator<RegulatoryReportingProductCreditDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductCreditDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("attachmentPoint", (BigDecimal) o.getAttachmentPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("exhaustionPoint", (BigDecimal) o.getExhaustionPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexSeries", (Integer) o.getIndexSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexAnnexVersion", (Integer) o.getIndexAnnexVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedRecoveryFinalPrice", (BigDecimal) o.getFixedRecoveryFinalPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductCreditDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductCreditDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductCreditDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingProductCreditDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductCreditDetails", path, "");
			})
			.collect(toList());
	}

}
