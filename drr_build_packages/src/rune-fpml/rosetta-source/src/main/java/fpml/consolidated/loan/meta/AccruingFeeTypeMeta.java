package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingFeeType;
import fpml.consolidated.loan.validation.AccruingFeeTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingFeeTypeValidator;
import fpml.consolidated.loan.validation.exists.AccruingFeeTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingFeeType.class)
public class AccruingFeeTypeMeta implements RosettaMetaData<AccruingFeeType> {

	@Override
	public List<Validator<? super AccruingFeeType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingFeeType> validator(ValidatorFactory factory) {
		return factory.<AccruingFeeType>create(AccruingFeeTypeValidator.class);
	}

	@Override
	public Validator<? super AccruingFeeType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingFeeType>create(AccruingFeeTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeType> validator() {
		return new AccruingFeeTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingFeeType> typeFormatValidator() {
		return new AccruingFeeTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeType, Set<String>> onlyExistsValidator() {
		return new AccruingFeeTypeOnlyExistsValidator();
	}
}
