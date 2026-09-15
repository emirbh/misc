package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.GenericIdentification175__1;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NonFinancialInstitutionSector10__2Validator implements Validator<NonFinancialInstitutionSector10__2> {

	private List<ComparisonResult> getComparisonResults(NonFinancialInstitutionSector10__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("sctr", (List<? extends GenericIdentification175__1>) o.getSctr() == null ? 0 : o.getSctr().size(), 1, 0), 
				checkCardinality("clrThrshld", (Boolean) o.getClrThrshld() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonFinancialInstitutionSector10__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonFinancialInstitutionSector10__2", ValidationResult.ValidationType.CARDINALITY, "NonFinancialInstitutionSector10__2", path, "", res.getError());
				}
				return success("NonFinancialInstitutionSector10__2", ValidationResult.ValidationType.CARDINALITY, "NonFinancialInstitutionSector10__2", path, "");
			})
			.collect(toList());
	}

}
