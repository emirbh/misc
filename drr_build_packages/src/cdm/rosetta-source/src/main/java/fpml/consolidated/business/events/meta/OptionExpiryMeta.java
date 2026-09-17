package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.business.events.validation.OptionExpiryTypeFormatValidator;
import fpml.consolidated.business.events.validation.OptionExpiryValidator;
import fpml.consolidated.business.events.validation.datarule.OptionExpiryChoice;
import fpml.consolidated.business.events.validation.exists.OptionExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionExpiry.class)
public class OptionExpiryMeta implements RosettaMetaData<OptionExpiry> {

	@Override
	public List<Validator<? super OptionExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<OptionExpiry>create(OptionExpiryChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionExpiry> validator(ValidatorFactory factory) {
		return factory.<OptionExpiry>create(OptionExpiryValidator.class);
	}

	@Override
	public Validator<? super OptionExpiry> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionExpiry>create(OptionExpiryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionExpiry> validator() {
		return new OptionExpiryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionExpiry> typeFormatValidator() {
		return new OptionExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExpiry, Set<String>> onlyExistsValidator() {
		return new OptionExpiryOnlyExistsValidator();
	}
}
