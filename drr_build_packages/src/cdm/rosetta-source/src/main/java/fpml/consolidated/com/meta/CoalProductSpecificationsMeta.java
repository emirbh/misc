package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalProductSpecifications;
import fpml.consolidated.com.validation.CoalProductSpecificationsTypeFormatValidator;
import fpml.consolidated.com.validation.CoalProductSpecificationsValidator;
import fpml.consolidated.com.validation.datarule.CoalProductSpecificationsChoice;
import fpml.consolidated.com.validation.exists.CoalProductSpecificationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalProductSpecifications.class)
public class CoalProductSpecificationsMeta implements RosettaMetaData<CoalProductSpecifications> {

	@Override
	public List<Validator<? super CoalProductSpecifications>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CoalProductSpecifications>create(CoalProductSpecificationsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalProductSpecifications, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalProductSpecifications> validator(ValidatorFactory factory) {
		return factory.<CoalProductSpecifications>create(CoalProductSpecificationsValidator.class);
	}

	@Override
	public Validator<? super CoalProductSpecifications> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalProductSpecifications>create(CoalProductSpecificationsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductSpecifications> validator() {
		return new CoalProductSpecificationsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductSpecifications> typeFormatValidator() {
		return new CoalProductSpecificationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalProductSpecifications, Set<String>> onlyExistsValidator() {
		return new CoalProductSpecificationsOnlyExistsValidator();
	}
}
