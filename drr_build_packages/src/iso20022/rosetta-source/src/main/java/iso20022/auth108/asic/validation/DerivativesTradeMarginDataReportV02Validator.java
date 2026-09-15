package iso20022.auth108.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.asic.DerivativesTradeMarginDataReportV02;
import iso20022.auth108.asic.TradeData61Choice__1;
import iso20022.auth108.asic.TradeReportHeader4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativesTradeMarginDataReportV02Validator implements Validator<DerivativesTradeMarginDataReportV02> {

	private List<ComparisonResult> getComparisonResults(DerivativesTradeMarginDataReportV02 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptHdr", (TradeReportHeader4__1) o.getRptHdr() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradData", (TradeData61Choice__1) o.getTradData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativesTradeMarginDataReportV02 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativesTradeMarginDataReportV02", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeMarginDataReportV02", path, "", res.getError());
				}
				return success("DerivativesTradeMarginDataReportV02", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeMarginDataReportV02", path, "");
			})
			.collect(toList());
	}

}
