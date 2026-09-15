package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.validation.TransactionReportInstructionTypeFormatValidator;
import drr.regulation.common.validation.TransactionReportInstructionValidator;
import drr.regulation.common.validation.exists.TransactionReportInstructionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=TransactionReportInstruction.class)
public class TransactionReportInstructionMeta implements RosettaMetaData<TransactionReportInstruction> {

	@Override
	public List<Validator<? super TransactionReportInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionReportInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransactionReportInstruction> validator(ValidatorFactory factory) {
		return factory.<TransactionReportInstruction>create(TransactionReportInstructionValidator.class);
	}

	@Override
	public Validator<? super TransactionReportInstruction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransactionReportInstruction>create(TransactionReportInstructionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransactionReportInstruction> validator() {
		return new TransactionReportInstructionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransactionReportInstruction> typeFormatValidator() {
		return new TransactionReportInstructionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionReportInstruction, Set<String>> onlyExistsValidator() {
		return new TransactionReportInstructionOnlyExistsValidator();
	}
}
