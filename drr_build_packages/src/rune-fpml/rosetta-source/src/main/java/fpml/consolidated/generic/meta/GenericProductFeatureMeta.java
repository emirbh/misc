package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericProductFeature;
import fpml.consolidated.generic.validation.GenericProductFeatureTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericProductFeatureValidator;
import fpml.consolidated.generic.validation.exists.GenericProductFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericProductFeature.class)
public class GenericProductFeatureMeta implements RosettaMetaData<GenericProductFeature> {

	@Override
	public List<Validator<? super GenericProductFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericProductFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericProductFeature> validator(ValidatorFactory factory) {
		return factory.<GenericProductFeature>create(GenericProductFeatureValidator.class);
	}

	@Override
	public Validator<? super GenericProductFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericProductFeature>create(GenericProductFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericProductFeature> validator() {
		return new GenericProductFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericProductFeature> typeFormatValidator() {
		return new GenericProductFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProductFeature, Set<String>> onlyExistsValidator() {
		return new GenericProductFeatureOnlyExistsValidator();
	}
}
