package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.PriceMateriality;
import fpml.consolidated.fx.validation.PriceMaterialityTypeFormatValidator;
import fpml.consolidated.fx.validation.PriceMaterialityValidator;
import fpml.consolidated.fx.validation.exists.PriceMaterialityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PriceMateriality.class)
public class PriceMaterialityMeta implements RosettaMetaData<PriceMateriality> {

	@Override
	public List<Validator<? super PriceMateriality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceMateriality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceMateriality> validator(ValidatorFactory factory) {
		return factory.<PriceMateriality>create(PriceMaterialityValidator.class);
	}

	@Override
	public Validator<? super PriceMateriality> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceMateriality>create(PriceMaterialityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceMateriality> validator() {
		return new PriceMaterialityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceMateriality> typeFormatValidator() {
		return new PriceMaterialityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceMateriality, Set<String>> onlyExistsValidator() {
		return new PriceMaterialityOnlyExistsValidator();
	}
}
