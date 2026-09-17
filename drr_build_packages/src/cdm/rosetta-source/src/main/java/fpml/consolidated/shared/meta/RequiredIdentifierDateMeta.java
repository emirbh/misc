package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.RequiredIdentifierDate;
import fpml.consolidated.shared.validation.RequiredIdentifierDateTypeFormatValidator;
import fpml.consolidated.shared.validation.RequiredIdentifierDateValidator;
import fpml.consolidated.shared.validation.exists.RequiredIdentifierDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequiredIdentifierDate.class)
public class RequiredIdentifierDateMeta implements RosettaMetaData<RequiredIdentifierDate> {

	@Override
	public List<Validator<? super RequiredIdentifierDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequiredIdentifierDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequiredIdentifierDate> validator(ValidatorFactory factory) {
		return factory.<RequiredIdentifierDate>create(RequiredIdentifierDateValidator.class);
	}

	@Override
	public Validator<? super RequiredIdentifierDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequiredIdentifierDate>create(RequiredIdentifierDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequiredIdentifierDate> validator() {
		return new RequiredIdentifierDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequiredIdentifierDate> typeFormatValidator() {
		return new RequiredIdentifierDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequiredIdentifierDate, Set<String>> onlyExistsValidator() {
		return new RequiredIdentifierDateOnlyExistsValidator();
	}
}
