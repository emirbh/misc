package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.DerivativesTradeReportV04;
import iso20022.auth030.asic.TradeData59Choice__1;
import iso20022.auth030.asic.TradeReportHeader4__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativesTradeReportV04Validator implements Validator<DerivativesTradeReportV04> {

	private List<ComparisonResult> getComparisonResults(DerivativesTradeReportV04 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rptHdr", (TradeReportHeader4__1) o.getRptHdr() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradData", (TradeData59Choice__1) o.getTradData() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativesTradeReportV04 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativesTradeReportV04", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeReportV04", path, "", res.getError());
				}
				return success("DerivativesTradeReportV04", ValidationResult.ValidationType.CARDINALITY, "DerivativesTradeReportV04", path, "");
			})
			.collect(toList());
	}

}
