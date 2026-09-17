package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RelativePriceChoice;
import fpml.consolidated.repo.validation.RelativePriceChoiceTypeFormatValidator;
import fpml.consolidated.repo.validation.RelativePriceChoiceValidator;
import fpml.consolidated.repo.validation.datarule.RelativePriceChoiceChoice;
import fpml.consolidated.repo.validation.exists.RelativePriceChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelativePriceChoice.class)
public class RelativePriceChoiceMeta implements RosettaMetaData<RelativePriceChoice> {

	@Override
	public List<Validator<? super RelativePriceChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RelativePriceChoice>create(RelativePriceChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RelativePriceChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativePriceChoice> validator(ValidatorFactory factory) {
		return factory.<RelativePriceChoice>create(RelativePriceChoiceValidator.class);
	}

	@Override
	public Validator<? super RelativePriceChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativePriceChoice>create(RelativePriceChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativePriceChoice> validator() {
		return new RelativePriceChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativePriceChoice> typeFormatValidator() {
		return new RelativePriceChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativePriceChoice, Set<String>> onlyExistsValidator() {
		return new RelativePriceChoiceOnlyExistsValidator();
	}
}
