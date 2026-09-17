package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalProductType;
import fpml.consolidated.com.validation.CoalProductTypeTypeFormatValidator;
import fpml.consolidated.com.validation.CoalProductTypeValidator;
import fpml.consolidated.com.validation.exists.CoalProductTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalProductType.class)
public class CoalProductTypeMeta implements RosettaMetaData<CoalProductType> {

	@Override
	public List<Validator<? super CoalProductType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalProductType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalProductType> validator(ValidatorFactory factory) {
		return factory.<CoalProductType>create(CoalProductTypeValidator.class);
	}

	@Override
	public Validator<? super CoalProductType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalProductType>create(CoalProductTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductType> validator() {
		return new CoalProductTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalProductType> typeFormatValidator() {
		return new CoalProductTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalProductType, Set<String>> onlyExistsValidator() {
		return new CoalProductTypeOnlyExistsValidator();
	}
}
