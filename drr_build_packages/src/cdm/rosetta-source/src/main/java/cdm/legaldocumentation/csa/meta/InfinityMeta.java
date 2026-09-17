package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.Infinity;
import cdm.legaldocumentation.csa.validation.InfinityTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.InfinityValidator;
import cdm.legaldocumentation.csa.validation.exists.InfinityOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=Infinity.class)
public class InfinityMeta implements RosettaMetaData<Infinity> {

	@Override
	public List<Validator<? super Infinity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Infinity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Infinity> validator(ValidatorFactory factory) {
		return factory.<Infinity>create(InfinityValidator.class);
	}

	@Override
	public Validator<? super Infinity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Infinity>create(InfinityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Infinity> validator() {
		return new InfinityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Infinity> typeFormatValidator() {
		return new InfinityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Infinity, Set<String>> onlyExistsValidator() {
		return new InfinityOnlyExistsValidator();
	}
}
