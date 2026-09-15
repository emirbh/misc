package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.ContractType14__1;
import iso20022.auth030.esma.CurrencyExchange23__1;
import iso20022.auth030.esma.FinancialInstrumentContractType2Code;
import iso20022.auth030.esma.ProductType4Code__1;
import iso20022.auth030.esma.SecurityIdentification41Choice__1;
import iso20022.auth030.esma.SecurityIdentification46__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ContractType14__1Validator implements Validator<ContractType14__1> {

	private List<ComparisonResult> getComparisonResults(ContractType14__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ctrctTp", (FinancialInstrumentContractType2Code) o.getCtrctTp() != null ? 1 : 0, 1, 1), 
				checkCardinality("asstClss", (ProductType4Code__1) o.getAsstClss() != null ? 1 : 0, 1, 1), 
				checkCardinality("pdctClssfctn", (String) o.getPdctClssfctn() != null ? 1 : 0, 1, 1), 
				checkCardinality("pdctId", (SecurityIdentification46__1) o.getPdctId() != null ? 1 : 0, 0, 1), 
				checkCardinality("undrlygInstrm", (SecurityIdentification41Choice__1) o.getUndrlygInstrm() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmCcy", (CurrencyExchange23__1) o.getSttlmCcy() != null ? 1 : 0, 0, 1), 
				checkCardinality("sttlmCcyScndLeg", (CurrencyExchange23__1) o.getSttlmCcyScndLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivBasedOnCrptAsst", (Boolean) o.getDerivBasedOnCrptAsst() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ContractType14__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ContractType14__1", ValidationResult.ValidationType.CARDINALITY, "ContractType14__1", path, "", res.getError());
				}
				return success("ContractType14__1", ValidationResult.ValidationType.CARDINALITY, "ContractType14__1", path, "");
			})
			.collect(toList());
	}

}
