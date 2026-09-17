package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalAttributePercentage;
import fpml.consolidated.com.validation.CoalAttributePercentageTypeFormatValidator;
import fpml.consolidated.com.validation.CoalAttributePercentageValidator;
import fpml.consolidated.com.validation.exists.CoalAttributePercentageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalAttributePercentage.class)
public class CoalAttributePercentageMeta implements RosettaMetaData<CoalAttributePercentage> {

	@Override
	public List<Validator<? super CoalAttributePercentage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributePercentage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalAttributePercentage> validator(ValidatorFactory factory) {
		return factory.<CoalAttributePercentage>create(CoalAttributePercentageValidator.class);
	}

	@Override
	public Validator<? super CoalAttributePercentage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalAttributePercentage>create(CoalAttributePercentageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalAttributePercentage> validator() {
		return new CoalAttributePercentageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalAttributePercentage> typeFormatValidator() {
		return new CoalAttributePercentageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributePercentage, Set<String>> onlyExistsValidator() {
		return new CoalAttributePercentageOnlyExistsValidator();
	}
}
