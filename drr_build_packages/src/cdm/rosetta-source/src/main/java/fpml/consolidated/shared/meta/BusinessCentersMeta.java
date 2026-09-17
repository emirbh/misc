package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BusinessCenters;
import fpml.consolidated.shared.validation.BusinessCentersTypeFormatValidator;
import fpml.consolidated.shared.validation.BusinessCentersValidator;
import fpml.consolidated.shared.validation.exists.BusinessCentersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessCenters.class)
public class BusinessCentersMeta implements RosettaMetaData<BusinessCenters> {

	@Override
	public List<Validator<? super BusinessCenters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessCenters> validator(ValidatorFactory factory) {
		return factory.<BusinessCenters>create(BusinessCentersValidator.class);
	}

	@Override
	public Validator<? super BusinessCenters> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessCenters>create(BusinessCentersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenters> validator() {
		return new BusinessCentersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessCenters> typeFormatValidator() {
		return new BusinessCentersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenters, Set<String>> onlyExistsValidator() {
		return new BusinessCentersOnlyExistsValidator();
	}
}
