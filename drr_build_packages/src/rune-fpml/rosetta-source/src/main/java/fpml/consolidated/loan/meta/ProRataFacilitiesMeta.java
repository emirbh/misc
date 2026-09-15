package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ProRataFacilities;
import fpml.consolidated.loan.validation.ProRataFacilitiesTypeFormatValidator;
import fpml.consolidated.loan.validation.ProRataFacilitiesValidator;
import fpml.consolidated.loan.validation.exists.ProRataFacilitiesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProRataFacilities.class)
public class ProRataFacilitiesMeta implements RosettaMetaData<ProRataFacilities> {

	@Override
	public List<Validator<? super ProRataFacilities>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProRataFacilities, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProRataFacilities> validator(ValidatorFactory factory) {
		return factory.<ProRataFacilities>create(ProRataFacilitiesValidator.class);
	}

	@Override
	public Validator<? super ProRataFacilities> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProRataFacilities>create(ProRataFacilitiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProRataFacilities> validator() {
		return new ProRataFacilitiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProRataFacilities> typeFormatValidator() {
		return new ProRataFacilitiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProRataFacilities, Set<String>> onlyExistsValidator() {
		return new ProRataFacilitiesOnlyExistsValidator();
	}
}
