package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.DateRange;
import fpml.consolidated.shared.validation.DateRangeTypeFormatValidator;
import fpml.consolidated.shared.validation.DateRangeValidator;
import fpml.consolidated.shared.validation.exists.DateRangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DateRange.class)
public class DateRangeMeta implements RosettaMetaData<DateRange> {

	@Override
	public List<Validator<? super DateRange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateRange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateRange> validator(ValidatorFactory factory) {
		return factory.<DateRange>create(DateRangeValidator.class);
	}

	@Override
	public Validator<? super DateRange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DateRange>create(DateRangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DateRange> validator() {
		return new DateRangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DateRange> typeFormatValidator() {
		return new DateRangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateRange, Set<String>> onlyExistsValidator() {
		return new DateRangeOnlyExistsValidator();
	}
}
