package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.validation.DayCountFractionTypeFormatValidator;
import fpml.consolidated.shared.validation.DayCountFractionValidator;
import fpml.consolidated.shared.validation.exists.DayCountFractionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DayCountFraction.class)
public class DayCountFractionMeta implements RosettaMetaData<DayCountFraction> {

	@Override
	public List<Validator<? super DayCountFraction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DayCountFraction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DayCountFraction> validator(ValidatorFactory factory) {
		return factory.<DayCountFraction>create(DayCountFractionValidator.class);
	}

	@Override
	public Validator<? super DayCountFraction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DayCountFraction>create(DayCountFractionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DayCountFraction> validator() {
		return new DayCountFractionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DayCountFraction> typeFormatValidator() {
		return new DayCountFractionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DayCountFraction, Set<String>> onlyExistsValidator() {
		return new DayCountFractionOnlyExistsValidator();
	}
}
