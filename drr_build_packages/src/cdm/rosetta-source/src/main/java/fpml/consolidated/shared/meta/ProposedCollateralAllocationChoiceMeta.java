package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ProposedCollateralAllocationChoice;
import fpml.consolidated.shared.validation.ProposedCollateralAllocationChoiceTypeFormatValidator;
import fpml.consolidated.shared.validation.ProposedCollateralAllocationChoiceValidator;
import fpml.consolidated.shared.validation.exists.ProposedCollateralAllocationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ProposedCollateralAllocationChoice.class)
public class ProposedCollateralAllocationChoiceMeta implements RosettaMetaData<ProposedCollateralAllocationChoice> {

	@Override
	public List<Validator<? super ProposedCollateralAllocationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProposedCollateralAllocationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProposedCollateralAllocationChoice> validator(ValidatorFactory factory) {
		return factory.<ProposedCollateralAllocationChoice>create(ProposedCollateralAllocationChoiceValidator.class);
	}

	@Override
	public Validator<? super ProposedCollateralAllocationChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProposedCollateralAllocationChoice>create(ProposedCollateralAllocationChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProposedCollateralAllocationChoice> validator() {
		return new ProposedCollateralAllocationChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProposedCollateralAllocationChoice> typeFormatValidator() {
		return new ProposedCollateralAllocationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProposedCollateralAllocationChoice, Set<String>> onlyExistsValidator() {
		return new ProposedCollateralAllocationChoiceOnlyExistsValidator();
	}
}
