package fpml.consolidated.eqd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eqd.EquityDerivativeLongFormBase;
import fpml.consolidated.eqd.validation.EquityDerivativeLongFormBaseTypeFormatValidator;
import fpml.consolidated.eqd.validation.EquityDerivativeLongFormBaseValidator;
import fpml.consolidated.eqd.validation.exists.EquityDerivativeLongFormBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityDerivativeLongFormBase.class)
public class EquityDerivativeLongFormBaseMeta implements RosettaMetaData<EquityDerivativeLongFormBase> {

	@Override
	public List<Validator<? super EquityDerivativeLongFormBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityDerivativeLongFormBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityDerivativeLongFormBase> validator(ValidatorFactory factory) {
		return factory.<EquityDerivativeLongFormBase>create(EquityDerivativeLongFormBaseValidator.class);
	}

	@Override
	public Validator<? super EquityDerivativeLongFormBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityDerivativeLongFormBase>create(EquityDerivativeLongFormBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityDerivativeLongFormBase> validator() {
		return new EquityDerivativeLongFormBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityDerivativeLongFormBase> typeFormatValidator() {
		return new EquityDerivativeLongFormBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityDerivativeLongFormBase, Set<String>> onlyExistsValidator() {
		return new EquityDerivativeLongFormBaseOnlyExistsValidator();
	}
}
