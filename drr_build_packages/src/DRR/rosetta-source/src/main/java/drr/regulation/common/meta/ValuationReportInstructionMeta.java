package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.validation.ValuationReportInstructionTypeFormatValidator;
import drr.regulation.common.validation.ValuationReportInstructionValidator;
import drr.regulation.common.validation.exists.ValuationReportInstructionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ValuationReportInstruction.class)
public class ValuationReportInstructionMeta implements RosettaMetaData<ValuationReportInstruction> {

	@Override
	public List<Validator<? super ValuationReportInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationReportInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationReportInstruction> validator(ValidatorFactory factory) {
		return factory.<ValuationReportInstruction>create(ValuationReportInstructionValidator.class);
	}

	@Override
	public Validator<? super ValuationReportInstruction> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationReportInstruction>create(ValuationReportInstructionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportInstruction> validator() {
		return new ValuationReportInstructionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReportInstruction> typeFormatValidator() {
		return new ValuationReportInstructionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationReportInstruction, Set<String>> onlyExistsValidator() {
		return new ValuationReportInstructionOnlyExistsValidator();
	}
}
