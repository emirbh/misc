package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.DateOffset;
import fpml.consolidated.shared.validation.DateOffsetTypeFormatValidator;
import fpml.consolidated.shared.validation.DateOffsetValidator;
import fpml.consolidated.shared.validation.exists.DateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DateOffset.class)
public class DateOffsetMeta implements RosettaMetaData<DateOffset> {

	@Override
	public List<Validator<? super DateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DateOffset> validator(ValidatorFactory factory) {
		return factory.<DateOffset>create(DateOffsetValidator.class);
	}

	@Override
	public Validator<? super DateOffset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DateOffset>create(DateOffsetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DateOffset> validator() {
		return new DateOffsetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DateOffset> typeFormatValidator() {
		return new DateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateOffset, Set<String>> onlyExistsValidator() {
		return new DateOffsetOnlyExistsValidator();
	}
}
