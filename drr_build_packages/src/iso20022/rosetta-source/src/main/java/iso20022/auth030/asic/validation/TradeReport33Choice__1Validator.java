package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.TradeData43__1;
import iso20022.auth030.asic.TradeData43__2;
import iso20022.auth030.asic.TradeData43__3;
import iso20022.auth030.asic.TradeData43__4;
import iso20022.auth030.asic.TradeData43__5;
import iso20022.auth030.asic.TradeData43__6;
import iso20022.auth030.asic.TradeData43__7;
import iso20022.auth030.asic.TradeReport33Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport33Choice__1Validator implements Validator<TradeReport33Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeReport33Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("new", (TradeData43__1) o.getNew() != null ? 1 : 0, 0, 1), 
				checkCardinality("mod", (TradeData43__2) o.getMod() != null ? 1 : 0, 0, 1), 
				checkCardinality("crrctn", (TradeData43__3) o.getCrrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("termntn", (TradeData43__4) o.getTermntn() != null ? 1 : 0, 0, 1), 
				checkCardinality("valtnUpd", (TradeData43__5) o.getValtnUpd() != null ? 1 : 0, 0, 1), 
				checkCardinality("err", (TradeData43__6) o.getErr() != null ? 1 : 0, 0, 1), 
				checkCardinality("portOut", (TradeData43__7) o.getPortOut() != null ? 1 : 0, 0, 1), 
				checkCardinality("rvv", (TradeData43__3) o.getRvv() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport33Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport33Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport33Choice__1", path, "", res.getError());
				}
				return success("TradeReport33Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport33Choice__1", path, "");
			})
			.collect(toList());
	}

}
