package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Mortgage;
import fpml.consolidated.asset.validation.MortgageTypeFormatValidator;
import fpml.consolidated.asset.validation.MortgageValidator;
import fpml.consolidated.asset.validation.datarule.MortgageChoice0;
import fpml.consolidated.asset.validation.datarule.MortgageChoice1;
import fpml.consolidated.asset.validation.exists.MortgageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Mortgage.class)
public class MortgageMeta implements RosettaMetaData<Mortgage> {

	@Override
	public List<Validator<? super Mortgage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Mortgage>create(MortgageChoice0.class),
			factory.<Mortgage>create(MortgageChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super Mortgage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Mortgage> validator(ValidatorFactory factory) {
		return factory.<Mortgage>create(MortgageValidator.class);
	}

	@Override
	public Validator<? super Mortgage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Mortgage>create(MortgageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Mortgage> validator() {
		return new MortgageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Mortgage> typeFormatValidator() {
		return new MortgageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Mortgage, Set<String>> onlyExistsValidator() {
		return new MortgageOnlyExistsValidator();
	}
}
