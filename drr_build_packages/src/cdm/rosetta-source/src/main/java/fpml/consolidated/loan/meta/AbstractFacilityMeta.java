package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacility;
import fpml.consolidated.loan.validation.AbstractFacilityTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFacilityValidator;
import fpml.consolidated.loan.validation.exists.AbstractFacilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFacility.class)
public class AbstractFacilityMeta implements RosettaMetaData<AbstractFacility> {

	@Override
	public List<Validator<? super AbstractFacility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFacility> validator(ValidatorFactory factory) {
		return factory.<AbstractFacility>create(AbstractFacilityValidator.class);
	}

	@Override
	public Validator<? super AbstractFacility> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFacility>create(AbstractFacilityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacility> validator() {
		return new AbstractFacilityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacility> typeFormatValidator() {
		return new AbstractFacilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacility, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityOnlyExistsValidator();
	}
}
