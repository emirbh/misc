package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.validation.TransactionReportInstructionBaseTypeFormatValidator;
import drr.base.trade.validation.TransactionReportInstructionBaseValidator;
import drr.base.trade.validation.exists.TransactionReportInstructionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=TransactionReportInstructionBase.class)
public class TransactionReportInstructionBaseMeta implements RosettaMetaData<TransactionReportInstructionBase> {

	@Override
	public List<Validator<? super TransactionReportInstructionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionReportInstructionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransactionReportInstructionBase> validator(ValidatorFactory factory) {
		return factory.<TransactionReportInstructionBase>create(TransactionReportInstructionBaseValidator.class);
	}

	@Override
	public Validator<? super TransactionReportInstructionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransactionReportInstructionBase>create(TransactionReportInstructionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransactionReportInstructionBase> validator() {
		return new TransactionReportInstructionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransactionReportInstructionBase> typeFormatValidator() {
		return new TransactionReportInstructionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionReportInstructionBase, Set<String>> onlyExistsValidator() {
		return new TransactionReportInstructionBaseOnlyExistsValidator();
	}
}
