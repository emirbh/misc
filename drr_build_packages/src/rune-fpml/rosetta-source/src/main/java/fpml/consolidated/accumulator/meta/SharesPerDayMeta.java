package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.SharesPerDay;
import fpml.consolidated.accumulator.validation.SharesPerDayTypeFormatValidator;
import fpml.consolidated.accumulator.validation.SharesPerDayValidator;
import fpml.consolidated.accumulator.validation.exists.SharesPerDayOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SharesPerDay.class)
public class SharesPerDayMeta implements RosettaMetaData<SharesPerDay> {

	@Override
	public List<Validator<? super SharesPerDay>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SharesPerDay, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SharesPerDay> validator(ValidatorFactory factory) {
		return factory.<SharesPerDay>create(SharesPerDayValidator.class);
	}

	@Override
	public Validator<? super SharesPerDay> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SharesPerDay>create(SharesPerDayTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SharesPerDay> validator() {
		return new SharesPerDayValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SharesPerDay> typeFormatValidator() {
		return new SharesPerDayTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SharesPerDay, Set<String>> onlyExistsValidator() {
		return new SharesPerDayOnlyExistsValidator();
	}
}
