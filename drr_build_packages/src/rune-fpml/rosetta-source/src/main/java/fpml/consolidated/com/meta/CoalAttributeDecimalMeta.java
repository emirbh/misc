package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalAttributeDecimal;
import fpml.consolidated.com.validation.CoalAttributeDecimalTypeFormatValidator;
import fpml.consolidated.com.validation.CoalAttributeDecimalValidator;
import fpml.consolidated.com.validation.exists.CoalAttributeDecimalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalAttributeDecimal.class)
public class CoalAttributeDecimalMeta implements RosettaMetaData<CoalAttributeDecimal> {

	@Override
	public List<Validator<? super CoalAttributeDecimal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributeDecimal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalAttributeDecimal> validator(ValidatorFactory factory) {
		return factory.<CoalAttributeDecimal>create(CoalAttributeDecimalValidator.class);
	}

	@Override
	public Validator<? super CoalAttributeDecimal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalAttributeDecimal>create(CoalAttributeDecimalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalAttributeDecimal> validator() {
		return new CoalAttributeDecimalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalAttributeDecimal> typeFormatValidator() {
		return new CoalAttributeDecimalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributeDecimal, Set<String>> onlyExistsValidator() {
		return new CoalAttributeDecimalOnlyExistsValidator();
	}
}
