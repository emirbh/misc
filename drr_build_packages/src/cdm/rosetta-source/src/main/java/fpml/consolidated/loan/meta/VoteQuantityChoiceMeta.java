package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.VoteQuantityChoice;
import fpml.consolidated.loan.validation.VoteQuantityChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.VoteQuantityChoiceValidator;
import fpml.consolidated.loan.validation.datarule.VoteQuantityChoiceChoice;
import fpml.consolidated.loan.validation.exists.VoteQuantityChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VoteQuantityChoice.class)
public class VoteQuantityChoiceMeta implements RosettaMetaData<VoteQuantityChoice> {

	@Override
	public List<Validator<? super VoteQuantityChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<VoteQuantityChoice>create(VoteQuantityChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VoteQuantityChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VoteQuantityChoice> validator(ValidatorFactory factory) {
		return factory.<VoteQuantityChoice>create(VoteQuantityChoiceValidator.class);
	}

	@Override
	public Validator<? super VoteQuantityChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VoteQuantityChoice>create(VoteQuantityChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VoteQuantityChoice> validator() {
		return new VoteQuantityChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VoteQuantityChoice> typeFormatValidator() {
		return new VoteQuantityChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VoteQuantityChoice, Set<String>> onlyExistsValidator() {
		return new VoteQuantityChoiceOnlyExistsValidator();
	}
}
