package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.CreditDefaultSwapChoice;
import fpml.consolidated.cd.validation.CreditDefaultSwapChoiceTypeFormatValidator;
import fpml.consolidated.cd.validation.CreditDefaultSwapChoiceValidator;
import fpml.consolidated.cd.validation.datarule.CreditDefaultSwapChoiceChoice;
import fpml.consolidated.cd.validation.exists.CreditDefaultSwapChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditDefaultSwapChoice.class)
public class CreditDefaultSwapChoiceMeta implements RosettaMetaData<CreditDefaultSwapChoice> {

	@Override
	public List<Validator<? super CreditDefaultSwapChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditDefaultSwapChoice>create(CreditDefaultSwapChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultSwapChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditDefaultSwapChoice> validator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwapChoice>create(CreditDefaultSwapChoiceValidator.class);
	}

	@Override
	public Validator<? super CreditDefaultSwapChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditDefaultSwapChoice>create(CreditDefaultSwapChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwapChoice> validator() {
		return new CreditDefaultSwapChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditDefaultSwapChoice> typeFormatValidator() {
		return new CreditDefaultSwapChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultSwapChoice, Set<String>> onlyExistsValidator() {
		return new CreditDefaultSwapChoiceOnlyExistsValidator();
	}
}
