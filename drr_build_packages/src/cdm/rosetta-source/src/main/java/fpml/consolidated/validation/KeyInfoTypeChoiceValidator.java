package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.KeyInfoTypeChoice;
import fpml.consolidated.KeyValueType;
import fpml.consolidated.PGPDataType;
import fpml.consolidated.RetrievalMethodType;
import fpml.consolidated.SPKIDataType;
import fpml.consolidated.X509DataType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class KeyInfoTypeChoiceValidator implements Validator<KeyInfoTypeChoice> {

	private List<ComparisonResult> getComparisonResults(KeyInfoTypeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("keyName", (String) o.getKeyName() != null ? 1 : 0, 0, 1), 
				checkCardinality("keyValue", (KeyValueType) o.getKeyValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("retrievalMethod", (RetrievalMethodType) o.getRetrievalMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("x509Data", (X509DataType) o.getX509Data() != null ? 1 : 0, 0, 1), 
				checkCardinality("pgpData", (PGPDataType) o.getPgpData() != null ? 1 : 0, 0, 1), 
				checkCardinality("spkiData", (SPKIDataType) o.getSpkiData() != null ? 1 : 0, 0, 1), 
				checkCardinality("mgmtData", (String) o.getMgmtData() != null ? 1 : 0, 0, 1), 
				checkCardinality("anyContents", (String) o.getAnyContents() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, KeyInfoTypeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("KeyInfoTypeChoice", ValidationResult.ValidationType.CARDINALITY, "KeyInfoTypeChoice", path, "", res.getError());
				}
				return success("KeyInfoTypeChoice", ValidationResult.ValidationType.CARDINALITY, "KeyInfoTypeChoice", path, "");
			})
			.collect(toList());
	}

}
