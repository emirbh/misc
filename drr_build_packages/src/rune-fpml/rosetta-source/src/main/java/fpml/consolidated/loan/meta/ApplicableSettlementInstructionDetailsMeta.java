package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApplicableSettlementInstructionDetails;
import fpml.consolidated.loan.validation.ApplicableSettlementInstructionDetailsTypeFormatValidator;
import fpml.consolidated.loan.validation.ApplicableSettlementInstructionDetailsValidator;
import fpml.consolidated.loan.validation.exists.ApplicableSettlementInstructionDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ApplicableSettlementInstructionDetails.class)
public class ApplicableSettlementInstructionDetailsMeta implements RosettaMetaData<ApplicableSettlementInstructionDetails> {

	@Override
	public List<Validator<? super ApplicableSettlementInstructionDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApplicableSettlementInstructionDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableSettlementInstructionDetails> validator(ValidatorFactory factory) {
		return factory.<ApplicableSettlementInstructionDetails>create(ApplicableSettlementInstructionDetailsValidator.class);
	}

	@Override
	public Validator<? super ApplicableSettlementInstructionDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ApplicableSettlementInstructionDetails>create(ApplicableSettlementInstructionDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableSettlementInstructionDetails> validator() {
		return new ApplicableSettlementInstructionDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ApplicableSettlementInstructionDetails> typeFormatValidator() {
		return new ApplicableSettlementInstructionDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableSettlementInstructionDetails, Set<String>> onlyExistsValidator() {
		return new ApplicableSettlementInstructionDetailsOnlyExistsValidator();
	}
}
