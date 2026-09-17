package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.LoanChoice;
import fpml.consolidated.asset.validation.LoanChoiceTypeFormatValidator;
import fpml.consolidated.asset.validation.LoanChoiceValidator;
import fpml.consolidated.asset.validation.datarule.LoanChoiceChoice;
import fpml.consolidated.asset.validation.exists.LoanChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanChoice.class)
public class LoanChoiceMeta implements RosettaMetaData<LoanChoice> {

	@Override
	public List<Validator<? super LoanChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanChoice>create(LoanChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanChoice> validator(ValidatorFactory factory) {
		return factory.<LoanChoice>create(LoanChoiceValidator.class);
	}

	@Override
	public Validator<? super LoanChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanChoice>create(LoanChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanChoice> validator() {
		return new LoanChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanChoice> typeFormatValidator() {
		return new LoanChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanChoice, Set<String>> onlyExistsValidator() {
		return new LoanChoiceOnlyExistsValidator();
	}
}
