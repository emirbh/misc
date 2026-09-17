package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ProposedCollateralAllocation;
import fpml.consolidated.shared.validation.ProposedCollateralAllocationTypeFormatValidator;
import fpml.consolidated.shared.validation.ProposedCollateralAllocationValidator;
import fpml.consolidated.shared.validation.exists.ProposedCollateralAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProposedCollateralAllocation.class)
public class ProposedCollateralAllocationMeta implements RosettaMetaData<ProposedCollateralAllocation> {

	@Override
	public List<Validator<? super ProposedCollateralAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProposedCollateralAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProposedCollateralAllocation> validator(ValidatorFactory factory) {
		return factory.<ProposedCollateralAllocation>create(ProposedCollateralAllocationValidator.class);
	}

	@Override
	public Validator<? super ProposedCollateralAllocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProposedCollateralAllocation>create(ProposedCollateralAllocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProposedCollateralAllocation> validator() {
		return new ProposedCollateralAllocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProposedCollateralAllocation> typeFormatValidator() {
		return new ProposedCollateralAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProposedCollateralAllocation, Set<String>> onlyExistsValidator() {
		return new ProposedCollateralAllocationOnlyExistsValidator();
	}
}
