package iso20022.auth108.iso.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.iso.TradeCounterpartyRelationship1Choice;
import iso20022.auth108.iso.TradeCounterpartyRelationshipRecord1;
import iso20022.auth108.iso.TradeCounterpartyType1Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeCounterpartyRelationshipRecord1Validator implements Validator<TradeCounterpartyRelationshipRecord1> {

	private List<ComparisonResult> getComparisonResults(TradeCounterpartyRelationshipRecord1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("startRltshPty", (TradeCounterpartyType1Code) o.getStartRltshPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("endRltshPty", (TradeCounterpartyType1Code) o.getEndRltshPty() != null ? 1 : 0, 1, 1), 
				checkCardinality("rltshTp", (TradeCounterpartyRelationship1Choice) o.getRltshTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("desc", (String) o.getDesc() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeCounterpartyRelationshipRecord1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyRelationshipRecord1", path, "", res.getError());
				}
				return success("TradeCounterpartyRelationshipRecord1", ValidationResult.ValidationType.CARDINALITY, "TradeCounterpartyRelationshipRecord1", path, "");
			})
			.collect(toList());
	}

}
