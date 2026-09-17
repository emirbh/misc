package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FacilityType;
import fpml.consolidated.asset.validation.FacilityTypeTypeFormatValidator;
import fpml.consolidated.asset.validation.FacilityTypeValidator;
import fpml.consolidated.asset.validation.exists.FacilityTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityType.class)
public class FacilityTypeMeta implements RosettaMetaData<FacilityType> {

	@Override
	public List<Validator<? super FacilityType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityType> validator(ValidatorFactory factory) {
		return factory.<FacilityType>create(FacilityTypeValidator.class);
	}

	@Override
	public Validator<? super FacilityType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityType>create(FacilityTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityType> validator() {
		return new FacilityTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityType> typeFormatValidator() {
		return new FacilityTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityType, Set<String>> onlyExistsValidator() {
		return new FacilityTypeOnlyExistsValidator();
	}
}
