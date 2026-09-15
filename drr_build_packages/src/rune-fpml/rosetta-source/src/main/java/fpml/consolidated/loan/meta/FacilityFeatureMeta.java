package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityFeature;
import fpml.consolidated.loan.validation.FacilityFeatureTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityFeatureValidator;
import fpml.consolidated.loan.validation.exists.FacilityFeatureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityFeature.class)
public class FacilityFeatureMeta implements RosettaMetaData<FacilityFeature> {

	@Override
	public List<Validator<? super FacilityFeature>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityFeature, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityFeature> validator(ValidatorFactory factory) {
		return factory.<FacilityFeature>create(FacilityFeatureValidator.class);
	}

	@Override
	public Validator<? super FacilityFeature> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityFeature>create(FacilityFeatureTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityFeature> validator() {
		return new FacilityFeatureValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityFeature> typeFormatValidator() {
		return new FacilityFeatureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityFeature, Set<String>> onlyExistsValidator() {
		return new FacilityFeatureOnlyExistsValidator();
	}
}
