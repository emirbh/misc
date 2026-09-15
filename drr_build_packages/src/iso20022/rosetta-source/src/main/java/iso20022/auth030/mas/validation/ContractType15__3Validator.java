package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.ContractType15__3;
import iso20022.auth030.mas.FinancialInstrumentContractType2Code;
import iso20022.auth030.mas.ProductType4Code__1;
import iso20022.auth030.mas.SecurityIdentification46__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractType15__3Validator implements Validator<ContractType15__3> {

	private List<ComparisonResult> getComparisonResults(ContractType15__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctTp", (FinancialInstrumentContractType2Code) o.getCtrctTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("asstClss", (ProductType4Code__1) o.getAsstClss() != null ? 1 : 0, 1, 1), 
				checkCardinality("pdctId", (SecurityIdentification46__3) o.getPdctId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractType15__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractType15__3", ValidationResult.ValidationType.CARDINALITY, "ContractType15__3", path, "", res.getError());
				}
				return success("ContractType15__3", ValidationResult.ValidationType.CARDINALITY, "ContractType15__3", path, "");
			})
			.collect(toList());
	}

}
