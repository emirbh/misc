package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.FirstPeriodStartDate;
import fpml.consolidated.doc.validation.FirstPeriodStartDateTypeFormatValidator;
import fpml.consolidated.doc.validation.FirstPeriodStartDateValidator;
import fpml.consolidated.doc.validation.exists.FirstPeriodStartDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FirstPeriodStartDate.class)
public class FirstPeriodStartDateMeta implements RosettaMetaData<FirstPeriodStartDate> {

	@Override
	public List<Validator<? super FirstPeriodStartDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FirstPeriodStartDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FirstPeriodStartDate> validator(ValidatorFactory factory) {
		return factory.<FirstPeriodStartDate>create(FirstPeriodStartDateValidator.class);
	}

	@Override
	public Validator<? super FirstPeriodStartDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FirstPeriodStartDate>create(FirstPeriodStartDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FirstPeriodStartDate> validator() {
		return new FirstPeriodStartDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FirstPeriodStartDate> typeFormatValidator() {
		return new FirstPeriodStartDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FirstPeriodStartDate, Set<String>> onlyExistsValidator() {
		return new FirstPeriodStartDateOnlyExistsValidator();
	}
}
