package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Equity;
import fpml.consolidated.asset.validation.EquityTypeFormatValidator;
import fpml.consolidated.asset.validation.EquityValidator;
import fpml.consolidated.asset.validation.exists.EquityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Equity.class)
public class EquityMeta implements RosettaMetaData<Equity> {

	@Override
	public List<Validator<? super Equity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Equity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Equity> validator(ValidatorFactory factory) {
		return factory.<Equity>create(EquityValidator.class);
	}

	@Override
	public Validator<? super Equity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Equity>create(EquityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Equity> validator() {
		return new EquityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Equity> typeFormatValidator() {
		return new EquityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Equity, Set<String>> onlyExistsValidator() {
		return new EquityOnlyExistsValidator();
	}
}
