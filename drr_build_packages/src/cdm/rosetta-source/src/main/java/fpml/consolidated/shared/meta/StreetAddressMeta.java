package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.StreetAddress;
import fpml.consolidated.shared.validation.StreetAddressTypeFormatValidator;
import fpml.consolidated.shared.validation.StreetAddressValidator;
import fpml.consolidated.shared.validation.exists.StreetAddressOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=StreetAddress.class)
public class StreetAddressMeta implements RosettaMetaData<StreetAddress> {

	@Override
	public List<Validator<? super StreetAddress>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StreetAddress, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StreetAddress> validator(ValidatorFactory factory) {
		return factory.<StreetAddress>create(StreetAddressValidator.class);
	}

	@Override
	public Validator<? super StreetAddress> typeFormatValidator(ValidatorFactory factory) {
		return factory.<StreetAddress>create(StreetAddressTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super StreetAddress> validator() {
		return new StreetAddressValidator();
	}

	@Deprecated
	@Override
	public Validator<? super StreetAddress> typeFormatValidator() {
		return new StreetAddressTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StreetAddress, Set<String>> onlyExistsValidator() {
		return new StreetAddressOnlyExistsValidator();
	}
}
