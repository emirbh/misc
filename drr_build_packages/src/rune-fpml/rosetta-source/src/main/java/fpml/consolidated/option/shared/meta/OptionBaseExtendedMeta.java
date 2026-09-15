package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.OptionBaseExtended;
import fpml.consolidated.option.shared.validation.OptionBaseExtendedTypeFormatValidator;
import fpml.consolidated.option.shared.validation.OptionBaseExtendedValidator;
import fpml.consolidated.option.shared.validation.datarule.OptionBaseExtendedChoice0;
import fpml.consolidated.option.shared.validation.datarule.OptionBaseExtendedChoice1;
import fpml.consolidated.option.shared.validation.exists.OptionBaseExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionBaseExtended.class)
public class OptionBaseExtendedMeta implements RosettaMetaData<OptionBaseExtended> {

	@Override
	public List<Validator<? super OptionBaseExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice0.class),
			factory.<OptionBaseExtended>create(OptionBaseExtendedChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super OptionBaseExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionBaseExtended> validator(ValidatorFactory factory) {
		return factory.<OptionBaseExtended>create(OptionBaseExtendedValidator.class);
	}

	@Override
	public Validator<? super OptionBaseExtended> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionBaseExtended>create(OptionBaseExtendedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionBaseExtended> validator() {
		return new OptionBaseExtendedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionBaseExtended> typeFormatValidator() {
		return new OptionBaseExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionBaseExtended, Set<String>> onlyExistsValidator() {
		return new OptionBaseExtendedOnlyExistsValidator();
	}
}
