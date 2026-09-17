package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.asset.validation.QuantityUnitTypeFormatValidator;
import fpml.consolidated.asset.validation.QuantityUnitValidator;
import fpml.consolidated.asset.validation.exists.QuantityUnitOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=QuantityUnit.class)
public class QuantityUnitMeta implements RosettaMetaData<QuantityUnit> {

	@Override
	public List<Validator<? super QuantityUnit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityUnit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityUnit> validator(ValidatorFactory factory) {
		return factory.<QuantityUnit>create(QuantityUnitValidator.class);
	}

	@Override
	public Validator<? super QuantityUnit> typeFormatValidator(ValidatorFactory factory) {
		return factory.<QuantityUnit>create(QuantityUnitTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super QuantityUnit> validator() {
		return new QuantityUnitValidator();
	}

	@Deprecated
	@Override
	public Validator<? super QuantityUnit> typeFormatValidator() {
		return new QuantityUnitTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityUnit, Set<String>> onlyExistsValidator() {
		return new QuantityUnitOnlyExistsValidator();
	}
}
