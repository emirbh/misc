package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.TradeData42__1;
import iso20022.auth030.fca.TradeData42__2;
import iso20022.auth030.fca.TradeData42__3;
import iso20022.auth030.fca.TradeData42__4;
import iso20022.auth030.fca.TradeData42__5;
import iso20022.auth030.fca.TradeData42__6;
import iso20022.auth030.fca.TradeData42__7;
import iso20022.auth030.fca.TradeData42__8;
import iso20022.auth030.fca.TradeReport32Choice__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeReport32Choice__1Validator implements Validator<TradeReport32Choice__1> {

	private List<ComparisonResult> getComparisonResults(TradeReport32Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("new", (TradeData42__1) o.getNew() != null ? 1 : 0, 0, 1), 
				checkCardinality("mod", (TradeData42__2) o.getMod() != null ? 1 : 0, 0, 1), 
				checkCardinality("crrctn", (TradeData42__3) o.getCrrctn() != null ? 1 : 0, 0, 1), 
				checkCardinality("termntn", (TradeData42__4) o.getTermntn() != null ? 1 : 0, 0, 1), 
				checkCardinality("posCmpnt", (TradeData42__5) o.getPosCmpnt() != null ? 1 : 0, 0, 1), 
				checkCardinality("valtnUpd", (TradeData42__6) o.getValtnUpd() != null ? 1 : 0, 0, 1), 
				checkCardinality("err", (TradeData42__7) o.getErr() != null ? 1 : 0, 0, 1), 
				checkCardinality("rvv", (TradeData42__8) o.getRvv() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeReport32Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeReport32Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport32Choice__1", path, "", res.getError());
				}
				return success("TradeReport32Choice__1", ValidationResult.ValidationType.CARDINALITY, "TradeReport32Choice__1", path, "");
			})
			.collect(toList());
	}

}
