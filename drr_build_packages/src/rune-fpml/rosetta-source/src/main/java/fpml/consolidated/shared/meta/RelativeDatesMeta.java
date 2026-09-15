package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.RelativeDates;
import fpml.consolidated.shared.validation.RelativeDatesTypeFormatValidator;
import fpml.consolidated.shared.validation.RelativeDatesValidator;
import fpml.consolidated.shared.validation.datarule.RelativeDateOffsetChoice;
import fpml.consolidated.shared.validation.exists.RelativeDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelativeDates.class)
public class RelativeDatesMeta implements RosettaMetaData<RelativeDates> {

	@Override
	public List<Validator<? super RelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RelativeDateOffset>create(RelativeDateOffsetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativeDates> validator(ValidatorFactory factory) {
		return factory.<RelativeDates>create(RelativeDatesValidator.class);
	}

	@Override
	public Validator<? super RelativeDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativeDates>create(RelativeDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDates> validator() {
		return new RelativeDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativeDates> typeFormatValidator() {
		return new RelativeDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDates, Set<String>> onlyExistsValidator() {
		return new RelativeDatesOnlyExistsValidator();
	}
}
