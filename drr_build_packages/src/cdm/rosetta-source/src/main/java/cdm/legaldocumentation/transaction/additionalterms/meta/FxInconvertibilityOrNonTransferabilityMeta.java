package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.FxInconvertibilityOrNonTransferability;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxInconvertibilityOrNonTransferabilityTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.FxInconvertibilityOrNonTransferabilityValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.FxInconvertibilityOrNonTransferabilityOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=FxInconvertibilityOrNonTransferability.class)
public class FxInconvertibilityOrNonTransferabilityMeta implements RosettaMetaData<FxInconvertibilityOrNonTransferability> {

	@Override
	public List<Validator<? super FxInconvertibilityOrNonTransferability>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxInconvertibilityOrNonTransferability, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxInconvertibilityOrNonTransferability> validator(ValidatorFactory factory) {
		return factory.<FxInconvertibilityOrNonTransferability>create(FxInconvertibilityOrNonTransferabilityValidator.class);
	}

	@Override
	public Validator<? super FxInconvertibilityOrNonTransferability> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxInconvertibilityOrNonTransferability>create(FxInconvertibilityOrNonTransferabilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxInconvertibilityOrNonTransferability> validator() {
		return new FxInconvertibilityOrNonTransferabilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxInconvertibilityOrNonTransferability> typeFormatValidator() {
		return new FxInconvertibilityOrNonTransferabilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxInconvertibilityOrNonTransferability, Set<String>> onlyExistsValidator() {
		return new FxInconvertibilityOrNonTransferabilityOnlyExistsValidator();
	}
}
