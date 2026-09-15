package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.NonPeriodicFixedPriceLeg;
import fpml.consolidated.com.validation.NonPeriodicFixedPriceLegTypeFormatValidator;
import fpml.consolidated.com.validation.NonPeriodicFixedPriceLegValidator;
import fpml.consolidated.com.validation.datarule.NonPeriodicFixedPriceLegChoice;
import fpml.consolidated.com.validation.exists.NonPeriodicFixedPriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NonPeriodicFixedPriceLeg.class)
public class NonPeriodicFixedPriceLegMeta implements RosettaMetaData<NonPeriodicFixedPriceLeg> {

	@Override
	public List<Validator<? super NonPeriodicFixedPriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<NonPeriodicFixedPriceLeg>create(NonPeriodicFixedPriceLegChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NonPeriodicFixedPriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> validator(ValidatorFactory factory) {
		return factory.<NonPeriodicFixedPriceLeg>create(NonPeriodicFixedPriceLegValidator.class);
	}

	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NonPeriodicFixedPriceLeg>create(NonPeriodicFixedPriceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> validator() {
		return new NonPeriodicFixedPriceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NonPeriodicFixedPriceLeg> typeFormatValidator() {
		return new NonPeriodicFixedPriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonPeriodicFixedPriceLeg, Set<String>> onlyExistsValidator() {
		return new NonPeriodicFixedPriceLegOnlyExistsValidator();
	}
}
