package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.NonAccruingFeeTypeId;
import fpml.consolidated.loan.validation.NonAccruingFeeTypeIdTypeFormatValidator;
import fpml.consolidated.loan.validation.NonAccruingFeeTypeIdValidator;
import fpml.consolidated.loan.validation.exists.NonAccruingFeeTypeIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonAccruingFeeTypeId.class)
public class NonAccruingFeeTypeIdMeta implements RosettaMetaData<NonAccruingFeeTypeId> {

	@Override
	public List<Validator<? super NonAccruingFeeTypeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonAccruingFeeTypeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonAccruingFeeTypeId> validator(ValidatorFactory factory) {
		return factory.<NonAccruingFeeTypeId>create(NonAccruingFeeTypeIdValidator.class);
	}

	@Override
	public Validator<? super NonAccruingFeeTypeId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonAccruingFeeTypeId>create(NonAccruingFeeTypeIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonAccruingFeeTypeId> validator() {
		return new NonAccruingFeeTypeIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonAccruingFeeTypeId> typeFormatValidator() {
		return new NonAccruingFeeTypeIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonAccruingFeeTypeId, Set<String>> onlyExistsValidator() {
		return new NonAccruingFeeTypeIdOnlyExistsValidator();
	}
}
