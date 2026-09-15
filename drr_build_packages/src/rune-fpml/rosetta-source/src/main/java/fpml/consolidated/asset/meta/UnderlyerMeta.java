package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.asset.validation.UnderlyerTypeFormatValidator;
import fpml.consolidated.asset.validation.UnderlyerValidator;
import fpml.consolidated.asset.validation.datarule.UnderlyerChoice;
import fpml.consolidated.asset.validation.exists.UnderlyerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Underlyer.class)
public class UnderlyerMeta implements RosettaMetaData<Underlyer> {

	@Override
	public List<Validator<? super Underlyer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Underlyer>create(UnderlyerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Underlyer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Underlyer> validator(ValidatorFactory factory) {
		return factory.<Underlyer>create(UnderlyerValidator.class);
	}

	@Override
	public Validator<? super Underlyer> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Underlyer>create(UnderlyerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Underlyer> validator() {
		return new UnderlyerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Underlyer> typeFormatValidator() {
		return new UnderlyerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Underlyer, Set<String>> onlyExistsValidator() {
		return new UnderlyerOnlyExistsValidator();
	}
}
