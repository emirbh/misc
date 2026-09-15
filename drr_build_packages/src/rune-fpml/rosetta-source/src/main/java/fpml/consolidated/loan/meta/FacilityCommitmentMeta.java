package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.validation.FacilityCommitmentTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityCommitmentValidator;
import fpml.consolidated.loan.validation.datarule.FacilityCommitmentChoice;
import fpml.consolidated.loan.validation.exists.FacilityCommitmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityCommitment.class)
public class FacilityCommitmentMeta implements RosettaMetaData<FacilityCommitment> {

	@Override
	public List<Validator<? super FacilityCommitment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityCommitment>create(FacilityCommitmentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityCommitment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityCommitment> validator(ValidatorFactory factory) {
		return factory.<FacilityCommitment>create(FacilityCommitmentValidator.class);
	}

	@Override
	public Validator<? super FacilityCommitment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityCommitment>create(FacilityCommitmentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityCommitment> validator() {
		return new FacilityCommitmentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityCommitment> typeFormatValidator() {
		return new FacilityCommitmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityCommitment, Set<String>> onlyExistsValidator() {
		return new FacilityCommitmentOnlyExistsValidator();
	}
}
