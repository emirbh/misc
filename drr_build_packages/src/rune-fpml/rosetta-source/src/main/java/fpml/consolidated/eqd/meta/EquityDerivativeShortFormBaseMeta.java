package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityDerivativeShortFormBase;
import fpml.consolidated.eqd.validation.EquityDerivativeShortFormBaseTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityDerivativeShortFormBaseValidator;
import fpml.consolidated.eqd.validation.exists.EquityDerivativeShortFormBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityDerivativeShortFormBase.class)
public class EquityDerivativeShortFormBaseMeta implements RosettaMetaData<EquityDerivativeShortFormBase> {

	@Override
	public List<Validator<? super EquityDerivativeShortFormBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityDerivativeShortFormBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityDerivativeShortFormBase> validator(ValidatorFactory factory) {
		return factory.<EquityDerivativeShortFormBase>create(EquityDerivativeShortFormBaseValidator.class);
	}

	@Override
	public Validator<? super EquityDerivativeShortFormBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityDerivativeShortFormBase>create(EquityDerivativeShortFormBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityDerivativeShortFormBase> validator() {
		return new EquityDerivativeShortFormBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityDerivativeShortFormBase> typeFormatValidator() {
		return new EquityDerivativeShortFormBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityDerivativeShortFormBase, Set<String>> onlyExistsValidator() {
		return new EquityDerivativeShortFormBaseOnlyExistsValidator();
	}
}
