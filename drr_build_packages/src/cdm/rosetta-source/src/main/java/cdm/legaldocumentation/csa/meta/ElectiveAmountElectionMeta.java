package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ElectiveAmountElection;
import cdm.legaldocumentation.csa.validation.ElectiveAmountElectionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ElectiveAmountElectionValidator;
import cdm.legaldocumentation.csa.validation.datarule.ElectiveAmountElectionNonZeroAmount;
import cdm.legaldocumentation.csa.validation.exists.ElectiveAmountElectionOnlyExistsValidator;
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
@RosettaMeta(model=ElectiveAmountElection.class)
public class ElectiveAmountElectionMeta implements RosettaMetaData<ElectiveAmountElection> {

	@Override
	public List<Validator<? super ElectiveAmountElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ElectiveAmountElection>create(ElectiveAmountElectionNonZeroAmount.class)
		);
	}
	
	@Override
	public List<Function<? super ElectiveAmountElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectiveAmountElection> validator(ValidatorFactory factory) {
		return factory.<ElectiveAmountElection>create(ElectiveAmountElectionValidator.class);
	}

	@Override
	public Validator<? super ElectiveAmountElection> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectiveAmountElection>create(ElectiveAmountElectionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectiveAmountElection> validator() {
		return new ElectiveAmountElectionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectiveAmountElection> typeFormatValidator() {
		return new ElectiveAmountElectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectiveAmountElection, Set<String>> onlyExistsValidator() {
		return new ElectiveAmountElectionOnlyExistsValidator();
	}
}
