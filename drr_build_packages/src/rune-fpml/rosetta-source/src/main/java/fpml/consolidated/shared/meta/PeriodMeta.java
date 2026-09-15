package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.validation.PeriodTypeFormatValidator;
import fpml.consolidated.shared.validation.PeriodValidator;
import fpml.consolidated.shared.validation.exists.PeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Period.class)
public class PeriodMeta implements RosettaMetaData<Period> {

	@Override
	public List<Validator<? super Period>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Period, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Period> validator(ValidatorFactory factory) {
		return factory.<Period>create(PeriodValidator.class);
	}

	@Override
	public Validator<? super Period> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Period>create(PeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Period> validator() {
		return new PeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Period> typeFormatValidator() {
		return new PeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Period, Set<String>> onlyExistsValidator() {
		return new PeriodOnlyExistsValidator();
	}
}
