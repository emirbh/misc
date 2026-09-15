package fpml.consolidated.reg.fpmlreporting.product.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductSettlementDetails;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class RegulatoryReportingProductSettlementDetailsValidator implements Validator<RegulatoryReportingProductSettlementDetails> {

	private List<ComparisonResult> getComparisonResults(RegulatoryReportingProductSettlementDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementMethod", (SettlementTypeEnum) o.getSettlementMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementCurrency", (Currency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementLocation", (BusinessCenter) o.getSettlementLocation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryReportingProductSettlementDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RegulatoryReportingProductSettlementDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductSettlementDetails", path, "", res.getError());
				}
				return success("RegulatoryReportingProductSettlementDetails", ValidationResult.ValidationType.CARDINALITY, "RegulatoryReportingProductSettlementDetails", path, "");
			})
			.collect(toList());
	}

}
