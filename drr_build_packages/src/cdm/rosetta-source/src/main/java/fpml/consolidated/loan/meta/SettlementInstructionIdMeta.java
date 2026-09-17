package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.SettlementInstructionId;
import fpml.consolidated.loan.validation.SettlementInstructionIdTypeFormatValidator;
import fpml.consolidated.loan.validation.SettlementInstructionIdValidator;
import fpml.consolidated.loan.validation.exists.SettlementInstructionIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementInstructionId.class)
public class SettlementInstructionIdMeta implements RosettaMetaData<SettlementInstructionId> {

	@Override
	public List<Validator<? super SettlementInstructionId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementInstructionId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementInstructionId> validator(ValidatorFactory factory) {
		return factory.<SettlementInstructionId>create(SettlementInstructionIdValidator.class);
	}

	@Override
	public Validator<? super SettlementInstructionId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementInstructionId>create(SettlementInstructionIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementInstructionId> validator() {
		return new SettlementInstructionIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementInstructionId> typeFormatValidator() {
		return new SettlementInstructionIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementInstructionId, Set<String>> onlyExistsValidator() {
		return new SettlementInstructionIdOnlyExistsValidator();
	}
}
