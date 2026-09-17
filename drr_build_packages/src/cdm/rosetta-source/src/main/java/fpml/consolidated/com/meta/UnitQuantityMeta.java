package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.com.validation.UnitQuantityTypeFormatValidator;
import fpml.consolidated.com.validation.UnitQuantityValidator;
import fpml.consolidated.com.validation.exists.UnitQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnitQuantity.class)
public class UnitQuantityMeta implements RosettaMetaData<UnitQuantity> {

	@Override
	public List<Validator<? super UnitQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnitQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnitQuantity> validator(ValidatorFactory factory) {
		return factory.<UnitQuantity>create(UnitQuantityValidator.class);
	}

	@Override
	public Validator<? super UnitQuantity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnitQuantity>create(UnitQuantityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnitQuantity> validator() {
		return new UnitQuantityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnitQuantity> typeFormatValidator() {
		return new UnitQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnitQuantity, Set<String>> onlyExistsValidator() {
		return new UnitQuantityOnlyExistsValidator();
	}
}
