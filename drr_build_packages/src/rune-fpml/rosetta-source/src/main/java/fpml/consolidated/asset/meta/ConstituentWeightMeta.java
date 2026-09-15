package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.asset.validation.ConstituentWeightTypeFormatValidator;
import fpml.consolidated.asset.validation.ConstituentWeightValidator;
import fpml.consolidated.asset.validation.exists.ConstituentWeightOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConstituentWeight.class)
public class ConstituentWeightMeta implements RosettaMetaData<ConstituentWeight> {

	@Override
	public List<Validator<? super ConstituentWeight>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConstituentWeight, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConstituentWeight> validator(ValidatorFactory factory) {
		return factory.<ConstituentWeight>create(ConstituentWeightValidator.class);
	}

	@Override
	public Validator<? super ConstituentWeight> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConstituentWeight>create(ConstituentWeightTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConstituentWeight> validator() {
		return new ConstituentWeightValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConstituentWeight> typeFormatValidator() {
		return new ConstituentWeightTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConstituentWeight, Set<String>> onlyExistsValidator() {
		return new ConstituentWeightOnlyExistsValidator();
	}
}
