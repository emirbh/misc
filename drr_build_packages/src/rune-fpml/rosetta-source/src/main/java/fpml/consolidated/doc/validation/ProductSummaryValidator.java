package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.ProductSummary;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CreditSeniority;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ProductSummaryValidator implements Validator<ProductSummary> {

	private List<ComparisonResult> getComparisonResults(ProductSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("finalSettlementDate", (ZonedDateTime) o.getFinalSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementType", (SettlementTypeEnum) o.getSettlementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementLocation", (BusinessCenter) o.getSettlementLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (CreditSeniority) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("admissionToTrading", (AdmissionToTrading) o.getAdmissionToTrading() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProductSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProductSummary", ValidationResult.ValidationType.CARDINALITY, "ProductSummary", path, "", res.getError());
				}
				return success("ProductSummary", ValidationResult.ValidationType.CARDINALITY, "ProductSummary", path, "");
			})
			.collect(toList());
	}

}
