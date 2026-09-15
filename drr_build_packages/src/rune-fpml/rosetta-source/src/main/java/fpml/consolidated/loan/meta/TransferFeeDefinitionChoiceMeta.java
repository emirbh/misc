package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TransferFeeDefinitionChoice;
import fpml.consolidated.loan.validation.TransferFeeDefinitionChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.TransferFeeDefinitionChoiceValidator;
import fpml.consolidated.loan.validation.datarule.TransferFeeDefinitionChoiceChoice;
import fpml.consolidated.loan.validation.exists.TransferFeeDefinitionChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TransferFeeDefinitionChoice.class)
public class TransferFeeDefinitionChoiceMeta implements RosettaMetaData<TransferFeeDefinitionChoice> {

	@Override
	public List<Validator<? super TransferFeeDefinitionChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TransferFeeDefinitionChoice>create(TransferFeeDefinitionChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TransferFeeDefinitionChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransferFeeDefinitionChoice> validator(ValidatorFactory factory) {
		return factory.<TransferFeeDefinitionChoice>create(TransferFeeDefinitionChoiceValidator.class);
	}

	@Override
	public Validator<? super TransferFeeDefinitionChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransferFeeDefinitionChoice>create(TransferFeeDefinitionChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransferFeeDefinitionChoice> validator() {
		return new TransferFeeDefinitionChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransferFeeDefinitionChoice> typeFormatValidator() {
		return new TransferFeeDefinitionChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferFeeDefinitionChoice, Set<String>> onlyExistsValidator() {
		return new TransferFeeDefinitionChoiceOnlyExistsValidator();
	}
}
