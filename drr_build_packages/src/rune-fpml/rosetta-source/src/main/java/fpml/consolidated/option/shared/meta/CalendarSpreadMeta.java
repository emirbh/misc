package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.CalendarSpread;
import fpml.consolidated.option.shared.validation.CalendarSpreadTypeFormatValidator;
import fpml.consolidated.option.shared.validation.CalendarSpreadValidator;
import fpml.consolidated.option.shared.validation.exists.CalendarSpreadOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalendarSpread.class)
public class CalendarSpreadMeta implements RosettaMetaData<CalendarSpread> {

	@Override
	public List<Validator<? super CalendarSpread>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalendarSpread, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalendarSpread> validator(ValidatorFactory factory) {
		return factory.<CalendarSpread>create(CalendarSpreadValidator.class);
	}

	@Override
	public Validator<? super CalendarSpread> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalendarSpread>create(CalendarSpreadTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalendarSpread> validator() {
		return new CalendarSpreadValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalendarSpread> typeFormatValidator() {
		return new CalendarSpreadTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalendarSpread, Set<String>> onlyExistsValidator() {
		return new CalendarSpreadOnlyExistsValidator();
	}
}
